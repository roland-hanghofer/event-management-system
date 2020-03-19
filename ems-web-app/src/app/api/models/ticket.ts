/* tslint:disable */
export interface Ticket  {
  category?: number;
  catering?: boolean;
  id?: number;
  invoiceAddress?: string;
  parking?: boolean;
  paymentMethod?: 'Invitation' | 'Cash' | 'ForAccount' | 'Cooperation';
  type?: 'GoldenVipTicket' | 'DaysaverTicket' | 'BoxTicket' | 'PlayerspartyTicket';
}
