import type { Article } from "./Article";

export interface Supplier {
    user_id: number;
    user_firstname: string;
    user_name: string;
    user_phone: string;
    userMail: string;
    user_password: string;
    userType: number;
    user_admin: boolean;
}

export interface SupplierArticle {
    supplier_article_id: number;
    supplier: Supplier;
    article: Article;
}

