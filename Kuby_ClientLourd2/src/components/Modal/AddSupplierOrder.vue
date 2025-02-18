<template>
    <v-dialog v-model="dialog" max-width="800" overlay-color="transparent">
      <template v-slot:activator="{ props: activatorProps }">
        <v-btn v-bind="activatorProps" color="primary" class="mx-5">
          Ajouter une commande Fournisseur
        </v-btn>
      </template>
  
      <v-card>
        <h3 class="mt-5 text-accent text-center">Créer une commande fournisseur</h3>
        <v-card-text>
          <!-- Sélecteur pour les fournisseurs -->
          <v-select
            v-model="selectedSupplier"
            :items="suppliers"
            item-title="user_name"
            item-value="user_id"
            label="Sélectionner un fournisseur"
            @update:modelValue="fetchAddresses"
            required
          ></v-select>
  
          <!-- Sélecteur pour les articles -->
          <v-select
            v-model="selectedArticle"
            :items="articles"
            item-title="article_name"
            item-value="article_id"
            label="Sélectionner un article"
            required
          ></v-select>
  
          <!-- Sélecteur pour les adresses du fournisseur -->
          <v-select
            v-model="selectedAddress"
            :items="formattedAddresses"
            item-title="text"
            item-value="id"
            label="Sélectionner une adresse"
            required
          ></v-select>
  
          <!-- Champ pour la quantité -->
          <v-text-field
            v-model.number="quantity"
            label="Quantité"
            type="number"
            min="1"
            required
          ></v-text-field>
  
          <!-- Affichage du total de la commande calculé -->
          <v-row class="mt-4" justify="space-between">
            <span>Total :</span>
            <span>{{ formatPrice(totalPrice) }} €</span>
          </v-row>
        </v-card-text>
  
        <v-divider></v-divider>
  
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn class="bg-secondary mb-2" text variant="plain" @click="dialog = false">
            Annuler
          </v-btn>
          <v-btn class="bg-primary mb-2" text variant="tonal" @click="createOrder">
            Créer la commande
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </template>
  
  <script setup lang="ts">
  import { ref, reactive, computed, onMounted } from 'vue';
  import type { User } from '@/api/interfaces/User';
  import type { Address } from '@/api/interfaces/Adress';
  import type { Article } from '@/api/interfaces/Article';
  import UserService from '@/api/services/UserService';
  import ArticleService from '@/api/services/ArticlesService';
  import AddressService from '@/api/services/AdressService';
  import OrderService from '@/api/services/OrdersService';
  import LocalisationService from '@/api/services/LocalisationService';
import OrderItemService from '@/api/services/OrderItemService';
import SupplierService from '@/api/services/SupplierService';
  
  const dialog = ref(false);
  
  const suppliers = ref<User[]>([]);
  const articles = ref<Article[]>([]);
  const addresses = ref<Address[]>([]);
  
  const selectedSupplier = ref<number | null>(null);
  const selectedArticle = ref<number | null>(null);
  const selectedAddress = ref<number | null>(null);
  const quantity = ref<number>(1);

  const emits = defineEmits(['refresh']);
  
  onMounted(async () => {
    await getSuppliers();
  });
  
  const getSuppliers = async () => {
    try {
      const users = await UserService.getUsersByType(2);
      suppliers.value = users;
    } catch (error) {
      console.error('Erreur lors de la récupération des fournisseurs:', error);
    }
  };
  
  const fetchAddresses = async () => {
    if (selectedSupplier.value) {
      try {
        addresses.value = await AddressService.getAddressesByUserId(selectedSupplier.value);

        const supplierArticles = await SupplierService.getArticlesBySupplierId(selectedSupplier.value);
        
        articles.value = await Promise.all(
          supplierArticles.map(async (supplierArticle: any) => {
            const articleDetail = await ArticleService.getArticleById(supplierArticle.id_article);
            return articleDetail;
          })
        );
      } catch (error) {
        console.error('Erreur lors de la récupération des adresses ou des articles:', error);
        addresses.value = [];
        articles.value = [];
      }
    }
  };
  
  const formattedAddresses = computed(() => {
    return addresses.value.map(addr => ({
      id: addr.adress_id,
      text: `${addr.adress_number} ${addr.adress_name}, ${addr.adress_city}, ${addr.adress_code}, ${addr.adress_country}`
    }));
  });
  
  const totalPrice = computed(() => {
    const article = articles.value.find(a => a.article_id === selectedArticle.value);
    return article ? article.article_price * quantity.value : 0;
  });
  
  const formatPrice = (price: number) => price.toFixed(2);
  
  const createOrder = async () => {
    if (!selectedSupplier.value || !selectedArticle.value || !selectedAddress.value || quantity.value < 1) {
      alert('Veuillez remplir tous les champs correctement.');
      return;
    }

    try {
      const localisation = await LocalisationService.getLocalisationByAdressId(selectedAddress.value);
      if (!localisation || !localisation.localisation_id) {
        alert('Impossible de récupérer la localisation pour cette adresse.');
        return;
      }
      const localisationId = localisation.localisation_id;

      const orderTotal = totalPrice.value;

      const orderData = {
        orders_date: new Date(),
        orders_status: 'Payée',
        orders_amount: orderTotal,
        id_localisation: localisationId,
      };

      const createdOrder = await OrderService.createOrder(orderData);
      if (!createdOrder || !createdOrder.orders_id) {
        throw new Error('Erreur lors de la création de la commande.');
      }
      const orderId = createdOrder.orders_id;

      const article = articles.value.find(a => a.article_id === selectedArticle.value);
      if (!article) {
        throw new Error('Article introuvable.');
      }

      const orderItem = {
        id_order: orderId,
        id_article: selectedArticle.value,
        order_items_quantity: quantity.value,
        unit_price: article.article_price,
      };
      await OrderItemService.createOrderItem(orderItem);

      dialog.value = false;
      emits('refresh');
    } catch (error) {
      console.error('Erreur lors de la création de la commande ou des items :', error);
      alert('Erreur lors de la création de la commande.');
    }
  };
  </script>
  