<template>
  <v-container>
    <TitleComponent :title="title" :msg="msg"/>
    <v-card class="mx-auto my-15" elevation="16" max-width="50%">
      <!-- Affichage de l'alerte d'erreur avec un message détaillé -->
      <v-alert v-if="error" type="error" dismissible class="my-3">
        {{ error }}
      </v-alert>
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
          <v-btn color="primary" @click="attemptLogin">Se Connecter</v-btn>
          <v-btn color="primary">Première connexion</v-btn>
        </div>
      </v-form>
    </v-card>
  </v-container>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import AuthService from '@/api/services/AuthService';
import TitleComponent from '@/components/Titles/BigTitle.vue';
import router from '@/router';
import { useUserConnectedStore } from '@/stores/userConnected';
import { getIds } from '@/utils/auth';
import { jwtDecode } from 'jwt-decode';

const title = ref("Connexion");
const msg = ref("Connectez-vous pour commencer vos achats");

interface DecodedToken {
  iss: string;
  iat: number;
  exp: number;
  userId: number;
  email: string;
  role: string;
}

const userConnectedStore = useUserConnectedStore();

const email = ref('');
const password = ref('');
const error = ref('');

const isAuthenticated = ref(false);
const userProfile = ref<DecodedToken | null>(null);

const attemptLogin = async () => {
  try {
    error.value = '';
    // Tentative de connexion via le loginAdmin (qui renvoie une erreur si l'utilisateur n'est pas admin)
    const { user, token } = await AuthService.loginAdmin(email.value, password.value);

    if (token) {
      localStorage.setItem('authToken', token);

      const decodedToken: DecodedToken = jwtDecode(token);
      const currentTime = Math.floor(Date.now() / 1000);

      if (decodedToken.exp > currentTime) {
        isAuthenticated.value = true;
        userProfile.value = decodedToken;

        const ids = getIds(token);
        // On met à jour le store avec l'ID utilisateur et le rôle (ici "admin")
        userConnectedStore.setUserInfo(ids.userId, ids.role);
        navigateTo('/');
      }
    }
  } catch (err: any) {
    // Par exemple, si l'utilisateur n'est pas admin, le message d'erreur est personnalisé
    error.value = err.message || 'Une erreur est survenue lors de la connexion.';
  }
};

function navigateTo(path: string) {
  router.push(path);
}
</script>
