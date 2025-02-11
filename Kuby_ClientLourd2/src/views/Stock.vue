<template>
  <v-container>
    <BigTitle :title="title" />
    <Filter @filterStock="filterStock" />
    <StockList :wines="filteredWine" @updateSelectedWine="updateSelectedWine"/>
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
  const filteredWine = ref<Article[]>([]);

    
    const getArticle = async () => {
      try {
        const articles = await ArticleService.getAllArticles();
        wines.value = articles; 
        filteredWine.value = articles;
        console.log("wines.value",wines.value);
      } catch (error) {
        console.error('Erreur lors de la récupération des utilisateurs:', error);
      }
    };

  onMounted(() => {
    getArticle();
  });

  const filterStock = (searchTerm: string) => {
    if (!searchTerm) {
      filteredWine.value = wines.value;  
      console.log("filteredWine", filteredWine.value);
    } else {
      filteredWine.value = wines.value.filter((wine: Article) => 
        wine.article_name.toLowerCase().includes(searchTerm.toLowerCase()) ||
        wine.supplierArticle?.supplier?.user_name?.toLowerCase().includes(searchTerm.toLowerCase())
      );
      console.log("filteredWine", filteredWine.value);
    }
  };

  const updateSelectedWine = (wine: Article) => {
    selectedWine.value = wine
    console.log(wine.supplierArticle.supplier.user_name)
  }
  
</script>
