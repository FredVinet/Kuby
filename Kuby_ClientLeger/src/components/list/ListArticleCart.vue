<template>
    <ArticleCart
      v-for="(item, index) in cartItems"
      :key="item.product.article_id"
      :product="item.product"
      :quantity="item.quantity"
      @update-quantity="updateQuantity"
      @remove="removeFromCart"
    />
  </template>
  
  <script setup lang="ts">
  import { defineProps } from 'vue';
  import ArticleCart from '../card/ArticleCart.vue';
  import { useCartStore } from '@/stores/cartStore';
  
  const props = defineProps({
    cartItems: {
      type: Array,
      required: true,
    },
  });
  
  const cartStore = useCartStore();
  
  const updateQuantity = (productId: number, quantity: number) => {
    cartStore.updateQuantity(productId, quantity);
  };
  
  const removeFromCart = (productId: number) => {
    cartStore.removeFromCart(productId);
  };
  </script>