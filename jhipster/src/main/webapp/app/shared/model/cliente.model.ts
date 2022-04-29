import { IFactura } from 'app/shared/model/factura.model';
import { ILocate } from 'app/shared/model/locate.model';
import { ITipoDni } from 'app/shared/model/tipo-dni.model';

export interface ICliente {
  id?: number;
  nombre?: string;
  direccion?: string;
  telefono?: number;
  facturas?: IFactura[] | null;
  locate?: ILocate;
  tipoDni?: ITipoDni;
}

export const defaultValue: Readonly<ICliente> = {};
