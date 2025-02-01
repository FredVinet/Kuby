<template>
    <div class="text-center my-15">
        <div class="text-h1">{{title}}</div>
        <div class="text-h5">{{msg}}</div>

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

.text-h5 {
    font-family: 'DuruSans', sans-serif;
}

</style>