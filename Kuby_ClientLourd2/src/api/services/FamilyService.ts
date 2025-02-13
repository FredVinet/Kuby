import apiClient from '../index';
import type { Family } from '@/api/interfaces/Family'
import { API_ENDPOINTS } from '../endpoints';

export default class FamilyService {

  static async getAllFamily(): Promise<Family[]> {
    try {
      const response = await apiClient.get(API_ENDPOINTS.GET_ALL_FAMILIES);
      return response.data;
    } catch (error: any) {
      throw new Error(`Error fetching family: ${error.response?.data?.message || error.message}`);
    }
  }

  static async createFamily(family: Family): Promise<Family> {
    try {
      const response = await apiClient.post(API_ENDPOINTS.CREATE_FAMILY, family)
      return response.data
    } catch (error: any) {
      throw new Error(`Error creating family: ${error.response?.data?.message || error.message}`)
    }
  }

}