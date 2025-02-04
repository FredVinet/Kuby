<template>
    <div v-for="n in Math.ceil(products.length / 5)" :key="'group-' + n" class="d-flex justify-center mx-5">
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
import type { Article } from '@/api/interfaces/Article'
import ArticleService from '../../api/services/ArticlesService'; // Assurez-vous que le chemin est correct

const products = ref<Article[]>([]);

onMounted(async () => {
    try {
        // Récupérer les articles depuis le service
        const articles = await ArticleService.getAllArticles();

        // Mapper les articles vers le format attendu par ArticleCatalogue
        products.value = articles.map((article) => ({
            article_id: article.article_id,         // article.article_id → article.article_id
            article_name: article.article_name,            // article.article_name → article.title
            article_description: article.article_description, // article.article_description → article.article_description
            article_grape: article.article_grape,            // article.article_grape → article.wine
            article_yearprod: article.article_yearprod,         // article.article_yearprod → article.year
            article_price: article.article_price,                   // article.price (déjà parsé par parseArticlesDetails)
            id_family: article.id_family,           // article.id_family → article.id_family
            id_grape: article.id_grape,             // article.id_grape → article.id_grape
        }));
    } catch (error) {
        console.error('Error fetching articles:', error);
    }
});
</script>