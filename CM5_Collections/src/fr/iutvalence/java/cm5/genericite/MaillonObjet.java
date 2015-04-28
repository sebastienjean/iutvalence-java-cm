package fr.iutvalence.java.cm5.genericite;

/**
 * Représente un maillon d'une chaîne, contenant une valeur de type quelconque.
 * @author sebastienjean
 *
 */
public class MaillonObjet
{
	/**
	 * La valeur du maillon
	 */
	private final Object valeur;
	
	/**
	 * Le maillon suivant
	 */
	private final MaillonObjet maillonObjetSuivant;

	/**
	 * Créer un nouveau maillon, de valeur donnée et raccroché devant un autre maillon
	 * @param valeur la valeur contenue dans le maillon
	 * @param suivant le maillon suivant
	 */
	public MaillonObjet(Object valeur, MaillonObjet suivant)
	{
		this.valeur = valeur;
		this.maillonObjetSuivant = suivant;
	}

	/**
	 * Créer un nouveau maillon, de valeur donnée, en bout de chaîne
	 * @param valeur la valeur contenue dans le maillon
	 */
	public MaillonObjet(Object valeur)
	{
		this.valeur = valeur;
		this.maillonObjetSuivant = null;
	}

	/**
	 * Obtenir la valeur du maillon
	 * @return la valeur du maillon
	 */
	public Object obtenirValeur()
	{
		return this.valeur;
	}

	/**
	 * Obtenir le maillon suivant
	 * @return le maillon suivant (<tt>null</tt> si bout de chaîne)
	 */
	public MaillonObjet obtenirElementSuivant()
	{
		return this.maillonObjetSuivant;
	}
}
