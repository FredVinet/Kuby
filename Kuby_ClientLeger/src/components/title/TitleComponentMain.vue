<template>
    <div class="text-center my-16 pt-10">
        <div class="text-h1">{{title}}</div>
        <div class="mx-auto text-h6 mt-10 w-50">{{msg}}</div>
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