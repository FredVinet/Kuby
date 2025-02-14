import apiClient from '../index';
import type { SupplierArticle } from '@/api/interfaces/Supplier'
import { API_ENDPOINTS } from '../endpoints';

export default class SupplierService {

  static async getAllSupplierArticles(): Promise<SupplierArticle[]> {
    try {
      const response = await apiClient.get(API_ENDPOINTS.GET_ALL_SUPPLIER_ARTICLES);
      return response.data;
      console.log(response.data)
    } catch (error: any) {
      throw new Error(`Error fetching products: ${error.response?.data?.message || error.message}`);
    }
  }

  static async createSupplierArticle(supplierArticle: SupplierArticle): Promise<SupplierArticle> {
    try {
      const response = await apiClient.post(API_ENDPOINTS.CREATE_SUPPLIER_ARTICLE, supplierArticle)
      return response.data
    } catch (error: any) {
      throw new Error(`Error creating supplierArticle: ${error.response?.data?.message || error.message}`)
    }
  }

}