import { defineStore } from 'pinia';
import { ref } from 'vue';
import { getIds, isTokenValid, setToken, removeToken, getToken } from '@/utils/auth'; // Importez les nouvelles fonctions
import AuthService from '@/api/services/AuthService';
import UserService from '@/api/services/UserService';
import { useCartStore } from '@/stores/cartStore';
import type { User } from '@/api/interfaces/User';

export const useUserConnectedStore = defineStore('userConnected', () => {
  const userId = ref<number | null>(null);
  const userDetails = ref<User | null>(null);

  // Méthode pour gérer la connexion
  const login = async (credentials: { email: string; password: string }) => {
    try {
      // Appeler le service de connexion
      const { user, token } = await AuthService.login(credentials.email, credentials.password);

      // Stocker les informations de l'utilisateur dans le store
      userId.value = user.user_id;
      userDetails.value = user;

      // Stocker le token dans le localStorage
      if (token) {
        setToken(token); // Utilisez setToken pour stocker le token
      }

      alert('Connexion réussie!');
    } catch (error) {
      console.error('Erreur de connexion:', error);
      alert('Erreur de connexion: ' + error.message);
    }
  };

  // Méthode pour déconnecter l'utilisateur
  const logout = () => {
    clearUserInfo();
    alert('Déconnexion réussie!');
  };

  // Méthode pour effacer les informations de l'utilisateur
  const clearUserInfo = () => {
    userId.value = null;
    userDetails.value = null;

    removeToken(); // Utilisez removeToken pour supprimer le token
    localStorage.removeItem('cart');

    useCartStore().$reset();
  };

  // Méthode pour initialiser l'utilisateur à partir du token
  const initializeFromToken = async () => {
    const token = getToken(); // Utilisez getToken pour récupérer le token
    if (token && isTokenValid(token)) {
      const ids = getIds(token);
      userId.value = ids.userId;

      await fetchUserInfo();
    } else {
      clearUserInfo();
    }
  };

  // Méthode pour récupérer les informations de l'utilisateur
  const fetchUserInfo = async () => {
    if (!userId.value) {
      console.error('Aucun ID utilisateur');
      return;
    }

    try {
      const details = await UserService.getUserById(userId.value);
      userDetails.value = details;
    } catch (error) {
      console.error('Erreur lors de la récupération des détails utilisateur :', error);
      userDetails.value = null;
    }
  };

  return {
    userId,
    userDetails,
    login,
    logout,
    clearUserInfo,
    initializeFromToken,
    fetchUserInfo,
  };
});