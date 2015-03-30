package fr.iutvalence.java.cm4.fonderie.etape1;

/**
 * Application de test de l'étude de cas "fonderie" (étape1)
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
		Pave[] desPaves = new Pave[] { new Pave(1, 2, 3), new Pave(2, 3, 4) };
		Pave[] dAutresPaves = new Pave[] { new Pave(3, 4, 5), new Pave(4, 5, 6) };

		Fonderie fonderie = new Fonderie();

		System.out.println(fonderie.fondre(desPaves) + " cm3 fondus");
		System.out.println(fonderie.fondre(dAutresPaves) + " cm3 fondus");
		System.out.println(fonderie.obtenirVolumeCumuleDesPavesFondusEnCm3()
				+ "cm3 de paves fondus au total");
	}
}
