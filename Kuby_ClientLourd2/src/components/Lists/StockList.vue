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
            :key="wine.id"
            class="clickable-row"
            @click="selectWine(wine)"
          >
            <td>
              <h3 class="font-weight-regular text-center">
                {{ wine.id }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ wine.name }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ wine.family }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ wine.variety }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ wine.year }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ wine.price }} €
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ wine.supplier }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ wine.quantity }}
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
            <v-btn
            color="primary"
            class="mx-5"
            >Ajouter un Produit</v-btn>
            <v-btn
            color="primary"
            class="mx-5"
            >Gestion inventaire</v-btn>
        </div>
  </template>
  
  <script setup lang="ts">
  import { defineEmits, defineProps } from 'vue'

  defineProps<{
    wines?: []
  }>()  
  
  
  const emits = defineEmits(['updateSelectedWine'])
  
  const selectWine = (wine: { id: number, name: string, family: string, variety: string, year: number, price: number, supplier: string, quantity: number }) => {
    emits('updateSelectedWine', wine)
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
  