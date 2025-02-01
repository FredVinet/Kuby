<template>  
      <TitleComponent :title="title" :msg="msg"/>
      
      <ListArticleCatalogue />

</template>
  
<script setup lang="ts">
  
  import ArticleCatalogue from '@/components/card/ArticleCatalogue.vue';
  import ListArticleCatalogue from '@/components/list/ListArticleCatalogue.vue';
  import TitleComponent from '@/components/title/TitleComponent.vue'
  import { ref } from 'vue';
  
  const title = ref("Notre catalogue");
  const msg = ref("Découvrez l’ensemble de nos vins ");
  
  
</script>