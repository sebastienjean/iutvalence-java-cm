package fr.iutvalence.java.cm4.fonderie.etape4;

/**
 * Représente un cube, qui est une forme particulière de pavé (et donc de pièce)
 * @author sebastienjean
 *
 */
public class Cube extends Pave
{
	/**
	 * Construire un cube de taille donnée
	 * @param longueurAreteEnCm la longueur des arêtes du cube, en cm
	 */
	public Cube(double longueurAreteEnCm)
	{	
		super(longueurAreteEnCm,longueurAreteEnCm,longueurAreteEnCm);
	}
}	
