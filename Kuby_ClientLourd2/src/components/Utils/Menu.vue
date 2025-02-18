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
      v-for="item in dynamicMenuItems"
      :key="item.title"
      :title="item.title"
      @click="item.action ? item.action() : navigate(item.path)"
      class="my-2"
    ></v-list-item>
    <v-divider></v-divider>
  </v-navigation-drawer>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue';
import { useRouter } from 'vue-router';
import Logo from '@/assets/icons/Logo1.png';
import { useUserConnectedStore } from '@/stores/userConnected';

const userConnectedStore = useUserConnectedStore();
const router = useRouter();

// Liste de base des éléments du menu
const baseMenuItems = ref([
  { title: 'Gestion du Stock', path: '/' },
  { title: 'Liste Client', path: '/clientslist' },
  { title: 'Liste Fournisseur', path: '/supplierslist' },
  { title: 'Commande Client', path: '/clientsorders' },
  { title: 'Commande Fournisseur', path: '/suppliersorders' },
]);

// Propriété calculée pour générer la liste dynamique des éléments du menu
const dynamicMenuItems = computed(() => {
  const items = [...baseMenuItems.value];

  if (userConnectedStore.userId && userConnectedStore.userRole == 'admin') {
    // Si l'utilisateur est connecté, ajouter le bouton de déconnexion
    items.push({ title: 'Déconnexion', action: logout });
  } else {
    // Si l'utilisateur n'est pas connecté, ajouter le bouton de connexion
    items.push({ title: 'Connexion', path: '/connexion' });
  }

  return items;
});

// Fonction de déconnexion
const logout = () => {
  localStorage.removeItem('authToken');
  userConnectedStore.clearUserInfo();
  router.push('/connexion');
};

// Fonction de navigation
const navigate = (path: string) => {
  router.push(path);
};
</script>