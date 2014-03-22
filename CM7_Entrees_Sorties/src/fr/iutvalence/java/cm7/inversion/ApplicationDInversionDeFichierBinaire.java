package fr.iutvalence.java.cm7.inversion;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Application faisant une inversion d'ordre des octets de fichier binaire
 * 
 * @author sebastienjean
 * 
 */
public class ApplicationDInversionDeFichierBinaire
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
		byte[] fileContent = null;
		File srcFile = new File(args[0]);
		FileInputStream fis = null;
		ByteArrayOutputStream bos = null;
		try
		{
			fis = new FileInputStream(srcFile);
		}
		catch (FileNotFoundException e)
		{
			System.err.println("Accès impossible au fichier source");
			System.exit(1);
		}
		bos = new ByteArrayOutputStream();
		long resteALire = srcFile.length();
		try
		{
			while (resteALire > 0)
			{
				int av = fis.available();
				byte[] buf = new byte[av];
				fis.read(buf, 0, av);
				bos.write(buf, 0, av);
				resteALire -= av;
			}
			fileContent = bos.toByteArray();
			bos.close();
			fis.close();
		}
		catch (IOException e)
		{
			System.err.println("Erreur de lecture");
			System.exit(1);
		}

		FileOutputStream fos = null;
		try
		{
			fos = new FileOutputStream(args[1]);
		}
		catch (FileNotFoundException e)
		{
			System.err.println("Accès impossible au fichier destination");
			System.exit(1);
		}

		try
		{
			for (int numeroDOctet = fileContent.length - 1; numeroDOctet >= 0; numeroDOctet--)
			{

				fos.write(fileContent[numeroDOctet]);

			}
			fos.close();
		}
		catch (IOException e)
		{
			System.err.println("Erreur d'écriture");
			System.exit(1);
		}
	}
}
