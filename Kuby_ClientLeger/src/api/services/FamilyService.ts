import apiClient from '../index';
import type { Family } from '@/api/interfaces/Family'
import { API_ENDPOINTS } from '../endpoints';

export default class FamilyService {

  static async getFamilyById(familyId: number): Promise<Family> {
    try {
      const endpoint = API_ENDPOINTS.GET_FAMILY_BY_ID.replace('{familyId}', familyId.toString());
      const response = await apiClient.get(endpoint);
  
      console.log("Article récupéré :", response.data);
  
      return response.data;
    } catch (error: any) {
      console.error("Erreur lors de la récupération de l'article :", error);
      throw new Error(`Error fetching article: ${error.response?.data?.message || error.message}`);
    }
  }

  static async getAllFamilies(): Promise<Family[]> {
    try {
      const response = await apiClient.get(API_ENDPOINTS.GET_ALL_FAMILIES)
      return response.data
    } catch (error: any) {
      throw new Error(`Error fetching users: ${error.response?.data?.message || error.message}`)
    }
  }
}