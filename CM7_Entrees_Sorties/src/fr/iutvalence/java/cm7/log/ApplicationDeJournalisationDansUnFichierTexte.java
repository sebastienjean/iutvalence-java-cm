package fr.iutvalence.java.cm7.log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Application faisant un affichage sur la console de valuers entières
 * sérialisées dans un fichier binaire
 * 
 * @author sebastienjean
 * 
 */
public class ApplicationDeJournalisationDansUnFichierTexte
{
	/**
	 * Point d'entrée de l'application
	 * 
	 * @param args
	 *            les arguments de la ligne de commande. Ici, il est attendu 1
	 *            argument correspondant au chemin complet d'accès au fichier
	 *            destination
	 */
	public static void main(String[] args)
	{
		PrintStream ps = null;
		try
		{
			ps = new PrintStream(new FileOutputStream(args[0]));
		}
		catch (FileNotFoundException e)
		{
			System.err.println("Accès impossible au fichier destination");
			System.exit(1);
		}
		try
		{
			long temps = System.currentTimeMillis();
			ps.println("démarrage de l’application ");
			Thread.sleep((int) (Math.random() * 10000));
			temps = System.currentTimeMillis() - temps;
			ps.print("l’application a fait une pause de ");
			ps.print(temps);
			ps.println(" ms");
			ps.close();
		}
		catch (Exception e)
		{
			System.err.println("Erreur d'écriture");
			System.exit(1);
		}
	}
}
