<template>  
  <v-container>
    <TitleComponent :title="title" :msg="msg" />
    <v-row class="my-5">
      <v-col cols="12" md="8">
        <ListArticleCart :cart-items="cartStore.cartItems" />
      </v-col>
      <v-col>
        <ReviewCart />
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup lang="ts">
import TitleComponent from '@/components/title/TitleComponent.vue';
import ListArticleCart from '@/components/list/ListArticleCart.vue';
import ReviewCart from '@/components/card/ReviewCart.vue';
import { ref } from 'vue';
import { useCartStore } from '@/stores/cartStore';

const cartStore = useCartStore();

const title = ref("Votre Panier");
const msg = ref("Merci de nous faire confiance");
</script>