<template>  
    <v-container>
      <TitleComponent :title="title"/>

      <Order />
      <Adresse />
      
    </v-container>
  </template>
  
  <script setup lang="ts">
  
  import { ref } from 'vue';
  import TitleComponent from '@/components/title/TitleComponent.vue'
  import Order from '@/components/card/Order.vue';
import Adresse from '@/components/card/Adresse.vue';

  const title = ref("Votre compte");
  
  </script>