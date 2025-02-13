<template>
  <v-container>
    <BigTitle :title="title" />
    <Filter @filterStock="filterStock" />
    <StockList :wines="filteredWine" :families="families" :grapes="grapes" :suppliers="suppliers" @updateSelectedWine="updateSelectedWine" />    
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
  import ArticleService from '@/api/services/ArticlesService'; 
  import FamilyService from '@/api/services/FamilyService';
  import GrapeService from '@/api/services/GrapeService';
  import type { SupplierArticle } from '@/api/interfaces/Supplier';
  import SupplierService from '@/api/services/SupplierService';
  import type {Article} from '@/api/interfaces/Article'
  import type { Family } from '@/api/interfaces/Family';
  import type { Grape } from '@/api/interfaces/Grape';

  import { ref, onMounted } from 'vue';

  const title = ref('Stock');

  const selectedWine= ref<{} | null>(null)
  const wines = ref<Article[]>([]);
  const filteredWine = ref<Article[]>([]);
  const families = ref<Family[]>([]);
  const grapes = ref<Grape[]>([]);
  const suppliers = ref<SupplierArticle[]>([]);
    
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

    async function getFamilies() {
    try {
        families.value = await FamilyService.getAllFamily();
        console.log(families.value)
    } catch (error) {
        console.error("Erreur lors de la récupération des familles", error);
    }
}

  async function getGrapes() {
      try {
          grapes.value = await GrapeService.getAllGrape();
          console.log(grapes.value)
      } catch (error) {
          console.error("Erreur lors de la récupération des familles", error);
      }
  }

  async function getSupplier() {
      try {
          suppliers.value = await SupplierService.getAllSupplierArticles();
          console.log('Supplier',suppliers.value)
      } catch (error) {
          console.error("Erreur lors de la récupération des familles", error);
      }
  }

  onMounted(() => {
    getArticle();
    getFamilies();
    getGrapes();
    getSupplier();
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
  };
  
</script>
