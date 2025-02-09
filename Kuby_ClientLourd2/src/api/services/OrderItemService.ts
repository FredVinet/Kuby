import apiClient from '../index'
import type { OrderItems } from '@/api/interfaces/OrderItems'
import { API_ENDPOINTS } from '../endpoints'

export default class OrderItemService {

  static async getAllOrdersItems(): Promise<OrderItems[]> {
    try {
      const response = await apiClient.get(API_ENDPOINTS.GET_ALL_ORDER_ITEMS)
      return response.data
    } catch (error: any) {
      throw new Error(`Error fetching users: ${error.response?.data?.message || error.message}`)
    }
  }

  static async createOrderItem(orderItems: OrderItems): Promise<OrderItems> {
    try {
      const response = await apiClient.post(API_ENDPOINTS.CREATE_ORDER_ITEM, orderItems)
      return response.data
    } catch (error: any) {
      throw new Error(
        `Error creating order item: ${error.response?.data?.message || error.message}`,
      )
    }
  }
}
