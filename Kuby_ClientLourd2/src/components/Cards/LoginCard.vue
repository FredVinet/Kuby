<!-- eslint-disable vue/multi-word-component-names -->
<template>
    <v-sheet class="d-flex align-center justify-center position-relative" height="100vh">
      <img src="../assets/icons/Printer_Noir.png" alt="Printer Icon" class="background-image" />
  
      <div class="text-center" style="z-index: 2">
        <h1 class="ml-4" style="font-size: 96px; font-weight: bold; color: #d1c4a7; text-align: left">
          Label<span style="color: #000000">7</span>
        </h1>
  
        <v-card
          class="mx-auto px-6 pt-4 rounded-lg d-flex flex-column"
          max-width="400"
          elevation="10"
          style="z-index: 3"
        >
  
          <v-card-title
            class="justify-center text-h4 mb-4"
            style="color: #d1c4a7; font-weight: bold; font-size: 64px"
          >
            Connexion
          </v-card-title>
          <div v-if="error" class="error-message" style="color: red">
            {{ error }}
          </div>
  
          <v-form>
            <v-responsive class="bg-white rounded-lg mx-auto mb-6" width="370">
              <v-text-field
                hide-details="auto"
                label="Votre adresse mail"
                type="email"
                v-model="email"
                name="email"
                autocomplete="username"
              ></v-text-field>
            </v-responsive>
  
            <v-responsive class="bg-white rounded-lg mx-auto mb-6" width="370">
              <v-text-field
                label="Votre mot de passe"
                hide-details="auto"
                type="password"
                v-model="password"
                name="password"
                autocomplete="current-password"
              ></v-text-field>
            </v-responsive>
  
            <div class="checkbox-container my-10">
              <input type="checkbox" id="remember-me" class="checkbox-input" />
              <label for="remember-me" class="checkbox-label">
                Se souvenir de vos identifiants
              </label>
            </div>
  
            <v-dialog v-model="dialog" max-width="400">
              <template v-slot:activator="{ props: activatorProps }">
                <v-btn class="rounded-lg mb-4" @click="openForgotPasswordDialog">
                  Mot de passe oublié
                </v-btn>
                <v-btn
                  class="rounded-lg"
                  width="250"
                  height="70"
                  color="primary"
                  size="large"
                  type="button"
                  @click="attemptLogin"
                >
                  Se connecter
                </v-btn>
  
                <v-btn class="rounded-lg my-4" @click="openFirstLoginDialog">
                  Première connexion
                </v-btn>
              </template>
  
              <template v-slot:default="">
                <v-card>
                  <h3 class="mt-5 text-accent text-center">Choix des partenaires</h3>
                  <v-card-text>
                    <div class="checkbox-container" :class="{ highlight: selectedOption === 'tous' }">
                      <input
                        type="radio"
                        id="all-partners"
                        name="partners"
                        value="tous"
                        v-model="selectedOption"
                        class="checkbox-input"
                      />
                      <label for="all-partners" class="checkbox-label">
                        Voir tous les partenaires
                      </label>
                    </div>
  
                    <div
                      class="checkbox-container mt-4"
                      :class="{ highlight: selectedOption === 'un_seul' }"
                    >
                      <input
                        type="radio"
                        id="single-partner"
                        name="partners"
                        value="un_seul"
                        v-model="selectedOption"
                        class="checkbox-input"
                      />
                      <label for="single-partner" class="checkbox-label">
                        Voir un seul partenaire
                      </label>
                    </div>
                  </v-card-text>
  
                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn variant="plain" color="primary" @click="dialog = false">
                      <h3>Annuler</h3>
                    </v-btn>
                    <v-btn color="primary" variant="plain" @click="handlePartnerSelection">
                      <h3 class="">Ok</h3>
                    </v-btn>
                  </v-card-actions>
                </v-card>
              </template>
            </v-dialog>
  
            <v-dialog v-model="firstLoginDialog" max-width="400">
              <v-card>
                <h3 class="mt-5 text-accent text-center">Première connexion</h3>
                <v-card-text>
                  <v-text-field
                    label="Votre adresse mail"
                    type="email"
                    v-model="firstLoginEmail"
                    required
                  ></v-text-field>
  
                  <v-btn
                    v-if="!showPasswordField"
                    color="primary"
                    block
                    class="mt-3"
                    @click="handleEmailVerification('firstLogin')"
                  >
                    Vérifier
                  </v-btn>
  
                  <v-text-field
                    v-if="showPasswordField"
                    label="Définissez votre mot de passe"
                    type="password"
                    v-model="firstLoginPassword"
                    required
                  ></v-text-field>
  
                  <div v-if="firstLoginError" class="error-message">{{ firstLoginError }}</div>
                </v-card-text>
  
                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn variant="plain" color="primary" @click="firstLoginDialog = false">
                    <h3>Annuler</h3>
                  </v-btn>
                  <v-btn
                    v-if="showPasswordField"
                    color="primary"
                    variant="plain"
                    @click="setNewPassword"
                  >
                    <h3>Valider</h3>
                  </v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>
  
            <v-dialog v-model="forgotPasswordDialog" max-width="400">
              <v-card>
                <h3 class="mt-5 text-accent text-center">Mot de passe oublié</h3>
                <v-card-text>
                  <v-text-field
                    label="Votre adresse mail"
                    type="email"
                    v-model="forgotPasswordEmail"
                    required
                  ></v-text-field>
  
                  <v-btn
                    v-if="!showForgotPasswordFields"
                    color="primary"
                    block
                    class="mt-3"
                    @click="handleEmailVerification('forgotPassword')"
                  >
                    Vérifier
                  </v-btn>
  
                  <v-text-field
                    v-if="showForgotPasswordFields"
                    label="Nouveau mot de passe"
                    type="password"
                    v-model="forgotPasswordNewPassword"
                    required
                  ></v-text-field>
  
                  <div v-if="forgotPasswordError" class="error-message">{{ forgotPasswordError }}</div>
                </v-card-text>
  
                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn variant="plain" color="primary" @click="forgotPasswordDialog = false">
                    <h3>Annuler</h3>
                  </v-btn>
                  <v-btn
                    v-if="showForgotPasswordFields"
                    color="primary"
                    variant="plain"
                    @click="changePassword"
                  >
                    <h3>Valider</h3>
                  </v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>
          </v-form>
        </v-card>
      </div>
    </v-sheet>
  </template>
  
  <script setup lang="ts">
  import { ref } from 'vue'
  import { useRouter } from 'vue-router'
  import AuthService from '../api/services/AuthService'
  
  import { jwtDecode } from 'jwt-decode'
  import { useMenuStore } from '@/stores/menuStore'
  import { getIds } from '@/utils/auth'
  import { useUserConnectedStore } from '@/stores/userConnected'
  
  const menuStore = useMenuStore()
  const userConnectedStore = useUserConnectedStore()
  
  interface DecodedToken {
    iss: string
    iat: number
    exp: number
    userId: number
    email: string
    profileId: number
  }
  
  // const errorMessage = ref('');
  const dialog = ref(false)
  const selectedOption = ref('')
  const router = useRouter()
  
  const email = ref('')
  const password = ref('')
  const error = ref('')
  
  const isAuthenticated = ref(false)
  const userProfile = ref<DecodedToken | null>(null)
  
  const attemptLogin = async () => {
    try {
      // on ajouter la requete axios + la logique de verification du token ici
  
      // Appel à AuthService pour récupérer le token
      error.value = ''
      const token = await AuthService.login(email.value, password.value)
  
      // Enregistrement du token dans le localStorage
      if (token != null) {
        localStorage.setItem('authToken', token)
  
        // Décodage et validation du token
        const decodedToken: DecodedToken = jwtDecode(token)
        const currentTime = Math.floor(Date.now() / 1000)
  
        if (decodedToken.exp > currentTime) {
          isAuthenticated.value = true
          userProfile.value = decodedToken
  
          // Logique selon le profil utilisateur
          console.log(
            `Utilisateur connecté : ${decodedToken.email} avec le profil ${decodedToken.profileId}`,
          )
          console.log(decodedToken)
          const Ids = getIds(token)
  
          menuStore.setConnectionStatus(true, Ids.profile)
          userConnectedStore.setUserInfo(Ids.profile, Ids.userId)
  
          if (Ids.profile === 'sharper') {
            dialog.value = true
          } else if (Ids.profile === 'brand' || Ids.profile === 'group') {
            router.push('/')
          }
        }
      }
    } catch (err: any) {
      error.value = err.message || 'Une erreur est survenue lors de la connexion.'
      console.error(error.value)
    }
  }
  
  // Constante first login
  const firstLoginDialog = ref(false)
  const firstLoginEmail = ref('')
  const firstLoginPassword = ref('')
  const firstLoginError = ref('')
  const showPasswordField = ref(false)
  
  const firstLoginUserId = ref<number | null>(null) // Variable pour stocker l'ID
  
  const openFirstLoginDialog = () => {
    firstLoginDialog.value = true
    firstLoginEmail.value = ''
    firstLoginPassword.value = ''
    firstLoginError.value = ''
    showPasswordField.value = false
  }
  
  // Constante forgot password
  const forgotPasswordDialog = ref(false);
  const forgotPasswordEmail = ref('');
  const forgotPasswordNewPassword = ref('');
  const forgotPasswordError = ref('');
  const showForgotPasswordFields = ref(false);
  const forgotPasswordUserId = ref<number | null>(null);
  
  const openForgotPasswordDialog = () => {
    forgotPasswordDialog.value = true;
    forgotPasswordEmail.value = '';
    forgotPasswordNewPassword.value = '';
    forgotPasswordError.value = '';
    showForgotPasswordFields.value = false;
  };
  
  // Update de la fonction handleFirstLogin pour utiliser qu'une seule fonction pour la vérification des emails de firstLogin et forgotPassword 
  const handleEmailVerification = async (context: 'firstLogin' | 'forgotPassword') => {
    try {
      // Réinitialiser les erreurs
      if (context === 'firstLogin') {
        firstLoginError.value = '';
      } else {
        forgotPasswordError.value = '';
      }
  
      // Récupérer l'email en fonction du contexte
      const emailToCheck = context === 'firstLogin' ? firstLoginEmail.value : forgotPasswordEmail.value;
  
      // Vérifier si l'email est vide
      if (!emailToCheck) {
        if (context === 'firstLogin') {
          firstLoginError.value = 'Veuillez entrer votre adresse e-mail.';
        } else {
          forgotPasswordError.value = 'Veuillez entrer votre adresse e-mail.';
        }
        return;
      }
  
      // Appeler le service pour vérifier l'email
      const response = await AuthService.checkFirstLogin(emailToCheck);
  
      // Gérer la réponse en fonction du contexte
      if (context === 'firstLogin') {
        if (response.firstLogin) {
          firstLoginUserId.value = response.userId;
          showPasswordField.value = true;
        } else {
          firstLoginError.value = 'Vous vous êtes déjà connecté au moins une fois.';
        }
      } else {
        if (!response.firstLogin) {
          forgotPasswordUserId.value = response.userId;
          showForgotPasswordFields.value = true;
        } else {
          forgotPasswordError.value = 'Cet email n\'est pas associé à un compte existant.';
        }
      }
    } catch (error) {
      // Gérer les erreurs en fonction du contexte
      if (context === 'firstLogin') {
        firstLoginError.value = 'Erreur lors de la vérification. Veuillez réessayer.';
      } else {
        forgotPasswordError.value = 'Erreur lors de la vérification. Veuillez réessayer.';
      }
      console.error(error);
    }
  };
  
  const changePassword = async () => {
    try {
      // Validation du nouveau mot de passe
      if (forgotPasswordNewPassword.value.length < 6) {
        forgotPasswordError.value = 'Le mot de passe doit contenir au moins 6 caractères.';
        return;
      }
  
      // Appel au service pour changer le mot de passe
      const success = await AuthService.changePassword(
        forgotPasswordEmail.value,
        forgotPasswordNewPassword.value,
      );
  
      if (success) {
        forgotPasswordDialog.value = false;
        alert('Mot de passe mis à jour avec succès ! Connectez-vous maintenant.');
      } else {
        forgotPasswordError.value = 'Erreur lors de la mise à jour du mot de passe.';
        console.error('Erreur API: success=false');
      }
    } catch (error) {
      forgotPasswordError.value = 'Erreur lors de la mise à jour du mot de passe.';
      console.error('Erreur changePassword:', error);
    }
  };
  
  const setNewPassword = async () => {
    try {
      if (firstLoginPassword.value.length < 6) {
        firstLoginError.value = 'Le mot de passe doit contenir au moins 6 caractères.'
        return
      }
  
      if (!firstLoginUserId.value) {
        firstLoginError.value = 'Une erreur est survenue. Veuillez réessayer.'
        return
      }
  
      const success = await AuthService.setNewPassword(
        firstLoginUserId.value,
        firstLoginPassword.value,
      )
  
      if (success) {
        console.log('Mot de passe défini avec succès !')
        firstLoginDialog.value = false
        alert('Mot de passe défini avec succès ! Connectez-vous maintenant.')
      } else {
        firstLoginError.value = 'Erreur lors de la définition du mot de passe.'
        console.error('Erreur API: success=false')
      }
    } catch (error) {
      firstLoginError.value = 'Erreur lors de la mise à jour du mot de passe.'
      console.error('Erreur setNewPassword:', error)
    }
  }
  
  const handlePartnerSelection = async () => {
    try {
      //Redirection vers une page sécurisée après la connexion
      if (selectedOption.value === 'tous') {
        router.push('/')
      } else if (selectedOption.value === 'un_seul') {
        router.push('/choice-partner-connect')
      }
    } catch (err: any) {
      error.value = err.message || 'Une erreur est survenue lors de la redirection.'
      console.error(error.value)
    }
  }
  </script>
  
  <style scoped>
  
  .checkbox-container {
    display: flex;
    align-items: left;
    justify-content: left;
  }
  
  .checkbox-input {
    margin-right: 8px;
    width: 20px;
    height: 20px;
    cursor: pointer;
  }
  
  .checkbox-label {
    font-size: 18px;
    color: #000000;
    cursor: pointer;
  }
  
  .highlight {
    padding: 8px;
    border-radius: 8px;
  }
  
  .error-message {
    color: red;
    margin-bottom: 16px; /* Ou toute autre valeur */
  }
  </style>
  