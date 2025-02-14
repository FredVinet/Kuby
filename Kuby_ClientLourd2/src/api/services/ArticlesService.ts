import apiClient from '../index';
import type { Article } from '@/api/interfaces/Article'
import { API_ENDPOINTS } from '../endpoints';

export default class ArticleService {
  private static parseArticlesDetails(article: any): Article {
    return {
      ...article,
      article_price: article.article_price, 
    };
  }

  static async getAllArticles(): Promise<Article[]> {
    try {
      const response = await apiClient.get(API_ENDPOINTS.GET_ALL_ARTICLES_DETAILS);
      return response.data.map(this.parseArticlesDetails);
    } catch (error: any) {
      throw new Error(`Error fetching products: ${error.response?.data?.message || error.message}`);
    }
  }

  static async createArticle(id: number,article: Article): Promise<Article> {
    try {
      const response = await apiClient.post(API_ENDPOINTS.CREATE_ARTICLE.replace(':id', id.toString()), article)
      return response.data
    } catch (error: any) {
      throw new Error(`Error creating article: ${error.response?.data?.message || error.message}`)
    }
  }

  static async deleteArticle(article_id: number): Promise<void> {
    try {
      const endpoint = API_ENDPOINTS.DELETE_ARTICLE.replace(':id', article_id.toString());
      await apiClient.delete(endpoint);
    } catch (error: any) {
      throw new Error(`Error deleting address: ${error.response?.data?.message || error.message}`);
    }
  }

}