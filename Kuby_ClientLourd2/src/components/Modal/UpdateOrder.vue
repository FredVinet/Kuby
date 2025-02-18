<template>
    <v-dialog v-model="dialog" max-width="800" overlay-color="transparent">
        <template v-slot:activator="{ props: activatorProps }">
            <v-btn
                v-bind="activatorProps"
                color="primary"
                class="mx-5"
                @click="fetchAddress"
            >
                Modifier une Commande
            </v-btn>
        </template>

        <template v-slot:default="{ isActive }">
            <v-card>
                <h3 class="mt-5 text-accent text-center">Modifier une Commande</h3>
                <v-card-text>
                    <v-row dense>
                        <v-col cols="12" md="6">
                            <v-text-field
                                label="ID Commande"
                                v-model="newOrder.orders_id"
                                disabled
                            ></v-text-field>
                        </v-col>
                        <v-col cols="12" md="6">
                            <v-select
                                label="Statut"
                                v-model="newOrder.orders_status"
                                :items="['Payée', 'En cours de livraison', 'Livrée', 'Sortie stock']"
                                required
                            ></v-select>
                        </v-col>
                        <v-col cols="12">
                            <v-select
                                label="Adresse de livraison"
                                v-model="newOrder.id_adress"
                                :items="formattedAddresses"
                                item-title="text"
                                item-value="id"
                                required
                            ></v-select>
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
                        @click="updateOrder"
                    >
                        Modifier
                    </v-btn>
                </v-card-actions>
            </v-card>
        </template>
    </v-dialog>
</template>

<script setup lang="ts">
import OrderService from '@/api/services/OrdersService';
import { ref, reactive, defineProps, watch, defineEmits, computed } from 'vue';
import type { Orders } from '@/api/interfaces/Orders';
import AdressService from '@/api/services/AdressService';
import type { Address } from '@/api/interfaces/Adress';
import LocalisationService from '@/api/services/LocalisationService';

const adresses = ref<Address[]>([]);

const dialog = ref(false);

const emits = defineEmits(['refresh']);

const props = defineProps<{
    order: Orders;
}>();

const newOrder = reactive<Orders>({
    orders_id: 0,
    orders_date: '',
    orders_status: 'Payée',
    orders_amount: 0,
    id_localisation: 0,
    id_user: 0,
    userType: 0,
    user_name: '',
    user_firstname: '',
    id_adress: 0,
    adress_number: 0,
    adress_name: '',
    adress_city: '',
    adress_code: '',
    adress_state: '',
    adress_country: '',
});

watch(
    () => props.order,
    (newOrderData) => {
        newOrder.orders_id = newOrderData.orders_id;
        newOrder.orders_date = newOrderData.orders_date;
        newOrder.orders_status = newOrderData.orders_status;
        newOrder.orders_amount = newOrderData.orders_amount;
        newOrder.id_localisation = newOrderData.id_localisation;
        newOrder.id_user = newOrderData.id_user;
        newOrder.id_adress = newOrderData.id_adress;

        newOrder.userType = newOrderData.userType;
        newOrder.user_name = newOrderData.user_name;
        newOrder.user_firstname = newOrderData.user_firstname;


    },
    { immediate: true }
);

async function updateOrder() {
    try {
        const response = await LocalisationService.getLocalisationByAdressId(newOrder.id_adress);
        console.log("LocalisationIs =", response);

        if(response){
            newOrder.id_localisation = response?.localisation_id;
        }

        await OrderService.updateOrder(newOrder);
        emits('refresh'); 
        dialog.value = false;
    } catch (error) {
        console.error('Erreur lors de la mise à jour de la commande', error);
    }
}

const fetchAddress = async () => {
  try {
    const response = await AdressService.getAddressesByUserId(newOrder.id_user);
    adresses.value = response ?? [];
  } catch (error) {
    adresses.value = [];
  }
};

const formattedAddresses = computed(() => {
    return adresses.value.map(addr => ({
        id: addr.adress_id,
        text: `${addr.adress_number} ${addr.adress_name}, ${addr.adress_city}, ${addr.adress_code}, ${addr.adress_country}`
    }));
});
</script>
