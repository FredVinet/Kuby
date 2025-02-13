import apiClient from '../index';
import type { Grape } from '@/api/interfaces/Grape'
import { API_ENDPOINTS } from '../endpoints';

export default class GrapeService {

  static async getAllGrape(): Promise<Grape[]> {
    try {
      const response = await apiClient.get(API_ENDPOINTS.GET_ALL_GRAPES);
      return response.data;
    } catch (error: any) {
      throw new Error(`Error fetching grape: ${error.response?.data?.message || error.message}`);
    }
  }

  static async createGrape(grape: Grape): Promise<Grape> {
    try {
      const response = await apiClient.post(API_ENDPOINTS.CREATE_GRAPE, grape)
      return response.data
    } catch (error: any) {
      throw new Error(`Error creating grape: ${error.response?.data?.message || error.message}`)
    }
  }

}