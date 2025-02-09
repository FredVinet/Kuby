import type { OrderItems } from '@/api/interfaces/OrderItems';
import type { Localisation } from '@/api/interfaces/Localisation';

export interface Orders {
  orders_id?: number;
  orders_date: Date;
  orders_status: number;
  orders_amount: number;
  id_localisation: number;

  items: OrderItems[]; 
  localisation: Localisation; 
}
