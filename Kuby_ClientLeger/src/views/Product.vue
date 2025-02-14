<template>
    <div v-if="product">
      <ArticleProduct :product="product" />
      <TitleComponentProduct :title="title" />
      <DescriptionProduct />
      <TitleComponentProduct :title="title2" />
    
      <div class="d-flex justify-center align-center bg-secondary" style="height: 75vh;">
        <ArticleMain />
        <ArticleMain />
        <ArticleMain />
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
import ArticlesService from '@/api/services/ArticlesService'; // Service pour récupérer les détails de la bouteille

const route = useRoute();
const product = ref<any>(null);

const title = ref('Description');
const title2 = ref('Les vins dans le même genre');
const title3 = ref('D’autre vin vous attendent');

onMounted(async () => {
  try {
    const productId = Number(route.params.id);
    if (productId) {
      product.value = await ArticlesService.getArticleById(productId); // Assurez-vous que cette fonction retourne bien les données
    } else {
      console.error("ID du produit manquant");
    }
  } catch (error) {
    console.error("Erreur lors de la récupération du produit :", error);
  }
});
</script>
