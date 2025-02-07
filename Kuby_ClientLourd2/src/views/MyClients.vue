<template>
    <v-container>
      <BigTitle :title="title" />
      <FilterClient />
      <ClientList  :clients="clients" @updateSelectedClient="updateSelectedClient"/>
      <div v-if="selectedClient">
        <ClientCard :client="selectedClient"/>
      </div>
      <div v-else class="text-center text-muted py-4">
        Veuillez sélectionner un client.
      </div>
    </v-container>
  </template>
  
  <script setup lang="ts">
    import ClientCard from '@/components/Cards/ClientCard.vue';
    import ClientList from '@/components/Lists/ClientList.vue';
    import FilterClient from '@/components/Search/FilterClient.vue';
    import BigTitle from '@/components/Titles/BigTitle.vue';
    import { ref } from 'vue';
  
    const title = ref('Clients Liste');

    const selectedClient= ref<{} | null>(null)
    const clients = [
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
  ];

  const updateSelectedClient = (client: User) => {
    selectedClient.value = client
    console.log('Partenaire sélectionné :', client)
  }

  </script>
  