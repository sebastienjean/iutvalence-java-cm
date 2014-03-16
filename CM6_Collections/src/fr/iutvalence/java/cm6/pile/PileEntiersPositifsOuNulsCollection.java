package fr.iutvalence.java.cm6.pile;

import java.util.LinkedList;
import java.util.List;

/**
 * Implémentation d'une pile, en utilisant une collection (ici, une liste)
 * 
 * @author sebastienjean
 * 
 */
public class PileEntiersPositifsOuNulsCollection implements
		PileEntiersPositifsOuNuls
{
	/**
	 * La capacite de la pile
	 */
	private final int capacite;

	/**
	 * Contenu de la pile (l'élément le plus bas de la pile est à l'indice le
	 * plus élevé de la liste)
	 */
	private final List<Integer> elements;

	/**
	 * Retourne une nouvelle pile, de capacité par défaut, initialement vide
	 */
	public PileEntiersPositifsOuNulsCollection()
	{
		this.capacite = CAPACITE_PAR_DEFAUT;
		this.elements = new LinkedList<Integer>();
	}

	/**
	 * Retourne une nouvelle pile, de capacité donnée, initialement vide
	 * 
	 * @param capaciteInitiale
	 *            la capacité de la pile
	 * @throws CapaciteInvalideException
	 *             si la capacité est < 0
	 */
	public PileEntiersPositifsOuNulsCollection(int capaciteInitiale)
			throws CapaciteInvalideException
	{
		if (capaciteInitiale < 0)
			throw new CapaciteInvalideException();

		this.capacite = capaciteInitiale;
		this.elements = new LinkedList<Integer>();
	}

	/**
	 * @see fr.iutvalence.java.cm6.pile.PileEntiersPositifsOuNuls#empiler(int)
	 */
	public void empiler(int elementAEmpiler) throws EntierNegatifException,
			PilePleineException
	{
		if (elementAEmpiler < 0)
			throw new EntierNegatifException();

		if (this.elements.size() == this.capacite)
			throw new PilePleineException();

		this.elements.add(0, elementAEmpiler);
	}

	/**
	 * @see fr.iutvalence.java.cm6.pile.PileEntiersPositifsOuNuls#depiler()
	 */
	public int depiler() throws PileVideException
	{
		if (this.elements.size() == 0)
			throw new PileVideException();

		return this.elements.remove(0);
	}

	/**
	 * @see fr.iutvalence.java.cm6.pile.PileEntiersPositifsOuNuls#voirSommet()
	 */
	public int voirSommet() throws PileVideException
	{
		if (this.elements.size() == 0)
			throw new PileVideException();

		return this.elements.get(0);
	}

	/**
	 * @see fr.iutvalence.java.cm6.pile.PileEntiersPositifsOuNuls#obtenirCapacite()
	 */
	public int obtenirCapacite()
	{
		return this.capacite;
	}

	/**
	 * @see fr.iutvalence.java.cm6.pile.PileEntiersPositifsOuNuls#obtenirTaille()
	 */
	public int obtenirTaille()
	{
		return this.elements.size();
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
		if (!(obj instanceof PileEntiersPositifsOuNulsCollection))
			return false;

		PileEntiersPositifsOuNulsCollection pile = (PileEntiersPositifsOuNulsCollection) obj;
		if (this.elements.size() != pile.elements.size())
			return false;

		for (int indiceElement = 0; indiceElement < this.elements.size(); indiceElement++)
			if (this.elements.get(indiceElement) != pile.elements.get(indiceElement))
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
		for (int indiceElement = 0; indiceElement < this.elements.size(); indiceElement++)
			hashCode += this.elements.get(indiceElement) * (indiceElement + 1);
		return hashCode;
	}

	/**
	 * Retourne une représentation texte de la pile contenant des informations
	 * sur la capacité et la taille, de même que les éléments (présentés
	 * verticalement, le premier élément empilé se situant sur la dernière
	 * ligne)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		String result = "Pile de capacite " + this.capacite
				+ ", contenant " + this.elements.size() + " element(s)";

		for (int indiceElement = 0; indiceElement < this.elements.size(); indiceElement++)
			result += this.elements.get(indiceElement) + "\n";
		return result;
	}
}
