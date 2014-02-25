package fr.iutvalence.fonderie.etape1;

/**
 * Représente un pavé dont on souhaite notamment connaitre le volume
 * @author sebastienjean
 *
 */
public class Pave
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
	 * Construit un pavé de taille donnée
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
	 * Obtenir le volume du pavé, en cm3
	 * @return le volume du pavé, en cm3
	 */
	public double obtenirVolumeEnCm3()
	{
		return (this.longueurAreteXEnCm*this.longueurAreteYEnCm*this.longueurAreteZEnCm);
	}
}
