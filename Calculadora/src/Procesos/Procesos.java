package Procesos;
import Enums.Cotizaciones;
import Enums.Distancias;
import Enums.Temperaturas_Magnitudes;

public class Procesos {

	public static double convertirArgTo(double peso,Cotizaciones monedaExtranjera) 
	{
		switch(monedaExtranjera) 
		{
		case Dolar:
			return peso/500;
		case Euro:
			return peso/278;
		case Yenes:
			return peso/1.77;
		case PesoMx:
			return peso/0.066;
		default:
			return peso;
			
			
		}		
	}
	
	public static double convertirToArg(double moneda,Cotizaciones monedaExrtanjera) 
	{
		switch(monedaExrtanjera)
		{
		case Dolar:
			return moneda*476;
		case Euro:
			return moneda*278;
		case Yenes:
			return moneda*1.77;
		case PesoMx:
			return moneda*0.066 ;
		default: return moneda;
		}
		
	}
	
	public static double convertir(double moneda,Cotizaciones MonedaExtranjera,Boolean argTo) 
	{
		if(argTo) 
		{
			return convertirArgTo(moneda, MonedaExtranjera);
		}else 
			return convertirToArg(moneda, MonedaExtranjera);
	}

	
	public static double convertirTemperatura(double temperatura, Temperaturas_Magnitudes temp1,Temperaturas_Magnitudes temp2) {

		switch(temp1) 
		{
		case C:
			return convertirTemperaturaC(temperatura, temp2);
		case K:
			return convertirTemperaturaK(temperatura, temp2);
		default:
			return convertirTemperaturaF(temperatura, temp2);
		}
	}		
	
	public static double convertirTemperaturaC(double temperatura,  Temperaturas_Magnitudes temperatura2) {

			switch(temperatura2) 
			{
			case F:
				return temperatura+32;
			case K:
				return temperatura+273;
			default:
				return temperatura;
			}
	}

	public static double convertirTemperaturaF(double temperatura,  Temperaturas_Magnitudes temperatura2) {

			switch(temperatura2) 
			{
			case C:
				return temperatura-32;
			case K:
				return temperatura+255;
			default:
				return temperatura;
			}
		}
	
	public static double convertirTemperaturaK(double temperatura,  Temperaturas_Magnitudes temperatura2) {

				switch(temperatura2) 
				{
				case F:
					return temperatura-255;
				case C:
					return temperatura-273;
				default:
					return temperatura;
				}
		}

	
	public static double convertirPeso(double peso, boolean porKg) {
		
		if(porKg) 
		{
			return peso*2.205;
		}else {
			return peso/2.205;
		}
	}

	
	public static double convertirDistancia(double distancia,Distancias dist) {

		switch (dist) {
		case M:
			return distancia*1000;
		case Pies:
			return distancia*3280.84;
		case Yardas:
			return distancia*1093.61;
		case Hectareas:
			return distancia*100;
		default:
			return distancia;
		}		
	}
}
