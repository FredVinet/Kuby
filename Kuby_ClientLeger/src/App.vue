<template>
  <v-app>
    <v-main >
      <Navbar />
      <router-view />
      <Footer />
    </v-main>
  </v-app>
</template>

<script setup lang="ts">
import Navbar from '@/components/Navbar.vue';
import Footer from '@/components/Footer.vue';
import { onMounted } from 'vue'
import { useCartStore } from '@/stores/cartStore'
import { useUserConnectedStore } from './stores/userConnected'
import { useRoute } from 'vue-router'

const userConnectedStore = useUserConnectedStore()

onMounted(() => {
  userConnectedStore.initializeFromToken()
  const cartStore = useCartStore()
  const savedCart = JSON.parse(sessionStorage.getItem('cart') || '[]')
  if (savedCart.length) {
    cartStore.cart = savedCart
  }
})
</script>
