package fr.iutvalence.java.cm4.fonderie.etape4;

/**
 * Enumération des métaux dont peuvent être faites les pièces
 * @author sebastienjean
 *
 */
public enum Metal
{
	/**
	 * Fer
	 */
	FER("Fe", 150, 7.88),
	/**
	 * Plomb
	 */
	PLOMB("Pb", 1500, 11.35),
	/**
	 * Cuivre
	 */
	CUIVRE("Cu", 5000, 8.96);
	
	/**
	 * Le symbole associé dans le tableau périodique des éléments
	 */
	private final String symbole;
	
	/**
	 * La masse volumique, en g/cm3
	 */
	private final double masseVolumiqueEnGrammesParCm3;
		
	/**
	 * Le prix par tonne, en Euros 
	 */
	private final int prixParTonneEnEuros;
	
	/**
	 * Ajouter un nouveau métal, étant donnés son symbole, son prix par tonne et sa masse volumique
	 * @param symbole le symbole associé dans le tableau périodique des éléments
	 * @param masseVolumiqueEnGrammesParCm3 la masse volumique
	 * @param prixParTonneEnEuros le prix par tonne
	 */
	private Metal(String symbole, int prixParTonneEnEuros, double masseVolumiqueEnGrammesParCm3)
	{
		this.symbole = symbole;
		this.prixParTonneEnEuros = prixParTonneEnEuros;	
		this.masseVolumiqueEnGrammesParCm3 = masseVolumiqueEnGrammesParCm3;
	}
		
	/**
	 * Obtenir le symbole associé dans le tableau périodique des éléments
	 * @return le symbole associé dans le tableau périodique des éléments
	 */
	public String obtenirSymbole()
	{
		return this.symbole;
	}
	
	/**
	 * Obtenir le prix par tonne, en Euros
	 * @return le prix par tonne, en Euros
	 */
	public int obtenirPrixParTonneEnEuros()
	{
		return this.prixParTonneEnEuros;
	}

	/**
	 * Obtenir la masse volumique, en g/cm3
	 * @return la masse volumique, en g/cm3
	 */
	public double obtenirMasseVolumiqueEnGrammesParCm3()
	{
		return this.masseVolumiqueEnGrammesParCm3;
	}
}
