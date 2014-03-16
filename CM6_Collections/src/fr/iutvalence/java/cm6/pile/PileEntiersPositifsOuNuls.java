package fr.iutvalence.java.cm6.pile;

/**
 * Classe représentant une pile d'entiers positifs ou nuls. Une pile est
 * caractérisée par sa capacité, et les éléments qu'elle contient.
 * 
 * @author sebastienjean
 * 
 */
public interface PileEntiersPositifsOuNuls
{
	/**
	 * Capacité par défaut d'une pile
	 */
	public static final int CAPACITE_PAR_DEFAUT = 5;

	/**
	 * Empiler un entier.
	 * 
	 * @param elementAEmpiler
	 *            l'entier à empiler
	 * @throws EntierNegatifException
	 *             si l'entier n'a pas pu être empilé car il était négatif.
	 * @throws PilePleineException
	 *             si l'entier n'a pas pu être empilé car la pile était pleine
	 */
	public void empiler(int elementAEmpiler) throws EntierNegatifException,
			PilePleineException;

	/**
	 * Dépiler un entier.
	 * 
	 * @throws PileVideException
	 *             si l'entier n'a pas pu être dépilé car la pile était vide.
	 * @return l'entier depilé
	 */
	public int depiler() throws PileVideException;

	/**
	 * Voir le sommet de la pile
	 * 
	 * @return l'entier en sommet de pile
	 * @throws PileVideException
	 *             si la pile était vide.
	 */
	public int voirSommet() throws PileVideException;

	/**
	 * Obtenir la capacité de la pile
	 * 
	 * @return la capacité de la pile
	 */
	public int obtenirCapacite();

	/**
	 * Obtenir la taille de la pile
	 * 
	 * @return la taille de la pile
	 */
	public int obtenirTaille();

}