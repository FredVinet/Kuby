import apiClient from '../index';
import { API_ENDPOINTS } from '../endpoints';

export const ArticleService = {
    async getAllArticles() {
        try {
            const response = await apiClient.get(API_ENDPOINTS.GET_ALL_ARTICLES);
            return response.data;
        } catch (error) {
            console.error('Error fetching articles:', error);
            throw error;
        }
    }
};