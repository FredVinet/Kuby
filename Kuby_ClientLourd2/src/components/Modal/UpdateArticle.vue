<template>
    <v-dialog v-model="dialog" max-width="800" overlay-color="transparent">
        <template v-slot:activator="{ props: activatorProps }">
            <v-btn
                v-bind="activatorProps"
                color="primary"
                class="mx-5"
            >
                Modifier un Article
            </v-btn>
        </template>

        <template v-slot:default="{ isActive }">
            <v-card>
                <h3 class="mt-5 text-accent text-center">Modifier un Fournisseur</h3>
                <v-card-text>
                    <v-row dense>
                        <v-col cols="12" md="6">
                            <v-text-field
                                label="Nom"
                                required
                                v-model="newArticle.article_name"
                            ></v-text-field>
                        </v-col>
                        <v-col cols="12" md="3">
                            <v-text-field
                                label="Prix de vente"
                                required
                                v-model="newArticle.article_price"
                            ></v-text-field>
                        </v-col>
                        <v-col cols="12" md="3">
                            <v-text-field
                                label="Année"
                                required
                                v-model="newArticle.article_yearprod"
                            ></v-text-field>
                        </v-col>
                        <v-col cols="12" md="4">
                            <v-select 
                                label="Famille" 
                                required 
                                v-model="newArticle.id_family" 
                                :items="families" 
                                item-title="family_name" 
                                item-value="family_id"
                            ></v-select>
                        </v-col>
                        <v-col cols="12" md="4">
                            <v-select 
                                label="Variété" 
                                required 
                                v-model="newArticle.id_grape" 
                                :items="grapes" 
                                item-title="grape_name" 
                                item-value="grape_id"
                            ></v-select>
                        </v-col>
                        <v-col cols="12" md="4">
                            <v-select 
                                label="Fournisseur" 
                                :items="suppliers" 
                                v-model="newArticle.user_id"
                                item-title="user_name" 
                                item-value="user_id"
                            ></v-select>
                        </v-col>
                        <v-col cols="12" md="6">
                            <v-text-field
                                label="Quantité entrer"
                                required
                                v-model="newArticle.article_quantity_in"
                            ></v-text-field>
                        </v-col>
                        <v-col cols="12" md="6">
                            <v-text-field
                                label="Quantité sortie"
                                required
                                v-model="newArticle.article_quantity_out"
                            ></v-text-field>
                        </v-col>
                        
                    </v-row>
                </v-card-text>

                <v-divider></v-divider>

                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn
                        class="bg-secondary mb-2"
                        text="Annuler"
                        variant="plain"
                        @click="dialog = false"
                    >
                        Annuler
                    </v-btn>
                    <v-btn
                        class="bg-primary mb-2"
                        text="Modifier"
                        variant="tonal"
                        @click="updateArticle"
                    >
                        Modifier
                    </v-btn>
                </v-card-actions>

            </v-card>
        </template>
    </v-dialog>
</template>

<script setup lang="ts">
import type { Article } from '@/api/interfaces/Article';
import type { Address } from '@/api/interfaces/Adress';
import AddressService from '@/api/services/AdressService';
import ArticlesService from '@/api/services/ArticlesService';
import { ref, reactive, defineProps, watch, defineEmits } from 'vue';
import type { Family } from '@/api/interfaces/Family';
import type { Grape } from '@/api/interfaces/Grape';
import type { User } from '@/api/interfaces/User';

const dialog = ref(false);

const emits = defineEmits(['refresh']);

const props = defineProps<{
    wine: Article;
    families: Family[];
    grapes: Grape[];
    suppliers: User[];
}>();

const newArticle = reactive<Article>({
    article_id: 0, 
    article_name: '',
    article_description: '',
    article_yearprod: 0,
    article_price: 0,
    article_quantity_in: 0,
    article_quantity_out: 0,
    id_family: 0,
    id_grape: 0,
    user_id: 0,
    grape_name: '',
    family_name: '',
    user_name: '',
});



watch(
    () => props.wine,
    (newWine) => {
        newArticle.article_id = newWine.article_id;
        newArticle.article_name = newWine.article_name;
        newArticle.article_description = newWine.article_description;
        newArticle.article_yearprod = newWine.article_yearprod;
        newArticle.article_price = newWine.article_price;
        newArticle.article_quantity_in = newWine.article_quantity_in;
        newArticle.article_quantity_out = newWine.article_quantity_out;

        newArticle.id_family = newWine.id_family;
        newArticle.id_grape = newWine.id_grape;
        newArticle.grape_name = newWine.family_name;
        newArticle.user_id = newWine.user_id;
        newArticle.user_name = newWine.user_name;

    },
    { immediate: true }
);

async function updateArticle() {
    try {
        await ArticlesService.updateArticle(newArticle.article_id, {
            article_name: newArticle.article_name,
            article_description: newArticle.article_description,
            article_yearprod: newArticle.article_yearprod,
            article_price: newArticle.article_price,
            article_quantity_in: newArticle.article_quantity_in,
            article_quantity_out: newArticle.article_quantity_out,

            id_family: newArticle.id_family,
            id_grape: newArticle.id_grape,
        }, newArticle.user_id);

        emits('refresh');

        dialog.value = false;
    } catch (error) {
        console.error('Erreur lors de la mise à jour de l\'utilisateur', error);
    }
}
</script>
