<template>
    <div v-if="article" class="mx-10 my-10" style="width: 18vw">
      <button style="background: none; border: none; padding: 0; width: 100%">
        <router-link :to="`/product/${article.article_id}`">
          <img
            src="../../assets/images/Bottle.png"
            style="width: 100%; cursor: pointer;"
            alt="Product Image"
          />
        </router-link>
      </button>
      <div class="mt-2">
        <div class="text-h6" style="min-height: 4rem; max-height: 4rem; overflow: hidden">{{ article.article_name }}</div>
        <v-row>
          <v-col cols="12" md="6">
            <div class="text-body-1">{{ article.family_name }}</div>
            <div class="text-body-1">{{ article.article_id }}</div>

            <div class="text-body-1">{{ article.article_price }} €</div>
          </v-col>
          <v-col cols="12" md="6">
            <div class="text-body-1 text-end">{{ article.article_yearprod }}</div>
          </v-col>
        </v-row>
      </div>
    </div>
    <div v-else>
      <p>Article non disponible</p>
    </div>
  </template>
  

<script setup lang="ts">
  import { useRouter } from 'vue-router';
  import { ref } from 'vue';
    import type { Article } from '@/api/interfaces/Article';

  const router = useRouter();

  const props = defineProps<{
    article: Article
  }>()

    function navigateTo(path) {
        router.push(path);
    }


</script>