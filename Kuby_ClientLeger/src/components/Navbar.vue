<template>
<v-app-bar fixed height="120">
<v-row class="d-flex align-center ">
    <v-col class="d-flex">
        <v-btn variant="plain" class="ms-10" @click="navigateTo('/catalogue')">Catalogue</v-btn>
    </v-col>
    <v-col class="d-flex justify-center mt-2">
        <button style="background: none; border: none; padding: 0;" @click="navigateTo('/')">
            <img src="../assets/images/Logo1.png" style="width: 7vw;  cursor: pointer;">
        </button>    
    </v-col>
    <v-col class="d-flex justify-end">
        <div v-if="isAuthenticated">
            <v-btn variant="plain" class="me-10" @click="navigateTo('/account')">Compte</v-btn>
            <v-btn variant="plain" class="me-10" @click="navigateTo('/cart')">Panier</v-btn>
            <v-btn variant="plain" class="me-10"  @click="logout">Deconnexion</v-btn>
        </div>
        <div v-else>
            <v-btn variant="plain" class="me-10" @click="navigateTo('/connexion')">Connexion</v-btn>
        </div>
    </v-col>
</v-row>
</v-app-bar>
</template>

<script setup lang="ts">

import { useRouter } from 'vue-router';
import { computed, ref, watchEffect, onMounted, onUnmounted } from 'vue';
import { isTokenValid } from '@/utils/auth';
import { useUserConnectedStore } from '@/stores/userConnected';

const userConnectedStore = useUserConnectedStore()

const token = ref(localStorage.getItem('authToken'));

const updateToken = () => {
  token.value = localStorage.getItem('authToken');
};

const isAuthenticated = computed(() => token.value && isTokenValid(token.value));

const router = useRouter();

function navigateTo(path) {
    router.push(path);
}

// Vérification automatique toutes les 500ms
let intervalId: number;

onMounted(() => {
  intervalId = setInterval(updateToken, 100);
});

onUnmounted(() => {
  clearInterval(intervalId);
});
function logout() {
  userConnectedStore.clearUserInfo();
  navigateTo("/connexion")
}

</script>