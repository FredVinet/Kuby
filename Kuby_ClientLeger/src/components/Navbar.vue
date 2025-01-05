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
        <v-btn variant="plain" class="me-10" @click="navigateTo('/account')">Compte</v-btn>
        <v-btn variant="plain" class="me-10" @click="navigateTo('/cart')">Panier</v-btn>
    </v-col>
</v-row>
</v-app-bar>
</template>

<script setup lang="ts">

import { useRouter } from 'vue-router';
import { ref } from 'vue';

const router = useRouter();

function navigateTo(path) {
    router.push(path);
}


</script>