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

  static async createArticle(id: number,article: Article): Promise<Article> {
    try {
      const response = await apiClient.post(API_ENDPOINTS.CREATE_ARTICLE.replace(':id', id.toString()), article)
      return response.data
    } catch (error: any) {
      throw new Error(`Error creating article: ${error.response?.data?.message || error.message}`)
    }
  }

  static async updateArticle(id: number, details_article: Partial<Article>, userId: number): Promise<Article> {
    try {
        const endpoint = API_ENDPOINTS.UPDATE_ARTICLE.replace(':id', id.toString());
        
        const response = await apiClient.put(endpoint, 
            { 
                ...details_article, 
                id: id 
            }, 
            {
                params: { userId } 
            }
        );
        
        return response.data;
    } catch (error: any) {
        throw new Error(`Erreur lors de la mise à jour de l'article: ${error.response?.data?.message || error.message}`);
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