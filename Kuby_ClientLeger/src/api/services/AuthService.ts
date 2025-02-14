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
}
