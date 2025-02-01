<template>  
        <ArticleProduct />
        <TitleComponentProduct :title="title" />
        <DescriptionProduct />
        <TitleComponentProduct :title="title2" />

        <div class="d-flex justify-center align-center bg-secondary" style="height: 75vh;">
            <ArticleMain />
            <ArticleMain />
            <ArticleMain />
        </div>

        <div class="my-15 pt-3 pb-15">
            <TitleComponentProduct :title="title3"/>
            <div class="d-flex justify-center">
                <v-btn color="primary" size="x-large" @click="navigateTo('/catalogue')">
                Revenir au catalogue        
                </v-btn>
            </div>
        </div>
  </template>
  
  <script setup lang="ts">
  
    import ArticleMain from '@/components/card/ArticleMain.vue';
import ArticleProduct from '@/components/card/ArticleProduct.vue';
    import DescriptionProduct from '@/components/card/DescriptionProduct.vue';
    import TitleComponentProduct from '@/components/title/TitleComponentProduct.vue';
    import { ref } from 'vue';
  
    const title = ref("Description");
    const title2 = ref("Les vins dans le même genre");
    const title3 = ref("D’autre vin vous attendent");

  </script>