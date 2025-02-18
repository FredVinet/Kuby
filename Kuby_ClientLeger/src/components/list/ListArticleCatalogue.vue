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
          clearable
        ></v-select>
      </v-col>
      <!-- Sélecteur pour les cépages -->
      <v-col cols="12" sm="3">
        <v-select
          v-model="selectedGrape"
          :items="grapes"
          item-title="grape_name"
          item-value="grape_id"
          label="Filtrer par cépage"
          variant="outlined"
          density="compact"
          @update:modelValue="filterProducts"
          clearable
        ></v-select>
      </v-col>
      <!-- Sélecteur pour les familles -->
      <v-col cols="12" sm="3">
        <v-select
          v-model="selectedFamily"
          :items="families"
          item-title="family_name"
          item-value="family_id"
          label="Filtrer par famille"
          variant="outlined"
          density="compact"
          @update:modelValue="filterProducts"
          clearable
        ></v-select>
      </v-col>
    </v-row>

    <!-- Affichage des produits -->
    <div v-for="n in Math.ceil(filteredProducts.length / 5)" :key="'group-' + n" class="d-flex justify-center mx-5">
      <ArticleCatalogue
        v-for="(product, index) in filteredProducts.slice((n - 1) * 5, n * 5)"
        :key="product.article_id"
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
import GrapeService from '@/api/services/GrapeService';
import FamilyService from '@/api/services/FamilyService';

// États pour les produits, la recherche et les filtres
const products = ref<Article[]>([]);
const searchQuery = ref('');
const selectedFilter = ref('name'); // Filtre par défaut
const filterOptions = ref([
  { title: 'Nom', value: 'name' },
  { title: 'Année', value: 'year' },
  { title: 'Prix', value: 'price' },
]);

// États pour les sélecteurs de cépage et de famille
const selectedGrape = ref<number | null>(null);
const selectedFamily = ref<number | null>(null);

// Données des cépages et des familles
const grapes = ref<any[]>([]);
const families = ref<any[]>([]);

// Charger les produits, cépages et familles au montage du composant
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

    const grapesData = await GrapeService.getAllGrapes();
    grapes.value = grapesData;

    const familiesData = await FamilyService.getAllFamilies();
    families.value = familiesData;
  } catch (error) {
    console.error('Erreur lors de la récupération des données :', error);
  }
});

// Filtrer les produits en fonction de la recherche et des filtres sélectionnés
const filteredProducts = computed(() => {
  return products.value.filter((product) => {
    const query = searchQuery.value.toLowerCase();

    // Filtre par recherche textuelle
    let matchesSearch = true;
    switch (selectedFilter.value) {
      case 'name':
        matchesSearch = product.article_name.toLowerCase().includes(query);
        break;
      case 'year':
        matchesSearch = product.article_yearprod.toString().startsWith(query);
        break;
      case 'price':
        matchesSearch = product.article_price.toString().startsWith(query);
        break;
      default:
        matchesSearch = true;
    }

    // Filtre par cépage sélectionné
    const matchesGrape = selectedGrape.value ? product.id_grape === selectedGrape.value : true;

    // Filtre par famille sélectionnée
    const matchesFamily = selectedFamily.value ? product.id_family === selectedFamily.value : true;

    // Le produit doit correspondre à tous les filtres
    return matchesSearch && matchesGrape && matchesFamily;
  });
});
</script>