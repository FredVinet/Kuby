<template>
    <v-card class="mx-auto my-8" elevation="16" max-width="90%" border="opacity-50 md info" rounded="lg">
      <div class="my-5 mx-5">
        <v-text-field
          hide-details
          label="Recherchez un nom, prénom, ville..."
          outlined
          variant="solo-filled"
          v-model="searchTerm" 
          @input="onSearchChange" 
        ></v-text-field>
  
        <v-row class="mt-2 ">
          <v-col cols="4">
            <label class="font-weight-bold text-info">Filtrer par prix</label>
            <v-row class="pt-3 justify-center">
              <v-col cols="6" >
                <v-text-field
                  label="Montant mini"
                  outlined
                  hide-details
                  value="0"
                ></v-text-field>
              </v-col>
              <v-col cols="6">
                <v-text-field
                  label="Montant maxi"
                  outlined
                  hide-details
                  value="12000"
                ></v-text-field>
              </v-col>
            </v-row>
          </v-col>
  
          <v-col cols="4">
            <label class="font-weight-bold text-info d-block ">Filtrer par famille</label>
            <v-select
            class="mt-3"
              label="Sélectionnez"
              variant="solo-filled"
            />
          </v-col>
          
          <v-col cols="4">
            <label class="font-weight-bold text-info d-block ">Filtrer par variété</label>
            <v-select
            class="mt-3"
              label="Sélectionnez"
              variant="solo-filled"
            />
          </v-col>
        </v-row>
  
        <v-row class="mt-4">
          <v-col cols="12" class="d-flex justify-end">
            <v-btn variant="plain" color="accent" large @click="resetSearch" class="mr-4">
              Réinitialiser
            </v-btn>
            <v-btn color="primary" large @click="">
              Rechercher
            </v-btn>
          </v-col>
        </v-row>
      </div>
    </v-card>
  </template>

<script setup lang="ts">
import { ref, defineEmits } from 'vue';

const emit = defineEmits<{
  (event: 'filterStock', searchTerm: string): void;
}>();

const searchTerm = ref('');

const onSearchChange = () => {
  emit('filterStock', searchTerm.value);
};

const resetSearch = () => {
  searchTerm.value = '';
  emit('filterStock', '');  
};

</script>
