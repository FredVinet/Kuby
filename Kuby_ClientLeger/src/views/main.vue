<template>  
  <TitleComponentMain :title="title" :msg="msg"/>
  <div class="d-flex justify-center align-center bg-secondary" style="height: 75vh;">
    <ArticleMain v-for="article in randomArticles" :key="article.article_id" :article="article" v-if="randomArticles.length > 0" />
  </div>
  <TitleComponentMain :title="title2" :msg="msg2"/>
  <div class="d-flex justify-center align-center " style="height: 75vh;">
    <ArticleMain v-for="article in randomArticles" :key="article.article_id" :article="article" v-if="randomArticles.length > 0" />
  </div>
  <ImgMain />
  <div class="my-15 pt-3 pb-15">
    <TitleComponentMain :title="title3" :msg="msg3"/>
    <div class="d-flex justify-center">
      <v-btn color="primary" size="x-large" @click="navigateTo('/catalogue')">
        Accéder au catalogue        
      </v-btn>
    </div>
  </div>
</template>


<script setup lang="ts">

import ArticleMain from '@/components/card/ArticleMain.vue';
import ImgMain from '@/components/img/imgMain.vue';
import TitleComponentMain from '@/components/title/TitleComponentMain.vue';
import ArticleService from '@/api/services/ArticlesService';
import type { Article } from '@/api/interfaces/Article';

import { onMounted, ref } from 'vue';
import { useRouter } from 'vue-router';

const articles = ref<Article[]>([]);

const randomArticles = ref<Article[]>([]);

function shuffleArray(array: Article[]) {
  return array.sort(() => Math.random() - 0.5);
}

const router = useRouter();

function navigateTo(path) {
    router.push(path);
}

const title = ref("Nos Coup de Coeur");
const msg = ref("Découvrez ou redécouvrez les coups de cœur de la maison de kuby : rouges, blancs secs, rosés, effervescents, vins mutés et liquoreux.Achetez votre vins en ligne et faites vous livrer en quelques jours. ");


const title2 = ref("Nouveauté");
const msg2 = ref("Venez essayez les dernière arrivées de la maison Kuby. ");

const title3 = ref("Et bien d’autre");
const msg3 = ref("Retrouver l’ensemble des vins ne sélectionnez pas nos experts, et profiter de nos conseils, pour choisir le vin qui vous convient.");


onMounted(async () => {
  try {
    articles.value = await ArticleService.getAllArticlesDetails();
    randomArticles.value = shuffleArray(articles.value).slice(0, 3); 
    console.log(randomArticles.value)
  } catch (error) {
    console.error("Erreur lors de la récupération des articles :", error);
  }
});

</script>

