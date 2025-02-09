<template>
  <v-dialog v-model="dialog" max-width="800">
    <template v-slot:activator="{ props: activatorProps }">
      <v-btn icon v-bind="activatorProps" class="bg-primary">
        <v-icon>mdi-pencil</v-icon>
      </v-btn>
    </template>

    <template v-slot:default="{ isActive }">
      <v-card v-if="editableAddress">
        <h3 class="mt-5 text-accent text-center">Modifier Adresse</h3>
        <v-card-text>
          <v-row dense>
            <!-- Adresse principale (line_1) -->
            <v-col cols="12" md="8">
              <v-text-field
                label="Numéro"
                required
                v-model="editableAddress.adress_number"
              ></v-text-field>
            </v-col>
            <v-col cols="12" md="4">
              <v-text-field
                label="Nom"
                v-model="editableAddress.adress_name"
              ></v-text-field>
            </v-col>
            <!-- Ville -->
            <v-col cols="12" md="6">
              <v-text-field
                label="Ville"
                required
                v-model="editableAddress.adress_city"
              ></v-text-field>
            </v-col>
            <!-- Code postal -->
            <v-col cols="12" md="6">
              <v-text-field
                label="Code postal"
                required
                v-model="editableAddress.adress_code"
              ></v-text-field>
            </v-col>
            <!-- État ou département -->
            <v-col cols="12" md="6">
              <v-text-field
                label="État ou département"
                v-model="editableAddress.adress_state"
              ></v-text-field>
            </v-col>
            <!-- Pays -->
            <v-col cols="12" md="6">
              <v-text-field
                label="Pays"
                required
                v-model="editableAddress.adress_country"
              ></v-text-field>
            </v-col>
          </v-row>
        </v-card-text>

        <v-divider></v-divider>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            rounded="lg"
            text="Close"
            variant="plain"
            class="bg-secondary mb-2"
            @click="dialog = false"
          >
            Annuler
          </v-btn>
          <v-btn
            rounded="lg"
            class="bg-primary mb-2"
            text="Save"
            variant="tonal"
            @click="updateAddress(editableAddress)"
          >
            Enregistrer
          </v-btn>
        </v-card-actions>
      </v-card>
    </template>
  </v-dialog>
</template>

<script setup lang="ts">
import type { Address } from '@/api/interfaces/Address';
import AdressService from '@/api/services/AdressService';
import { ref, reactive, watch } from 'vue';

const dialog = ref(false);

const props = defineProps<{
  address?: Address;
}>();

const editableAddress = reactive({ ...props.address })

watch(
  () => props.address,
  (newAddress) => {
    if (newAddress) {
      Object.assign(editableAddress, newAddress);
    }
  },
  { immediate: true }, // Appliquer immédiatement au montage
);

async function updateAddress(address: Address) {
  if (!address) {
    console.error('Adresse non définie');
    return;
  }

  if (address.adress_id) {
    try {
      await AdressService.updateAddress(address.adress_id, address);
      dialog.value = false;
    } catch (error) {
      console.error('Erreur lors de la mise à jour de l\'adresse :', error);
    }
  } else {
    console.error('ID de l\'adresse non défini');
  }
}
</script>