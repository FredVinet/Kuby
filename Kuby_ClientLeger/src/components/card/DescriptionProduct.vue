<template>
    <v-row class="my-10">
        <v-col cols="12" md="8" class="d-flex align-center">
            <div class="text-h5 ">
            Belle robe bordeaux aux nuances violacées.
            Le nez est intense gourmand et fruité aux notes de petits fruits rouges.
            La bouche, très ronde, est également sur le fruit : framboise et fraise.
            Ce vin se caractérise par une belle sucrosité en attaque, des tanins souples et un fruité intense.
            
            Ce vin s’accorder parfaitement avec des terrines, un plateau de charcuterie, un poulet aux champignons, une fricassée de lapin de garenne, des fromages à pâte molle.
            
            Service : Entre 16 et 18°C / Garde : 5 ans
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
    },
  });

</script>

<style scoped>


</style>