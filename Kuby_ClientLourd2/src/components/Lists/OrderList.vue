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
                <h2 class="text-primary" style="text-transform: none">Statut</h2>
              </v-btn>
            </th>
            <th class="text-center">
              <v-btn variant="text">
                <h2 class="text-primary" style="text-transform: none">Date</h2>
              </v-btn>
            </th>
            <th class="text-center">
              <v-btn variant="text">
                <h2 class="text-primary" style="text-transform: none">Qté Article</h2>
              </v-btn>
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
            <th class="text-center">
              <v-btn variant="text">
                <h2 class="text-primary" style="text-transform: none">Adresse Livraison</h2>
              </v-btn>
            </th>
            <th class="text-center">
              <v-btn variant="text">
                <h2 class="text-primary" style="text-transform: none">Prix</h2>
              </v-btn>
            </th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="order in tableData"
            :key="order.id"
            class="clickable-row"
            @click="selectOrder(order)"
          >
            <td>
              <h3 class="font-weight-regular text-center">
                {{ order.id }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ order.status }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ order.date }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ order.quantity }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ order.name }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ order.prenom }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ order.deliveryAddress }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ order.price }} €
              </h3>
            </td>
          </tr>
        </tbody>
      </v-table>
      <div v-else>
        <p class="text-center text-muted">Aucune commande trouvée.</p>
      </div>
    </v-card>
  </template>
  
  <script setup lang="ts">
  import { defineEmits } from 'vue'
  
  // Liste des commandes avec ID, Statut, Date, Qté Article, Nom, Prénom, Adresse Livraison et Prix
  const tableData = [
    {
      id: 1,
      status: 'En cours',
      date: '2025-02-01',
      quantity: 3,
      name: 'Dupont',
      prenom: 'Jean',
      deliveryAddress: '123 Rue Principale, Paris',
      price: 150
    },
    {
      id: 2,
      status: 'Livrée',
      date: '2025-01-28',
      quantity: 2,
      name: 'Martin',
      prenom: 'Claire',
      deliveryAddress: '45 Avenue des Champs-Élysées, Paris',
      price: 200
    },
    {
      id: 3,
      status: 'Annulée',
      date: '2025-01-30',
      quantity: 1,
      name: 'Lemoine',
      prenom: 'Pierre',
      deliveryAddress: '12 Boulevard Saint-Germain, Paris',
      price: 80
    },
    {
      id: 4,
      status: 'Livrée',
      date: '2025-02-02',
      quantity: 5,
      name: 'Lemoine',
      prenom: 'Sylvie',
      deliveryAddress: '78 Rue de Rivoli, Paris',
      price: 300
    },
    {
      id: 5,
      status: 'En cours',
      date: '2025-02-03',
      quantity: 10,
      name: 'Durand',
      prenom: 'Lucie',
      deliveryAddress: '56 Rue de la Paix, Lyon',
      price: 500
    },
    {
      id: 6,
      status: 'Livrée',
      date: '2025-01-29',
      quantity: 7,
      name: 'Bernard',
      prenom: 'Paul',
      deliveryAddress: '34 Avenue de la République, Marseille',
      price: 350
    }
  ]
  
  const emits = defineEmits(['updateSelectedOrder'])
  
  const selectOrder = (order: { id: number, status: string, date: string, quantity: number, name: string, prenom: string, deliveryAddress: string, price: number }) => {
    emits('updateSelectedOrder', order)
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
  