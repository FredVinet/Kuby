<template>
    <h1 class="my-5 text-info" >{{title}}</h1>
</template>

<script setup lang="ts">
import { defineProps } from 'vue';
  
  const props = defineProps({
    title: {
      type: String,
      required: true,
    },
  });

</script>