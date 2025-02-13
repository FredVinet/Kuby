<template>
    <v-dialog v-model="dialog" max-width="800" overlay-color="transparent">
        <template v-slot:activator="{ props: activatorProps }">
            <v-btn
                v-bind="activatorProps"
                color="primary"
                class="mx-5"
            >
                Ajouter un Produit
            </v-btn>
        </template>

        <template v-slot:default="{ isActive }">
            <v-card>
                <h3 class="mt-5 text-accent text-center">Ajouter un Produit</h3>
                <v-card-text>
                    <v-row dense>
                        <v-col cols="12" md="7">
                        <v-text-field
                            label="Nom"
                            required
                            v-model="newArticle.article_name"
                        ></v-text-field>
                        </v-col>
                        <v-col cols="12" md="3">
                        <v-text-field
                            label="Année"
                            required
                            v-model="newArticle.article_yearprod"

                        ></v-text-field>
                        </v-col>
                        <v-col cols="12" md="2">
                        <v-text-field
                            label="Prix"
                            required
                            v-model="newArticle.article_price"

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
                                item-title="supplier.user_name" 
                                item-value="supplier.user_id"
                            ></v-select>
                        </v-col>
                        <v-col cols="12" >
                        <v-textarea
                            label="Description"
                            required
                            v-model="newArticle.article_description"
                            row-height="25"
                            rows="3" 
                            auto-grow                       
                            >
                        </v-textarea>
                        </v-col>
                    </v-row>
                    </v-card-text>

                    <v-divider></v-divider>

                    <v-card-actions>
                        
                    <v-spacer></v-spacer>
                    <v-btn
                        class="bg-secondary mb-2"
                        text="Close"
                        variant="plain"
                        @click="dialog = false"
                    >
                        Annuler
                    </v-btn>
                    <v-btn
                        class="bg-primary mb-2"
                        text="Save"
                        variant="tonal"
                        @click="addArticle()"
                    >
                        Ajouter
                    </v-btn>
                    </v-card-actions>

            </v-card>
        </template>
    </v-dialog>
</template>

<script setup lang="ts">

import type { Article } from '@/api/interfaces/Article';
import type { Family } from '@/api/interfaces/Family';
import type { Grape } from '@/api/interfaces/Grape';
import type { SupplierArticle } from '@/api/interfaces/Supplier';
import ArticleService from '@/api/services/ArticlesService';
import { ref, reactive} from 'vue'

const dialog = ref(false)

const props = defineProps<{
    families: Family[];
    grapes: Grape[];
    suppliers: SupplierArticle[];
}>();

const newArticle = reactive<Article>({
    article_name: '',
    article_description: '',
    article_yearprod: 0,
    article_price: 0,
    id_family: 0,
    id_grape: 0,
    article_quantity_in: 0,  
    article_quantity_out: 0,
    family: undefined, 
    grape: undefined  
});


async function addArticle(){
    try {
        newArticle.family = props.families.find(familie => familie.family_id === newArticle.id_family); //Renvoie les objets de Family et Grape car lié 
        newArticle.grape = props.grapes.find(grape => grape.grape_id === newArticle.id_grape);

        if (!newArticle.family || !newArticle.grape) {
            console.error('Famille ou variété manquante');
            return;
        }

        await ArticleService.createArticle(newArticle);
        dialog.value = false;
        console.log('Nouvelle Article', newArticle);
    } catch (error) {
        console.error('Erreur lors de la création de Article', error);
    }
}


</script>
