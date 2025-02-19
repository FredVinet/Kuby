<template>
    <div v-if="product && grape && family">
      <ArticleProduct :product="product" :grape="grape" :family="family"  />
      <TitleComponentProduct :title="title" />
      <DescriptionProduct :product="product" />
      <TitleComponentProduct :title="title2" />
    
      <div class="d-flex justify-center align-center bg-secondary" style="height: 75vh;">
        <ArticleMain v-for="article in randomArticles" :key="article.article_id" :article="article" v-if="randomArticles.length > 0" />
      </div>
    
      <div class="my-15 pt-3 pb-15">
        <TitleComponentProduct :title="title3" />
        <div class="d-flex justify-center">
          <v-btn color="primary" size="x-large" @click="navigateTo('/catalogue')">
            Revenir au catalogue
          </v-btn>
        </div>
      </div>
    </div>
  
    <div v-else class="d-flex justify-center align-center" style="height: 75vh;">
      <v-progress-circular indeterminate color="primary"></v-progress-circular>
    </div>
  </template>
  
  
  <script setup lang="ts">
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import ArticleMain from '@/components/card/ArticleMain.vue';
import ArticleProduct from '@/components/card/ArticleProduct.vue';
import DescriptionProduct from '@/components/card/DescriptionProduct.vue';
import TitleComponentProduct from '@/components/title/TitleComponentProduct.vue';
import ArticlesService from '@/api/services/ArticlesService';
import GrapeService from '@/api/services/GrapeService';
import FamilyService from '@/api/services/FamilyService';
import ArticleService from '@/api/services/ArticlesService';
import type { Article } from '@/api/interfaces/Article';

const route = useRoute();
const product = ref<any>(null);
const grape = ref<any>(null);
const family = ref<any>(null);

const title = ref('Description');
const title2 = ref('Les vins dans le même genre');
const title3 = ref('D’autres vins vous attendent');

const articles = ref<Article[]>([]);

const randomArticles = ref<Article[]>([]);

function shuffleArray(array: Article[]) {
  return array.sort(() => Math.random() - 0.5);
}

onMounted(async () => {
  try {
    const productId = Number(route.params.id);
    if (productId) {
      product.value = await ArticlesService.getArticleById(productId);
      
      if (product.value?.id_grape) {
        grape.value = await GrapeService.getGrapeById(product.value.id_grape);
      }
      if (product.value?.id_family) {
        family.value = await FamilyService.getFamilyById(product.value.id_family);
      }
    } else {
      console.error("ID du produit manquant");
    }
  } catch (error) {
    console.error("Erreur lors de la récupération du produit :", error);
  }

  try {
    articles.value = await ArticleService.getAllArticlesDetails();
    randomArticles.value = shuffleArray(articles.value).slice(0, 3); 
    console.log(randomArticles.value)
  } catch (error) {
    console.error("Erreur lors de la récupération des articles :", error);
  }
});

</script>
