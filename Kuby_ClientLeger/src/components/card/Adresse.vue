<template>
    <div>
      <h2 class="text-md ms-15 mt-5">Mon adresse</h2>
      <v-card
        v-if="adress"
        elevation="5"
        max-width="40%"
        rounded="lg"
        class="mx-auto my-8"
      >
        <v-card-text>
          <v-row>
            <v-col>
              <div class="py-1">
                <h2 class="text-md font-weight-light">
                  {{ adress.adress_number }} {{ adress.adress_name }}
                </h2>
              </div>
              <div class="py-1">
                <h3 class="text-md font-weight-light">
                  {{ adress.adress_code }} {{ adress.adress_city }}
                </h3>
              </div>
              <div class="py-1">
                <h3 class="text-md font-weight-light">
                  {{ adress.adress_state }}
                </h3>
              </div>
              <div class="py-1">
                <h3 class="text-md font-weight-light">
                  {{ adress.adress_country }}
                </h3>
              </div>
            </v-col>
          </v-row>
        </v-card-text>
      </v-card>
      <v-alert v-else type="info">Aucune adresse trouvée.</v-alert>
    </div>
  </template>
  
  <script setup lang="ts">
  import { defineProps } from 'vue';
  import type { Adress } from '@/api/interfaces/Adress';
  
  // Définir la prop address
  const props = defineProps<{
    adress: Adress | null;
  }>();
  </script>