import apiClient from '../index';
import type { SupplierArticle } from '@/api/interfaces/SupplierArticle'
import { API_ENDPOINTS } from '../endpoints';
import ArticleService from './ArticlesService';
import type { Article } from '../interfaces/Article';

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

  static async updateSupplierArticle(id: number, details_supplier: Partial<SupplierArticle>): Promise<SupplierArticle> {
    try {
      const endpoint = API_ENDPOINTS.CREATE_SUPPLIER_ARTICLE.replace(':id', id.toString())
      const response = await apiClient.put(endpoint, { ...details_supplier, id: id }) 
      return response.data
    } catch (error: any) {
      throw new Error(`Error updating article: ${error.response?.data?.message || error.message}`)
    }
  }

  static async getArticlesBySupplierId(userId: number): Promise<SupplierArticle> {
    try {
      const endpoint = API_ENDPOINTS.GET_SUPPLIER_ARTICLE_BY_USER_ID.replace('{userId}', userId.toString());
      const supplierArticles = await apiClient.get(endpoint);
      return supplierArticles.data;
    } catch (error: any) {
      throw new Error(`Error fetching articles for supplier: ${error.response?.data?.message || error.message}`);
    }
  }

}