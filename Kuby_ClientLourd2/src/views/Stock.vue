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
  import ArticleService from '@/api/services/ArticlesService.ts'; 
  import {Article} from '@/api/interfaces/Article.ts'

  import { ref, onMounted } from 'vue';

  const title = ref('Stock');

  const selectedWine= ref<{} | null>(null)
  const wines = ref<Article[]>([]);
    
    const getArticle = async () => {
      try {
        const articles = await ArticleService.getAllArticles();
        wines.value = articles; 
        console.log("wines.value",wines.value);
      } catch (error) {
        console.error('Erreur lors de la récupération des utilisateurs:', error);
      }
    };

  onMounted(() => {
    getArticle();
  });

const updateSelectedWine = (wine: User) => {
    selectedWine.value = wine
    console.log('wine sélectionné :', wine)
  }

</script>
