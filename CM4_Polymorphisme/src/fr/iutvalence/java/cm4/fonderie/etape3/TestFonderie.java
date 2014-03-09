package fr.iutvalence.java.cm4.fonderie.etape3;

/**
 * Application de test de l'étude de cas "fonderie" (étape3)
 * 
 * @author sebastienjean
 * 
 */
public class TestFonderie
{
	/**
	 * Point d'entrée de l'application
	 * 
	 * @param args
	 *            les arguments de la ligne de commande (inutilisés ici)
	 */
	public static void main(String[] args)
	{
		Piece[] desPieces = new Piece[] { new Cube(1), new Pave(2,3,4), new Cylindre(1, 6), new Sphere(5)};
		Piece[] dAutresPieces = new Piece[] { new Pave(3, 4, 5), new Cube(4), new Sphere(1), new Cylindre(2, 3) };
		
		Fonderie fonderie = new Fonderie();
		
		System.out.println(fonderie.fondre(desPieces)+" cm3 fondus");
		System.out.println(fonderie.fondre(dAutresPieces)+" cm3 fondus");
		System.out.println(fonderie.obtenirVolumeCumuleDesPiecesFonduesEnCm3()+"cm3 de paves fondus au total");
	}

}
