import type { User } from '@/api/interfaces/User';

export interface Localisation {
  localisation_id?: number;
  id_user: number;
  id_adress: number;
  user?: User; 
}
