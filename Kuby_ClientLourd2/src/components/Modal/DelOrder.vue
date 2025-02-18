<template>
    <v-dialog v-model="dialog" max-width="800" overlay-color="transparent">

        <template v-if="userRole == 'admin'" v-slot:activator="{ props: activatorProps }">
            <v-btn
                v-bind="activatorProps"
                color="primary"
                class="mx-5"
            >
                Supprimer un orders
            </v-btn>
        </template>
        <template v-slot:default="{ isActive }">
            <v-card>
                <v-card-title class="text-h5">Confirmer la suppression</v-card-title>
                <v-card-text>
                    Êtes-vous sûr de vouloir supprimer la commande n°{{ order.orders_id }} ?
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

import type { Orders } from '@/api/interfaces/Orders';
import OrdersService from '@/api/services/OrdersService';
import { useUserConnectedStore } from '@/stores/userConnected';
import { ref, defineProps, defineEmits } from 'vue';

const dialog = ref(false)

const emits = defineEmits(['refresh']);
const userConnectedStore = useUserConnectedStore()
const userRole = userConnectedStore.userRole

const props = defineProps<{
    order: Orders 
}>();

console.log(props.order);

async function confirmDelete() {
    console.log("ID Orders à supprimer :", props.order?.orders_id);

    try {
        await OrdersService.deleteOrder(props.order.orders_id);
        console.log("Orders supprimé avec succès");

        emits('refresh');

        dialog.value = false;
    } catch (error) {
        console.error("Erreur lors de la suppression de l'orders", error);
    }
}


</script>
