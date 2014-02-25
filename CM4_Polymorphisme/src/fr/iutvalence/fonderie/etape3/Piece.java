package fr.iutvalence.fonderie.etape3;

/**
 * REprésente une pièce, dont on souhaite connaitre le volume
 * @author sebastienjean
 *
 */
public abstract class Piece
{
	/**
	 * Obtenir le volume de la piece, en cm3
	 * @return le volume de la piece, en cm3
	 */
	public abstract double obtenirVolumeEnCm3();
}