<template>
    <v-card
      class="mx-auto my-8 overflow-auto"
      elevation="16"
      max-width="100%"
      border="opacity-50 md info"
      rounded="lg"
    >
      <v-table
        v-if="wines && wines.length > 0"
        style="max-height: 28rem; overflow-y: auto"
        fixed-header
      >
        <thead>
          <tr>
            <th class="d-flex justify-center">
              <div class="d-flex align-center">
                <v-btn variant="text">
                  <h2 class="text-primary text-center" style="text-transform: none">id</h2>
                </v-btn>
              </div>
            </th>
            <th class="text-center">
              <v-btn variant="text">
                <h2 class="text-primary" style="text-transform: none">Nom</h2>
              </v-btn>
            </th>
            <th class="text-center">
              <v-btn variant="text">
                <h2 class="text-primary" style="text-transform: none">Famille</h2>
              </v-btn>
            </th>
            <th class="text-center">
              <v-btn variant="text">
                <h2 class="text-primary" style="text-transform: none">Variété</h2>
              </v-btn>
            </th>
            <th class="text-center">
              <v-btn variant="text">
                <h2 class="text-primary" style="text-transform: none">Année</h2>
              </v-btn>
            </th>
            <th class="text-center">
              <v-btn variant="text">
                <h2 class="text-primary" style="text-transform: none">Prix</h2>
              </v-btn>
            </th>
            <th class="text-center">
              <v-btn variant="text">
                <h2 class="text-primary" style="text-transform: none">Fournisseur</h2>
              </v-btn>
            </th>
            <th class="text-center">
              <v-btn variant="text">
                <h2 class="text-primary" style="text-transform: none">Quantité</h2>
              </v-btn>
            </th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="wine in wines"
            :key="wine.article_id"
            class="clickable-row"
            @click="selectWine(wine)"
          >
            <td>
              <h3 class="font-weight-regular text-center">
                {{ wine.article_id }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ wine.article_name }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ wine.family_name }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ wine.grape_name }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ wine.article_yearprod }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ wine.article_price }} €
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ wine.user_name || 'Non renseigné' }}              
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ calculateTotalQuantity(wine) }}
              </h3>
            </td>
          </tr>
        </tbody>
      </v-table>
      <div v-else>
        <p class="text-center text-muted">Aucun vin trouvé.</p>
      </div>
    </v-card>

    <div class="d-flex justify-center my-10">
            <AddArticle :families="props.families" :grapes="props.grapes" :suppliers="suppliers" @refresh="refresh"/>            
            <v-btn
            color="primary"
            class="mx-5"
            >Gestion inventaire</v-btn>
        </div>
  </template>
  
  <script setup lang="ts">
  import { defineEmits, defineProps,onMounted,ref} from 'vue'
  import type {Article} from '@/api/interfaces/Article'
  import type { Family } from '@/api/interfaces/Family';
  import type { Grape } from '@/api/interfaces/Grape';
  import type { User } from '@/api/interfaces/User';
  import AddArticle from '../Modal/AddArticle.vue';

  const props = defineProps<{
    wines: Article[];
    families: Family[];
    grapes: Grape[];
    suppliers: User[];
}>();

  const emits = defineEmits(['updateSelectedWine','refresh'])


  onMounted(() => {
    console.log(':', props.suppliers);
  });

  const calculateTotalQuantity = (wine: Article) => {
    return (wine.article_quantity_in ?? 0) - (wine.article_quantity_out ?? 0)
  }


  const refresh = () => {
        emits('refresh')
    };
  
  const selectWine = (wine: Article) => {
    emits('updateSelectedWine', wine)
    console.log(wine)
  }
  </script>
  
  <style>
  .clickable-row {
    cursor: pointer;
    transition: background-color 0.2s ease;
  }
  
  .clickable-row:hover {
    background-color: #d1a671;
  }
  </style>
  