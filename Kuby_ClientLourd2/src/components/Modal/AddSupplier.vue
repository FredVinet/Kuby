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
                            v-model="newUser.user_mail"
                        ></v-text-field>
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
                        @click="addUser()"
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
import UserService from '@/api/services/UserService';
import { ref, reactive} from 'vue'

const dialog = ref(false)

const newUser = reactive<User>({
    user_firstname: '',
    user_name: '',
    user_phone: '',
    userMail: '',
    user_password: '',
    userType:  2,
    user_admin:  false,
});


async function addUser(){
    try {

        await UserService.createUser(newUser);
        dialog.value = false;
        console.log('Nouvelle User', newUser);
    } catch (error) {
        console.error('Erreur lors de la création de Article', error);
    }
}


</script>
