import apiClient from '../index'
import type { User } from '@/api/interfaces/User'
import { API_ENDPOINTS } from '../endpoints'

export default class UserService {

  static async getAllUsers(): Promise<User[]> {
    try {
      const response = await apiClient.get(API_ENDPOINTS.GET_ALL_USERS)
      return response.data
    } catch (error: any) {
      throw new Error(`Error fetching users: ${error.response?.data?.message || error.message}`)
    }
  }

  static async getUserById(userId: number): Promise<User> {
    try {
      const endpoint = API_ENDPOINTS.GET_USER_BY_ID.replace('{userId}', userId.toString())
      const response = await apiClient.get(endpoint)

      const user = response.data

      return user
    } catch (error: any) {
      throw new Error(`Error fetching user: ${error.response?.data?.message || error.message}`)
    }
  }

  static async createUser(user: User): Promise<User> {
    try {
      const response = await apiClient.post(API_ENDPOINTS.CREATE_USER, user)
      return response.data
    } catch (error: any) {
      throw new Error(`Error creating user: ${error.response?.data?.message || error.message}`)
    }
  }

  static async updateUser(id: number, details_user: Partial<User>): Promise<User> {
    try {
      const endpoint = API_ENDPOINTS.UPDATE_USER.replace(':id', id.toString())
      const response = await apiClient.put(endpoint, { ...details_user, id: id }) // Envoie un objet plat
      return response.data
    } catch (error: any) {
      throw new Error(`Error updating user: ${error.response?.data?.message || error.message}`)
    }
  }

  static async updatePassword(
    userId: number,
    newPassword: string
  ): Promise<boolean> {
    try {
      const endpoint = API_ENDPOINTS.UPDATE_PASSWORD.replace('{userId}', userId.toString());
      
      // Envoyer la requête POST avec le nouveau mot de passe
      const response = await apiClient.post(endpoint, {
        newPassword: newPassword // Assurez-vous que le nom de la clé correspond à ce que l'API attend
      });
  
      if (response.data === "Mot de passe mis à jour avec succès") {
        return true;
      } else {
        throw new Error(response.data.message || "Une erreur est survenue.");
      }
    } catch (error: any) {
      throw new Error(
        `Erreur lors de la mise à jour du mot de passe : ${error.response?.data?.message || error.message}`
      );
    }
  }
  

  static async deleteUser(userId: number): Promise<void> {
    try {
      const endpoint = API_ENDPOINTS.DELETE_USER.replace(':id', userId.toString())
      await apiClient.delete(endpoint)
    } catch (error: any) {
      throw new Error(`Error deleting user: ${error.response?.data?.message || error.message}`)
    }
  }
}
