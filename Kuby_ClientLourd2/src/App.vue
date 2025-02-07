<template>
  <v-app>
    <Menu />
    <v-main>
      <router-view />
    </v-main>
  </v-app>
</template>

<script setup lang="ts">
import Menu from '@/components/Utils/Menu.vue'
import { computed, onMounted } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()

</script>
