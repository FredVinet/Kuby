<template>
  <v-container>
    <BigTitle :title="title" />
    <FilterClient @filterClients="filterClients" />
    <ClientList :clients="filteredClients" @updateSelectedClient="updateSelectedClient"/>
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
import UserService from '@/api/services/UserService.ts'; 
import { User } from '@/api/interfaces/user.ts';

import { ref, onMounted } from 'vue';

const title = ref('Clients Liste');
const selectedClient = ref<{} | null>(null);
const clients = ref<User[]>([]);
const filteredClients = ref<User[]>([]);

const getClient = async () => {
  try {
    const users = await UserService.getUsersByType(1);
    clients.value = users; 
    filteredClients.value = users;  
    console.log(clients.value);
  } catch (error) {
    console.error('Erreur lors de la récupération des utilisateurs:', error);
  }
};

onMounted(() => {
  getClient();
});


const filterClients = (searchTerm: string) => {
  if (!searchTerm) {
    filteredClients.value = clients.value;  
  } else {
    filteredClients.value = clients.value.filter((client:User) =>
      client.user_firstname.toLowerCase().includes(searchTerm.toLowerCase()) || 
      client.user_name.toLowerCase().includes(searchTerm.toLowerCase())
    );
  }
};

const updateSelectedClient = (client: User) => {
  selectedClient.value = client;
  console.log('Partenaire sélectionné :', client);
};
</script>
