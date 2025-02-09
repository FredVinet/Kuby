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
                    <div class="py-3"><h2>Pour le client: <span class="font-weight-medium">{{order.localisation.user.user_name}} {{order.localisation.user.user_firstname}} </span></h2></div>
                    <div class="py-3"><h2>Statut: : <span class="font-weight-medium">{{order.orders_status}} </span></h2></div>
                    <div class="py-3"><h2>Montant de la commande : <span class="font-weight-medium">{{order.orders_amount}} € </span></h2></div>
                    <div class="py-3"><h2>Date de la commande : <span class="font-weight-medium">{{order.orders_date}}</span></h2></div>
                    <div class="py-3"><h2>Adresse de livraison : <span class="font-weight-medium">{{order.localisation.address.adress_number}} {{order.localisation.address.adress_name}} {{order.localisation.address.adress_code}} {{order.localisation.address.adress_city}}, {{order.localisation.address.adress_country}} </span></h2></div>

                </v-card-text>
            </v-col>
            <v-col :cols="12" :md="4">
                <v-card-text class="font-weight-bold text-accent">


                </v-card-text>
            </v-col>
        </v-row>

        <div class="d-flex justify-center my-10">
            <v-btn
            color="primary"
            class="mx-5"
            >Modifier Commande</v-btn>
            <v-btn
            color="primary"
            class="mx-5"
            >Supprimer Commande</v-btn>
        </div>
    </v-card>
</template>

<script setup lang="ts">
import {Order} from '@/api/interfaces/Order';
import { defineProps } from 'vue'

defineProps<{
    order: Order

}>()

</script>


