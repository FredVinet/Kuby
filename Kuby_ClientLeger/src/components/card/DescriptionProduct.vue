<template>
    <v-row class="my-10">
        <v-col cols="12" md="8" class="d-flex align-center">
            <div class="text-h5 ">
            {{ product.article_description}}
        </div>
        </v-col>
        <v-col cols="12" md="4" class="text-center">
            <div class="" >
                <img src="../../assets/images/BottleDescription.png" style="object-fit: cover; width: 100%;">
            </div>
        </v-col>
    </v-row>
  </template>

<script setup lang="ts">
  import { useRouter } from 'vue-router';
  import { defineProps } from 'vue';

  const router = useRouter();

    function navigateTo(path) {
        router.push(path);
    }

    const props = defineProps({
      product: {
        type: Object,
        required: true,
      },
    });

</script>

<style scoped>


</style>