export interface Orders {
    orders_id?: number
    orders_date: Date
    orders_status:
        | 'Payée'
        | 'En cours de livraison'  
        | 'Livrée'
        | 'Sortie stock'  
    orders_amount: number
    id_localisation: number
}
  