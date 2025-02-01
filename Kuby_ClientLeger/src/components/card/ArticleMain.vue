<template>

    <div class="mx-10 my-10" style="width: 18vw">
        <button style="background: none; border: none; padding: 0; width: 100%" @click="navigateTo('/product')">
            <img src="../../assets/images/Bottle.png" style=" width: 100%; cursor: pointer;">
        </button>
        <div class="mt-2">
            <div class="text-h6 " style="min-height: 4rem; max-height: 4rem; overflow: hidden" >Product.title</div>
            <v-row>
                <v-col cols="12" md="6">
                    <div class="text-body-1">product.wine</div>
                    <div class="text-body-1 ">product.price €</div>
                </v-col>
                <v-col cols="12" md="6">
                    <div class="text-body-1 text-end">2004</div>
                </v-col>
            </v-row>
        </div>
    </div>

  </template>

<script setup lang="ts">
  import { useRouter } from 'vue-router';
  import { ref } from 'vue';

  const router = useRouter();

    function navigateTo(path) {
        router.push(path);
    }


</script>