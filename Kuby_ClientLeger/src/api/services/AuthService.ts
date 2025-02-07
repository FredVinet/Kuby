import apiClient from '../index' // Axios instance
// import type { Address } from '@/api/interfaces/Address';
import { API_ENDPOINTS } from '../endpoints'
import type { User } from '../interfaces/User'

export default class AuthService {
  // Méthode pour se connecter
  static async login(email: string, password: string): Promise<{ user: User; token: string }> {
    try {
      console.log("Tentative de connexion avec :", { email, password }); // Log pour déboguer
      const response = await apiClient.post(API_ENDPOINTS.LOGIN, {
        email,
        password,
      });

      console.log('Réponse de l\'API:', response.data); // Log pour déboguer

      return {
        user: response.data.user, // Assurez-vous que votre API renvoie l'utilisateur sous `response.data.user`
        token: response.data.token, // Assurez-vous que votre API renvoie le token sous `response.data.token`
      };
    } catch (error: any) {
        console.error('Erreur lors de la connexion:', error.response?.data); // Log pour déboguer
      throw new Error(
        `Erreur lors de la connexion : ${error.response?.data?.message || error.message}`,
      );
    }
  }

  static async checkFirstLogin(email: string): Promise<{ userId: number; firstLogin: boolean }> {
    try {
      const response = await apiClient.post(API_ENDPOINTS.CHECK_FIRST_LOGIN, {
        email,
      })

      return response.data
    } catch (error: any) {
      throw new Error(
        `Erreur lors de la vérification de la première connexion : ${error.response?.data?.message || error.message}`,
      )
    }
  }

  static async setNewPassword(userId: number, newPassword: string): Promise<boolean> {
    try {
      const response = await apiClient.post(API_ENDPOINTS.SET_NEW_PASSWORD, {
        userId,
        newPassword,
      })

      console.log('Réponse API setNewPassword:', response.data)

      return response.data.success || response.data.message === 'Mot de passe défini avec succès.'
    } catch (error: any) {
      throw new Error(
        `Erreur lors de la définition du mot de passe : ${error.response?.data?.message || error.message}`,
      )
    }
  }

  static async updatePassword(
    userId: number,
    userEmail: string,
    newPassword: string,
    oldPassword: string,
    authJwt: string,
  ): Promise<Boolean> {
    try {
      const response = await apiClient.post(API_ENDPOINTS.UPDATE_PASSWORD, {
        userId,
        userEmail,
        newPassword,
        oldPassword,
        authJwt,
      })

      // Retourne le token reçu
      return response.data.success
    } catch (error: any) {
      throw new Error(
        `Erreur lors de la connexion : ${error.response?.data?.message || error.message}`,
      )
    }
  }

  static async changePassword(
    userEmail: string,
    newPassword: string,
  ): Promise<boolean> {
    try {
      const response = await apiClient.post(API_ENDPOINTS.CHANGE_PASSWORD, {
        userEmail,
        newPassword,
      });
  
      return response.data.success;
    } catch (error: any) {
      throw new Error(
        `Erreur lors du changement de mot de passe : ${error.response?.data?.message || error.message}`,
      );
    }
  }
}
