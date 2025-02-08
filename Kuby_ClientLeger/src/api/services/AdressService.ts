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
}
