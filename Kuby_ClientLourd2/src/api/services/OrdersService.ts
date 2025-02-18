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
      const response = await apiClient.get(API_ENDPOINTS.GET_ALL_ORDERS_DETAILS)
      return response.data
    } catch (error: any) {
      throw new Error(`Error fetching users: ${error.response?.data?.message || error.message}`)
    }
  }

  static async createOrder(orders: Orders): Promise<Orders> {
    try {
      const response = await apiClient.post(API_ENDPOINTS.CREATE_ORDER, orders)
      return response.data
    } catch (error: any) {
      throw new Error(`Error creating order: ${error.response?.data?.message || error.message}`)
    }
  }

  static async deleteOrder(orders_id: number): Promise<void> {
    try {
      const endpoint = API_ENDPOINTS.DELETE_ORDER.replace(':id', orders_id.toString());
      await apiClient.delete(endpoint);
    } catch (error: any) {
      throw new Error(`Error deleting address: ${error.response?.data?.message || error.message}`);
    }
  }
  
  static async updateOrder(order: Orders): Promise<Orders> {
    try {
      const endpoint = API_ENDPOINTS.UPDATE_ORDER.replace(':id', order.orders_id.toString());
      const response = await apiClient.put(endpoint, order);
      return response.data;
    } catch (error: any) {
      throw new Error(`Error updating order: ${error.response?.data?.message || error.message}`);
    }
  }
  

}
