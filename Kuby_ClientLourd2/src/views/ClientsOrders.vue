<template>
    <v-container>
      <BigTitle :title="title" />
      <FilterOrder />
      <OrderList />
      <OrderCard />
    </v-container>
  </template>
  
  <script setup lang="ts">
    import OrderCard from '@/components/Cards/OrderCard.vue';
    import OrderList from '@/components/Lists/OrderList.vue';
    import FilterOrder from '@/components/Search/FilterOrder.vue';
    import BigTitle from '@/components/Titles/BigTitle.vue';
    import { ref } from 'vue';
  
    const title = ref('Client Orders');
  </script>
  