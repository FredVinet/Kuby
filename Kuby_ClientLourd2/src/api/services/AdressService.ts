import apiClient from '../index';
import type { Address } from '@/api/interfaces/Adress';
import { API_ENDPOINTS } from '../endpoints';

export default class AddressService {

  static async getAllAddresses(): Promise<Address[]> {
    try {
      const response = await apiClient.get(API_ENDPOINTS.GET_ALL_ADRESSES);
      return response.data;
    } catch (error: any) {
      throw new Error(`Error fetching addresses: ${error.response?.data?.message || error.message}`);
    }
  }

  static async createAddress(address: Address): Promise<Address> {
    try {
      const response = await apiClient.post(API_ENDPOINTS.CREATE_ADRESSES, address);
      return response.data;
    } catch (error: any) {
      throw new Error(`Erreur lors de la création de l'adresse: ${error.response?.data?.message || error.message}`);
    }
  }

  static async updateAddress(id: number, address: Partial<Address>): Promise<Address> {
    try {
      const endpoint = API_ENDPOINTS.UPDATE_ADRESSES.replace(':id', id.toString());
      const response = await apiClient.put(endpoint, address);
      return response.data;
    } catch (error: any) {
      throw new Error(`Erreur lors de la mise à jour de l'adresse: ${error.response?.data?.message || error.message}`);
    }
  }

  static async getAddressesByUserId(userId: number): Promise<Address[]> {
    try {
      const endpoint = API_ENDPOINTS.GET_ADRESSES_BY_USER_ID.replace('{userId}', userId.toString());
      const response = await apiClient.get(endpoint);
      return response.data;
    } catch (error: any) {
      throw new Error(`Error fetching addresses by user: ${error.response?.data?.message || error.message}`);
    }
  }

}
