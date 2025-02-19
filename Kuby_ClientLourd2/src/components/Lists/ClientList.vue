<template>
    <v-card
      class="mx-auto my-8 overflow-auto"
      elevation="16"
      max-width="100%"
      border="opacity-50 md info"
      rounded="lg"
    >
      <v-table
        v-if="clients && clients.length > 0"
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
            v-for="client in clients"
            :key="client.id"
            class="clickable-row"
            @click="selectClient(client)"
          >
            <td>
              <h3 class="font-weight-regular text-center">
                {{ client.user_id }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ client.user_name }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ client.user_firstname }}
              </h3>
            </td>
          </tr>
        </tbody>
      </v-table>
      <div v-else>
        <p class="text-center text-muted">Aucun client trouvé.</p>
      </div>
    </v-card>
  </template>
  
  <script setup lang="ts">
  import { defineEmits, defineProps } from 'vue'
  import type { User } from '@/api/interfaces/User';

  defineProps<{
    clients?: []
  }>()
  
  const emits = defineEmits(['updateSelectedClient'])
  
  const selectClient = (client: User) => {
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
  