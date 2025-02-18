<template>
    <v-card
        elevation="16"
        max-width="100%"
        border="opacity-50 md info"
        rounded="lg"
        class="mx-auto my-8"
    >
        <v-card-title class="text-center text-accent my-2 font-weight-bold">
            <h1 class="text-info">Supplier : {{supplier?.user_name}} {{supplier?.user_firstname}} </h1>
        </v-card-title>
        <v-row align="center" no-gutters>
            <v-col class="text-left px-3" :cols="12" :md="6">
                <v-card-text class="font-weight-bold text-accent">
                    <div class="py-3"><h2>ID : <span class="font-weight-medium">{{supplier.user_id}} </span></h2></div>
                    <div class="py-3"><h2>Nom : <span class="font-weight-medium">{{supplier.user_name}} </span></h2></div>
                    <div class="py-3"><h2>Prénom : <span class="font-weight-medium">{{supplier.user_firstname}} </span></h2></div>


                </v-card-text>
            </v-col>
            <v-col :cols="12" :md="6">
                <v-card-text class="font-weight-bold text-accent mt-14">

                    <div class="py-3"><h2>Mail : <span class="font-weight-medium">{{supplier.userMail}}</span></h2></div>
                    <div class="py-3"><h2>Téléphone : <span class="font-weight-medium">{{supplier.user_phone}} </span></h2></div>

                    <!-- <div class="py-3"><h2>Nb Commande : <span class="font-weight-medium">supplier.mail</span></h2></div>
                    <div class="py-3"><h2>Prix Total : <span class="font-weight-medium">supplier.mail</span></h2></div>
                    <div class="py-3"><h2>Derniere Connexion : <span class="font-weight-medium">supplier.mail</span></h2></div> -->

                </v-card-text>
            </v-col>
        </v-row>
        <v-row align="center" no-gutters>
            <v-col class="text-left px-3" :cols="12" :md="6">
                <v-card-text class="font-weight-bold text-accent">
                    <div class="py-3"><h2>Liste d'adresse : <span class="font-weight-medium">{{supplier.address.adress_number}} {{supplier.address.adress_name}} {{supplier.address.adress_code}} {{supplier.address.adress_city}}, {{supplier.address.adress_country}}</span></h2></div>
                </v-card-text>
            </v-col>
        </v-row>
        <div class="d-flex justify-center my-10">
            <UpdateSupplier :user="supplierRef" @refresh="refresh"/>
            <DelSupplier :user="supplierRef"  @refresh="refresh"/>      
         </div>
    </v-card>
</template>

<script setup lang="ts">
import { User } from '@/api/interfaces/User';
import { defineProps,computed,defineEmits } from 'vue'
import DelSupplier from '@/components/Modal/DelSupplier.vue';
import UpdateSupplier from '../Modal/UpdateSupplier.vue';
import { useUserConnectedStore } from '@/stores/userConnected';

const emits = defineEmits(['refresh']);


const props = defineProps<{
    supplier: User 
}>()

const refresh = () => {
    emits('refresh')
};

const supplierRef = computed(() => props.supplier)

</script>


