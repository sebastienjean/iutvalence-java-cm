package fr.iutvalence.java.cm5.parametres;

/**
 * Classe représentant une pile d'objets quelconques. Une pile est
 * caractérisée par sa capacité, et les éléments qu'elle contient.
 * 
 * @author sebastienjean
 * @param <E> le type des éléments de la pile
 * 
 */
public interface Pile<E>
{
	/**
	 * Capacité par défaut d'une pile
	 */
	public static final int CAPACITE_PAR_DEFAUT = 5;

	/**
	 * Empiler un élément.
	 * 
	 * @param elementAEmpiler
	 *            l'élément à empiler
	 * @throws PilePleineException
	 *             si l'élément n'a pas pu être empilé car la pile était pleine
	 */
	public void empiler(E elementAEmpiler) throws PilePleineException;

	/**
	 * Depiler un élément
	 * 
	 * @throws PileVideException
	 *             si l'élément n'a pas pu être dépilé car la pile était vide.
	 * @return l'élément dépilé
	 */
	public E depiler() throws PileVideException;

	/**
	 * Voir le sommet de la pile
	 * 
	 * @return l'élément en sommet de pile
	 * @throws PileVideException
	 *             si la pile était vide.
	 */
	public E voirSommet() throws PileVideException;

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