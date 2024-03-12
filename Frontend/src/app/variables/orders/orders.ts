export interface Orders{
    id?: number;
    table_Number: number;
    priority: number;
    item_Name: string;
    extra: string;
    excluded: string;
    included: string;
    quantity: number;
    ordered: boolean;
    order_Cost: number;
    size: string;
}