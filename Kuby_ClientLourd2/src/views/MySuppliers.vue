<template>
  <v-container>
    <BigTitle :title="title" />
    <FilterClient @filterClients="filterClients" />
    <SupplierList  :suppliers="filteredSuppliers" @updateSelectedSupplier="updateSelectedSupplier" @refresh="refresh"/>
    <div v-if="selectedSupplier">
      <SupplierCard :supplier="selectedSupplier" @refresh="refresh"/>
    </div>
    <div v-else class="text-center text-muted py-4">
      Veuillez sélectionner un supplier.
    </div>
  </v-container>
</template>

<script setup lang="ts">
  import SupplierCard from '@/components/Cards/SupplierCard.vue';
  import SupplierList from '@/components/Lists/SupplierList.vue';
  import FilterClient from '@/components/Search/FilterClient.vue';
  import BigTitle from '@/components/Titles/BigTitle.vue';
  import UserService from '@/api/services/UserService'; 
  import type { User } from '@/api/interfaces/User'
  import { ref, onMounted } from 'vue';

  const title = ref('Suppliers Liste');

  const selectedSupplier= ref<User | null>(null)
  const suppliers = ref<User[]>([]);
  const filteredSuppliers = ref<User[]>([]);


const getSupplier = async () => {
  try {
    const users = await UserService.getUsersByType(2);
    suppliers.value = users; 
    filteredSuppliers.value = users;  
  } catch (error) {
    console.error('Erreur lors de la récupération des utilisateurs:', error);
  }
};

onMounted(() => {
  getSupplier();
});

const refresh = () => {
  getSupplier();
};

const filterClients = (searchTerm: string) => {
  if (!searchTerm) {
    filteredSuppliers.value = suppliers.value;  
  } else {
    filteredSuppliers.value = suppliers.value.filter((supplier:User) =>
      supplier.user_firstname.toLowerCase().includes(searchTerm.toLowerCase()) || 
      supplier.user_name.toLowerCase().includes(searchTerm.toLowerCase())
    );
  }
};

const updateSelectedSupplier = (supplier: User) => {
  selectedSupplier.value = supplier
}

</script>
