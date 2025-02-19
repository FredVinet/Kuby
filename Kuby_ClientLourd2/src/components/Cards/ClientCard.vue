<template>
    <v-card
        elevation="16"
        max-width="100%"
        border="opacity-50 md info"
        rounded="lg"
        class="mx-auto my-8"
    >
        <v-card-title class="text-center text-accent my-2 font-weight-bold">
            <h1 class="text-info">Client : {{client.user_name}} {{client.user_firstname}} </h1>
        </v-card-title>
        <v-row align="center" no-gutters>
            <v-col class="text-left px-3" :cols="12" :md="6">
                <v-card-text class="font-weight-bold text-accent">
                    <div class="py-3"><h2>ID : <span class="font-weight-medium">{{client.user_id}} </span></h2></div>
                    <div class="py-3"><h2>Nom : <span class="font-weight-medium">{{client.user_name}} </span></h2></div>
                    <div class="py-3"><h2>Prénom : <span class="font-weight-medium">{{client.user_firstname}} </span></h2></div>


                </v-card-text>
            </v-col>
            <v-col :cols="12" :md="6">
                <v-card-text class="font-weight-bold text-accent mt-14">

                    <div class="py-3"><h2>Mail : <span class="font-weight-medium">{{client.userMail}}</span></h2></div>
                    <div class="py-3"><h2>Téléphone : <span class="font-weight-medium">{{client.user_phone}} </span></h2></div>

                    <!-- <div class="py-3"><h2>Nb Commande : <span class="font-weight-medium">client.mail</span></h2></div>
                    <div class="py-3"><h2>Prix Total : <span class="font-weight-medium">client.mail</span></h2></div>
                    <div class="py-3"><h2>Derniere Connexion : <span class="font-weight-medium">client.mail</span></h2></div> -->

                </v-card-text>
            </v-col>
        </v-row>
        <v-row align="center" no-gutters>
            <v-col class="text-left px-3" :cols="12" :md="6">
                <v-card-text class="font-weight-bold text-accent">
                    <div class="py-3"><h2>Liste d'adresse : <span class="font-weight-medium">{{client.address.adress_number}} {{client.address.adress_name}} {{client.address.adress_code}} {{client.address.adress_city}}, {{client.address.adress_country}}</span></h2></div>
                </v-card-text>
            </v-col>
        </v-row>
        <div class="d-flex justify-center my-10">
            <UpdateClient :user="clientRef"  @refresh="refresh"/>
            <DelClient :user="clientRef"  @refresh="refresh"/>
        </div>
    </v-card>
</template>

<script setup lang="ts">
    import type { User } from '@/api/interfaces/User';
    import { computed, defineProps, defineEmits } from 'vue'
    import DelClient from '../Modal/DelClient.vue';
    import UpdateClient from '../Modal/UpdateClient.vue';

    const emits = defineEmits(['refresh']);

    const refresh = () => {
        emits('refresh')
    };

    const props = defineProps<{
        client: User | null

    }>()

    const clientRef = computed(() => props.client)


</script>


