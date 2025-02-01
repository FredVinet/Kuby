<template>
    <v-container>
        <v-row class="my-10">
            <v-col cols="12" md="6" class="text-center">
                    <img src="../../assets/images/Bottle.png" class="text-end" style="width: 25rem;">
            </v-col>
            <v-col cols="12" md="6">
                <div class="text-h2 border-article " style="width: 85%;">Chateau de Ligonnes</div>
                <div class="text-h5 my-5">150,00 €</div>
                <div class="text-h5 marging-product">Rouge</div>
                <div class="text-h5 mt-1">Gamay</div>
                <div class="text-h5 mt-1">Bordeaux, France</div>
                <div class="text-h5 mt-1">Année de production 1997</div>
                <div class="mt-1" >
                    <input class="py-1 ms-1" id="number" type="number" min="1" value="1" style="width: 25%;" />
                    <v-btn
                    rounded="lg"
                    size="x-large"
                    class="bg-primary mb-1 mx-15" 
                    width="50%"
                    >
                        Ajouter au panier
                    </v-btn>
                </div>
            </v-col>
        </v-row>
    </v-container>

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
    },
  });

</script>

<style scoped>

.text-h2 {
    font-family: 'Tan Pearl', sans-serif;
}

.border-article {
    border-bottom: 0.4rem solid #d1a671;
}

.marging-product {
    margin-top: 11rem;
}

</style>