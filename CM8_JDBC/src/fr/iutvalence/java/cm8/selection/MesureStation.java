package fr.iutvalence.java.cm8.selection;

/**
 * Classe représentant une mesure météo (association station/température)
 * @author sebastienjean
 *
 */
public class MesureStation
{
	/**
	 * Le nom de la station météo
	 */
	private final String nom;
	
	/**
	 * La température relevée
	 */
	private final double temperature;

	/**
	 * Création d'une nouvelle mesure étant données une station et la température relevée
	 * @param nom le nom de la station météo
	 * @param temperature la température relevée
	 */
	public MesureStation(String nom, double temperature)
	{
		super();
		this.nom = nom;
		this.temperature = temperature;
	}

	/**
	 * Obtention du nom de la station
	 * @return le nom de la station
	 */
	public String obtenirNom()
	{
		return this.nom;
	}

	/**
	 * Obtention de la température relevée
	 * @return la température relevée
	 */
	public double obtenirTemperature()
	{
		return this.temperature;
	}
}
