<template>
    <v-dialog v-model="dialog" max-width="800" overlay-color="transparent">
        <template v-slot:activator="{ props: activatorProps }">
            <v-btn
                v-bind="activatorProps"
                color="primary"
                class="mx-5"
            >
                Ajouter un Fournisseur
            </v-btn>
        </template>

        <template v-slot:default="{ isActive }">
            <v-card>
                <h3 class="mt-5 text-accent text-center">Ajouter un Fournisseur</h3>
                <v-card-text>
                    <v-row dense>
                        <v-col cols="12" md="6">
                            <v-text-field
                                label="Prénom"
                                required
                                v-model="newUser.user_firstname"
                            ></v-text-field>
                        </v-col>
                        <v-col cols="12" md="6">
                            <v-text-field
                                label="Nom"
                                required
                                v-model="newUser.user_name"
                            ></v-text-field>
                        </v-col>
                        <v-col cols="12" md="6">
                            <v-text-field
                                label="Phone"
                                required
                                v-model="newUser.user_phone"
                            ></v-text-field>
                        </v-col>
                        <v-col cols="12" md="6">
                            <v-text-field
                                label="Mail"
                                required
                                v-model="newUser.userMail"
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
                        text="Ajouter"
                        variant="tonal"
                        @click="addUser"
                    >
                        Ajouter
                    </v-btn>
                </v-card-actions>

            </v-card>
        </template>
    </v-dialog>
</template>

<script setup lang="ts">

import type { User } from '@/api/interfaces/User';
import type { Address } from '@/api/interfaces/Adress';
import LocalisationService from '@/api/services/LocalisationService';
import AddressService from '@/api/services/AdressService';
import UserService from '@/api/services/UserService';
import { ref, reactive, defineEmits} from 'vue'

const dialog = ref(false)

const emits = defineEmits(['refresh']);

const newUser = reactive<User>({
    user_firstname: '',
    user_name: '',
    user_phone: '',
    userMail: '',
    user_password: '',
    userType:  2,
    user_admin:  false,
});

const newAddress = reactive<Address>({
    adress_number: 0,
    adress_country: '',
    adress_state: '',
    adress_name: '',
    adress_city: '',
    adress_code: '',
});


async function addUser() {
    try {
        const createdUser = await UserService.createUser(newUser);

        const createdAddress = await AddressService.createAddress(newAddress);

        const localisationData = {
            id_user: createdUser.user_id,
            id_adress: createdAddress.adress_id, 
        };

        await LocalisationService.createLocalisation(localisationData);

        emits('refresh');

        dialog.value = false;
        console.log('Nouvelle User', createdUser);
        console.log('Nouvelle Adresse', createdAddress);
    } catch (error) {
        console.error('Erreur lors de la création de l\'utilisateur, de l\'adresse ou de la localisation', error);
    }
}



</script>
