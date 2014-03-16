package fr.iutvalence.java.cm6.parametres;

/**
 * Représente un maillon d'une chaîne, contenant une valeur de type quelconque.
 * @author sebastienjean
 * @param <E> le type de la valeur du maillon
 *
 */
public class MaillonParametre<E>
{
	/**
	 * La valeur du maillon
	 */
	private final E valeur;
	
	/**
	 * Le maillon suivant
	 */
	private final MaillonParametre<E> maillonEntierSuivant;

	/**
	 * Créer un nouveau maillon, de valeur donnée et raccroché devant un autre maillon
	 * @param valeur la valeur contenue dans le maillon
	 * @param suivant le maillon suivant
	 */
	public MaillonParametre(E valeur, MaillonParametre<E> suivant)
	{
		this.valeur = valeur;
		this.maillonEntierSuivant = suivant;
	}

	/**
	 * Créer un nouveau maillon, de valeur donnée, en bout de chaîne
	 * @param valeur la valeur contenue dans le maillon
	 */
	public MaillonParametre(E valeur)
	{
		this.valeur = valeur;
		this.maillonEntierSuivant = null;
	}

	/**
	 * Obtenir la valeur du maillon
	 * @return la valeur du maillon
	 */
	public E obtenirValeur()
	{
		return this.valeur;
	}

	/**
	 * Obtenir le maillon suivant
	 * @return le maillon suivant (<tt>null</tt> si bout de chaîne)
	 */
	public MaillonParametre<E> obtenirElementSuivant()
	{
		return this.maillonEntierSuivant;
	}
}
