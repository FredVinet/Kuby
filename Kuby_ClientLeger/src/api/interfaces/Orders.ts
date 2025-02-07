export interface Orders {
    orders_id?: number
    orders_date: Date
    orders_status:
        | 'placed'
        | 'paid'
    orders_amount: number
    id_location: number
}
  