<template>
    <v-card class="mx-auto my-8" elevation="16" max-width="90%" border="opacity-50 md info" rounded="lg">
      <div class="my-5 mx-5">
        <v-text-field
          hide-details
          label="Recherchez un nom, une variété..."
          outlined
          variant="solo-filled"
          v-model="searchTerm" 
          @input="onSearchChange" 
        ></v-text-field>
  
        <v-row class="mt-2 ">

          <v-col cols="4">
            <label class="font-weight-bold text-info d-block ">Filtrer par statut</label>
            <v-select
            class="mt-3"
              label="Sélectionnez"
              variant="solo-filled"
            />
          </v-col>
          
          <v-col cols="8">
            <v-row class="mt-4">
                <v-col cols="12" class="d-flex justify-end">
                    <v-btn variant="plain" color="accent" large @click="resetSearch"class="mr-4">
                    Réinitialiser
                    </v-btn>
                    <v-btn color="primary" large @click="">
                    Rechercher
                    </v-btn>
                </v-col>
            </v-row>
          </v-col>
        </v-row>
  

      </div>
    </v-card>
  </template>

<script setup lang="ts">
import { ref, defineEmits } from 'vue';

const emit = defineEmits<{
  (event: 'filterOrder', searchTerm: string): void;
}>();

const searchTerm = ref('');

const onSearchChange = () => {
  console.log('Recherche en cours:', searchTerm.value); 
  emit('filterOrder', searchTerm.value);
};

const resetSearch = () => {
  searchTerm.value = '';
  emit('filterOrder', '');  
};

</script>