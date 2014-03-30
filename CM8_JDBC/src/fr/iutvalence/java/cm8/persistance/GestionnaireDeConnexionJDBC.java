package fr.iutvalence.java.cm8.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe permettant la gestion de la connexion avec une base de données via JDBC
 * @author sebastienjean
 *
 */
public class GestionnaireDeConnexionJDBC
{
	/**
	 * L'URL de la base de données
	 */
	private final String urlBase;

	/**
	 * Le login de l'utilisateur
	 */
	private final String login;

	/**
	 * Le mot de passe de l'utilisateur
	 */
	private final String motDePasse;

	/**
	 * La connexion à la base de données (<tt>null</tt> si non connecté)
	 */
	private Connection connexion;

	/**
	 * Création d'un nouveau gestionnaire de connexion JDBC étant données les
	 * informations de connexion
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
	 *             Si le dirver JDBC n'a pas pu être chargé
	 */

	public GestionnaireDeConnexionJDBC(String nomDuDriverJDBC, String urlBase,
			String login, String motDePasse) throws ClassNotFoundException
	{
		super();
		Class.forName(nomDuDriverJDBC);

		this.urlBase = urlBase;
		this.login = login;
		this.motDePasse = motDePasse;
	}

	/**
	 * Ouvrir la connexion
	 * 
	 * @return la connexion ouverte
	 * @throws SQLException
	 *             si la connexion n'a pas pau être ouverte
	 */
	public Connection ouvrirConnexion() throws SQLException
	{
		if (this.connexion == null)
			this.connexion = DriverManager.getConnection(this.urlBase, this.login,
					this.motDePasse);
		return this.connexion;

	}

	/**
	 * Fermer la connexion
	 */
	public void fermerConnexion()
	{
		if (this.connexion != null)
		{
			try
			{
				this.connexion.close();
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.connexion = null;
		}
	}

}
