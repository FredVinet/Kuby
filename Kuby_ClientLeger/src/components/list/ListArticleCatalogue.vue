<template>
    <v-container>
      <!-- Barre de recherche et filtre -->
      <v-row class="mb-6" justify="center">
        <v-col cols="12" sm="3">
            <v-text-field
            v-model="searchQuery"
            label="Rechercher un produit"
            variant="outlined"
            density="compact"
            clearable
            @input="filterProducts"
            ></v-text-field>
        </v-col>
        <v-col cols="12" sm="3">
            <v-select
            v-model="selectedFilter"
            :items="filterOptions"
            item-title="title"
            item-value="value"
            label="Filtrer par"
            variant="outlined"
            density="compact"
            @update:modelValue="filterProducts"
            ></v-select>
        </v-col>
        </v-row>

  
      <!-- Affichage des produits -->
      <div v-for="n in Math.ceil(filteredProducts.length / 5)" :key="'group-' + n" class="d-flex justify-center mx-5">
        <ArticleCatalogue
          v-for="(product, index) in filteredProducts.slice((n - 1) * 5, n * 5)"
          :key="'product-' + index"
          :product="product"
        />
      </div>
    </v-container>
  </template>
  
  <script setup lang="ts">
  import ArticleCatalogue from '../../components/card/ArticleCatalogue.vue';
  import { ref, onMounted, computed } from 'vue';
  import type { Article } from '@/api/interfaces/Article';
  import ArticleService from '../../api/services/ArticlesService';
  
  // États pour les produits et la recherche
  const products = ref<Article[]>([]);
  const searchQuery = ref('');
  const selectedFilter = ref('name'); // Filtre par défaut
  const filterOptions = ref([
    { title: 'Nom', value: 'name' },
    { title: 'Année', value: 'year' },
    { title: 'Prix', value: 'price' },
    ]);

  
  // Charger les produits au montage du composant
  onMounted(async () => {
    try {
      const articles = await ArticleService.getAllArticles();
      products.value = articles.map((article) => ({
        article_id: article.article_id,
        article_name: article.article_name,
        article_description: article.article_description,
        article_yearprod: article.article_yearprod,
        article_price: article.article_price,
        id_family: article.id_family,
        id_grape: article.id_grape,
      }));
    } catch (error) {
      console.error('Error fetching articles:', error);
    }
  });
  
  // Filtrer les produits en fonction de la recherche et du filtre sélectionné
  const filteredProducts = computed(() => {
    return products.value.filter((product) => {
      const query = searchQuery.value.toLowerCase();
  
      switch (selectedFilter.value) {
        case 'name':
          return product.article_name.toLowerCase().includes(query);
        case 'year':
          return product.article_yearprod.toString().includes(query);
        case 'price':
          return product.article_price.toString().includes(query);
        default:
          return true;
      }
    });
  });
  </script>