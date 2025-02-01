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
        { title: "Château Margaux", wine: "Rouge", price: 500, year:2004 },
        { title: "Château Latour", wine: "Rouge", price: 450, year:2004 },
        { title: "Clos Saint Denis", wine: "Rouge", price: 350, year:2004 },
        { title: "Hermitage La Chapelle", wine: "Rouge", price: 300, year:2004 },
        { title: "Château de Beaucastel", wine: "Blanc", price: 200, year:2004 },
        { title: "Domaine Leroy", wine: "Rouge", price: 600, year:2004 },
        { title: "Petrus", wine: "Rouge", price: 2200, year:2004 },
        { title: "Le Montrachet", wine: "Blanc", price: 400, year:2004 },
        { title: "Sauternes", wine: "Blanc", price: 150, year:2004 },
        { title: "Côte Rôtie", wine: "Rouge", price: 250, year:2004 },
        { title: "Château Haut-Brion", wine: "Rouge", price: 350, year:2004 },
        { title: "Château Cheval Blanc", wine: "Rouge", price: 500, year:2004 },
        { title: "Chablis Grand Cru", wine: "Blanc", price: 180, year:2004 },
        { title: "Barolo", wine: "Rouge", price: 300, year:2004 },
        { title: "Amarone della Valpolicella", wine: "Rouge", price: 350, year:2004 },
        { title: "Champagne Dom Pérignon", wine: "Mousseux", price: 450, year:2004 },
        { title: "Tokaji Aszú", wine: "Doux", price: 250, year:2004 },
        { title: "Rioja", wine: "Rouge", price: 100, year:2004 },
        { title: "Pouilly-Fumé", wine: "Blanc", price: 120, year:2004 },
        { title: "Château d'Yquem", wine: "Doux", price: 650 }
    ]);
    
</script>