package fr.iutvalence.java.cm5.enumerations;

/**
 * Représente le rapport d'une fusion, informant sur la nature (métal) des pièces, le volume fondu et le prix correspondant
 * @author sebastienjean
 *
 */
public class RapportFusion
{
	/**
	 * Le métal dont étaient faites les pièces fondues
	 */
	private Metal metal;
	
	/**
	 * Le volume fondu, en cm3
	 */
	private int volumeEnCm3;
	
	/**
	 * Le prix, en Euros
	 */
	private double prixEnEuros;

	/**
	 * Créer un nouveau rapport de fusion, pour un métal donné
	 * @param metal le métal dont étaient faites les pièces à fondre
	 */
	public RapportFusion(Metal metal)
	{
		this.metal = metal;
		this.volumeEnCm3 = 0;
		this.prixEnEuros = 0;
	}
	
	/**
	 * Mettre à jour le rapport en prenant en compte la fusion d'une pièce
	 * @param piece la pièce fondue
	 */
	public void mettreAJourAvec(Piece piece)
	{
		this.volumeEnCm3 += piece.obtenirVolumeEnCm3();
		this.prixEnEuros += piece.obtenirVolumeEnCm3()*this.metal.obtenirMasseVolumiqueEnGrammesParCm3()*this.metal.obtenirPrixParTonneEnEuros()/1000000;
	}
	
	/**
	 * Obtenir le métal dont étaient faites les pièces fondues
	 * @return le métal dont étaient faites les pièces fondues
	 */
	public Metal obtenirMetal()
	{
		return this.metal;
	}
	
	/**
	 * Obtenir le volume total des pièces fondues, en cm3
	 * @return le volume total des pièces fondues, en cm3
	 */
	public double obtenirVolumeEnCm3()
	{
		return this.volumeEnCm3;
	}
	
	/**
	 * Obtenir le prix total des pièces fondues, en Euros
	 * @return le prix total des pièces fondues, en Euros
	 */
	public double obtenirPrixEnEuros()
	{
		return this.prixEnEuros;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return this.metal.obtenirSymbole()+" / "+ this.volumeEnCm3+"cm3 / "+this.obtenirPrixEnEuros();
	}
}
