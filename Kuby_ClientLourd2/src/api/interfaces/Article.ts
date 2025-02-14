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

    family?: { 
        family_id: number;
        family_name: string;
        family_description?: string;
    };

    grape?: { 
        grape_id: number;
        grape_name: string;
        grape_description?: string;
    };

    supplierArticle?: {
        supplier_article_id: number;
        supplier: {
            user_id: number;
            user_firstname: string;
            user_name: string;
            user_phone: string;
            userMail: string;
            user_password: string;
            userType: number;
            user_admin: boolean;
        };
    };
}

