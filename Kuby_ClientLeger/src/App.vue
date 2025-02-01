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

</script>
