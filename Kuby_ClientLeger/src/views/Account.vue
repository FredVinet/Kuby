<template>
  <v-container>
    <TitleComponent :title="title" />
    <UserInfos />
    
    <v-sheet elevation="2" class="pa-4 rounded-lg mb-6">
      <v-row class="align-center justify-space-between">
        <h3 class="text-h6 font-weight-bold mb-2 d-flex align-center">
          <v-icon class="ml-2">mdi-truck-delivery</v-icon> Vos adresses :
        </h3>
        <AddAddress @refreshAddresses="fetchAddress" />
      </v-row>

      <v-row dense class="gap-4">
        <v-col
          v-for="(address, index) in adresses"
          :key="'delivery-' + index"
          cols="12"
          sm="6"
          md="4"
          lg="3"
          class="d-flex justify-center mx-auto "
        >
          <Adresse
            :address="address"
            :onlyOneAddress="adresses.length === 1"
            :editable="true"
            @refreshAddresses="fetchAddress"
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
    <Order :orders="orders" />
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
import AddAddress from '@/components/Modal/AddAdress.vue'
import UserInfos from '@/components/card/UserInfos.vue'

const title = ref('Votre compte');
const adresses = ref<Adress[]>([]);
const orders = ref<Orders[] | null>(null);
const userConnectedStore = useUserConnectedStore();
const userId = computed(() => userConnectedStore.userId);
const userDetails = computed(() => userConnectedStore.userDetails);

const fetchAddress = async () => {
  if (!userId.value) {
    console.error('Aucun utilisateur connecté.');
    return;
  }

  try {
    const response = await AdressService.getAddressesByUserId(userId.value);
    if (response && response.length > 0) {
      adresses.value = response;
    } else {
      adresses.value = [];
    }
  } catch (error) {
    adresses.value = [];
  }
};

const fetchOrders = async () => {
  if (!userId.value) {
    return;
  }

  try {
    const response = await OrderService.getOrdersByUserId(userId.value);
    if (response) {
      orders.value = response || [];
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