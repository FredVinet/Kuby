<template>
  <v-col cols="3" class="card-container" style="border: 1px solid #e0e0e0;">
    <v-row >
      <v-col cols="4">
        <router-link :to="`/product/${product.article_id}`" style="text-decoration: none; color: inherit;">
          <img
            src="../../assets/images/Bottle.png"
            style="height: 15rem; width: 100%; object-fit: cover; "
            alt="Product Image"
          />
        </router-link>
      </v-col>
      <v-col cols="8" class="pl-4">
        <div class="text-h6 font-weight-bold overflow-hidden" style="color: #2c3e50; height: 3.5rem;">
          {{ product.article_name }}
        </div>
  
        <div class="text-body-1 font-weight-medium mt-2 accent">
          {{ product.article_yearprod }}
        </div>
  
        <!-- Affichage conditionnel de la grape -->
        <div v-if="grape" class="text-body-1 font-weight-medium mt-1" style="color: #7f8c8d;">
          {{ grape.grape_name }}
        </div>
  
        <!-- Affichage conditionnel de la famille -->
        <div v-if="family" class="text-body-1 font-weight-medium mt-1" style="color: #7f8c8d;">
          {{ family.family_name }}
        </div>
  
        <div class="text-body-1 font-weight-bold mt-2">
          {{ product.article_price }} €
        </div>
  
        <v-row align="center" class="mt-1">
          <v-col cols="8">
            <v-text-field
              v-model.number="quantity"
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
              @click.stop="addToCart"
            >
              <v-icon>mdi-cart</v-icon>
            </v-btn>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
</v-col>
  <v-snackbar v-model="alertCart.show" :timeout="3000" color="primary" location="bottom right">
    {{ alertCart.message }}
    <template #actions>
      <v-btn @click="alertCart.show = false">OK</v-btn>
    </template>
  </v-snackbar>
</template>
  
<script setup lang="ts">
import { onMounted, reactive, ref } from 'vue';
import { useCartStore } from '@/stores/cartStore';
import GrapeService from '@/api/services/GrapeService';
import FamilyService from '@/api/services/FamilyService';
  
const cartStore = useCartStore();
const quantity = ref(1);
const alertCart = reactive({ show: false, message: '' });
  
const grape = ref<any>(null);
const family = ref<any>(null);
  
const props = defineProps({
  product: {
    type: Object,
    required: true,
  },
});
  
const addToCart = () => {
  if (quantity.value > 0) {
    cartStore.addToCart(props.product, Number(quantity.value));
    alertCart.message = `${quantity.value} × ${props.product.article_name} (${props.product.article_yearprod}) ajouté(s) au panier.`;
    alertCart.show = true;
    quantity.value = 1;
  }
};
  
onMounted(async () => {
  try {
    if (props.product.id_grape) {
      grape.value = await GrapeService.getGrapeById(props.product.id_grape);
    }
    if (props.product.id_family) {
      family.value = await FamilyService.getFamilyById(props.product.id_family);
    }
  } catch (error) {
    console.error("Erreur lors de la récupération des informations :", error);
  }
});
</script>
  
<style scoped>
.card-container {
  transition: box-shadow 0.3s ease;
}
  
.card-container:hover {
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}
</style>
