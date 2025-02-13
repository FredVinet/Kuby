<template>
    <div class="card-container ml-4 mb-4" style="width: 350px; border: 1px solid #e0e0e0; border-radius: 8px; padding: 12px;">
      <v-row no-gutters align="start">
        <v-col cols="4">
          <img
            src="../../assets/images/Bottle.png"
            style="height: 150px; border-radius: 8px; width: 100%; object-fit: cover;"
            alt="Product Image"
          />
        </v-col>
  
        <v-col cols="8" class="pl-4">
          <div class="text-h6 font-weight-bold" style="color: #2c3e50;">
            {{ product.article_name }}
          </div>
  
          <div class="text-body-1 font-weight-medium" style="color: #7f8c8d;">
            {{ product.article_yearprod }}
          </div>
  
          <div class="text-body-1 font-weight-bold mt-4" style="color: #27ae60;">
            {{ product.article_price }} €
          </div>
  
          <v-row align="center">
            <v-col cols="8">
              <v-text-field
                v-model="quantity"
                type="number"
                min="1"
                density="compact"
                variant="outlined"
                hide-details
                style="max-width: 100px;"
              />
            </v-col>
  
            <v-col cols="4">
              <v-btn
                class="bg-primary"
                icon
                variant="flat"
                @click="addToCart"
              >
                <v-icon>mdi-cart</v-icon>
              </v-btn>
            </v-col>
          </v-row>
        </v-col>
      </v-row>
    </div>
  </template>
  
  <script setup lang="ts">
  import { ref } from 'vue';
  import { useCartStore } from '@/stores/cartStore';
  
  const cartStore = useCartStore();
  const quantity = ref(1);
  
  const props = defineProps({
    product: {
      type: Object,
      required: true,
    },
  });
  
  const addToCart = () => {
    if (quantity.value > 0) {
      cartStore.addToCart(props.product, quantity.value);
      alert(`${quantity.value} × ${props.product.article_name} ajouté(s) au panier.`);
      quantity.value = 1;
    }
  };
  </script>
  
  <style scoped>
  .card-container {
    transition: box-shadow 0.3s ease;
  }
  
  .card-container:hover {
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  }
  </style>