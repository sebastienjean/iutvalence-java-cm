package fr.iutvalence.java.cm6.parametres;

/**
 * Implémentation d'une pile, en utilisant une liste chainee pour stocker les éléments
 * 
 * @author sebastienjean
 * @param <E> le type des éléments de la pile
 * 
 */
public class PileListeChainee<E> implements Pile<E>
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
	private MaillonParametre<E> sommet;

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
	 * @see fr.iutvalence.java.cm6.parametres.Pile#empiler(java.lang.Object)
	 */
	public void empiler(E elementAEmpiler) throws PilePleineException
	{
		if (this.taille == this.capacite)
			throw new PilePleineException();

		this.sommet = new MaillonParametre<E>(elementAEmpiler, this.sommet);
		this.taille = this.taille + 1;
	}

	/**
	 * @see fr.iutvalence.java.cm6.parametres.Pile#depiler()
	 */
	public E depiler() throws PileVideException
	{
		if (this.taille == 0)
			throw new PileVideException();

		this.taille = this.taille - 1;
		
		E resultat = this.sommet.obtenirValeur();
		this.sommet = this.sommet.obtenirElementSuivant();
		return resultat;
	}

	/**
	 * @see fr.iutvalence.java.cm6.parametres.Pile#voirSommet()
	 */
	public E voirSommet() throws PileVideException
	{
		if (this.taille == 0)
			throw new PileVideException();

		return this.sommet.obtenirValeur();
	}

	/**
	 * @see fr.iutvalence.java.cm6.parametres.Pile#obtenirCapacite()
	 */
	public int obtenirCapacite()
	{
		return this.capacite;
	}

	/**
	 * @see fr.iutvalence.java.cm6.parametres.Pile#obtenirTaille()
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

		PileListeChainee<E> pile = (PileListeChainee<E>) obj;
		if (this.taille != pile.taille)
			return false;

		MaillonParametre<E> sommetPile = this.sommet;
		MaillonParametre<E> sommetAutrePile = pile.sommet;
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
		MaillonParametre<E> sommetPile = this.sommet;
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
		
		MaillonParametre<E> sommetPile = this.sommet;
		while (true)
		{
			if (sommetPile == null) break;
			result += sommetPile.obtenirValeur()+"\n";
			sommetPile = sommetPile.obtenirElementSuivant();
		}
			
		return result;
	}
}
