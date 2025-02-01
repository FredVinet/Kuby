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
            <span>{{sumBottle}} €</span>
        </v-row>
        <v-row justify="space-between" class="mb-3">
            <span>Livraison :</span>
            <span>{{deliveryPrice}} €</span>
        </v-row>
        <v-divider class="my-3"></v-divider>
        <v-row justify="space-between" class="mb-1">
            <span class="text-subtitle-1 text-info font-weight-bold">Total :</span>
            <span class="text-subtitle-1 text-info font-weight-bold">{{sumTotal}}€</span>
        </v-row>
        </v-card-text>
        <v-row justify="center" class="my-5">
            <v-btn color="primary"  width="80%">
                Payer ma commande
            </v-btn>
        </v-row >
    </v-card>
</template>

<script setup lang="ts">

    import Product from '@/views/Product.vue';
    import { ref,defineProps } from 'vue';

    const props = defineProps({
        products: {
        type: Array,
        },
    });

    let sumBottle = ref(0);
    let deliveryPrice = ref(15);
    let sumTotal = ref(0);

    for(let i = 0; i< props.products.length ; i++){
        sumBottle.value += props.products[i].price * props.products[i].quantity;    
    }

    sumTotal.value = sumBottle.value + deliveryPrice.value;

</script>