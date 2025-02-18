<template>
    <v-dialog v-model="dialog" max-width="800">
      <template v-slot:activator="{ props: activatorProps }">
        <v-btn v-bind:="activatorProps" color="primary">Crée un compte</v-btn>
      </template>
    
      <template v-slot:default="{ isActive }">
        <v-card>
          <h3 class="mt-5 text-accent text-center">Modifier Adresse</h3>
          <v-card-text>
            <v-row dense>
              <v-col cols="12" md="4">
                <v-text-field
                  label="Prénom"
                  required
                  v-model="newUser.user_firstname"
                ></v-text-field>
              </v-col>
              <v-col cols="12" md="4">
                <v-text-field
                  label="Nom"
                  v-model="newUser.user_name"
                ></v-text-field>
              </v-col>
              <v-col cols="12" md="4">
                <v-text-field
                  label="Numéro de téléphone"
                  required
                  v-model="newUser.user_phone"
                ></v-text-field>
              </v-col>
              <v-col cols="12" md="6">
                <v-text-field
                  label="Email"
                  type="email"
                  required
                  v-model="newUser.userMail"
                ></v-text-field>
              </v-col>
              <v-col cols="12" md="6">
                <v-text-field
                  label="Mot de passe"
                  type="password"
                  v-model="newUser.user_password"
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
              @click="createAccount()"
            >
             Crée votre compte
            </v-btn>
          </v-card-actions>
        </v-card>
      </template>
    </v-dialog>
  </template>
  
<script setup lang="ts">
import type { User } from '@/api/interfaces/User';
import UserService from '@/api/services/UserService';
import { ref } from 'vue';

const dialog = ref(false);

// Nouvelle adresse à créer
const newUser = ref<User>({
    user_firstname: '',
    user_name: '',
    user_phone: '',
    userMail: '',
    user_password: '',
    userType: 1
});

// Fonction pour créer une nouvelle adresse et une localisation
const createAccount = async () => {
  try {
    const response = await UserService.createUser(newUser.value);
    console.log('Utilisateur crée avec succès :', response);

    newUser.value = {
        user_firstname: '',
        user_name: '',
        user_phone: '',
        userMail: '',
        user_password: '',
        userType: 1
    };
    // Fermer le modal
    dialog.value = false;

  } catch (error) {
    console.error('Erreur lors de la création de l\'utilisateur :', error);
  }
};
</script>