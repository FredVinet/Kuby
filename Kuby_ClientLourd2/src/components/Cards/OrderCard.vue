<template>
    <v-card
        elevation="16"
        max-width="100%"
        border="opacity-50 md info"
        rounded="lg"
        class="mx-auto my-8"
    >
        <v-card-title class="text-center text-accent my-2 font-weight-bold">
            <h1 class="text-info">Informations sur la commande</h1>
        </v-card-title>
        <v-row align="center" no-gutters>
            <v-col class="text-left px-3" :cols="12" :md="8">
                <v-card-text class="font-weight-bold text-accent">
                    <div class="py-3"><h2>Pour le client: <span class="font-weight-medium">{{order.user_name}} {{order.user_firstname}} </span></h2></div>
                    <div class="py-3"><h2>Statut: : <span class="font-weight-medium">{{order.orders_status}} </span></h2></div>
                    <div class="py-3"><h2>Montant de la commande : <span class="font-weight-medium">{{order.orders_amount}} € </span></h2></div>
                    <div class="py-3"><h2>Date de la commande : <span class="font-weight-medium">{{formatDate(order.orders_date)}}</span></h2></div>
                    <div class="py-3"><h2>Adresse de livraison : <span class="font-weight-medium">{{order.adress_number}} {{order.adress_name}} {{order.adress_code}} {{order.adress_city}}, {{order.adress_country}} </span></h2></div>

                </v-card-text>
            </v-col>
            <v-col :cols="12" :md="4">
                <v-card-text class="font-weight-bold text-accent">


                </v-card-text>
            </v-col>
        </v-row>

        <div class="d-flex justify-center my-10">
            <UpdateOrder :order="orderRef" @refresh="refresh"/>
            <DelOrder :order="orderRef" @refresh="refresh"/>
        </div>
    </v-card>
</template>

<script setup lang="ts">
import DelOrder from '../Modal/DelOrder.vue';
import type {Orders} from '@/api/interfaces/Orders';
import { computed, defineProps, defineEmits } from 'vue'
import UpdateOrder from '../Modal/UpdateOrder.vue';

const props = defineProps<{
    order: Orders

}>()

const emits = defineEmits(['refresh']);

const formatDate = (dateString: string) => {
  const date = new Date(dateString);
  const day = String(date.getDate()).padStart(2, '0');
  const month = String(date.getMonth() + 1).padStart(2, '0');
  const year = date.getFullYear();
  return `${day}/${month}/${year}`;
}

const orderRef = computed(() => props.order)

const refresh = () => {
        emits('refresh')
    };


</script>


