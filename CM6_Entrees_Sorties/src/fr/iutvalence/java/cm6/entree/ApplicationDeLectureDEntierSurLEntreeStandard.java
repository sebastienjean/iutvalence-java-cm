package fr.iutvalence.java.cm6.entree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Application faisant la lecture d'un entier sur l'entrée standard, à partir
 * d'une ligne de texte représentant l'entier à lire
 * 
 * @author sebastienjean
 * 
 */
public class ApplicationDeLectureDEntierSurLEntreeStandard
{
	/**
	 * Point d'entrée de l'application
	 * 
	 * @param args
	 *            les arguments de la ligne de commande (aucun ici)
	 */
	public static void main(String[] args)
	{
		InputStreamReader isr = null;
		try
		{
			isr = new InputStreamReader(System.in, "US-ASCII");
		}
		catch (UnsupportedEncodingException e1)
		{
			// US-ASCII est universellement disponible			
		}
		BufferedReader br = new BufferedReader(isr);
		String s = null;
		try
		{
			s = br.readLine();
			int i = Integer.parseInt(s);
			System.out.println(i);
			isr.close();
			br.close();
		}
		catch (IOException e)
		{
			System.err.println("Erreur de lecture");
			System.exit(1);
		}
	}
}
