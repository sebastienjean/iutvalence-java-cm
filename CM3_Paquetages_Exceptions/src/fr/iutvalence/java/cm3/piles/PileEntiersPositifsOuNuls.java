package fr.iutvalence.java.cm3.piles;

import fr.iutvalence.java.cm3.piles.exceptions.CapaciteInvalideException;
import fr.iutvalence.java.cm3.piles.exceptions.EntierNegatifException;
import fr.iutvalence.java.cm3.piles.exceptions.PilePleineException;
import fr.iutvalence.java.cm3.piles.exceptions.PileVideException;

/**
 * Classe représentant une pile d'entiers positifs ou nuls. Une pil est caractérisée par sa capacité, 
 * et les éléments qu'elle contient.
 * @author sebastienjean
 *
 */
public class PileEntiersPositifsOuNuls
{
	/**
	 * Capacité par défaut d'une pile
	 */
	public static final int CAPACITE_PAR_DEFAUT = 5;

	/**
	 * Capacité de la pile (nombre maximal d'éléments qu'elle peut contenir)
	 */
	private final int capacite;
	
	/**
	 * Taille de la pile (nombre d'éléments qu'elle contient)
	 */
	private int taille;
	
	/**
	 * Contenu de la pile
	 * (l'élément le plus bas de la pile est à l'indice le plus faible du tableau)
	 */
	private final int[] elements;

	/**
	 * Retourne une nouvelle pile, de capacité par défaut, initialement vide
	 */
	public PileEntiersPositifsOuNuls()
	{
		this.capacite = CAPACITE_PAR_DEFAUT;
		this.taille = 0;
		
		// N.B. Tous les attributs doivent être correctement initialisés, y
		// compris elements qui doit contenir la référence d'un objet tableau d'entiers
		// qu'il est nécessaire d'allouer
		this.elements = new int[this.capacite];
	}

	/**
	 * Retourne une nouvelle pile, de capacité donnée, initialement vide
	 * @param capaciteInitiale la capacité de la pile
	 * @throws CapaciteInvalideException si la capacité est < 0
	 */
	public PileEntiersPositifsOuNuls(int capaciteInitiale) throws CapaciteInvalideException
	{
		if (capaciteInitiale < 0)
			throw new CapaciteInvalideException();

		this.capacite = capaciteInitiale;
		this.taille = 0;
		this.elements = new int[this.capacite];
	}

	/**
	 * Empiler un entier dans la pile.
	 * @param elementAEmpiler l'entier à empiler
	 * @throws EntierNegatifException si l'entier n'a pas pu être empilé car il était négatif.
	 * @throws PilePleineException si l'entier n'a pas pu être empilé car la pile était pleine
	 */
	public void empiler(int elementAEmpiler) throws EntierNegatifException, PilePleineException
	{
		if (elementAEmpiler < 0)
			throw new EntierNegatifException();

		if (this.taille == this.capacite)
			throw new PilePleineException();

		this.elements[this.taille] = elementAEmpiler;
		this.taille = this.taille + 1;
	}

	/**
	 * Depiler un entier dans la pile. 
	 * @throws PileVideException si l'entier
	 * n'a pas pu être dépilé car la pile était vide.
	 * @return l'entier depilé 
	 */
	public int depiler() throws PileVideException
	{
		if (this.taille == 0)
			throw new PileVideException();
		
		this.taille = this.taille-1;
		return this.elements[this.taille];
	}
	
	/**
	 * Voir le sommet de la pile
	 * @return l'entier en somment de pile
	 * @throws PileVideException si la pile était vide.
	 */
	public int voirSommet() throws PileVideException
	{
		if (this.taille == 0)
			throw new PileVideException();
	
		return this.elements[this.taille-1];
	}

	/**
	 * Obtenir la capacité de la pile
	 * @return la capacité de la pile
	 */
	public int obtenirCapacite()
	{
		return this.capacite;
	}

	/**
	 * Obtenir la taille de la pile
	 * @return la taille de la pile
	 */
	public int obtenirTaille()
	{
		return this.taille;
	}
}
