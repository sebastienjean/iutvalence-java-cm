package fr.iutvalence.java.cm7.primitif;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Application faisant de la journalisation d'évènements dans un fichier texte
 * 
 * @author sebastienjean
 * 
 */
public class ApplicationDeLectureDEntiersDansUnFichierBinaire
{
	/**
	 * Point d'entrée de l'application
	 * 
	 * @param args
	 *            les arguments de la ligne de commande. Ici, il est attendu 1
	 *            argument correspondant au chemin complet d'accès au fichier
	 *            source
	 */
	public static void main(String[] args)
	{

		File srcFile = new File(args[0]);
		DataInputStream dis = null;
		try
		{
			dis = new DataInputStream(new FileInputStream(srcFile));
		}
		catch (FileNotFoundException e)
		{
			System.err.println("Accès impossible au fichier source");
			System.exit(1);
		}
		long numberOfIntsInFile = srcFile.length() / 4;
		try
		{
			while (numberOfIntsInFile > 0)
			{
				System.out.println(dis.readInt());
				numberOfIntsInFile--;
			}
			dis.close();
		}
		catch (IOException e)
		{
			System.err.println("Erreur de lecture");
			System.exit(1);
		}
	}
}
