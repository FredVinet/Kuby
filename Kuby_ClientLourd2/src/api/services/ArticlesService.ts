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
      const response = await apiClient.get(API_ENDPOINTS.GET_ALL_ARTICLES);
      return response.data.map(this.parseArticlesDetails);
    } catch (error: any) {
      throw new Error(`Error fetching products: ${error.response?.data?.message || error.message}`);
    }
  }

  static async createArticle(article: Article): Promise<Article> {
    try {
      const response = await apiClient.post(API_ENDPOINTS.CREATE_ARTICLE, article)
      return response.data
    } catch (error: any) {
      throw new Error(`Error creating article: ${error.response?.data?.message || error.message}`)
    }
  }

}