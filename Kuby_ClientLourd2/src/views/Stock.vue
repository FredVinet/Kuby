<template>
  <v-container>
    <BigTitle :title="title" />
    <Filter />
    <StockList />
    <StockCard />
  </v-container>
</template>

<script setup lang="ts">
  import StockCard from '@/components/Cards/StockCard.vue';
  import StockList from '@/components/Lists/StockList.vue';
  import Filter from '@/components/Search/Filter.vue';
  import BigTitle from '@/components/Titles/BigTitle.vue';
  import { ref } from 'vue';

  const title = ref('Stock');
</script>
