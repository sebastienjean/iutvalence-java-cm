package fr.iutvalence.java.cm6.copie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Application faisant une copie de fichier binaire
 * 
 * @author sebastienjean
 * 
 */
public class ApplicationDeCopieDeFichierBinaire
{
	/**
	 * Point d'entrée de l'application
	 * 
	 * @param args
	 *            les arguments de la ligne de commande. Ici, il est attendu 2
	 *            arguments correspondant respectivement aux chemins complets
	 *            d'accès aux fichiers source et destination
	 */
	public static void main(String[] args)
	{
		File srcFile = new File(args[0]);
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try
		{
			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(args[1]);
		}
		catch (FileNotFoundException e)
		{
			System.err.println("Accès impossible au fichier source ou destination");
			System.exit(1);
		}
		long resteALire = srcFile.length();
		try
		{
			while (resteALire > 0)
			{
				int av = fis.available();
				byte[] buf = new byte[av];
				fis.read(buf, 0, av);
				fos.write(buf, 0, av);
				resteALire -= av;
			}
			fos.close();
			fis.close();
		}
		catch (IOException e)
		{
			System.err.println("Erreur de lecture/écriture");
			System.exit(1);
		}
	}
}
