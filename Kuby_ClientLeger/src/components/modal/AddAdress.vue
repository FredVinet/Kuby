<template>
    <v-dialog v-model="dialog" max-width="800">
      <template v-slot:activator="{ props: activatorProps }">
        <v-tooltip location="left">
          <template v-slot:activator="{ props: tooltipProps }">
            <div class="d-flex justify-end mr-2 mb-4 add-address-container">
              <v-btn 
                icon 
                v-bind="{ ...activatorProps, ...tooltipProps }" 
                class="bg-primary my-2 add-address-btn"
              >
                <v-icon>mdi-plus</v-icon>
              </v-btn>
            </div>
          </template>
          <span>Ajouter une adresse</span>
        </v-tooltip>
      </template>
    
      <template v-slot:default="{ isActive }">
        <v-card>
          <h3 class="mt-5 text-accent text-center">Modifier Adresse</h3>
          <v-card-text>
            <v-row dense>
              <!-- Adresse principale (line_1) -->
              <v-col cols="12" md="8">
                <v-text-field
                  label="Numéro"
                  required
                  v-model="newAddress.adress_number"
                ></v-text-field>
              </v-col>
              <v-col cols="12" md="4">
                <v-text-field
                  label="Nom"
                  v-model="newAddress.adress_name"
                ></v-text-field>
              </v-col>
              <!-- Ville -->
              <v-col cols="12" md="6">
                <v-text-field
                  label="Ville"
                  required
                  v-model="newAddress.adress_city"
                ></v-text-field>
              </v-col>
              <!-- Code postal -->
              <v-col cols="12" md="6">
                <v-text-field
                  label="Code postal"
                  required
                  v-model="newAddress.adress_code"
                ></v-text-field>
              </v-col>
              <!-- État ou département -->
              <v-col cols="12" md="6">
                <v-text-field
                  label="État ou département"
                  v-model="newAddress.adress_state"
                ></v-text-field>
              </v-col>
              <!-- Pays -->
              <v-col cols="12" md="6">
                <v-text-field
                  label="Pays"
                  required
                  v-model="newAddress.adress_country"
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
              @click="createAddress()"
            >
             Ajouter
            </v-btn>
          </v-card-actions>
        </v-card>
      </template>
    </v-dialog>
  </template>
  
<script setup lang="ts">
import type { Address } from '@/api/interfaces/Address';
import type { Adress } from '@/api/interfaces/Adress';
import AdressService from '@/api/services/AdressService';
import { useUserConnectedStore } from '@/stores/userConnected';
import { ref, reactive, watch, computed } from 'vue';

const dialog = ref(false);
const userConnectedStore = useUserConnectedStore();
const userId = computed(() => userConnectedStore.userId);

const emit = defineEmits(['refreshAddresses']);

// Nouvelle adresse à créer
const newAddress = ref<Adress>({
  adress_number: 0,
  adress_country: '',
  adress_state: '',
  adress_name: '',
  adress_city: '',
  adress_code: '',
});

// Fonction pour créer une nouvelle adresse et une localisation
const createAddress = async () => {
  if (!userId.value) {
    console.error('Aucun utilisateur connecté.');
    return;
  }

  try {
    const response = await AdressService.createUserAddress(userId.value, newAddress.value);
    console.log('Adresse et localisation créées avec succès :', response);

    // Réinitialiser le formulaire
    newAddress.value = {
      adress_number: 0,
      adress_country: '',
      adress_state: '',
      adress_name: '',
      adress_city: '',
      adress_code: '',
    };

    // Fermer le modal
    dialog.value = false;

    // Notifier le parent de rafraîchir les adresses
    emit('refreshAddresses');;
  } catch (error) {
    console.error('Erreur lors de la création de l\'adresse et de la localisation :', error);
  }
};
</script>