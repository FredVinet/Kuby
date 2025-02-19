<template>
    <div v-if="article" class="mx-10 my-5" style="width: 18vw">
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
        <div class="text-h5 text-center font-weight-bold" style="min-height: 4rem; max-height: 4rem; overflow: hidden">{{ article.article_name }}</div>
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

<style>

.text-h5 {
    font-family: 'DuruSans', sans-serif;
}
</style>