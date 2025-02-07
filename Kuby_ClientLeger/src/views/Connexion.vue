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
  import AuthService from '@/api/services/AuthService'
  import { useUserConnectedStore } from '@/stores/userConnected' // Importez le store
import { useRouter } from 'vue-router'
  
  const title = ref("Connexion")
  const msg = ref("Connectez-vous pour commencer vos achats")
  
  const email = ref('')
  const password = ref('')
  
  // Utilisez le store
  const userConnectedStore = useUserConnectedStore()
  const userConnected = userConnectedStore.userDetails
  
  // Méthode de connexion
  async function login() {
    try {
      const credentials = {
        email: email.value,
        password: password.value,
      };
      const { user, token } = await AuthService.login(credentials.email, credentials.password);
  
      console.log("userinfo", user)
      // Stocker les informations de l'utilisateur dans le store
      userConnectedStore.setUserInfo(user);
      if (token) {
        localStorage.setItem('authToken', token); // Stocker le token dans le localStorage
      }
      
      alert('Connexion réussie!');
      navigateTo('/account')
    } catch (error) {
      alert('Erreur de connexion: ' + error.message);
    }
  }

  const router = useRouter();

function navigateTo(path) {
    router.push(path);
}
  
  // Méthode de déconnexion
  function logout() {
    userConnectedStore.clearUserInfo(); // Effacer les informations de l'utilisateur
    alert('Déconnexion réussie!');
  }
  </script>

