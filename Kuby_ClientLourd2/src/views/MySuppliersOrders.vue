<template>
    <v-container>
      <BigTitle :title="title" />
      <FilterOrder />
      <OrderList :orders="orders" @updateSelectedOrder="updateSelectedOrder"/>
      <div v-if="selectedOrder">
        <OrderCard :order="selectedOrder"/>
      </div>
      <div v-else class="text-center text-muted py-4">
        Veuillez sélectionner une commande.
      </div>
    </v-container>
  </template>
  
  <script setup lang="ts">
    import OrderCard from '@/components/Cards/OrderCard.vue';
    import OrderList from '@/components/Lists/OrderSupplierList.vue';
    import FilterOrder from '@/components/Search/FilterOrder.vue';
    import BigTitle from '@/components/Titles/BigTitle.vue';
    import { ref } from 'vue';
  
    const title = ref('Suppliers Order');

    const selectedOrder= ref<{} | null>(null)


    const orders = [
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


    const updateSelectedOrder = (order: User) => {
    selectedOrder.value = order
    console.log('order sélectionné :', order)
    }
  </script>
  