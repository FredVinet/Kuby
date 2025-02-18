import type { Article } from "./Article";

export interface SupplierArticle {
    map(arg0: (supplierArticle: any) => Promise<any>): any;
    supplier_article_id: number;
    id_user: number;
    id_article: number;
}

