<template>
    <div class="mx-10 my-10" style="width: 11vw;">
        <button style="background: none; border: none; padding: 0;">
            <img src="../../assets/images/Bottle.png" style=" height: 450; cursor: pointer;">
        </button>
        <div class="mt-2">
            <div class="text-h6 " style="min-height: 4rem; max-height: 4rem; overflow: hidden">{{ product.article_name }}</div>
            <v-row>
                <v-col cols="12" md="6">
                    <div class="text-body-1">{{ product.article_grape }}</div>
                    <div class="text-body-1">{{ product.article_price }} €</div>
                </v-col>
                <v-col cols="12" md="6">
                    <div class="text-body-1 text-center">{{ product.article_yearprod }}</div>
                </v-col>
            </v-row>
            <div class="mt-1">
                <input class="py-1 ms-1" id="number" type="number" min="1" v-model="quantity" style="width: 35%;" />
                <v-btn class="mb-1 ms-4" variant="plain" color="primary" @click="addToCart">Ajouter</v-btn>
            </div>
        </div>
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
        alert(`${quantity.value} × ${props.product.title} ajouté(s) au panier.`);
        quantity.value = 1; // Réinitialiser la quantité après l'ajout
    }
};
</script>