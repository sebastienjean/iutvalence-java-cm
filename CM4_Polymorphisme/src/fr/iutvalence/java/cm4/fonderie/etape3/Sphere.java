package fr.iutvalence.java.cm4.fonderie.etape3;

/**
 * Représente une sphère, qui est une forme particulière de pièce 
 * @author sebastienjean
 *
 */
public class Sphere extends Piece
{
	/**
	 * Rayon de la sphère, en cm
	 */
	final double rayonEnCm;

	/**
	 * Construire une sphère de taille donnée
	 * @param rayonEnCm rayon, en cm
	 */
	public Sphere(double rayonEnCm)
	{
		this.rayonEnCm = rayonEnCm;
	}

	/**
	 * @see fr.iutvalence.java.cm4.fonderie.etape3.Piece#obtenirVolumeEnCm3()
	 */
	public double obtenirVolumeEnCm3()
	{
		return (4/3*Math.PI * Math.pow(this.rayonEnCm, 3));
	}
}
