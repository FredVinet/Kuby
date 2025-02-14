<template>
    <v-container>
      <v-row class="my-10">
        <!-- Image -->
        <v-col cols="12" md="6" class="text-center">
          <img src="../../assets/images/Bottle.png" class="text-end" style="width: 25rem;" />
        </v-col>
  
        <!-- Contenu texte -->
        <v-col cols="12" md="6" class="d-flex flex-column justify-space-between">
          <div>
            <div class="text-h2 border-article mb-4" style="width: 85%;">
              {{ product.article_name }}, {{ product.article_yearprod }}
            </div>
            
            <!-- Informations sur le cépage et la famille -->
            <div v-if="grape" class="text-h6 mt-4">Cépage : {{ grape.grape_name }}</div>
            <div v-if="grape" class="text-body-1">{{ grape.grape_description }}</div>
            <div v-if="family" class="text-h6 mt-4">Famille : {{ family.family_name }}</div>
            <div v-if="family" class="text-body-1">{{ family.family_description }}</div>
          </div>
  
          <!-- Bloc Prix + Quantité + Bouton -->
          <div class="mt-auto pt-10">
            <div class="text-h5">{{ product.article_price }} €</div>
            <div class="d-flex align-center ">
                <v-text-field
                    v-model.number="quantity"
                    type="number"
                    min="1"
                    density="compact"
                    variant="outlined"
                    hide-details
                    class="mr-6"
                    style="max-width: 100px;"
                />
              <v-btn @click.stop="addToCart" rounded="lg" size="x-large" class="bg-primary" width="50%">
                Ajouter au panier
              </v-btn>
            </div>
          </div>
        </v-col>
      </v-row>

      <v-snackbar v-model="alertCart.show" :timeout="3000" color="primary" location="bottom right">
            {{ alertCart.message }}
            <template #actions>
            <v-btn @click="alertCart.show = false">OK</v-btn>
            </template>
        </v-snackbar>
    </v-container>
  </template>
  
  <script setup lang="ts">
  import { useCartStore } from '@/stores/cartStore';
import { defineProps, reactive, ref } from 'vue';
  
  const props = defineProps({
    product: {
      type: Object,
      required: true,
    },
    grape: {
      type: Object,
      required: true,
    },
    family: {
      type: Object,
      required: true,
    },
  });

  const cartStore = useCartStore();
  const quantity = ref(1);
  const alertCart = reactive({ show: false, message: '' })

  const addToCart = () => {
    if (quantity.value > 0) {
      cartStore.addToCart(props.product, Number(quantity.value));
      alertCart.message = `${quantity.value} × ${props.product.article_name} (${props.product.article_yearprod}) ajouté(s) au panier.`
      alertCart.show = true
      quantity.value = 1;
    }
  };

  </script>
  
  <style scoped>
  .text-h2 {
    font-family: 'Tan Pearl', sans-serif;
  }
  
  .border-article {
    border-bottom: 0.4rem solid #d1a671;
  }

  input {
  border: 1px solid #ccc;
  border-radius: 5px;
}
  </style>