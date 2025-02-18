<template>
    <v-dialog v-model="dialog" max-width="800" overlay-color="transparent">
        <template v-slot:activator="{ props: activatorProps }">
            <v-btn
                v-bind="activatorProps"
                color="primary"
                class="mx-5"
            >
                Modifier le Client
            </v-btn>
        </template>

        <template v-slot:default="{ isActive }">
            <v-card>
                <h3 class="mt-5 text-accent text-center">Modifier un Client</h3>
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
import type { User } from '@/api/interfaces/User';
import type { Address } from '@/api/interfaces/Adress';
import AddressService from '@/api/services/AdressService';
import UserService from '@/api/services/UserService';
import { ref, reactive, defineProps, watch, defineEmits } from 'vue';

const dialog = ref(false);

const emits = defineEmits(['refresh']);


const props = defineProps<{
    user: User;
}>();

const newUser = reactive<User>({
    user_id: 0,
    user_firstname: '',
    user_name: '',
    user_phone: '',
    userMail: '',
    user_password: '',
    userType: 2,
    user_admin: false,
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
    () => props.user,
    (newClient) => {
        newUser.user_id = newClient.user_id;
        newUser.user_firstname = newClient.user_firstname;
        newUser.user_name = newClient.user_name;
        newUser.user_phone = newClient.user_phone;
        newUser.userMail = newClient.userMail;
        newUser.user_password = newClient.user_password;
        newUser.userType = newClient.userType;
        newUser.user_admin = newClient.user_admin;

        newAddress.adress_id = newClient.address.adress_id;
        newAddress.adress_number = newClient.address.adress_number;
        newAddress.adress_country = newClient.address.adress_country;
        newAddress.adress_state = newClient.address.adress_state;
        newAddress.adress_name = newClient.address.adress_name;
        newAddress.adress_city = newClient.address.adress_city;
        newAddress.adress_code = newClient.address.adress_code;
    },
    { immediate: true }
);

async function updateUser() {
    try {

        console.log('updateUser');

        await UserService.updateUser(newUser.user_id, {
            user_firstname: newUser.user_firstname,
            user_name: newUser.user_name,
            user_phone: newUser.user_phone,
            userMail: newUser.userMail,
            user_password: newUser.user_password,
            userType: newUser.userType,
            user_admin: newUser.user_admin,
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

    } catch (error) {
        console.error('Erreur lors de la mise à jour de l\'utilisateur', error);
    }
}
</script>
