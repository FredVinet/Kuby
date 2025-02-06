<template>
    <v-card
        elevation="16"
        max-width="100%"
        border="opacity-50 md info"
        rounded="lg"
        class="mx-auto my-8"
    >
        <v-card-title class="text-center text-accent my-2 font-weight-bold">
            <h1 class="text-info">Informations du Produit</h1>
        </v-card-title>
        <v-row align="center" no-gutters>
            <v-col class="text-left px-3" :cols="12" :md="6">
                <v-card-text class="font-weight-bold text-accent">

                    <div class="py-3"><h2>ID : <span class="font-weight-medium">product.id </span></h2></div>
                    <div class="py-3"><h2>Nom : <span class="font-weight-medium">product.nom </span></h2></div>
                    <div class="py-3"><h2>Famille : <span class="font-weight-medium">product.familly </span></h2></div>
                    <div class="py-3"><h2>Variété : <span class="font-weight-medium">product.variety </span></h2></div>
                    <div class="py-3"><h2>Année : <span class="font-weight-medium">product.year</span></h2></div>
                    <div class="py-3"><h2>Fournisseur : <span class="font-weight-medium">product.mail</span></h2></div>

                </v-card-text>
            </v-col>
            <v-col :cols="12" :md="6">
                <v-card-text class="font-weight-bold text-accent">

                    <div class="py-3"><h2>Prix Acheter: <span class="font-weight-medium">product.price</span></h2></div>
                    <div class="py-3"><h2>Prix Vendu: <span class="font-weight-medium">product.price</span></h2></div>
                    <div class="py-3"><h2>Nb vendu : <span class="font-weight-medium">product.sold</span></h2></div>
                    <div class="py-3"><h2>Nb acheter : <span class="font-weight-medium">product.buy</span></h2></div>
                    <div class="py-3"><h2>Nb en stock : <span class="font-weight-medium">product.total</span></h2></div>

                </v-card-text>
            </v-col>
        </v-row>
        <v-row align="center" no-gutters>
            <v-col class="text-left px-3" :cols="12" :md="6">
                <v-card-text class="font-weight-bold text-accent">
                    <div class="py-3"><h2>Description: <span class="font-weight-medium">product.description </span></h2></div>
                </v-card-text>
            </v-col>
        </v-row>
        <div class="d-flex justify-center my-10">
            <v-btn
            color="primary"
            class="mx-5"
            >Modifier Produit</v-btn>
            <v-btn
            color="primary"
            class="mx-5"
            >Supprimer Produit</v-btn>
        </div>
    </v-card>
</template>

<script setup lang="ts">


</script>


