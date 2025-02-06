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
                  <h2 class="text-primary text-center" style="text-transform: none">ID</h2>
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
                <h2 class="text-primary" style="text-transform: none">Prénom</h2>
              </v-btn>
            </th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="client in tableData"
            :key="client.id"
            class="clickable-row"
            @click="selectClient(client)"
          >
            <td>
              <h3 class="font-weight-regular text-center">
                {{ client.id }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ client.name }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ client.prenom }}
              </h3>
            </td>
          </tr>
        </tbody>
      </v-table>
      <div v-else>
        <p class="text-center text-muted">Aucun client trouvé.</p>
      </div>
    </v-card>

    <div class="d-flex justify-center my-10">
            <v-btn
            color="primary"
            class=""
            >Ajouter un client Client</v-btn>
        </div>
  </template>
  
  <script setup lang="ts">
  import { defineEmits } from 'vue'
  
  // Liste des clients avec ID, Nom, et Prénom
  const tableData = [
    {
      id: 1,
      name: 'Dupont',
      prenom: 'Jean'
    },
    {
      id: 2,
      name: 'Martin',
      prenom: 'Claire'
    },
    {
      id: 3,
      name: 'Lemoine',
      prenom: 'Pierre'
    },
    {
      id: 4,
      name: 'Lemoine',
      prenom: 'Sylvie'
    },
    {
      id: 5,
      name: 'Durand',
      prenom: 'Lucie'
    },
    {
      id: 6,
      name: 'Bernard',
      prenom: 'Paul'
    },
    {
      id: 7,
      name: 'Thomas',
      prenom: 'Nicolas'
    },
    {
      id: 8,
      name: 'Robert',
      prenom: 'Marie'
    },
    {
      id: 9,
      name: 'Henri',
      prenom: 'Emilie'
    },
    {
      id: 10,
      name: 'Garnier',
      prenom: 'Victor'
    }
  ]
  
  const emits = defineEmits(['updateSelectedClient'])
  
  const selectClient = (client: { id: number, name: string, prenom: string }) => {
    emits('updateSelectedClient', client)
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
  