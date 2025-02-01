<template>
        <ArticleCart
            v-for="(product, index) in products"
            :key="index"
            :product="product"
        />
</template>
    
<script setup>

    import { ref } from 'vue';
    import ArticleCart from '../card/ArticleCart.vue';

    import { defineProps } from 'vue';

    const props = defineProps({
        products: {
        type: Array,
        },
    });


    
</script>