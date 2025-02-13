import apiClient from '../index';
import type { Orders } from '@/api/interfaces/Orders';
import type { Localisation } from '@/api/interfaces/Localisation';
import type { User } from '@/api/interfaces/User';
import type { OrderItems } from '@/api/interfaces/OrderItems';
import type { Article } from '@/api/interfaces/Article';
import type { Address } from '@/api/interfaces/Adress';
import { API_ENDPOINTS } from '../endpoints';

import UserService from '@/api/services/UserService';
import OrderItemService from '@/api/services/OrderItemService';
import LocalisationService from '@/api/services/LocalisationService';
import ArticleService from '@/api/services/ArticlesService';
import AddressService from '@/api/services/AdressService'; 

export default class OrderService {
  static async getAllOrders(): Promise<Orders[]> {
    try {
      const ordersResponse = await apiClient.get(API_ENDPOINTS.GET_ALL_ORDERS);
      const orderItemsResponse = await OrderItemService.getAllOrdersItems();
      const localisationsResponse = await LocalisationService.getAllLocalisations();
      const usersResponse = await UserService.getAllUsers();
      const articlesResponse = await ArticleService.getAllArticles();
      const addressesResponse = await AddressService.getAllAddresses(); 

      const orders: Orders[] = ordersResponse.data || [];
      const orderItems: OrderItems[] = orderItemsResponse || [];
      const localisations: Localisation[] = localisationsResponse || [];
      const users: User[] = usersResponse || [];
      const articles: Article[] = articlesResponse || [];
      const addresses: Address[] = addressesResponse || [];

      const enrichedLocalisations = localisations.map(loc => ({
        ...loc,
        user: users.find(user => user.user_id === loc.id_user) || null,
        address: addresses.find(addr => addr.adress_id === loc.id_adress) || null, 
      }));

      const enrichedOrderItems = orderItems.map(item => ({
        ...item,
        article: articles.find(article => article.article_id === item.id_article) || null,
      }));

      const enrichedOrders = orders.map(order => ({
        ...order,
        items: enrichedOrderItems.filter(item => item.id_order === order.orders_id),
        localisation: enrichedLocalisations.find(loc => loc.localisation_id === order.id_localisation) || null,
      }));

      return enrichedOrders;
    } catch (error: any) {
      throw new Error(`Erreur lors de la récupération des commandes: ${error.response?.data?.message || error.message}`);
    }
  }
}
