import apiClient from '../index'
import type { Adress } from '@/api/interfaces/Adress'
import { API_ENDPOINTS } from '../endpoints'

export default class AdressService {

    static async getAddressesByUserId(userId: number): Promise<Adress[]> {
      try {
        const endpoint = API_ENDPOINTS.GET_ADRESSES_BY_USER_ID.replace('{userId}', userId.toString());
        const response = await apiClient.get(endpoint);
        return response.data;
      } catch (error: any) {
        throw new Error(`Error fetching addresses by user: ${error.response?.data?.message || error.message}`);
      }
    }

    static async updateAddress(addressId: number, address: Partial<Adress>): Promise<Adress> {
      try {
        const endpoint = API_ENDPOINTS.UPDATE_ADRESSES.replace('{adressId}', addressId.toString());
        const response = await apiClient.put(endpoint, address);
        return response.data;
      } catch (error: any) {
        throw new Error(`Error updating address: ${error.response?.data?.message || error.message}`);
      }
    }
  
    static async deleteAddress(addressId: number): Promise<void> {
      try {
        const endpoint = API_ENDPOINTS.DELETE_ADRESSES.replace('{adressId}', addressId.toString());
        await apiClient.delete(endpoint);
      } catch (error: any) {
        throw new Error(`Error deleting address: ${error.response?.data?.message || error.message}`);
      }
    }
}
