import apiClient from '../index';
import type { Address } from '@/api/interfaces/Address';
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
}
