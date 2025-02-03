<template>
    <div v-for="n in Math.ceil(products.length / 5)"  :key="'group-' + n" class="d-flex justify-center mx-5">
        <ArticleCatalogue
        v-for="(product, index) in products.slice((n - 1) * 5, n * 5)"
            :key="'product-' + index"
            :product="product"
        />
    </div>
</template>

<script setup lang="ts">
import ArticleCatalogue from '../../components/card/ArticleCatalogue.vue';
import { ref, onMounted } from 'vue';
import { ArticleService } from '../../api/services/ArticlesService'; // Assurez-vous que le chemin est correct

const products = ref([]);

onMounted(async () => {
    try {
        const response = await ArticleService.getAllArticles();
        // Mapper les données de l'API vers le format attendu par ArticleCatalogue
        products.value = response.map((article: { article_name: any; article_grape: any; article_price: any; article_yearprod: any; }) => ({
            title: article.article_name,       // article.article_name → article.title
            wine: article.article_grape,       // article.article_grape → article.wine
            price: article.article_price,      // article.article_price → article.price
            year: article.article_yearprod     // article.article_yearprod → article.year
        }));
    } catch (error) {
        console.error('Error fetching articles:', error);
    }
});
</script>