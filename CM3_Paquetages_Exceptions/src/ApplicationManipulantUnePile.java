import java.util.Random;

import fr.iutvalence.java.cm3.piles.PileEntiersPositifsOuNulsAvecSomme;
import fr.iutvalence.java.cm3.piles.exceptions.CapaciteInvalideException;
import fr.iutvalence.java.cm3.piles.exceptions.EntierNegatifException;
import fr.iutvalence.java.cm3.piles.exceptions.PilePleineException;
import fr.iutvalence.java.cm3.piles.exceptions.PileVideException;

/**
 * Application manipulant une pile (version avec exceptions)
 * 
 * @author sebastienjean
 * 
 */
public class ApplicationManipulantUnePile
{
	/**
	 * Code opération correspondant à l'opération empiler
	 */
	private static final int CODE_OPERATION_EMPILER = 0;

	/**
	 * Code opération correspondant à l'opération depiler
	 */	
	private static final int CODE_OPERATION_DEPILER = 1;
	
	/**
	 * Code opération correspondant à l'opération voirSommet
	 */
	private static final int CODE_OPERATION_VOIR_SOMMET = 2;

	/**
	 * Un générateur de nombres aléatoires, utilisé pour obtenir des entiers positifs ou nuls
	 */
	private static Random generateurAleatoire;

	/**
	 * Une pile d'entiers positifs ou nuls, avec calcul incrémental de somme, à manipuler
	 */
	private static PileEntiersPositifsOuNulsAvecSomme pile;

	/**
	 * Le point d'entrée de l'application. 
	 * Création d'une nouvelle pile (avec capacité aléatoire), puis enchainement d'une séquence de 
	 * 10 opérations choisies aléatoirement parmi empiler/depiler/voirSommet
	 * 
	 * @param args
	 *            les arguments de la ligne de commande (inutilisés ici)
	 */
	public static void main(String[] args)
	{
		generateurAleatoire = new Random();

		int capaciteInitiale = generateurAleatoire.nextInt();
		
		System.out.println("Création d'une PEPNS de capacité "
				+ capaciteInitiale);

		pile = null;

		try
		{
			pile = new PileEntiersPositifsOuNulsAvecSomme(capaciteInitiale);
		}
		catch (CapaciteInvalideException e1)
		{
			// On décide ici que si la création de la pile échoue,
			// on construit une pile par défaut
			System.out
					.println("Capacité invalide, création d'une PEPNS de capacité par défaut");
			pile = new PileEntiersPositifsOuNulsAvecSomme();
		}

		System.out.println("Début de la séquence d'opérations aléatoires");

		for (int nombreDOperations = 0; nombreDOperations < 10; nombreDOperations++)
		{
			executerOperationSuivante();
		}

		System.out.println("Fin de la séquence d'opérations aléatoires");
	}

	/**
	 * Execution d'une opération choisie aléatoirement parmi
	 * empiler/depiler/voirSommet
	 */
	private static void executerOperationSuivante()
	{
		int codeOperation = generateurAleatoire.nextInt(3);
		switch (codeOperation)
		{
		case CODE_OPERATION_EMPILER: 
			executerOperationEmpiler();
			break;
		case CODE_OPERATION_DEPILER:
			executerOperationDepiler();
			break;
		case CODE_OPERATION_VOIR_SOMMET:
			executerOperationVoirSommet();
			break;
		default:
		}
	}

	/**
	 * Execution de l'opération empiler
	 */
	private static void executerOperationEmpiler()
	{
		int elementAEmpiler = generateurAleatoire.nextInt();
		System.out.println("empiler(" + elementAEmpiler + ")");
		try
		{
			pile.empiler(elementAEmpiler);
			System.out.println("OK");
		}
		catch (PilePleineException e1)
		{
			System.out.println("Impossible d'empiler, la pile est pleine");
		}
		catch (EntierNegatifException e2)
		{
			System.out.println("Impossible d'empiler, l'entier est négatif");
		}
	}

	/**
	 * Execution de l'opération depiler
	 */
	private static void executerOperationDepiler()
	{
		System.out.println("depiler() ");
		try
		{
			System.out.println(pile.depiler());
		}
		catch (PileVideException e1)
		{
			System.out.println("Impossible de depiler, la pile est vide");
		}
	}
	
	/**
	 * Execution de l'opération voirSommet
	 */
	private static void executerOperationVoirSommet()
	{
		System.out.println("voirSommet() ");
		try
		{
			System.out.println(pile.voirSommet());
		}
		catch (PileVideException e1)
		{
			System.out.println("Impossible de voir le sommet, la pile est vide");
		}
	}
}
