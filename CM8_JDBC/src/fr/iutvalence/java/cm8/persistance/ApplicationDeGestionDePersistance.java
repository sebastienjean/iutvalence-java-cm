package fr.iutvalence.java.cm8.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Application gérant la persistance de données méteo dans une base de données
 * 
 * @author sebastienjean
 * 
 */
public class ApplicationDeGestionDePersistance
{

	/**
	 * Point d'entrée de l'application
	 * 
	 * @param args
	 *            les arguments de la ligne de commande. Ici, il est attendu 4
	 *            arguments correspondant respectivement : - au nom de la classe
	 *            implémentant le driver JDBC, - l'URL de la base de données, -
	 *            le login de l'utilisateur - le mot de passe de l'utilisateur
	 */
	public static void main(String[] args)
	{
		BaseDeDonneesMeteo bddMeteo = null;
		try
		{
			bddMeteo = new BaseDeDonneesMeteo(args[0], args[1], args[2], args[3]);
		}
		catch (ClassNotFoundException e)
		{
			System.out.print("Chargement du driver JDBC impossible ...");
			System.exit(1);
		}
		System.out.println("Nom des stations connues :");
		for (String nomDeStation : bddMeteo.obtenirNomsDesStationsConnues())
			System.out.println(nomDeStation);
		
		try
		{
			System.out.print("Température à Valence : ");
			System.out.println(bddMeteo.obtenirDerniereTemperatureRelevee("Valence"));
			System.out.println("Modification de température à Valence (10.4°C)");
			bddMeteo.modifierDerniereTemperatureRelevee("Valence", 10.4);
			System.out.print("Température à Valence : ");
			System.out.println(bddMeteo.obtenirDerniereTemperatureRelevee("Valence"));
		}
		catch (SQLException e)
		{
			System.out.println("Problème de connexion avec la BDD");
			System.exit(1);
		}
	}
}
