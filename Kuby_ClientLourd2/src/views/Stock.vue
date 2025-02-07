<template>
  <v-container>
    <BigTitle :title="title" />
    <Filter />
    <StockList :wines="wines" @updateSelectedWine="updateSelectedWine"/>
    <div v-if="selectedWine">
      <StockCard :wine="selectedWine"/>
    </div>
      <div v-else class="text-center text-muted py-4">
        Veuillez sélectionner un vin.
      </div>
  </v-container>
</template>

<script setup lang="ts">
  import StockCard from '@/components/Cards/StockCard.vue';
  import StockList from '@/components/Lists/StockList.vue';
  import Filter from '@/components/Search/Filter.vue';
  import BigTitle from '@/components/Titles/BigTitle.vue';
  import { ref } from 'vue';

  const title = ref('Stock');

  const selectedWine= ref<{} | null>(null)
  const wines = [
  {
    id: 1,
    name: 'Château Margaux',
    family: 'Rouge',
    variety: 'Cabernet Sauvignon',
    year: 2015,
    price: 120,
    supplier: 'Château Margaux',
    quantity: 50
  },
  {
    id: 2,
    name: 'Domaine de la Romanée-Conti',
    family: 'Rouge',
    variety: 'Pinot Noir',
    year: 2018,
    price: 350,
    supplier: 'Domaine de la Romanée-Conti',
    quantity: 30
  },
  {
    id: 3,
    name: 'Veuve Clicquot',
    family: 'Blanc',
    variety: 'Chardonnay, Pinot Noir',
    year: 2017,
    price: 55,
    supplier: 'Veuve Clicquot',
    quantity: 100
  },
  {
    id: 4,
    name: 'Château d\'Yquem',
    family: 'Blanc',
    variety: 'Sémillon, Sauvignon Blanc',
    year: 2015,
    price: 500,
    supplier: 'Château d\'Yquem',
    quantity: 20
  },
  {
    id: 5,
    name: 'Château Lafite Rothschild',
    family: 'Rouge',
    variety: 'Cabernet Sauvignon, Merlot',
    year: 2010,
    price: 850,
    supplier: 'Château Lafite Rothschild',
    quantity: 15
  },
  {
    id: 6,
    name: 'Pétrus',
    family: 'Rouge',
    variety: 'Merlot',
    year: 2012,
    price: 1200,
    supplier: 'Pétrus',
    quantity: 10
  },
  {
    id: 7,
    name: 'Cloudy Bay',
    family: 'Blanc',
    variety: 'Sauvignon Blanc',
    year: 2019,
    price: 45,
    supplier: 'Cloudy Bay',
    quantity: 75
  },
  {
    id: 8,
    name: 'Moët & Chandon',
    family: 'Rosé',
    variety: 'Pinot Noir, Chardonnay',
    year: 2016,
    price: 75,
    supplier: 'Moët & Chandon',
    quantity: 60
  },
  {
    id: 9,
    name: 'Dom Pérignon',
    family: 'Blanc',
    variety: 'Chardonnay, Pinot Noir',
    year: 2012,
    price: 250,
    supplier: 'Dom Pérignon',
    quantity: 25
  },
  {
    id: 10,
    name: 'La Romanée-Conti',
    family: 'Rouge',
    variety: 'Pinot Noir',
    year: 2015,
    price: 1200,
    supplier: 'La Romanée-Conti',
    quantity: 12
  }
]

const updateSelectedWine = (wine: User) => {
    selectedWine.value = wine
    console.log('wine sélectionné :', wine)
  }

</script>
