import apiClient from '../index';
import type { Grape } from '@/api/interfaces/Grape'
import { API_ENDPOINTS } from '../endpoints';

export default class GrapeService {

  static async getGrapeById(grapeId: number): Promise<Grape> {
    try {
      const endpoint = API_ENDPOINTS.GET_GRAPE_BY_ID.replace('{grapeId}', grapeId.toString());
      const response = await apiClient.get(endpoint);
  
      console.log("Article récupéré :", response.data);
  
      return response.data;
    } catch (error: any) {
      console.error("Erreur lors de la récupération de l'article :", error);
      throw new Error(`Error fetching article: ${error.response?.data?.message || error.message}`);
    }
  }
}