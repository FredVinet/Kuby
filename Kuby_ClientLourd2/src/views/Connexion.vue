<template>
    <v-container>
      <BigTitle :title="title" />
      <v-card
        elevation="16"
        max-width="100%"
        border="opacity-50 md info"
        rounded="lg"
        class="mx-auto my-8"
      >
        
      </v-card>
    </v-container>
</template>

<script setup lang="ts">
  import { useRouter } from 'vue-router'
  import BigTitle from '@/components/Titles/BigTitle.vue';
  import { ref } from 'vue';
    
  const title = ref('Connexion');
</script>

<style scoped>

</style>

  