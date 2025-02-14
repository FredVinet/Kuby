import apiClient from '../index';
import type { User } from '@/api/interfaces/User';
import type { Localisation } from '@/api/interfaces/Localisation';
import type { Address } from '@/api/interfaces/Address';
import { API_ENDPOINTS } from '../endpoints';
import LocalisationService from '@/api/services/LocalisationService';
import AddressService from '@/api/services/AdressService'; 

export default class UserService {

  static async getAllUsers(): Promise<User[]> {
    try {
      const response = await apiClient.get(API_ENDPOINTS.GET_ALL_USERS);
      const users: User[] = response.data || [];

      const localisationsResponse = await LocalisationService.getAllLocalisations();
      const addressesResponse = await AddressService.getAllAddresses();
      const localisations: Localisation[] = localisationsResponse || [];
      const addresses: Address[] = addressesResponse || [];

      const enrichedUsers = users.map(user => {
        const userLocation = localisations.find(loc => loc.id_user === user.user_id);
        const userAddress = userLocation ? addresses.find(addr => addr.adress_id === userLocation.id_adress) : null;

        return {
          ...user,
          localisation: userLocation || null,
          address: userAddress || null,
        };
      });

      return enrichedUsers;
    } catch (error: any) {
      throw new Error(`Error fetching users: ${error.response?.data?.message || error.message}`);
    }
  }

  static async getUserById(userId: number): Promise<User> {
    try {
      const endpoint = API_ENDPOINTS.GET_USER_BY_ID.replace(':id', userId.toString())
      const response = await apiClient.get(endpoint)

      const user = response.data

      return user
    } catch (error: any) {
      throw new Error(`Error fetching user: ${error.response?.data?.message || error.message}`)
    }
  }

  static async getUsersByType(userType: number): Promise<User[]> {
    try {
      const response = await apiClient.get(`${API_ENDPOINTS.GET_USERS_BY_TYPE}/${userType}`);
      const users: User[] = response.data || [];

      const localisationsResponse = await LocalisationService.getAllLocalisations();
      const addressesResponse = await AddressService.getAllAddresses();
      const localisations: Localisation[] = localisationsResponse || [];
      const addresses: Address[] = addressesResponse || [];

      const enrichedUsers = users.map(user => {
        const userLocation = localisations.find(loc => loc.id_user === user.user_id);
        const userAddress = userLocation ? addresses.find(addr => addr.adress_id === userLocation.id_adress) : null;

        return {
          ...user,
          localisation: userLocation || null,
          address: userAddress || null,
        };
      });

      return enrichedUsers;
    } catch (error: any) {
      throw new Error(`Error fetching users by type: ${error.response?.data?.message || error.message}`);
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
      const response = await apiClient.put(endpoint, { ...details_user, id: id }) 
      return response.data
    } catch (error: any) {
      throw new Error(`Error updating user: ${error.response?.data?.message || error.message}`)
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
