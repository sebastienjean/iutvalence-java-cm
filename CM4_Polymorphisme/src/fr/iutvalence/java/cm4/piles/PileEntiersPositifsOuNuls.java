package fr.iutvalence.java.cm4.piles;

/**
 * Classe représentant une pile d'entiers positifs ou nuls. Une pile est
 * caractérisée par sa capacité, et les éléments qu'elle contient.
 * 
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
	 * Contenu de la pile (l'élément le plus bas de la pile est à l'indice le
	 * plus faible du tableau)
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
		// compris elements qui doit contenir la référence d'un objet tableau
		// d'entiers
		// qu'il est nécessaire d'allouer
		this.elements = new int[this.capacite];
	}

	/**
	 * Retourne une nouvelle pile, de capacité donnée, initialement vide
	 * 
	 * @param capaciteInitiale
	 *            la capacité de la pile
	 * @throws CapaciteInvalideException
	 *             si la capacité est < 0
	 */
	public PileEntiersPositifsOuNuls(int capaciteInitiale)
			throws CapaciteInvalideException
	{
		if (capaciteInitiale < 0)
			throw new CapaciteInvalideException();

		this.capacite = capaciteInitiale;
		this.taille = 0;
		this.elements = new int[this.capacite];
	}

	/**
	 * Empiler un entier dans la pile.
	 * 
	 * @param elementAEmpiler
	 *            l'entier à empiler
	 * @throws EntierNegatifException
	 *             si l'entier n'a pas pu être empilé car il était négatif.
	 * @throws PilePleineException
	 *             si l'entier n'a pas pu être empilé car la pile était pleine
	 */
	public void empiler(int elementAEmpiler) throws EntierNegatifException,
			PilePleineException
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
	 * 
	 * @throws PileVideException
	 *             si l'entier n'a pas pu être dépilé car la pile était vide.
	 * @return l'entier depilé
	 */
	public int depiler() throws PileVideException
	{
		if (this.taille == 0)
			throw new PileVideException();

		this.taille = this.taille - 1;
		return this.elements[this.taille];
	}

	/**
	 * Voir le sommet de la pile
	 * 
	 * @return l'entier en somment de pile
	 * @throws PileVideException
	 *             si la pile était vide.
	 */
	public int voirSommet() throws PileVideException
	{
		if (this.taille == 0)
			throw new PileVideException();

		return this.elements[this.taille - 1];
	}

	/**
	 * Obtenir la capacité de la pile
	 * 
	 * @return la capacité de la pile
	 */
	public int obtenirCapacite()
	{
		return this.capacite;
	}

	/**
	 * Obtenir la taille de la pile
	 * 
	 * @return la taille de la pile
	 */
	public int obtenirTaille()
	{
		return this.taille;
	}

	/**
	 * Remarque : deux piles sont considérées comme équivalentes si elle ont les
	 * mêmes élements (dans le même ordre)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof PileEntiersPositifsOuNuls))
			return false;

		PileEntiersPositifsOuNuls pile = (PileEntiersPositifsOuNuls) obj;
		if (this.taille != pile.taille)
			return false;

		for (int indiceElement = 0; indiceElement < this.taille; indiceElement++)
			if (this.elements[indiceElement] != pile.elements[indiceElement])
				return false;
		return true;

	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		int hashCode = 0;
		for (int indiceElement = 0; indiceElement < this.taille; indiceElement++)
			hashCode += this.elements[indiceElement] * (indiceElement + 1);
		return hashCode;
	}

	/**
	 * Retourne une représentation texte de la pile contenant des informations
	 * sur la capacité et la taille, de même que les éléments (présentés verticalement, 
	 * le premier élément empilé se situant sur la dernière ligne)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		String result = "Pile de capacite " + this.capacite + ", contenant "
				+ this.taille + " element(s)";
		
		for (int indiceElement = this.taille-1; indiceElement >= 0; indiceElement--)
			result += this.elements[indiceElement]+"\n";
		return result;
	}
}
