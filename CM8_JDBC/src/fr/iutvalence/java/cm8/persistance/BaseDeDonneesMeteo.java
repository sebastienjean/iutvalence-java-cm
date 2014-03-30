package fr.iutvalence.java.cm8.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe représentant une "base de données" météo.
 * 
 * @author sebastienjean
 * 
 */
public class BaseDeDonneesMeteo
{
	/**
	 * Requête permettant d'obtenir la liste des stations
	 */
	private final static String REQUETE_OBTENTION_NOMS_DES_STATIONS = "SELECT STATION FROM TEMPERATURES";
	
	/**
	 * Requête permettant d'obtenir la dernière température relevée par une station
	 */
	private final static String REQUETE_OBTENTION_TEMPERATURE_STATION = "SELECT TEMPERATURE FROM TEMPERATURES WHERE STATION = ?";
	
	/**
	 * Requête permettant de modifier la dernière température relevée par une station
	 */
	private final static String REQUETE_MODIFICATION_TEMPERATURE_STATION = "UPDATE TEMPERATURES SET TEMPERATURE = ? WHERE STATION = ?";
	
	/**
	 * Le gestionnaire de connexion JDBC
	 */
	private final GestionnaireDeConnexionJDBC gestionnaireDeConnexionJDBC;

	/**
	 * Création d'une nouvelle "base de données" étant données les informations
	 * de connexion
	 * 
	 * @param nomDuDriverJDBC
	 *            le nom de la classe implémentant le driver JDBC
	 * @param urlBase
	 *            l'URL de la base de données
	 * @param login
	 *            le login de l'utilisateur
	 * @param motDePasse
	 *            le mot de passe de l'utilisateur
	 * @throws ClassNotFoundException
	 *             si le driver JDBC n'a pas pu être chargé
	 */

	public BaseDeDonneesMeteo(String nomDuDriverJDBC, String urlBase,
			String login, String motDePasse) throws ClassNotFoundException
	{
		super();
		this.gestionnaireDeConnexionJDBC = new GestionnaireDeConnexionJDBC(
				nomDuDriverJDBC, urlBase, login, motDePasse);
	}

	/**
	 * Obtention du nom de la station
	 * 
	 * @return le nom de la station
	 */
	public Set<String> obtenirNomsDesStationsConnues()
	{
		Set<String> nomsDesStations = new HashSet<String>();

		try
		{
			Connection connexion = this.gestionnaireDeConnexionJDBC
					.ouvrirConnexion();
			Statement statement = connexion.createStatement();
			ResultSet resultat = statement
					.executeQuery(REQUETE_OBTENTION_NOMS_DES_STATIONS);
			while (resultat.next())
				nomsDesStations.add(resultat.getString("STATION"));
		}
		catch (SQLException e)
		{
			return null;
		}

		return nomsDesStations;
	}

	/**
	 * Obtention de la dernière température relevée par une station
	 * 
	 * @param nomDeLaStation
	 *            le nom de la station
	 * 
	 * @return la dernière température relevée par une station
	 * @throws SQLException
	 *             Si la connexion est défaillante
	 */
	public double obtenirDerniereTemperatureRelevee(String nomDeLaStation)
			throws SQLException
	{
		Connection connexion = this.gestionnaireDeConnexionJDBC
				.ouvrirConnexion();
		PreparedStatement statement = connexion
				.prepareStatement(REQUETE_OBTENTION_TEMPERATURE_STATION);
		statement.setString(1, nomDeLaStation);
		ResultSet resultat = statement.executeQuery();
		resultat.absolute(1);
		return resultat.getDouble("TEMPERATURE");
	}

	/**
	 * Modification de la dernière température relevée par une station
	 * 
	 * @param nomDeLaStation
	 *            le nom de la station
	 * @param temperatureRelevee
	 *            la dernière température relevée par la station
	 * @throws SQLException
	 *             Si la connexion est défaillante
	 */
	public void modifierDerniereTemperatureRelevee(String nomDeLaStation, double temperatureRelevee)
			throws SQLException
	{
		Connection connexion = this.gestionnaireDeConnexionJDBC
				.ouvrirConnexion();
		PreparedStatement statement = connexion
				.prepareStatement(REQUETE_MODIFICATION_TEMPERATURE_STATION);
		statement.setDouble(1, temperatureRelevee);
		statement.setString(2, nomDeLaStation);
		statement.executeQuery();
	}

}
