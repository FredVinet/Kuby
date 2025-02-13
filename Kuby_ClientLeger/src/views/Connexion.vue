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
          <v-btn color="primary" @click="attemptLogin">Se Connecter</v-btn>
          <AddUser />
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
import { jwtDecode } from 'jwt-decode'
import AuthService from '@/api/services/AuthService'
import AddUser from '@/components/Modal/AddUser.vue'
import { useUserConnectedStore } from '@/stores/userConnected' // Importez le store
import { useRouter } from 'vue-router'
import { getIds } from '@/utils/auth'

interface DecodedToken {
  iss: string
  iat: number
  exp: number
  userId: number
  email: string
}

const userConnectedStore = useUserConnectedStore()
const userConnected = userConnectedStore.userDetails

const title = ref("Connexion")
const msg = ref("Connectez-vous pour commencer vos achats")

const email = ref('')
const password = ref('')
const error = ref('')

const isAuthenticated = ref(false)
const userProfile = ref<DecodedToken | null>(null)



const attemptLogin = async () => {
try {
  error.value = ''
  const { user, token } = await AuthService.login(email.value, password.value)

  if (token != null) {
    localStorage.setItem('authToken', token)

    const decodedToken: DecodedToken = jwtDecode(token)
    const currentTime = Math.floor(Date.now() / 1000)

    if (decodedToken.exp > currentTime) {
      isAuthenticated.value = true
      userProfile.value = decodedToken
      

      const Ids = getIds(token)
      userConnectedStore.setUserInfo(Ids.userId)

      navigateTo('/')
    }
  }
} catch (err: any) {
  error.value = err.message || 'Une erreur est survenue lors de la connexion.'
  console.error(error.value)
}
}

const createAccount = async () => {
try {
  error.value = ''
  const { user, token } = await AuthService.login(email.value, password.value)

  if (token != null) {
    localStorage.setItem('authToken', token)

    const decodedToken: DecodedToken = jwtDecode(token)
    const currentTime = Math.floor(Date.now() / 1000)

    if (decodedToken.exp > currentTime) {
      isAuthenticated.value = true
      userProfile.value = decodedToken
      

      const Ids = getIds(token)
      userConnectedStore.setUserInfo(Ids.userId)

      navigateTo('/')
    }
  }
} catch (err: any) {
  error.value = err.message || 'Une erreur est survenue lors de la connexion.'
  console.error(error.value)
}
}

const router = useRouter();

function navigateTo(path) {
  router.push(path);
}

// Méthode de déconnexion

</script>

