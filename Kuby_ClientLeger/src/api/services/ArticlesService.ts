import apiClient from '../index';
import type { Article } from '@/api/interfaces/Article'
import { API_ENDPOINTS } from '../endpoints';

export default class ArticleService {
  private static parseArticlesDetails(article: any): Article {
    return {
      ...article,
      article_price: article.article_price, // Conversion en nombre
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

  static async getArticleById(articleId: number): Promise<Article> {
    try {
      const endpoint = API_ENDPOINTS.GET_ARTICLES_BY_ID.replace('{articleId}', articleId.toString());
      const response = await apiClient.get(endpoint);
  
      console.log("Article récupéré :", response.data);
  
      return this.parseArticlesDetails(response.data);
    } catch (error: any) {
      console.error("Erreur lors de la récupération de l'article :", error);
      throw new Error(`Error fetching article: ${error.response?.data?.message || error.message}`);
    }
  }
}