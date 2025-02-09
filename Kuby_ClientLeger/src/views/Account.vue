<template>
    <v-container>
      <TitleComponent :title="title" />
      <Order :orders="orders" />
      <v-sheet elevation="2" class="pa-4 rounded-lg">
        <h3 class="text-h6 font-weight-bold mb-2">
          <v-icon left>mdi-truck-delivery</v-icon> Adresses de livraison
        </h3>
  
        <v-row dense class="gap-4">
          <v-col
            v-for="(address, index) in adresses"
            :key="'delivery-' + index"
            cols="12"
            sm="6"
            md="4"
            lg="3"
            class="d-flex justify-center mx-auto"
          >
            <Adresse
              title="Mes Adresses"
              :address="address"
              :onlyOneAddress="adresses.length === 1"
              :editable="true"
            />
          </v-col>
          <v-col v-if="adresses.length === 0" cols="12">
            <v-alert type="info" class="text-center">
              <v-icon left>mdi-information-outline</v-icon>
              Aucune adresse de livraison disponible.
            </v-alert>
          </v-col>
        </v-row>
      </v-sheet>
    </v-container>
  </template>
  
  <script setup lang="ts">
  import { ref, onMounted, computed } from 'vue';
  import TitleComponent from '@/components/title/TitleComponent.vue';
  import Order from '@/components/card/Order.vue';
  import Adresse from '@/components/card/Adresse.vue';
  import AdressService from '@/api/services/AdressService';
  import { useUserConnectedStore } from '@/stores/userConnected';
  import type { Adress } from '@/api/interfaces/Adress';
  import OrderService from '@/api/services/OrdersService';
  import type { Orders } from '@/api/interfaces/Orders';
  
  const title = ref('Votre compte');
  const adresses = ref<Adress[]>([]); // Initialiser comme un tableau vide
  const orders = ref<Orders[] | null>(null);
  const userConnectedStore = useUserConnectedStore();
  const userId = computed(() => userConnectedStore.userDetails?.user_id);
  
  // Fonction pour récupérer les adresses de l'utilisateur
  const fetchAddress = async () => {
    if (!userId.value) {
      console.error('Aucun utilisateur connecté.');
      return;
    }
  
    try {
      const response = await AdressService.getAddressesByUserId(userId.value);
      if (response && response.length > 0) {
        adresses.value = response; // Affecter à adresses.value
        console.log('Adresses récupérées :', adresses.value);
      } else {
        console.warn('Aucune adresse trouvée.');
        adresses.value = []; // Réinitialiser à un tableau vide
      }
    } catch (error) {
      console.error('Erreur lors de la récupération des adresses :', error);
      adresses.value = []; // Réinitialiser à un tableau vide en cas d'erreur
    }
  };
  
  const fetchOrders = async () => {
    if (!userId.value) {
      console.error('Aucun utilisateur connecté.');
      return;
    }
  
    try {
      const response = await OrderService.getOrdersByUserId(userId.value);
      console.log("response order", response);
      if (response) {
        orders.value = response || [];
        console.log('Commandes récupérées :', orders.value);
      } else {
        console.warn('Aucune commande trouvée.');
      }
    } catch (error) {
      console.error('Erreur lors de la récupération des commandes :', error);
    }
  };
  
  // Appeler fetchAddress et fetchOrders lorsque le composant est monté
  onMounted(() => {
    fetchAddress();
    fetchOrders();
  });
  </script>