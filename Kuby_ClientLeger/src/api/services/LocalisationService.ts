import apiClient from '../index'
import type { Adress } from '@/api/interfaces/Adress'
import { API_ENDPOINTS } from '../endpoints'
import type { Localisation } from '../interfaces/Localisation';

export default class LocalisationService {

    static async getLocalisationByAdressId(adressId: number): Promise<Localisation | null> {
        try {
          const endpoint = API_ENDPOINTS.GET_LOCALISATION_BY_ADRESS_ID.replace('{adressId}', adressId.toString());
          const response = await apiClient.get(endpoint);
          return response.data;
        } catch (error: any) {
          console.error('Erreur lors de la récupération de la localisation :', error);
          return null;
        }
      }
      
}
