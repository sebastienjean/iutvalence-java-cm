package fr.iutvalence.java.cm5.fidelite;

/**
 * Représente un client d'une boutique. Un client est caractérisé par son nom/prénom et son code postal.
 * @author sebastienjean
 *
 */
public class Client implements Comparable<Client>
{
	/**
	 * Le nom du client
	 */
	private final String nom;

	/**
	 * Le prénom du client
	 */
	private final String prenom;

	/**
	 * Le code postal de résidence du client
	 */
	private int codePostal;

	/**
	 * Création d'un nouveau client de nom, prénom et code postal donnés
	 * @param nom le nom du client
	 * @param prenom le prénom du client
	 * @param codePostal le code postal de résidence du client
	 */
	public Client(String nom, String prenom, int codePostal)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.codePostal = codePostal;
	}

	/**
	 * Obtention du code postal de résidence du client
	 * @return  le code postal de résidence du client
	 */
	public int obtenirCodePostal()
	{
		return this.codePostal;
	}

	/**
	 * Modification du code postal de résidence du client
	 * @param codePostal le nouveau code postal de résidence du client          
	 */
	public void modifierCodePostal(int codePostal)
	{
		this.codePostal = codePostal;
	}

	/**
	 * Obtention du nom du client
	 * @return  le nom du client
	 */
	public String obtenirNom()
	{
		return this.nom;
	}

	/**
	 * Obtention du prénom du client
	 * @return  le prénom du client
	 */
	public String obtenirPrenom()
	{
		return this.prenom;
	}

	/**
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Client client)
	{
		int resultatComparaison = this.codePostal - client.codePostal;

		if (resultatComparaison == 0)
		{
			resultatComparaison = this.nom.compareTo(client.nom);
			if (resultatComparaison == 0)
				resultatComparaison = this.prenom.compareTo(client.prenom);
		}

		return resultatComparaison;
	}

	/**
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		return this.codePostal + this.codePostal * (this.nom.length())
				+ (this.prenom.length());
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Client))
			return false;

		Client client = (Client) obj;

		if (!this.nom.equals(client.nom))
			return false;
		if (!this.prenom.equals(client.prenom))
			return false;
		return true;
	}

}
