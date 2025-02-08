<template>
    <v-container>
      <TitleComponent :title="title" />
      <Order :orders="orders"/>
      <Adresse :adress="adress" />
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
const adress = ref<Adress | null>(null); // Stocke l'adresse récupérée
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
        adress.value = response[0]; // Prend le premier élément du tableau
        console.log('Adresse récupérée :', adress.value);
        } else {
        console.warn('Aucune adresse trouvée.');
        }
    } catch (error) {
        console.error('Erreur lors de la récupération de l\'adresse :', error);
}
};

const fetchOrders = async () => {
    if (!userId.value) {
        console.error('Aucun utilisateur connecté.');
        return;
    }

    try {
        const response = await OrderService.getOrdersByUserId(userId.value);
        console.log("respons order", response)
        if (response) {
            orders.value = response || [];
            console.log('Adresse récupérée :', adress.value);
        } else {
            console.warn('Aucune adresse trouvée.');
        }
    } catch (error) {
        console.error('Erreur lors de la récupération de l\'adresse :', error);
    }
};

// Appeler fetchAddress lorsque le composant est monté
onMounted(() => {
fetchAddress();
fetchOrders();
});
</script>