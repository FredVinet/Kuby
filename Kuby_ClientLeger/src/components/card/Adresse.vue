<template>
  <v-card
    elevation="6"
    class="pa-4 d-flex flex-column justify-space-between align-center mt-6"
    style="border-radius: 12px; box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1)"
    border="opacity-50 md info"
  >
    <!-- Titre et service -->
    <v-card-title class="text-lg font-semibold text-center mb-4">
      {{ title }}
    </v-card-title>

    <!-- Contenu de l'adresse -->
    <v-card-text v-if="address" class="text-center text-body-1">
      <div>{{ address.adress_name }}</div>
      <div>{{ address.adress_number }}</div>
      <div>{{ address.adress_city }}, {{ address.adress_code }}</div>
      <div v-if="address.adress_state">
        {{ address.adress_state }}
      </div>
      <div>{{ address.adress_country }}</div>
    </v-card-text>

    <!-- Message en cas d'absence d'adresse -->
    <v-card-text v-else class="text-center text-accent">
      <h3 class="font-medium text-lg">Pas d'adresse disponible</h3>
    </v-card-text>

    <!-- Actions -->
    <v-divider class="my-2"></v-divider>
    <v-card-actions class="d-flex justify-end gap-2">
      <template v-if="editable">
        <ModifyAdress :address="address" @refreshAddresses="$emit('refreshAddresses')">
          <v-btn>
            Modifier
          </v-btn>
        </ModifyAdress>

        <DeleteAddress :adress="address?.adress_id ?? 0" @refreshAddresses="$emit('refreshAddresses')">
          <v-btn>
            Supprimer
          </v-btn>
        </DeleteAddress>
      </template>
    </v-card-actions>
  </v-card>
</template>

<script setup lang="ts">
import { defineProps } from 'vue';
import type { Adress } from '@/api/interfaces/Adress';
import ModifyAdress from '../modal/ModifyAdress.vue';
import DeleteAddress from '../modal/DeleteAddress.vue';

const emit = defineEmits(['refreshAddresses']);

// Définir la prop address
const props = defineProps<{
  address: Adress | null; // Utiliser `address` au lieu de `adress`
  title: string;
  editable?: boolean;
}>();
</script>