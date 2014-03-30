package fr.iutvalence.java.cm8.creation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Application établissant une connexion à une base de données et créant la
 * table TEMPERATURES
 * 
 * @author sebastienjean
 * 
 */
public class ApplicationDeCreationDeTable
{
	/**
	 * Ouverture d'une connexion à une base de données, via JDBC
	 * 
	 * @param nomDuDriver
	 *            le nom du driver JDBC à charger et utiliser
	 * @param urlBase
	 *            l'URL de la base
	 * @param login
	 *            le login de l'utilisateur
	 * @param pass
	 *            le mot de passe de l'utilisateur
	 * @return la connexion établie à la base de données
	 * @throws ClassNotFoundException
	 *             si le driver JDBC n'a pas pu être chargé
	 * @throws SQLException
	 *             si la connexion n'a pas pu être établie
	 */
	private static Connection obtenirConnexion(String nomDuDriver,
			String urlBase, String login, String pass)
			throws ClassNotFoundException, SQLException
	{
		Class.forName(nomDuDriver);
		return DriverManager.getConnection(urlBase, login, pass);
	}

	/**
	 * Création de la table TEMPERATURES
	 * @param connexion la connexion établie à la base de données
	 * @throws SQLException si la table n'a pas pu être créée
	 */
	private static void creationDeLaTableTemperatures(Connection connexion) throws SQLException
	{
		Statement statement = connexion.createStatement();

		String req = "CREATE TABLE TEMPERATURES (STATION VARCHAR(32), TEMPERATURE FLOAT, PRIMARY KEY (STATION))";

		statement.executeUpdate(req);
	}

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
		Connection connexion = null;
		try
		{
			connexion = obtenirConnexion(args[0], args[1], args[2], args[3]);
		}
		catch (ClassNotFoundException e1)
		{
			System.out.print("Chargement du driver JDBC impossible ...");
			System.exit(1);
		}
		catch (SQLException e1)
		{
			System.out.print("Connexion à la base de données impossible ...");
			System.exit(1);
		}

		System.out.println("Connexion à la base de données établie");

		System.out.println("Création de la table TEMPERATURES");
		
		try
		{
			creationDeLaTableTemperatures(connexion);
		}
		catch (SQLException e1)
		{
			System.out.print("Création de la table TEMPERATURES impossible ...");
			System.exit(1);
		}
		
		System.out.println("Création de la table TEMPERATURES effectuée");
		System.out.println("Fermeture de la connexion.");
		try
		{
			connexion.close();
		}
		catch (SQLException e)
		{
		}
	}
}
