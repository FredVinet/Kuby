
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
    <v-btn color="primary">Se Connectez</v-btn>
    <v-btn color="primary">Premiere connexion</v-btn>
    </div>
    </v-form>
    </v-card>
    
    </template>
    <script setup lang="ts">
    import TitleComponent from '@/components/title/TitleComponent.vue'
    import { ref } from 'vue';
    const title = ref("Connexion");
    const msg = ref("Connectez vous pour commencer vos achats");
    
    </script>