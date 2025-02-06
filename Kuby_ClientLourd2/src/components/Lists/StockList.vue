<template>
    <v-card
      class="mx-auto my-8 overflow-auto"
      elevation="16"
      max-width="100%"
      border="opacity-50 md info"
      rounded="lg"
    >
      <v-table
        v-if="tableData && tableData.length > 0"
        style="max-height: 40rem; overflow-y: auto"
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
            v-for="wine in tableData"
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
  import { defineEmits } from 'vue'
  
  const tableData = [
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
  