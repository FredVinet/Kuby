<template>

    <div class="mx-10 my-10" style="width: 11vw;">
        <button style="background: none; border: none; padding: 0;" @click="navigateTo('/product')">
            <img src="../../assets/images/Bottle.png" style=" height: 450; cursor: pointer;">
        </button>
        <div class="mt-2">
            <div class="text-h6 " style="min-height: 4rem; max-height: 4rem; overflow: hidden" >{{product.title}}</div>
            <v-row>
                <v-col cols="12" md="6">
                    <div class="text-body-1">{{product.wine}}</div>
                    <div class="text-body-1 ">{{product.price}} €</div>
                </v-col>
                <v-col cols="12" md="6">
                    <div class="text-body-1 text-center">2004</div>
                </v-col>
            </v-row>
            <div class="mt-1" >
                <input class="py-1 ms-1" id="number" type="number" min="1" value="1" style="width: 35%;" />
                <v-btn class="mb-1 ms-4" variant="plain" >Ajouter</v-btn>
            </div>
        </div>
    </div>

  </template>

<script setup lang="ts">
  import { useRouter } from 'vue-router';
  import { ref,defineProps } from 'vue';

  const router = useRouter();

    function navigateTo(path) {
        router.push(path);
    }

    const props = defineProps({
    product: {
      type: Object,
    },
  });

</script>