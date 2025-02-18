<template>
    <v-container>
      <BigTitle :title="title" />
      <FilterOrder @filterOrder="filterOrder"/>
      <OrderClientList :orders="filtereOrder" @updateSelectedOrder="updateSelectedOrder"/>
      <div v-if="selectedOrder">
        <OrderCard :order="selectedOrder" @refresh="refresh"/>
      </div>
      <div v-else class="text-center text-muted py-4">
        Veuillez sélectionner une commande.
      </div>
    </v-container>
  </template>
  
  <script setup lang="ts">
    import { ref, onMounted } from 'vue';
    import FilterOrder from '@/components/Search/FilterOrder.vue';
    import OrderClientList from '@/components/Lists/OrderClientList.vue';
    import OrderCard from '@/components/Cards/OrderCard.vue';
    import OrdersService from '@/api/services/OrdersService';
    import type { Orders } from '@/api/interfaces/Orders.ts';

    const orders = ref<Orders[]>([]);
    const selectedOrder = ref<Orders | null>(null);
    const filtereOrder = ref<Orders[]>([]);

      
    const getOrders = async () => {
      try {
        orders.value = await OrdersService.getAllOrders();
        filtereOrder.value = orders.value;
        console.log('order sélectionné :', orders.value)

      } catch (error) {
        console.error('Erreur lors de la récupération des commandes:', error);
      }
    };

    onMounted(() => {
      getOrders();
    });

    const refresh = () => {
      selectedOrder.value = null;
      getOrders();
    };

  const updateSelectedOrder = (order: Orders) => {
    selectedOrder.value = order
  }

  const filterOrder = (searchTerm: string) => {
    if (!searchTerm) {
      filtereOrder.value = orders.value;  
    } else {
      filtereOrder.value = orders.value.filter((order: Orders) => 
        order.user_name.toLowerCase().includes(searchTerm.toLowerCase()) ||
        order.adress_city.toLowerCase().includes(searchTerm.toLowerCase()) ||
        order.user_firstname.toLowerCase().includes(searchTerm.toLowerCase()) 
      );
    }
  };

  </script>
  