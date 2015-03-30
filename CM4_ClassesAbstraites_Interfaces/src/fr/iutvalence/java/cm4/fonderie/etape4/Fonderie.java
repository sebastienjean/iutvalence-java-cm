package fr.iutvalence.java.cm4.fonderie.etape4;

/**
 * Représente une fonderie, dans laquelle sont fondus des pièces.
 * 
 * @author sebastienjean
 */
public class Fonderie
{
	/**
	 * Le volume total de pièces fondues depuis la mise en service de la fonderie, en cm3
	 */
	private double volumeCumuleDesPiecesFonduesEnCm3;
	
	/**
	 * Le prix total de pièces fondues depuis la mise en service de la fonderie, en Euros
	 */
	private double prixCumuleDesPiecesFonduesEnEuros;
	
	/**
	 * Construire une fonderie, immédiatement mise en service
	 */
	public Fonderie()
	{
		this.volumeCumuleDesPiecesFonduesEnCm3 = 0;
		this.prixCumuleDesPiecesFonduesEnEuros = 0;
	}
	
	/**
	 * Fondre une série de pièces d'un même métal donné
	 * @param pieces les pièces à fondre
	 * @param metal le métal à l'origine de chaque pièce
	 * @return le rapport de la fusion (métal, volume, prix des pièces fondues)
	 */
	public RapportFusion fondre(Piece[] pieces, Metal metal)
	{
		Fusion fusion = new Fusion(metal);
		
		for (int indicePiece = 0; indicePiece < pieces.length; indicePiece++)
			fusion.fondre(pieces[indicePiece]);
		
		RapportFusion rapport = fusion.obtenirRapport(); 
		this.volumeCumuleDesPiecesFonduesEnCm3 +=  rapport.obtenirVolumeEnCm3();
		this.prixCumuleDesPiecesFonduesEnEuros += rapport.obtenirPrixEnEuros();
		
		return rapport;
	}
	
	/**
	 * Obtenir le volume total des pièces fondues depuis la mise en service de la fonderie, en cm3
	 * @return le volume total des pièces fondues depuis la mise en service de la fonderie, en cm3
	 */
	public double obtenirVolumeCumuleDesPiecesFonduesEnCm3()
	{
		return this.volumeCumuleDesPiecesFonduesEnCm3;
	}
	
	/**
	 * Obtenir le prix total des pièces fondues depuis la mise en service de la fonderie, en Euros
	 * @return le prix total des pièces fondues depuis la mise en service de la fonderie, en Euros
	 */
	public double obtenirPrixCumuleDesPiecesFonduesEnEuros()
	{
		return this.prixCumuleDesPiecesFonduesEnEuros;
	}
}
