<template>
  <v-card class="mx-auto my-8" elevation="16" max-width="90%" border="opacity-50 md info" rounded="lg">
    <div class="my-5 mx-5">
      <v-text-field
        hide-details
        label="Recherchez un nom, prénom"
        outlined
        variant="solo-filled"
        v-model="searchTerm" 
        @input="onSearchChange" 
      ></v-text-field>   

      <v-row class="mt-4">
        <v-col cols="12" class="d-flex justify-end">
          <v-btn variant="plain" color="accent" large @click="resetSearch">
            Réinitialiser
          </v-btn>
        </v-col>
      </v-row>
    </div>
  </v-card>
</template>

<script setup lang="ts">
import { ref, defineEmits } from 'vue';

const emit = defineEmits<{
  (event: 'filterClients', searchTerm: string): void;
}>();

const searchTerm = ref('');

const onSearchChange = () => {
  console.log('Recherche en cours:', searchTerm.value); 
  emit('filterClients', searchTerm.value);
};

const resetSearch = () => {
  searchTerm.value = '';
  emit('filterClients', '');  
};

</script>
