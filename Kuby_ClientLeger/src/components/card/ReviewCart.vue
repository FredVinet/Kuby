<template>
  <v-card class="mb-4" elevation="5" max-width="100%" border="opacity-25 md info">
    <v-card-title class="font-weight-bold mb-3">
      <h4 class="text-info">Résumé de la commande</h4>
    </v-card-title>
    <v-card-text class="mx-2">
      <v-row justify="space-between" class="my-3">
        <span>Sous-total :</span>
        <span>{{ formatPrice(totalPrice) }} €</span>
      </v-row>
      <v-row justify="space-between" class="mb-3">
        <span>Livraison :</span>
        <span>{{ formatPrice(deliveryPrice) }} €</span>
      </v-row>
      <v-divider class="my-3"></v-divider>
      <v-row justify="space-between" class="mb-1">
        <span class="text-subtitle-1 text-info font-weight-bold">Total :</span>
        <span class="text-subtitle-1 text-info font-weight-bold">{{ formatPrice(totalWithDelivery) }} €</span>
      </v-row>
    </v-card-text>
    <v-row justify="center" class="my-5">
      <v-btn color="primary" width="80%" @click="openAddressModal">
        Payer ma commande
      </v-btn>
    </v-row>
    <v-row justify="center" class="my-3">
      <v-btn color="error" width="80%" @click="clearCart">
        Vider le panier
      </v-btn>
    </v-row>

    <!-- Modale pour sélectionner l'adresse -->
    <v-dialog v-model="isAddressModalOpen" max-width="600">
      <v-card>
        <v-card-title class="font-weight-bold">
          Sélectionnez une adresse de livraison
        </v-card-title>
        <v-card-text>
          <v-radio-group v-model="selectedAddressId">
            <v-radio
              v-for="address in adresses"
              :key="address.adress_id"
              :label="`${address.adress_number}, ${address.adress_country}, ${address.adress_state}, ${address.adress_name}, ${address.adress_city}, ${address.adress_code}`"
              :value="address.adress_id"
            ></v-radio>
          </v-radio-group>
        </v-card-text>
        <v-card-actions>
          <v-btn color="primary" @click="confirmAddress">Confirmer</v-btn>
          <v-btn color="error" @click="isAddressModalOpen = false">Annuler</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-card>
</template>

<script setup lang="ts">
import { computed, ref, reactive } from 'vue';
import { useCartStore } from '@/stores/cartStore';
import type { Orders } from '@/api/interfaces/Orders';
import OrdersService from '@/api/services/OrdersService';
import OrderItemService from '@/api/services/OrderItemService';
import { useMyAccountStore } from '@/stores/MyAccountStore';
import LocalisationService from '@/api/services/LocalisationService';

const cartStore = useCartStore();
const myAccountStore = useMyAccountStore();

// États pour la modale et l'adresse sélectionnée
const isAddressModalOpen = ref(false);
const selectedAddressId = ref<number | null>(null); // Stocke adress_id
const localisationId = ref<number | null>(null); // Stocke localisation_id récupéré

// Récupérer les adresses de l'utilisateur
const adresses = computed(() => myAccountStore.adresses);

// Récupérer le prix total du panier
const totalPrice = computed(() => cartStore.totalPrice || 0);

// Prix de la livraison
const deliveryPrice = ref(15);

// Calcul du total avec la livraison
const totalWithDelivery = computed(() => totalPrice.value + deliveryPrice.value);

// Fonction pour formater le prix
const formatPrice = (price: number) => price.toFixed(2);

// Fonction pour vider le panier
const clearCart = () => cartStore.clearCart();

// Ouvrir la modale des adresses
const openAddressModal = async () => {
  await myAccountStore.fetchUserData(); // Charger les adresses
  isAddressModalOpen.value = true;
};

// Confirmer l'adresse sélectionnée et créer la commande
const confirmAddress = async () => {
  if (!selectedAddressId.value) {
    alert('Veuillez sélectionner une adresse.');
    return;
  }

  try {
    // Récupérer la localisation_id à partir de l'adresse sélectionnée
    const localisation = await LocalisationService.getLocalisationByAdressId(selectedAddressId.value);
    console.log("LocalisationId", localisation?.localisation_id)
    if (!localisation || !localisation.localisation_id) {
      alert('Impossible de récupérer la localisation pour cette adresse.');
      return;
    }

    localisationId.value = localisation.localisation_id;

    // Passer l'id_localisation à la commande
    await checkout(totalWithDelivery.value, localisationId.value);
    isAddressModalOpen.value = false;
  } catch (error) {
    console.error('Erreur lors de la récupération de la localisation :', error);
  }
};

const newOrder = reactive<Orders>({
  orders_date: new Date(),
  orders_status: 'placed',
  orders_amount: 0,
  id_localisation: 0, // Stockera localisation_id
});

async function checkout(orderTotal: number, localisationId: number) {
  try {
    newOrder.orders_amount = orderTotal;
    newOrder.id_localisation = localisationId;

    const createdOrder = await OrdersService.createOrder(newOrder);
    if (!createdOrder || !createdOrder.orders_id) {
      throw new Error('Erreur lors de la création de la commande.');
    }
    const orderId = createdOrder.orders_id;

    const orderItems = cartStore.cartItems.map((cartItem) => ({
      id_order: orderId,
      id_article: cartItem.product.article_id,
      order_items_quantity: cartItem.quantity,
      unit_price: cartItem.product.article_price,
    }));

    for (const item of orderItems) {
      await OrderItemService.createOrderItem(item);
    }

    cartStore.clearCart();
  } catch (error) {
    console.error('Erreur lors de la création de la commande ou des items :', error);
  }
}
</script>
