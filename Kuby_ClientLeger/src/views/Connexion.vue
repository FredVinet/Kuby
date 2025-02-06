<template>
    <TitleComponent :title="title" :msg="msg"/>
  
    <v-card
      class="mx-auto my-8"
      elevation="16"
      max-width="30%">
  
      <v-form>
        <v-text-field
          class="my-5"
          hide-details="auto"
          label="Votre adresse mail"
          type="email"
          v-model="email"
          name="email"
          autocomplete="username"
        ></v-text-field>
  
        <v-text-field
          class="my-5"
          label="Votre mot de passe"
          hide-details="auto"
          type="password"
          v-model="password"
          name="password"
          autocomplete="current-password"
        ></v-text-field>
        
        <div class="my-5 d-flex justify-space-evenly">
          <v-btn color="primary" @click="login">Se Connecter</v-btn>
          <v-btn color="primary" @click="logout">Se Déconnecter</v-btn>
        </div>
      </v-form>
    </v-card>
  
    <div v-if="userConnected">
      <h2>Bienvenue, {{ userConnected.user_firstname }}!</h2>
    </div>
  </template>
  
  <script setup lang="ts">
  import TitleComponent from '@/components/title/TitleComponent.vue'
  import { ref } from 'vue'
  import { useUserConnectedStore } from '@/stores/userConnected' // Importez le store
  
  const title = ref("Connexion")
  const msg = ref("Connectez-vous pour commencer vos achats")
  
  const email = ref('')
  const password = ref('')
  
  // Utilisez le store
  const userConnectedStore = useUserConnectedStore()
  const userConnected = userConnectedStore.userDetails
  
  // Méthode de connexion
  async function login() {
    const credentials = {
      email: email.value,
      password: password.value,
    }
    await userConnectedStore.login(credentials)
  }
  
  // Méthode de déconnexion
  function logout() {
    userConnectedStore.logout()
  }
  </script>