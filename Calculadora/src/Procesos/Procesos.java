package Procesos;
import Enums.Cotizaciones;

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

	private static double convertirTemperatura(double temperatura,  String temperatura2) {
		
		switch(temperatura2) 
		{
		case "F°":
			return temperatura+32;
		case "K°":
			return temperatura+273;
		default:
			return temperatura;
		}
	}


}
