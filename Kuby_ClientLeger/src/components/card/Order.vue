<template>
    <div>
      <h1 class="text-left text-accent mb-1">
        Liste des commandes
      </h1>
      <p class="text-muted text-sm italic mb-4">
        Cliquez sur un titre de colonne pour trier les données.
      </p>
  
      <!-- Afficher un message si aucune commande n'est disponible -->
      <div v-if="!orders || orders.length === 0" class="text-center">
        Aucune commande trouvée.
      </div>
  
      <!-- Afficher le tableau si des commandes sont disponibles -->
      <v-table v-else class="table-with-border" ref="orderTable">
        <thead>
          <tr>
            <th class="font-weight-bold text-center" @click="sortBy('orders_id')">
              N° de commande
              <v-icon v-if="sortColumn === 'orders_id'" size="16">{{
                sortOrder === 'asc' ? 'mdi-arrow-up' : 'mdi-arrow-down'
              }}</v-icon>
            </th>
            <th class="font-weight-bold text-center" @click="sortBy('orders_date')">
              Date de commande
              <v-icon v-if="sortColumn === 'orders_date'" size="16">{{
                sortOrder === 'asc' ? 'mdi-arrow-up' : 'mdi-arrow-down'
              }}</v-icon>
            </th>
            <th class="font-weight-bold text-center" @click="sortBy('orders_status')">
              Statut
              <v-icon v-if="sortColumn === 'orders_status'" size="16">{{
                sortOrder === 'asc' ? 'mdi-arrow-up' : 'mdi-arrow-down'
              }}</v-icon>
            </th>
            <th class="font-weight-bold text-center" @click="sortBy('orders_amount')">
              Montant
              <v-icon v-if="sortColumn === 'orders_amount'" size="16">{{
                sortOrder === 'asc' ? 'mdi-arrow-up' : 'mdi-arrow-down'
              }}</v-icon>
            </th>
          </tr>
        </thead>
        <tbody class="text-center">
          <tr v-for="order in paginatedOrders" :key="order.orders_id">
            <td>{{ order.orders_id }}</td>
            <td>{{ formatDate(order.orders_date) }}</td> <!-- Utilisation de formatDate -->
            <td>{{ order.orders_status }}</td>
            <td>{{ formatAmount(order.orders_amount) }}</td>
          </tr>
        </tbody>
      </v-table>
  
      <!-- Afficher la pagination uniquement si des commandes sont disponibles -->
      <Pagination v-if="orders && orders.length > 0" v-model="page" :length="totalPages" />
    </div>
  </template>
  
  <script setup lang="ts">
  import { ref, computed, type PropType } from 'vue';
  import type { Orders } from '@/api/interfaces/Orders';
  import Pagination from '../Utils/Pagination.vue';
  
  const props = defineProps({
    orders: {
      type: Array as PropType<Orders[]>,
      required: true,
      default: () => [], // Valeur par défaut pour éviter que `orders` soit `null`
    },
  });
  
  const page = ref(1);
  const itemsPerPage = ref(10);
  
  const sortColumn = ref('');
  const sortOrder = ref('');
  
  const sortBy = (column: string) => {
    if (sortColumn.value === column) {
      sortOrder.value = sortOrder.value === 'asc' ? 'desc' : 'asc';
    } else {
      sortColumn.value = column;
      sortOrder.value = 'asc';
    }
  };
  
  const paginatedOrders = computed(() => {
    if (!props.orders || props.orders.length === 0) {
      return [];
    }
  
    const sortedOrders = [...props.orders];
  
    if (sortColumn.value) {
      sortedOrders.sort((a, b) => {
        const key = sortColumn.value as keyof Orders;
  
        const valA = a[key];
        const valB = b[key];
  
        if (valA < valB) return sortOrder.value === 'asc' ? -1 : 1;
        if (valA > valB) return sortOrder.value === 'asc' ? 1 : -1;
        return 0;
      });
    }
  
    const start = (page.value - 1) * itemsPerPage.value;
    return sortedOrders.slice(start, start + itemsPerPage.value);
  });
  
  const totalPages = computed(() => {
    if (!props.orders || props.orders.length === 0) {
      return 0;
    }
    return Math.ceil(props.orders.length / itemsPerPage.value);
  });
  
  const formatDate = (dateString: string | Date) => {
    // Si `dateString` est déjà un objet Date, utilisez-le directement
    if (dateString instanceof Date) {
        return formatDateTime(dateString);
    }

    // Sinon, convertissez la chaîne en objet Date
    const date = new Date(dateString);

    // Vérifiez que la conversion a réussi
    if (isNaN(date.getTime())) {
        console.error('Date invalide :', dateString);
        return 'Date invalide';
    }

    return formatDateTime(date);
    };

    const formatDateTime = (date: Date) => {
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0'); // Mois commence à 0
    const day = String(date.getDate()).padStart(2, '0');
    const hours = String(date.getHours()).padStart(2, '0');
    const minutes = String(date.getMinutes()).padStart(2, '0');
    const seconds = String(date.getSeconds()).padStart(2, '0');

    return `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;
    };
  
  const formatAmount = (amount: number) => {
    return `${amount.toFixed(2)}€`;
  };
  </script>
  
  <style scoped>
  .table-with-border {
    border: 2px solid #000000;
  }
  
  .table-with-border th,
  .table-with-border td {
    border: 1px solid #000000;
    font-size: 1.25rem;
  }
  </style>