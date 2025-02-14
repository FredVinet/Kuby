<template>
    <v-container>
      <v-row class="my-10">
        <v-col cols="12" md="6" class="text-center">
          <img src="../../assets/images/Bottle.png" class="text-end" style="width: 25rem;" />
        </v-col>
        <v-col cols="12" md="6">
          <div class="text-h2 border-article" style="width: 85%;">{{ product.article_name }}</div>
          <div class="text-h5 my-5">{{ product.article_price }} €</div>
          <div class="text-h5 marging-product">{{ product.article_type }}</div>
          <div class="text-h5 mt-1">{{ product.article_variety }}</div>
          <div class="text-h5 mt-1">{{ product.article_region }}, {{ product.article_country }}</div>
          <div class="text-h5 mt-1">Année de production {{ product.article_yearprod }}</div>
          <div class="mt-1">
            <input class="py-1 ms-1" id="number" type="number" min="1" value="1" style="width: 25%;" />
            <v-btn rounded="lg" size="x-large" class="bg-primary mb-1 mx-15" width="50%">
              Ajouter au panier
            </v-btn>
          </div>
        </v-col>
      </v-row>
    </v-container>
  </template>
  
  <script setup lang="ts">
  import { defineProps } from 'vue';
  
  const props = defineProps({
    product: {
      type: Object,
      required: true,
    },
  });
  </script>
  
  <style scoped>
  .text-h2 {
    font-family: 'Tan Pearl', sans-serif;
  }
  
  .border-article {
    border-bottom: 0.4rem solid #d1a671;
  }
  
  .marging-product {
    margin-top: 11rem;
  }
  </style>