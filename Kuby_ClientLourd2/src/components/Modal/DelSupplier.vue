<template>
    <v-dialog v-model="dialog" max-width="800" overlay-color="transparent">

        <template v-slot:activator="{ props: activatorProps }">
            <v-btn
                v-bind="activatorProps"
                color="primary"
                class="mx-5"
            >
                Supprimer un fournisseur
            </v-btn>
        </template>
        <template v-slot:default="{ isActive }">
            <v-card>
                <v-card-title class="text-h5">Confirmer la suppression</v-card-title>
                <v-card-text>
                    Êtes-vous sûr de vouloir supprimer {{ user?.user_name }} {{ user?.user_id }} ?
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

import type { User } from '@/api/interfaces/User';
import UserService from '@/api/services/UserService';
import { ref, defineProps, defineEmits } from 'vue';

const dialog = ref(false)

const emits = defineEmits(['refresh']);

const props = defineProps<{
    user: User 
}>();


async function confirmDelete() {

    if (!props.user?.user_id) {
        console.error("Erreur: ID utilisateur non défini !");
        return;
    }

    try {
        await UserService.deleteUser(props.user.user_id);

        emits('refresh');

        dialog.value = false;
    } catch (error) {
        console.error("Erreur lors de la suppression de l'utilisateur", error);
    }
}


</script>
