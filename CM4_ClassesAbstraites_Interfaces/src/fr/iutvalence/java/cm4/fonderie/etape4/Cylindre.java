package fr.iutvalence.java.cm4.fonderie.etape4;

/**
 * Représente un cylindre, qui est une forme particulière de pièce 
 * @author sebastienjean
 *
 */
public class Cylindre extends Piece
{
	/**
	 * Rayon de la base du cylindre, en cm
	 */
	final double rayonDeLaBaseEnCm;

	/**
	 * Hauteur du cylindre, en cm
	 */
	final double hauteurEnCm;
	
	/**
	 * Construire un cylindre de taille donnée
	 * @param rayonDeLaBaseEnCm rayon de la base du cylindre, en cm
	 * @param hauteurEnCm hauteur du cylindre, en cm
	 */
	public Cylindre(double rayonDeLaBaseEnCm, double hauteurEnCm)
	{
		this.rayonDeLaBaseEnCm = rayonDeLaBaseEnCm;
		this.hauteurEnCm = hauteurEnCm;
	}

	/**
	 * @see fr.iutvalence.java.cm4.fonderie.etape4.Piece#obtenirVolumeEnCm3()
	 */
	public double obtenirVolumeEnCm3()
	{
		return (Math.PI * this.rayonDeLaBaseEnCm * this.rayonDeLaBaseEnCm * this.hauteurEnCm);
	}
}
