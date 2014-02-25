package fr.iutvalence.fonderie.etape2;

/**
 * Représente un cube, qui est une forme particulière de pavé
 * @author sebastienjean
 *
 */
public class Cube extends Pave
{
	/**
	 * Construit un cube de taille donnée
	 * @param longueurAreteEnCm la longueur des arêtes du cube, en cm
	 */
	public Cube(double longueurAreteEnCm)
	{	
		super(longueurAreteEnCm,longueurAreteEnCm,longueurAreteEnCm);
	}
}	
	
