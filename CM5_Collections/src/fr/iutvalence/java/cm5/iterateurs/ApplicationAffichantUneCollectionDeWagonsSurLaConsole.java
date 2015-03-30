package fr.iutvalence.java.cm5.iterateurs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Application parcourant une collection d'objets (avec un itérateur, puis une boucle foreach) et les affichant sur la console
 * @author sebastienjean
 *
 */
public class ApplicationAffichantUneCollectionDeWagonsSurLaConsole
{
	
	/**
	 * Méthode interne affichant un wagon sur la console
	 * @param wagon le wagon à afficher
	 */
	private static void afficherUnWagonSurLaConsole(Wagon wagon)
	{
		System.out.println(wagon);
	}

	/**
	 * Méthode interne parcourant une collection de wagons (avec un itérateur) et affichant chaque wagon sur la console
	 * @param wagons la collection de wagons
	 */
	private static void parcourirUneCollectionDeWagonsAvecUnIterateurEtAfficherChaqueWagonSurLaConsole(Collection<Wagon> wagons)
	{
		Iterator<Wagon> iterateurDeWagons = wagons.iterator();
		
		while (iterateurDeWagons.hasNext())
			afficherUnWagonSurLaConsole(iterateurDeWagons.next());
	}
	
	/**
	 * Méthode interne parcourant une collection de wagons (avec une boucle foreach) et affichant chaque wagon sur la console
	 * @param wagons la collection de wagons
	 */
	private static void parcourirUneCollectionDeWagonsAvecForEachEtAfficherChaqueWagonSurLaConsole(Collection<Wagon> wagons)
	{
		for (Wagon wagon: wagons)
			afficherUnWagonSurLaConsole(wagon);
	}
	
	/**
	 * Point d'entrée de l'application
	 * 
	 * @param args
	 *            les arguments de la ligne de commande (inutilisés ici)
	 */
	public static void main(String[] args)
	{
		Collection<Wagon> wagons = new ArrayList<Wagon>();
		wagons.add(new Wagon(true, 30));
		wagons.add(new Wagon(true, 15));
		wagons.add(new Wagon(false, 20));
		
		System.out.println("Parcours en utilisant un itérateur, affichage sur la console");
		parcourirUneCollectionDeWagonsAvecUnIterateurEtAfficherChaqueWagonSurLaConsole(wagons);
		
		System.out.println();
		
		System.out.println("Parcours en utilisant foreach, affichage sur la console");
		parcourirUneCollectionDeWagonsAvecForEachEtAfficherChaqueWagonSurLaConsole(wagons);
	}
}
