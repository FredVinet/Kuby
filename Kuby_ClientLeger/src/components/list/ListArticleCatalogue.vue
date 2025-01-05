<template>
    <div v-for="n in Math.ceil(products.length / 5)" :key="'group-' + n" class="d-flex justify-center mx-5">
        <ArticleCatalogue
            v-for="(product, index) in products.slice((n - 1) * 5, n * 5)"
            :key="'product-' + index"
            :product="product"
        />
    </div>
</template>
    
<script setup>
    import ArticleCatalogue from '../../components/card/ArticleCatalogue.vue';

    import { ref } from 'vue';

    const products = ref([
        { title: "Château Margaux", wine: "Rouge", price: 500 },
        { title: "Château Latour", wine: "Rouge", price: 450 },
        { title: "Clos Saint Denis", wine: "Rouge", price: 350 },
        { title: "Hermitage La Chapelle", wine: "Rouge", price: 300 },
        { title: "Château de Beaucastel", wine: "Blanc", price: 200 },
        { title: "Domaine Leroy", wine: "Rouge", price: 600 },
        { title: "Petrus", wine: "Rouge", price: 2200 },
        { title: "Le Montrachet", wine: "Blanc", price: 400 },
        { title: "Sauternes", wine: "Blanc", price: 150 },
        { title: "Côte Rôtie", wine: "Rouge", price: 250 },
        { title: "Château Haut-Brion", wine: "Rouge", price: 350 },
        { title: "Château Cheval Blanc", wine: "Rouge", price: 500 },
        { title: "Chablis Grand Cru", wine: "Blanc", price: 180 },
        { title: "Barolo", wine: "Rouge", price: 300 },
        { title: "Amarone della Valpolicella", wine: "Rouge", price: 350 },
        { title: "Champagne Dom Pérignon", wine: "Mousseux", price: 450 },
        { title: "Tokaji Aszú", wine: "Doux", price: 250 },
        { title: "Rioja", wine: "Rouge", price: 100 },
        { title: "Pouilly-Fumé", wine: "Blanc", price: 120 },
        { title: "Château d'Yquem", wine: "Doux", price: 650 }
    ]);
    
</script>