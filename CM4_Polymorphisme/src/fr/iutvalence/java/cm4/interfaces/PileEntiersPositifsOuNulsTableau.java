package fr.iutvalence.java.cm4.interfaces;

/**
 * Implémentation d'une pile, en utilisant un tableau pour stocker les éléments
 * 
 * @author sebastienjean
 * 
 */
public class PileEntiersPositifsOuNulsTableau implements PileEntiersPositifsOuNuls
{
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
	public PileEntiersPositifsOuNulsTableau()
	{
		this.taille = 0;
		this.elements = new int[CAPACITE_PAR_DEFAUT];
	}

	/**
	 * Retourne une nouvelle pile, de capacité donnée, initialement vide
	 * 
	 * @param capaciteInitiale
	 *            la capacité de la pile
	 * @throws CapaciteInvalideException
	 *             si la capacité est < 0
	 */
	public PileEntiersPositifsOuNulsTableau(int capaciteInitiale)
			throws CapaciteInvalideException
	{
		if (capaciteInitiale < 0)
			throw new CapaciteInvalideException();

		this.taille = 0;
		this.elements = new int[capaciteInitiale];
	}

	/**
	 * @see fr.iutvalence.java.cm4.interfaces.PileEntiersPositifsOuNuls#empiler(int)
	 */
	public void empiler(int elementAEmpiler) throws EntierNegatifException,
			PilePleineException
	{
		if (elementAEmpiler < 0)
			throw new EntierNegatifException();

		if (this.taille == this.elements.length)
			throw new PilePleineException();

		this.elements[this.taille] = elementAEmpiler;
		this.taille = this.taille + 1;
	}

	/**
	 * @see fr.iutvalence.java.cm4.interfaces.PileEntiersPositifsOuNuls#depiler()
	 */
	public int depiler() throws PileVideException
	{
		if (this.taille == 0)
			throw new PileVideException();

		this.taille = this.taille - 1;
		return this.elements[this.taille];
	}

	/**
	 * @see fr.iutvalence.java.cm4.interfaces.PileEntiersPositifsOuNuls#voirSommet()
	 */
	public int voirSommet() throws PileVideException
	{
		if (this.taille == 0)
			throw new PileVideException();

		return this.elements[this.taille - 1];
	}

	/**
	 * @see fr.iutvalence.java.cm4.interfaces.PileEntiersPositifsOuNuls#obtenirCapacite()
	 */
	public int obtenirCapacite()
	{
		return this.elements.length;
	}

	/**
	 * @see fr.iutvalence.java.cm4.interfaces.PileEntiersPositifsOuNuls#obtenirTaille()
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
		if (!(obj instanceof PileEntiersPositifsOuNulsTableau))
			return false;

		PileEntiersPositifsOuNulsTableau pile = (PileEntiersPositifsOuNulsTableau) obj;
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
		String result = "Pile de capacite " + this.elements.length + ", contenant "
				+ this.taille + " element(s)";
		
		for (int indiceElement = this.taille-1; indiceElement >= 0; indiceElement--)
			result += this.elements[indiceElement]+"\n";
		return result;
	}
}
