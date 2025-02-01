<template>  
  <v-container>
    
    <TitleComponent :title="title" :msg="msg"/>


    <v-row class="my-5">
      <v-col cols="12" md="8">
        <ListArticleCart :products="products"/>

        </v-col>
        <v-col>
          <ReviewCart :products="products"/>
        </v-col>
      </v-row>
  </v-container>

</template>
  
<script setup lang="ts">
  import TitleComponent from '@/components/title/TitleComponent.vue';
  import ArticleCart from '@/components/card/ArticleCart.vue';
  import ReviewCart from '@/components/card/ReviewCart.vue';
  import { ref } from 'vue';
  import ListArticleCart from '@/components/list/ListArticleCart.vue';
  
  const title = ref("Votre Panier");
  const msg = ref("Merci de nous faire confiance");

  const products = ref([
    {
      title: "Château Margaux",
      wine: "Rouge",
      price: 500,
      year: 2015,
      grape: "Cabernet Sauvignon",
      quantity: 3
    },
    {
      title: "Château Latour",
      wine: "Rouge",
      price: 450,
      year: 2018,
      grape: "Merlot",
      quantity: 6
    },
    {
      title: "Clos Saint Denis",
      wine: "Rouge",
      price: 350,
      year: 2012,
      grape: "Pinot Noir",
      quantity: 3
    },
    {
      title: "Hermitage La Chapelle",
      wine: "Rouge",
      price: 300,
      year: 2017,
      grape: "Syrah",
      quantity: 12
    },
    {
      title: "Château de Beaucastel",
      wine: "Blanc",
      price: 200,
      year: 2020,
      grape: "Roussanne",
      quantity: 1
    }
  ]);
  
</script>