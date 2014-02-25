package fr.iutvalence.fonderie.etape3;

/**
 * Représente une fonderie, dans laquelle sont fondus des pavés.
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
	 * Construit une fonderie, immédiatement mise ne service
	 */
	public Fonderie()
	{
		this.volumeCumuleDesPiecesFonduesEnCm3 = 0;
	}
	
	/**
	 * Fondre une série de pièces
	 * @param pieces les pièces à fondre
	 * @return le volume total des pièces fondues, en cm3
	 */
	public double fondre(Piece[] pieces)
	{
		double volumeDesPiecesFonduesEnCm3 = 0;
		
		for (int indicePiece = 0; indicePiece < pieces.length; indicePiece++)
			volumeDesPiecesFonduesEnCm3 += pieces[indicePiece].obtenirVolumeEnCm3();
		
		this.volumeCumuleDesPiecesFonduesEnCm3 += volumeDesPiecesFonduesEnCm3;
		
		return volumeDesPiecesFonduesEnCm3;
	}
	
	/**
	 * Obtenir le volume total des pièces fondues depuis la mise en service de la fonderie, en cm3
	 * @return le volume total des pièces fondues depuis la mise en service de la fonderie, en cm3
	 */
	public double obtenirVolumeCumuleDesPiecesFonduesEnCm3()
	{
		return this.volumeCumuleDesPiecesFonduesEnCm3;
	}
}
