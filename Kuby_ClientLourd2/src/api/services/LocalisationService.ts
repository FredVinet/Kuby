import apiClient from '../index';
import type { Localisation } from '@/api/interfaces/Localisation';
import { API_ENDPOINTS } from '../endpoints';

export default class LocalisationService {
  static async getAllLocalisations(): Promise<Localisation[]> {
    try {
      const response = await apiClient.get(API_ENDPOINTS.GET_ALL_LOCALISATIONS);
      return response.data;
    } catch (error: any) {
      throw new Error(`Erreur lors de la récupération des localisations: ${error.response?.data?.message || error.message}`);
    }
  }

  static async getLocalisationById(localisationId: number): Promise<Localisation> {
    try {
      const endpoint = API_ENDPOINTS.GET_LOCALISATION_BY_ID.replace(':id', localisationId.toString());
      const response = await apiClient.get(endpoint);
      return response.data;
    } catch (error: any) {
      throw new Error(`Erreur lors de la récupération de la localisation: ${error.response?.data?.message || error.message}`);
    }
  }
}
