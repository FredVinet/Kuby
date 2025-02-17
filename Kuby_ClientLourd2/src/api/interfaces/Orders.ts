import type { OrderItems } from '@/api/interfaces/OrderItems';
import type { Localisation } from '@/api/interfaces/Localisation';

export interface Orders {
  orders_id: number;
  orders_date: string; 
  orders_status: number;
  orders_amount: number;
  id_localisation: number;
  id_user: number;
  userType: number;
  user_name: string;
  user_firstname: string;
  id_adress: number;
  adress_number: number;
  adress_name: string;
  adress_city: string;
  adress_code: string;
  adress_state: string;
  adress_country: string;
  
}

