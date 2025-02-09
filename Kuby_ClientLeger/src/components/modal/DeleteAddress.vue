<template>
  <v-dialog v-model="dialog" max-width="800">

    <template v-slot:activator="{ props: activatorProps }">

          <v-btn 
            v-bind="activatorProps"
            class="bg-error"
          >
            <v-icon>mdi-delete</v-icon>
          </v-btn>
    </template>

    <template v-slot:default="{ isActive }">
        <v-card>
          <h3 class="mt-5 text-accent text-center">Supprimer l'adresse</h3>
          <v-card-text>
            <h4 class="my-3 text-accent text-center">Voulez-vous supprimer définitivement cette adresse de livraison ? </h4>

            <v-row dense>
              <v-col cols="12" md="6" sm="6">
                <v-btn
                    rounded="lg"
                    size="large"
                    class="bg-secondary"
                    block
                    @click="dialog = false"
                >
                    Annuler
                </v-btn>              
              </v-col>
              <v-col cols="12" md="6" sm="6">
                <v-btn
                    rounded="lg"
                    size="large"
                    class="bg-error"
                    block
                    @click="DeleteItem(adress)"
                >
                    Supprimer
                </v-btn>  
              </v-col>
            </v-row>
          </v-card-text>
  
          <v-divider></v-divider>
        </v-card>
      </template>

  </v-dialog>
</template>

<script setup lang="ts">
import AdressService from '@/api/services/AdressService';
import { defineProps,ref } from 'vue';
  
const dialog = ref(false)

defineProps<{
  adress: number
}>()
function DeleteItem(id: number) {
  AdressService.deleteAddress(id);
  dialog.value = false;
}

</script>