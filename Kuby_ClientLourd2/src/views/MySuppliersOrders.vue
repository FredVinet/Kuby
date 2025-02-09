<template>
    <v-container>
      <BigTitle :title="title" />
      <FilterOrder @filterOrder="filterOrder"/>
      <OrderList :orders="filtereOrder" @updateSelectedOrder="updateSelectedOrder"/>
      <div v-if="selectedOrder">
        <OrderCard :order="selectedOrder"/>
      </div>
      <div v-else class="text-center text-muted py-4">
        Veuillez sélectionner une commande.
      </div>
    </v-container>
  </template>
  
  <script setup lang="ts">
    import OrderCard from '@/components/Cards/OrderCard.vue';
    import OrderList from '@/components/Lists/OrderSupplierList.vue';
    import FilterOrder from '@/components/Search/FilterOrder.vue';
    import BigTitle from '@/components/Titles/BigTitle.vue';
    import { ref, onMounted } from 'vue';

    import OrdersService from '@/api/services/OrdersService';
    import type { Orders } from '@/api/interfaces/Orders.ts';

    const orders = ref<Orders[]>([]);
    const selectedOrder = ref<Orders | null>(null);
    const filtereOrder = ref<Orders[]>([]);

    const getOrders = async () => {
      try {
        orders.value = await OrdersService.getAllOrders();
        console.log("Commandes enrichies :", orders.value);
        filtereOrder.value = orders.value;

      } catch (error) {
        console.error('Erreur lors de la récupération des commandes:', error);
      }
    };

    onMounted(() => {
      getOrders();
    });


    const updateSelectedOrder = (order: Orders) => {
    selectedOrder.value = order
    console.log('order sélectionné :', order)
    }

    const filterOrder = (searchTerm: string) => {
    if (!searchTerm) {
      filtereOrder.value = orders.value;  
      console.log("filtereOrder", filtereOrder.value);
    } else {
      filtereOrder.value = orders.value.filter((order: Orders) => 
        order.localisation.user?.user_name.toLowerCase().includes(searchTerm.toLowerCase()) ||
        order.localisation.address.adress_city.toLowerCase().includes(searchTerm.toLowerCase()) ||
        order.localisation.user?.user_firstname.toLowerCase().includes(searchTerm.toLowerCase()) 
      );
      console.log("filtereOrder", filtereOrder.value);
    }
  };
  </script>
  