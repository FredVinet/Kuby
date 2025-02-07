<template>
    <v-card
      class="mx-auto my-8 overflow-auto"
      elevation="16"
      max-width="100%"
      border="opacity-50 md info"
      rounded="lg"
    >
      <v-table
        v-if="orders && orders.length > 0"
        style="max-height: 28rem; overflow-y: auto"
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
            v-for="order in orders"
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
  import { defineEmits, defineProps } from 'vue'

  defineProps<{
    orders?: []
  }>()
  
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
  