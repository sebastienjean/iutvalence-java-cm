package fr.iutvalence.java.cm5.interfaces;

/**
 * Représente un maillon d'une chaîne, contenant une valeur de type entier.
 * @author sebastienjean
 *
 */
public class MaillonEntier
{
	/**
	 * La valeur du maillon
	 */
	private final int valeur;
	
	/**
	 * Le maillon suivant
	 */
	private final MaillonEntier maillonEntierSuivant;

	/**
	 * Créer un nouveau maillon, de valeur donnée et raccroché devant un autre maillon
	 * @param valeur la valeur contenue dans le maillon
	 * @param suivant le maillon suivant
	 */
	public MaillonEntier(int valeur, MaillonEntier suivant)
	{
		this.valeur = valeur;
		this.maillonEntierSuivant = suivant;
	}

	/**
	 * Créer un nouveau maillon, de valeur donnée, en bout de chaîne
	 * @param valeur la valeur contenue dans le maillon
	 */
	public MaillonEntier(int valeur)
	{
		this.valeur = valeur;
		this.maillonEntierSuivant = null;
	}

	/**
	 * Obtenir la valeur du maillon
	 * @return la valeur du maillon
	 */
	public int obtenirValeur()
	{
		return this.valeur;
	}

	/**
	 * Obtenir le maillon suivant
	 * @return le maillon suivant (<tt>null</tt> si bout de chaîne)
	 */
	public MaillonEntier obtenirElementSuivant()
	{
		return this.maillonEntierSuivant;
	}
}
