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
  import { ref } from 'vue';

  const title = ref('Suppliers Liste');

  const selectedSupplier= ref<User | null>(null)
  const suppliers = [
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

const updateSelectedSupplier = (supplier: User) => {
  selectedSupplier.value = supplier
  console.log('Partenaire sélectionné :', supplier)
}

</script>
