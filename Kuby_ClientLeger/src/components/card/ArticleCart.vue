<template>
    <v-row class="me-10">
        <v-col cols="12" md="4">
                <button style="background: none; border: none; padding: 0;" @click="navigateTo('/product')">
                    <img src="../../assets/images/Bottle.png" style="cursor: pointer; object-fit: cover;">
                </button>
        </v-col>
        <v-col cols="12" md="8">
            <div 
                class="text-h4 mb-5 d-inline-block text-truncate" 
                style="max-width: 30rem"
            >
            {{product.title}}
            </div>
            <v-row>
                <v-col cols="12" md="6">
                    <div class="text-h6 my-2">{{product.wine}}</div>
                    <div class="text-h6 my-2">{{product.grape}} </div>

                    <div class="text-h6 my-2">{{product.price}} €</div>
                </v-col>
                <v-col cols="12" md="6">

                    <div class="text-h6 my-2 text-end ">{{product.year}}</div>
                </v-col>
            </v-row>
            <div class="mt-1" >
                <v-row>
                    <v-col>
                        <input class="py-1 ms-1" id="number" type="number" min="1" :value="product.quantity" />
                    </v-col>
                    <v-col>
                        <div class="text-h6 text-end ">Quantité</div>
                    </v-col>
                </v-row>
                
                <v-btn class="mt-3 text-error text-bold " variant="plain" block>Supprimer</v-btn>
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
    },
  });

</script>