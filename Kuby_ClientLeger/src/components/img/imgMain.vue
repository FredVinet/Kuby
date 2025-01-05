<template>
    <div class="text-center my-15 " style="height: 60vh;">
        <img src="../../assets/images/imageMain1.png"   style="width: 100%; height: 100%; object-fit: cover; filter: grayscale(100%);">
    </div>
</template>

<script setup lang="ts">
  import { defineProps } from 'vue';
  
  const props = defineProps({
    msg: {
      type: String,
    },
    title: {
      type: String,
    },
  });

</script>

<style scoped>

.text-h1 {
    font-family: 'Tan Pearl', sans-serif;
}

.text-h6 {
    font-family: 'DuruSans', sans-serif;
}

</style>