package fr.iutvalence.java.cm6.genericite;

/**
 * Implémentation d'une pile, en utilisant une liste chainee pour stocker les éléments
 * 
 * @author sebastienjean
 * 
 */
public class PileListeChainee implements Pile
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
	private MaillonObjet sommet;

	/**
	 * Retourne une nouvelle pile, de capacité par défaut, initialement vide
	 */
	public PileListeChainee()
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
	public PileListeChainee(int capaciteInitiale)
			throws CapaciteInvalideException
	{
		if (capaciteInitiale < 0)
			throw new CapaciteInvalideException();

		this.capacite = capaciteInitiale;
		this.taille = 0;
		this.sommet = null;
	}

	/**
	 * @see fr.iutvalence.java.cm6.genericite.Pile#empiler(java.lang.Object)
	 */
	public void empiler(Object elementAEmpiler) throws PilePleineException
	{
		if (this.taille == this.capacite)
			throw new PilePleineException();

		this.sommet = new MaillonObjet(elementAEmpiler, this.sommet);
		this.taille = this.taille + 1;
	}

	/**
	 * @see fr.iutvalence.java.cm6.genericite.Pile#depiler()
	 */
	public Object depiler() throws PileVideException
	{
		if (this.taille == 0)
			throw new PileVideException();

		this.taille = this.taille - 1;
		
		Object resultat = this.sommet.obtenirValeur();
		this.sommet = this.sommet.obtenirElementSuivant();
		return resultat;
	}

	/**
	 * @see fr.iutvalence.java.cm6.genericite.Pile#voirSommet()
	 */
	public Object voirSommet() throws PileVideException
	{
		if (this.taille == 0)
			throw new PileVideException();

		return this.sommet.obtenirValeur();
	}

	/**
	 * @see fr.iutvalence.java.cm6.genericite.Pile#obtenirCapacite()
	 */
	public int obtenirCapacite()
	{
		return this.capacite;
	}

	/**
	 * @see fr.iutvalence.java.cm6.genericite.Pile#obtenirTaille()
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
		if (!(obj instanceof PileListeChainee))
			return false;

		PileListeChainee pile = (PileListeChainee) obj;
		if (this.taille != pile.taille)
			return false;

		MaillonObjet sommetPile = this.sommet;
		MaillonObjet sommetAutrePile = pile.sommet;
		while (true)
		{
			if (sommetPile == null) break;
			if (!(sommetPile.obtenirValeur().equals(sommetAutrePile.obtenirValeur())))
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
		MaillonObjet sommetPile = this.sommet;
		for (int indiceElement = 0; indiceElement < this.taille; indiceElement++)
		{
			hashCode += sommetPile.obtenirValeur().hashCode();
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
		
		MaillonObjet sommetPile = this.sommet;
		while (true)
		{
			if (sommetPile == null) break;
			result += sommetPile.obtenirValeur()+"\n";
			sommetPile = sommetPile.obtenirElementSuivant();
		}
			
		return result;
	}
}
