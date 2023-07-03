package Procesos;
import Enums.Cotizaciones;
import gui.VentanaPrincipal;

public class Procesos {
	public static double convertir(double peso,String monedaExtranjera) 
	{
		switch(monedaExtranjera) 
		{
		case "Dolar":
			return peso/500;
		case "Euro":
			return peso/278;
		case "Yen":
			return peso/1.77;
		
		default:
			return peso;
			
			
		}		
	}
}
