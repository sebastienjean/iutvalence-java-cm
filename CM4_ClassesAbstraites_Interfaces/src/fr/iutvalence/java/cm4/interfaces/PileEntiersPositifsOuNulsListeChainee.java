package fr.iutvalence.java.cm4.interfaces;

/**
 * Implémentation d'une pile, en utilisant une liste chainee pour stocker les éléments
 * 
 * @author sebastienjean
 * 
 */
public class PileEntiersPositifsOuNulsListeChainee implements PileEntiersPositifsOuNuls
{
	/**
	 * Taille de la pile (nombre d'éléments qu'elle contient)
	 */
	private int taille;
	
	/**
	 * Capacité de la pile (nombre d'éléments qu'elle peut contenir)
	 */
	private int capacite;

	/**
	 * Element en sommet de pile
	 */
	private MaillonEntier sommet;

	/**
	 * Retourne une nouvelle pile, de capacité par défaut, initialement vide
	 */
	public PileEntiersPositifsOuNulsListeChainee()
	{
		this.taille = 0;
		this.capacite = CAPACITE_PAR_DEFAUT;
		this.sommet = null;
	}

	/**
	 * Retourne une nouvelle pile, de capacité donnée, initialement vide
	 * 
	 * @param capaciteInitiale
	 *            la capacité de la pile
	 * @throws CapaciteInvalideException
	 *             si la capacité est < 0
	 */
	public PileEntiersPositifsOuNulsListeChainee(int capaciteInitiale)
			throws CapaciteInvalideException
	{
		if (capaciteInitiale < 0)
			throw new CapaciteInvalideException();

		this.capacite = capaciteInitiale;
		this.taille = 0;
		this.sommet = null;
	}

	/**
	 * @see fr.iutvalence.java.cm4.interfaces.PileEntiersPositifsOuNuls#empiler(int)
	 */
	public void empiler(int elementAEmpiler) throws EntierNegatifException,
			PilePleineException
	{
		if (elementAEmpiler < 0)
			throw new EntierNegatifException();

		if (this.taille == this.capacite)
			throw new PilePleineException();

		this.sommet = new MaillonEntier(elementAEmpiler, this.sommet);
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
		
		int resultat = this.sommet.obtenirValeur();
		this.sommet = this.sommet.obtenirElementSuivant();
		return resultat;
	}

	/**
	 * @see fr.iutvalence.java.cm4.interfaces.PileEntiersPositifsOuNuls#voirSommet()
	 */
	public int voirSommet() throws PileVideException
	{
		if (this.taille == 0)
			throw new PileVideException();

		return this.sommet.obtenirValeur();
	}

	/**
	 * @see fr.iutvalence.java.cm4.interfaces.PileEntiersPositifsOuNuls#obtenirCapacite()
	 */
	public int obtenirCapacite()
	{
		return this.capacite;
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
		if (!(obj instanceof PileEntiersPositifsOuNulsListeChainee))
			return false;

		PileEntiersPositifsOuNulsListeChainee pile = (PileEntiersPositifsOuNulsListeChainee) obj;
		if (this.taille != pile.taille)
			return false;

		MaillonEntier sommetPile = this.sommet;
		MaillonEntier sommetAutrePile = pile.sommet;
		while (true)
		{
			if (sommetPile == null) break;
			if (sommetPile.obtenirValeur() != sommetAutrePile.obtenirValeur())
				return false;
			sommetPile = sommetPile.obtenirElementSuivant();
			sommetAutrePile = sommetAutrePile.obtenirElementSuivant();
		}
		
		return true;

	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		int hashCode = 0;
		MaillonEntier sommetPile = this.sommet;
		for (int indiceElement = 0; indiceElement < this.taille; indiceElement++)
		{
			hashCode += sommetPile.obtenirValeur() * (indiceElement + 1);
			sommetPile = sommetPile.obtenirElementSuivant();
		}
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
		
		MaillonEntier sommetPile = this.sommet;
		while (true)
		{
			if (sommetPile == null) break;
			result += sommetPile.obtenirValeur()+"\n";
			sommetPile = sommetPile.obtenirElementSuivant();
		}
			
		return result;
	}
}
