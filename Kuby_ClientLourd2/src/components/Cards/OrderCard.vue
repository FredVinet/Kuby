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
                    <div class="py-3"><h2>Pour le client: <span class="font-weight-medium">Nom </span></h2></div>
                    <div class="py-3"><h2>Statut: : <span class="font-weight-medium">Validée </span></h2></div>
                    <div class="py-3"><h2>Montant de la commande : <span class="font-weight-medium">10000€ </span></h2></div>
                    <div class="py-3"><h2>Date de la commande : <span class="font-weight-medium">10/10/2010 </span></h2></div>
                    <div class="py-3"><h2>Adresse de livraison : <span class="font-weight-medium">3 rue des gens heureux, HappyTown, France </span></h2></div>

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


</script>


