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
                                label="Prénom"
                                required
                                v-model="newArticle.user_firstname"
                            ></v-text-field>
                        </v-col>
                        <v-col cols="12" md="6">
                            <v-text-field
                                label="Nom"
                                required
                                v-model="newArticle.user_name"
                            ></v-text-field>
                        </v-col>
                        <v-col cols="12" md="6">
                            <v-text-field
                                label="Phone"
                                required
                                v-model="newArticle.user_phone"
                            ></v-text-field>
                        </v-col>
                        <v-col cols="12" md="6">
                            <v-text-field
                                label="Mail"
                                required
                                v-model="newArticle.userMail"
                            ></v-text-field>
                        </v-col>
                    </v-row>

                    <v-divider></v-divider>
                    <h4 class="mt-4 text-center">Adresse</h4>
                    <v-row dense>
                        <v-col cols="12" md="6">
                            <v-text-field
                                label="Numéro"
                                required
                                v-model="newAddress.adress_number"
                            ></v-text-field>
                        </v-col>
                        <v-col cols="12" md="6">
                            <v-text-field
                                label="Nom de rue"
                                required
                                v-model="newAddress.adress_name"
                            ></v-text-field>
                        </v-col>
                        <v-col cols="12" md="6">
                            <v-text-field
                                label="Ville"
                                required
                                v-model="newAddress.adress_city"
                            ></v-text-field>
                        </v-col>
                        <v-col cols="12" md="6">
                            <v-text-field
                                label="État"
                                required
                                v-model="newAddress.adress_state"
                            ></v-text-field>
                        </v-col>
                        <v-col cols="12" md="6">
                            <v-text-field
                                label="Code Postal"
                                required
                                v-model="newAddress.adress_code"
                            ></v-text-field>
                        </v-col>
                        <v-col cols="12" md="6">
                            <v-text-field
                                label="Pays"
                                required
                                v-model="newAddress.adress_country"
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
                        @click="updateUser"
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

const dialog = ref(false);

const emits = defineEmits(['refresh']);

const props = defineProps<{
    wine: Article;
}>();

const newArticle = reactive<Article>({
    user_id: 0,
    user_name: '',
    user_phone: '',

});

const newAddress = reactive<Address>({
    adress_id:0,
    adress_number: 0,
    adress_country: '',
    adress_state: '',
    adress_name: '',
    adress_city: '',
    adress_code: '',
});

watch(
    () => props.wine,
    (newSupplier) => {
        newArticle.user_id = newSupplier.user_id;
    },
    { immediate: true }
);

async function updateUser() {
    try {
        await ArticlesService.updateArticle(newArticle.article_id, {
            user_firstname: newArticle.user_firstname,
            user_name: newArticle.user_name,
            user_phone: newArticle.user_phone,
            userMail: newArticle.userMail,
            user_password: newArticle.user_password,
            userType: newArticle.userType,
            user_admin: newArticle.user_admin,
        });

        await AddressService.updateAddress(newAddress.adress_id, {
            adress_number: newAddress.adress_number,
            adress_name: newAddress.adress_name,
            adress_city: newAddress.adress_city,
            adress_state: newAddress.adress_state,
            adress_code: newAddress.adress_code,
            adress_country: newAddress.adress_country,
        });

        emits('refresh');

        

        dialog.value = false;
        console.log('Utilisateur mis à jour', newArticle);
        console.log('Adresse mise à jour', newAddress);
    } catch (error) {
        console.error('Erreur lors de la mise à jour de l\'utilisateur', error);
    }
}
</script>
