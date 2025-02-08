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
            <v-btn color="primary" width="80%" @click="checkout(totalWithDelivery)">
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
import { computed, ref, reactive } from 'vue';
import { useCartStore } from '@/stores/cartStore';
import type { Orders } from '@/api/interfaces/Orders';
import OrdersService from '@/api/services/OrdersService';
import OrderItemService from '@/api/services/OrderItemService';

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

const newOrder = reactive<Orders>({
  orders_date: new Date(),
  orders_status: 'placed',
  orders_amount: 0,
  id_localisation: 1,
})

async function checkout(orderTotal: number) {
  try {
    newOrder.orders_amount = orderTotal

    const createdOrder = await OrdersService.createOrder(newOrder)
    if (!createdOrder || !createdOrder.orders_id) {
      throw new Error('Erreur lors de la création de la commande.')
    }
    const orderId = createdOrder.orders_id

    const orderItems = cartStore.cartItems.map((cartItem) => ({
        id_order: orderId,
        id_article: cartItem.product.article_id,
        order_items_quantity: cartItem.quantity,
        unit_price: cartItem.product.article_price,
    }))
    for (const item of orderItems) {
      await OrderItemService.createOrderItem(item)
    }

    cartStore.clearCart()
  } catch (error) {
    console.error('Erreur lors de l’ajout de la commande ou des items :', error)
  }
}
</script>