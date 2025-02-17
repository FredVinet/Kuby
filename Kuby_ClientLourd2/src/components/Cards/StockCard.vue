<template>
    <v-card
        elevation="16"
        max-width="100%"
        border="opacity-50 md info"
        rounded="lg"
        class="mx-auto my-8"
    >
        <v-card-title class="text-center text-accent my-2 font-weight-bold">
            <h1 class="text-info">{{wine.name}}</h1>
        </v-card-title>
        <v-row align="center" no-gutters>
            <v-col class="text-left px-3" :cols="12" :md="6">
                <v-card-text class="font-weight-bold text-accent">

                    <div class="py-3"><h2>ID : <span class="font-weight-medium">{{wine.article_id}} </span></h2></div>
                    <div class="py-3"><h2>Nom : <span class="font-weight-medium">{{wine.article_name}}</span></h2></div>
                    <div class="py-3"><h2>Famille : <span class="font-weight-medium">{{wine.family_name}} </span></h2></div>
                    <div class="py-3"><h2>Variété : <span class="font-weight-medium">{{wine.grape_name}}</span></h2></div>
                    <div class="py-3"><h2>Année : <span class="font-weight-medium">{{wine.article_yearprod}}</span></h2></div>
                    <div class="py-3"><h2>Fournisseur : <span class="font-weight-medium"> {{ wine.user_name || 'Non renseigné' }}              
                    </span></h2></div>

                </v-card-text>
            </v-col>
            <v-col :cols="12" :md="6">
                <v-card-text class="font-weight-bold text-accent">

                    <div class="py-3"><h2>Prix Acheter: <span class="font-weight-medium">Non défini encore a voir</span></h2></div>
                    <div class="py-3"><h2>Prix Vendu: <span class="font-weight-medium">{{wine.article_price}}</span></h2></div>
                    <div class="py-3"><h2>Nb vendu : <span class="font-weight-medium">{{wine.article_quantity_out}}</span></h2></div>
                    <div class="py-3"><h2>Nb acheter : <span class="font-weight-medium">{{wine.article_quantity_in}}</span></h2></div>
                    <div class="py-3"><h2>Nb en stock : <span class="font-weight-medium">{{calculateTotalQuantity(wine)}}</span></h2></div>

                </v-card-text>
            </v-col>
        </v-row>
        <v-row align="center" no-gutters>
            <v-col class="text-left px-3" :cols="12" :md="12">
                <v-card-text class="font-weight-bold text-accent">
                    <div class="py-3"><h2>Description: <span class="font-weight-medium">{{wine.article_description}} </span></h2></div>
                </v-card-text>
            </v-col>
        </v-row>
        <div class="d-flex justify-center my-10">
            <UpdateArticle :wine="wine" :families="families" :grapes="grapes" :suppliers="suppliers" @refresh="refresh" />
            <DelArticle :article="wine" @refresh="refresh"/>
        </div>
    </v-card>
</template>

<script setup lang="ts">
    import type { Article } from '@/api/interfaces/Article';
    import { defineProps, defineEmits } from 'vue'
    import DelArticle from '../Modal/DelArticle.vue';
    import UpdateArticle from '../Modal/UpdateArticle.vue';
    import type { Family } from '@/api/interfaces/Family';
    import type { Grape } from '@/api/interfaces/Grape';
    import type { User } from '@/api/interfaces/User';

    const emits = defineEmits(['refresh']);


    defineProps<{
        wine: Article;
        families: Family[];
        grapes: Grape[];
        suppliers: User[];
    }>()
    
    const refresh = () => {
        emits('refresh')
    };

    const calculateTotalQuantity = (wine: Article) => {
    return (wine.article_quantity_in ?? 0) - (wine.article_quantity_out ?? 0)
  }

</script>


