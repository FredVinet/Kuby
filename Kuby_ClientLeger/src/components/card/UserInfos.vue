<template>
  <v-card
    elevation="16"
    max-width="40%"
    border="opacity-50 md info"
    rounded="lg"
    class="mx-auto my-8"
  >
    <v-card-title class="text-center text-accent my-2 font-weight-bold">
      <h1 class="text-info">Vos informations</h1>
    </v-card-title>

    <v-card-text v-if="userDetails">
      <v-row class="align-start">
        <v-col :cols="12" :md="6" class="text-left px-2">
          <v-card-text class="text-accent">
            <div class="py-1">
              <h2 class="text-md">
                Vous :
                <span class="font-weight-light">
                  {{ userDetails.user_firstname }} {{ userDetails.user_name }}
                </span>
              </h2>
            </div>
            <div class="py-1">
              <h2 class="text-md">
                Mail :
                <span class="font-weight-light">
                  {{ userDetails.userMail || 'Non communiqué' }}
                </span>
              </h2>
            </div>
            <div class="py-1">
              <h2 class="text-md">
                Téléphone :
                <span class="font-weight-light">
                  {{ userDetails.user_phone || 'Non communiqué' }}
                </span>
              </h2>
            </div>
          </v-card-text>
        </v-col>
      </v-row>
    </v-card-text>

    <v-divider class="my-4"></v-divider>

    <v-card-actions class="d-flex flex-wrap justify-center align-center gap-4 mb-4">
      <v-btn rounded="lg" class="bg-primary text-white" variant="text" @click="openModalPassword">
        Modifier votre mot de passe
      </v-btn>
    </v-card-actions>

    <!-- Modale pour modifier le mot de passe -->
    <v-dialog v-model="isModalPasswordOpen" max-width="500px">
      <v-card>
        <v-card-title>
          <h3>Modifier votre mot de passe</h3>
        </v-card-title>
        <!-- Affichez le message d'erreur si apiError est défini -->
        <v-alert
          v-if="apiError"
          type="error"
          class="mb-4 api-error"
          dismissible
          @click:close="apiError = null"
          >{{ apiError }}</v-alert
        >
        <v-card-text>
          <v-form ref="form">
            <v-text-field
              label="Nouveau mot de passe"
              type="password"
              v-model="newPassword"
              required
            ></v-text-field>
            <v-text-field
              label="Confirmer le nouveau mot de passe"
              type="password"
              v-model="confirmPassword"
              required
            ></v-text-field>
          </v-form>
        </v-card-text>
        <v-card-actions>
          <v-btn rounded="lg" class="bg-secondary mb-2" variant="text" @click="closeModal"
            >Annuler</v-btn
          >
          <v-btn rounded="lg" class="bg-primary mb-2" variant="text" @click="submitForm()"
            >Valider</v-btn
          >
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-card>
</template>

<script setup lang="ts">
import { computed, onMounted, ref } from 'vue'
import { useUserConnectedStore } from '@/stores/userConnected'
import UserService from '@/api/services/UserService'


const userConnectedStore = useUserConnectedStore()

onMounted(async () => {
  await userConnectedStore.initializeFromToken()
})
const userDetails = computed(() => userConnectedStore.userDetails || {})

// État de la modale
const isModalPasswordOpen = ref(false)

// Champs du formulaire
const newPassword = ref('')
const confirmPassword = ref('')
const apiError = ref<string | null>(null)

// Ouvrir la modale
const openModalPassword = () => {
  isModalPasswordOpen.value = true
}

// Fermer la modale
const closeModal = () => {
  isModalPasswordOpen.value = false
}



const submitForm = async () => {
  // Vérifier que les champs ne sont pas vides
  if (!newPassword.value || !confirmPassword.value) {
    apiError.value = 'Veuillez remplir tous les champs.';
    return;
  }

  // Vérifier que les mots de passe correspondent
  if (newPassword.value === confirmPassword.value) {
    try {
      
      // Appel à l'API pour mettre à jour le mot de passe
      const success = await UserService.updatePassword(
        userDetails.value.user_id ?? 0,
        newPassword.value
      );

      if (success) {
        closeModal();
      } else {
        apiError.value = 'Échec de la mise à jour du mot de passe.';
      }
    } catch (err: any) {
      apiError.value = err.message || 'Une erreur est survenue lors de la mise à jour du mot de passe.';
    }
  } else {
    apiError.value = 'Les mots de passe ne correspondent pas.';
  }
};

</script>

<style scoped>
.api-error {
  margin: 16px; /* Augmenter le padding */
  padding: 16px; /* Augmenter le padding */
}
.api-response {
  border: 1px solid #28a745;
  background-color: #d4edda;
  color: #155724;
  margin: 16px; /* Augmenter le padding */
  padding: 16px; /* Augmenter le padding */
  border-radius: 4px; /* Optionnel : arrondir les coins */
  margin-bottom: 1rem; /* Espacement en bas */
}
</style>
