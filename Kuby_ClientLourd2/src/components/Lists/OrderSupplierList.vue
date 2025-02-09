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
              <h2 class="text-primary" style="text-transform: none">Nom Fournisseur</h2>
            </v-btn>
          </th>
          <th class="text-center">
            <v-btn variant="text">
              <h2 class="text-primary" style="text-transform: none">Ville de Livraison</h2>
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
        v-for="order in orders.filter(order => order.localisation?.user?.userType === 2)"            
        :key="order.id"
          class="clickable-row"
          @click="selectOrder(order)"
        >
          <td>
            <h3 class="font-weight-regular text-center">
              {{ order.orders_id }}
            </h3>
          </td>
          <td>
            <h3 class="font-weight-regular text-center">
              {{ order.orders_status }}
            </h3>
          </td>
          <td>
            <h3 class="font-weight-regular text-center">
              {{ formatDate(order.orders_date) }}
            </h3>
          </td>
          <td>
            <h3 class="font-weight-regular text-center">
              {{ order.items.length }}
            </h3>
          </td>
          <td>
            <h3 class="font-weight-regular text-center">
              {{ order.localisation.user.user_name }}
            </h3>
          </td>
          <td>
            <h3 class="font-weight-regular text-center">
              {{ order.localisation.address.adress_city}}
            </h3>
          </td>
          <td>
            <h3 class="font-weight-regular text-center">
              {{ order.orders_amount }} €
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
import type { Orders } from '@/api/interfaces/Orders';
import { defineEmits, defineProps } from 'vue'

defineProps<{
  orders?: []
}>()

const emits = defineEmits(['updateSelectedOrder'])

const selectOrder = (order: Orders) => {
  emits('updateSelectedOrder', order)
}

const formatDate = (dateString: string) => {
  const date = new Date(dateString);
  const day = String(date.getDate()).padStart(2, '0');
  const month = String(date.getMonth() + 1).padStart(2, '0');
  const year = date.getFullYear();
  return `${day}/${month}/${year}`;
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
