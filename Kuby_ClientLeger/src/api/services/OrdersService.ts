import apiClient from '../index'
import type { Orders } from '@/api/interfaces/Orders'
import { API_ENDPOINTS } from '../endpoints'

export default class OrderService {

  static async createOrder(orders: Orders): Promise<Orders> {
    try {
      const response = await apiClient.post(API_ENDPOINTS.CREATE_ORDER, orders)
      return response.data
    } catch (error: any) {
      throw new Error(`Error creating order: ${error.response?.data?.message || error.message}`)
    }
  }

  static async getOrdersByUserId(userId: number): Promise<Orders> {
    try {
      const endpoint = API_ENDPOINTS.GET_ORDERS_BY_USER_ID.replace('{userId}', userId.toString())
      const response = await apiClient.get(endpoint)

      const user = response.data

      return user
    } catch (error: any) {
      throw new Error(`Error fetching user: ${error.response?.data?.message || error.message}`)
    }
  }
}
