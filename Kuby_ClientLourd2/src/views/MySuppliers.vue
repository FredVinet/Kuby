<template>
  <v-container>
    <BigTitle :title="title" />
    <FilterClient />
    <SupplierList  :suppliers="suppliers" @updateSelectedSupplier="updateSelectedSupplier"/>
    <div v-if="selectedSupplier">
      <SupplierCard :supplier="selectedSupplier"/>
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
  import UserService from '@/api/services/UserService.ts'; 
  import { User } from '@/api/interfaces/user.ts'
  import { ref, onMounted } from 'vue';

  const title = ref('Suppliers Liste');

  const selectedSupplier= ref<User | null>(null)
  const suppliers = ref<User[]>([]);

const getSupplier = async () => {
  try {
    const users = await UserService.getUsersByType(2);
    suppliers.value = users; 
    console.log(suppliers.value);
  } catch (error) {
    console.error('Erreur lors de la récupération des utilisateurs:', error);
  }
};

onMounted(() => {
  getSupplier();
});


const updateSelectedSupplier = (supplier: User) => {
  selectedSupplier.value = supplier
  console.log('Partenaire sélectionné :', supplier)
}

</script>
