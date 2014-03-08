package fr.iutvalence.fonderie.etape3;

/**
 * Représente un pavé, qui est une forme particulière de pièce
 * @author sebastienjean
 *
 */
public class Pave extends Piece
{
	/**
	 * Longueur de l'arête X, en cm
	 */
	private final double longueurAreteXEnCm;

	/**
	 * Longueur de l'arête Y, en cm
	 */
	private final double longueurAreteYEnCm;
	
	/**
	 * Longueur de l'arête Z, en cm
	 */
	private final double longueurAreteZEnCm;

	/**
	 * Construire un pavé de taille donnée
	 * @param longueurAreteXenCm longueur de l'arête X, en cm
	 * @param longueurAreteYenCm longueur de l'arête Y, en cm
	 * @param longueurAreteZenCm longueur de l'arête Z, en cm
	 */
	public Pave(double longueurAreteXenCm, double longueurAreteYenCm, double longueurAreteZenCm)
	{
		this.longueurAreteXEnCm = longueurAreteXenCm;
		this.longueurAreteYEnCm = longueurAreteYenCm;
		this.longueurAreteZEnCm = longueurAreteZenCm;
	}

	/**
	 * @see fr.iutvalence.fonderie.etape3.Piece#obtenirVolumeEnCm3()
	 */
	public double obtenirVolumeEnCm3()
	{
		return (this.longueurAreteXEnCm*this.longueurAreteYEnCm*this.longueurAreteZEnCm);
	}
}
