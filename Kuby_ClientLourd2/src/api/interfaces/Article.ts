import type { Supplier } from "./Supplier";

export interface Article {
    article_id?: number; 
    article_name: string;
    article_description?: string;
    article_yearprod?: number;
    article_price: number;
    article_quantity_in: number;
    article_quantity_out: number;
    id_family: number;
    id_grape: number;
    user_id:number;
    grape_name: string;
    family_name: string;
    user_name: string;
}

