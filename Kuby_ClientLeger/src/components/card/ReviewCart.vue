<template>
    <v-card 
        class="mb-4"
        elevation="5"
        max-width="100%"
        border="opacity-25 md info"
    >
        <v-card-title class="font-weight-bold mb-3">
            <h4 class="text-info">Résumé de la commande</h4>
        </v-card-title>
        <v-card-text class="mx-2">
            <v-row justify="space-between" class="my-3">
                <span>Sous-total :</span>
                <span>{{ formatPrice(totalPrice) }} €</span> <!-- Utilisation de formatPrice -->
            </v-row>
            <v-row justify="space-between" class="mb-3">
                <span>Livraison :</span>
                <span>{{ formatPrice(deliveryPrice) }} €</span> <!-- Utilisation de formatPrice -->
            </v-row>
            <v-divider class="my-3"></v-divider>
            <v-row justify="space-between" class="mb-1">
                <span class="text-subtitle-1 text-info font-weight-bold">Total :</span>
                <span class="text-subtitle-1 text-info font-weight-bold">{{ formatPrice(totalWithDelivery) }} €</span> <!-- Utilisation de formatPrice -->
            </v-row>
        </v-card-text>
        <v-row justify="center" class="my-5">
            <v-btn color="primary" width="80%">
                Payer ma commande
            </v-btn>
        </v-row>
        <v-row justify="center" class="my-3">
            <v-btn color="error" width="80%" @click="clearCart">
                Vider le panier
            </v-btn>
        </v-row>
    </v-card>
</template>

<script setup lang="ts">
import { computed, ref } from 'vue';
import { useCartStore } from '@/stores/cartStore';

const cartStore = useCartStore();

// Récupérer le prix total du panier depuis le store
const totalPrice = computed(() => {
  const total = cartStore.totalPrice;
  return isNaN(total) ? 0 : total; // Retourne 0 si total est NaN
});

// Prix de la livraison
const deliveryPrice = ref(15);

// Calcul du total avec la livraison
const totalWithDelivery = computed(() => {
  const total = totalPrice.value + deliveryPrice.value;
  return isNaN(total) ? 0 : total; // Retourne 0 si total est NaN
});

// Fonction pour formater le prix (évite NaN et formate à 2 décimales)
const formatPrice = (price: number) => {
  return isNaN(price) ? '0.00' : price.toFixed(2);
};

// Fonction pour vider le panier
const clearCart = () => {
  cartStore.clearCart();
};
</script>