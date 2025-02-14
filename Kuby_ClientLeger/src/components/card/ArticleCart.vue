<template>
    <v-card class="mb-4 mx-auto" elevation="5" max-width="90%" border="opacity-50 md info" rounded="">
      <v-row align="center" justify="space-between">
        <v-col cols="5">
          <div class="my-5">
            <h3 class="product-name">{{ product.article_name }}</h3>
            <p class="product-description">{{ product.article_description }}</p>
            <h2 class="product-price">{{ product.article_price }}€</h2>
          </div>
        </v-col>
        <v-col cols="4" class="d-flex align-center justify-space-evenly">
          <v-text-field
            v-model.number="localQuantity"
            type="number"
            min="0"
            max-width="60%"
            @change="onQuantityChange"
          />
          <v-btn icon small color="error" class="mb-5" @click="onRemove">
            <v-icon>mdi-delete</v-icon>
          </v-btn>
        </v-col>
      </v-row>
    </v-card>
  </template>
  
  <script setup lang="ts">
  import { defineProps, ref, watch } from 'vue';
  import { useCartStore } from '@/stores/cartStore';
  
  const props = defineProps({
    product: {
      type: Object,
      required: true,
    },
    quantity: {
      type: Number,
      required: true,
    },
  });
  
  const emit = defineEmits(['update-quantity', 'remove']);
  const localQuantity = ref(props.quantity);
  
  const onQuantityChange = () => {
    emit('update-quantity', props.product.article_id, Number(localQuantity.value));
  };
  
  const onRemove = () => {
    emit('remove', props.product.article_id);
  };
  
  watch(
    () => props.quantity,
    (newQuantity) => {
      localQuantity.value = newQuantity;
    },
  );
  </script>