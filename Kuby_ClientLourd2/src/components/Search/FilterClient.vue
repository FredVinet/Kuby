<template>
    <v-card class="mx-auto my-8" elevation="16" max-width="90%" border="opacity-50 md info" rounded="lg">
      <div class="my-5 mx-5">
        <v-text-field
          hide-details
          label="Recherchez un nom, une variété..."
          outlined
          variant="solo-filled"
          @keyup.enter=""
        ></v-text-field>   
  
        <v-row class="mt-4">
          <v-col cols="12" class="d-flex justify-end">
            <v-btn variant="plain" color="accent" large @click="" class="mr-4">
              Réinitialiser
            </v-btn>
            <v-btn color="primary" large @click="">
              Rechercher
            </v-btn>
          </v-col>
        </v-row>
      </div>
    </v-card>
  </template>