package fr.iutvalence.java.cm5.iterateurs;

public class Wagon
{

	private final boolean estWagonDePremiereClasse;
	
	private final int nombreDePlaces;
	
	public Wagon(boolean estWagonDePremiereClasse, int nombreDePlaces)
	{
		this.estWagonDePremiereClasse = estWagonDePremiereClasse;
		this.nombreDePlaces = nombreDePlaces;
	}
	
	public boolean estWagonDePremiereClasse()
	{
		return this.estWagonDePremiereClasse;
	}
	
	public int obtenirNombreDePlaces()
	{
		return this.nombreDePlaces;
	}
	
	public String toString()
	{
		String result = "Wagon de ";
		
		if (this.estWagonDePremiereClasse) result +="première ";
		else result += "seconde ";
		
		result += "classe, comportant "+this.nombreDePlaces+ " places";
		
		return result;
	}
	

}
