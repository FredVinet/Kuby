<template>
    <v-navigation-drawer>
      <v-img
        :width="150"
        aspect-ratio="16/9"
        cover
        :src="Logo" 
        class="mx-auto mt-5"
      ></v-img>     

      <v-divider class="my-3"></v-divider>
      <v-list-item
        v-for="item in menuItems"
        :key="item.title"
        :title="item.title"
        @click="navigate(item.path)"
        class="my-2"
      ></v-list-item>
      <v-divider></v-divider>
    </v-navigation-drawer>
  </template>
  
  <script setup lang="ts">
  import { ref } from 'vue';
  import { useRouter } from 'vue-router';
  import Logo from '@/assets/icons/Logo1.png'

  
  const menuItems = ref([
    { title: 'Gestion du Stock',  path: '/' },
    { title: 'Liste Client', path: '/clientslist' }, 
    { title: 'Liste Fournisseur', path: '/supplierslist' },
    { title: 'Commande Client', path: '/clientsorders' },
    { title: 'Commande Fournisseur', path: '/suppliersorders' },
    { title: 'Connexion', path: '/connexion' },
  ]);
  
  const router = useRouter();
  
  const navigate = (path: string) => {
    router.push(path);
  };
  </script>