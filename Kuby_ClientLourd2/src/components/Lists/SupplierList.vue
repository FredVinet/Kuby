<template>
    <v-card
      class="mx-auto my-8 overflow-auto"
      elevation="16"
      max-width="100%"
      border="opacity-50 md info"
      rounded="lg"
    >
      <v-table
        v-if="suppliers && suppliers.length > 0"
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
            v-for="supplier in suppliers"
            :key="supplier.id"
            class="clickable-row"
            @click="selectSupplier(supplier)"
          >
            <td>
              <h3 class="font-weight-regular text-center">
                {{ supplier.user_id }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ supplier.user_name }}
              </h3>
            </td>
            <td>
              <h3 class="font-weight-regular text-center">
                {{ supplier.user_firstname}}
              </h3>
            </td>
          </tr>
        </tbody>
      </v-table>
      <div v-else>
        <p class="text-center text-muted">Aucun supplier trouvé.</p>
      </div>
    </v-card>

    <div class="d-flex justify-center my-10">
            <v-btn
            color="primary"
            class=""
            >Ajouter un supplier</v-btn>
        </div>
  </template>
  
  <script setup lang="ts">
  import { defineEmits, defineProps } from 'vue'

  defineProps<{
    suppliers?: User[]
  }>()
  
  const emits = defineEmits(['updateSelectedSupplier'])
  
  const selectSupplier = (supplier: { id: number, name: string, prenom: string }) => {
    emits('updateSelectedSupplier', supplier)
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
  