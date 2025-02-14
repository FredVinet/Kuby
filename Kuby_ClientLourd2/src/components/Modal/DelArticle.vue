<template>
    <v-dialog v-model="dialog" max-width="800" overlay-color="transparent">

        <template v-slot:activator="{ props: activatorProps }">
            <v-btn
                v-bind="activatorProps"
                color="primary"
                class="mx-5"
            >
                Supprimer un article
            </v-btn>
        </template>
        <template v-slot:default="{ isActive }">
            <v-card>
                <v-card-title class="text-h5">Confirmer la suppression</v-card-title>
                <v-card-text>
                    Êtes-vous sûr de vouloir supprimer {{ article?.article_name }} ?
                </v-card-text>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="secondary" @click="dialog = false">Annuler</v-btn>
                    <v-btn color="primary" @click="confirmDelete">Supprimer</v-btn>
                </v-card-actions>
            </v-card>
        </template>
    </v-dialog>
</template>

<script setup lang="ts">

import type { Article } from '@/api/interfaces/Article';
import ArticleService from '@/api/services/ArticlesService';
import { ref, defineProps, defineEmits } from 'vue';

const dialog = ref(false)

const emits = defineEmits(['refresh']);

const props = defineProps<{
    article: Article 
}>();

console.log('vin', props.article);

async function confirmDelete() {
    console.log("ID Article à supprimer :", props.article?.article_id);

    try {
        await ArticleService.deleteArticle(props.article.article_id);
        console.log("Vin supprimé avec succès");

        emits('refresh');

        dialog.value = false;
    } catch (error) {
        console.error("Erreur lors de la suppression de l'article", error);
    }
}


</script>
