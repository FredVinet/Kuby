<template>
    <v-container>
      <BigTitle :title="title" />
      <FilterClient />
      <ClientList />
      <ClientCard />
    </v-container>
  </template>
  
  <script setup lang="ts">
    import ClientCard from '@/components/Cards/ClientCard.vue';
import ClientList from '@/components/Lists/ClientList.vue';
    import FilterClient from '@/components/Search/FilterClient.vue';
    import BigTitle from '@/components/Titles/BigTitle.vue';
    import { ref } from 'vue';
  
    const title = ref('Suppliers Liste');
  </script>
  