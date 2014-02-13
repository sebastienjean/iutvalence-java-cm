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
	 * Code de retour utilisé pour signaler qu'une opération sur une pile s'est passée normalement
	 */
	public final static int SUCCES = 0;

	/**
	 * Code de retour utilisé pour signaler qu'une opération sur une pile a échoué 
	 * car la pile était pleine
	 */
	public final static int PILE_PLEINE = -1;

	/**
	 * Code de retour utilisé pour signaler qu'une opération sur une pile a échoué 
	 * car la pile était vide
	 */
	public final static int PILE_VIDE = -2;
	
	/**
	 * Code de retour utilisé pour signaler qu'une opération sur une pile a échoué 
	 * car l'entier passé en paramètre était négatif
	 */
	public final static int ENTIER_NEGATIF = -3;

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
	 */
	public PileEntiersPositifsOuNuls(int capaciteInitiale)
	{
		if (capaciteInitiale < 0)
			this.capacite = CAPACITE_PAR_DEFAUT;
		else
			this.capacite = capaciteInitiale;

		this.taille = 0;
		this.elements = new int[this.capacite];
	}

	/**
	 * Empiler un entier dans la pile.
	 * @param elementAEmpiler l'entier à empiler
	 * @return <tt>SUCCES</tt> si l'entier a pu être empilé, <tt>PILE_PLEINE</tt> si l'entier
	 * n'a pas pu être empilé car la pile était pleine, <tt>ENTIER_NEGATIF</tt> si l'entier
	 * n'a pas pu être empilé car il était négatif.
	 */
	public int empiler(int elementAEmpiler)
	{
		if (elementAEmpiler < 0)
			return ENTIER_NEGATIF;

		if (this.taille == this.capacite)
			return PILE_PLEINE;

		this.elements[this.taille] = elementAEmpiler;
		this.taille = this.taille + 1;
		return SUCCES;
	}

	/**
	 * Depiler un entier dans la pile.
	 * @return l'entier s'il a pu être depilé, <tt>PILE_VIDE</tt> si l'entier
	 * n'a pas pu être dépilé car la pile était vide.
	 */
	public int depiler()
	{
		if (this.taille == 0)
			return PILE_VIDE;
		
		this.taille = this.taille-1;
		return this.elements[this.taille];
	}
	
	/**
	 * Voir le sommet de la pile
	 * @return l'entier en somment de pile, <tt>PILE_VIDE</tt> si la pile était vide.
	 */
	public int voirSommet()
	{
		if (this.taille == 0)
			return PILE_VIDE;
	
		return this.elements[this.taille-1];
	}

	/**
	 * Obtenir la capacité de la pile
	 * @return la capacité de la pile
	 */
	public int getCapacite()
	{
		return this.capacite;
	}

	/**
	 * Obtenir la taille de la pile
	 * @return la taille de la pile
	 */
	public int getTaille()
	{
		return this.taille;
	}
}
