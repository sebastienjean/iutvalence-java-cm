package fr.iutvalence.java.cm5.fidelite;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 * Représente un groupe de cartes de fidélités. Une carte de fidélité associe un client à un nombre entier de points
 * @author sebastienjean
 *
 */
public class CartesDeFidelite
{
	/**
	 * L'association triée permettant de stocker les cartes de fidélités. La clé est un client, la valeur le nombre de points
	 */
	private SortedMap<Client, Integer> cartesDeFidelite;
	
	/**
	 * Création d'un nouveau groupe de cartes de fidélité, initialement vide
	 */
	public CartesDeFidelite()
	{
		this.cartesDeFidelite = new TreeMap<Client, Integer>();
	}
	
	/**
	 * Création ou mise à jour d'une carte de fidélité. Si le client n'avait pas de carte, elle est créée. 
	 * Si le client possèdait déjà une carte, le nombre de points est remplacé.
	 * @param client le client
	 * @param points le nombre de points
	 */
	public void creerOuMettreAJourClient(Client client, int points)
	{
		this.cartesDeFidelite.put(client, points);
	}
	
	/**
	 * Suppression d'une carte de fidélité
	 * @param client le client dont on souhaite supprimer la carte
	 * @throws ClientInconnuException si le client n'avait pas de carte
	 */
	public void supprimerClient(Client client) throws ClientInconnuException
	{
		if (this.cartesDeFidelite.remove(client) == null) throw new ClientInconnuException();
	}
	
	/**
	 * Obtention du nombre de points d'un client
	 * @param client le client
	 * @return le nombre de points du client
	 * @throws ClientInconnuException si le client n'avait pas de carte
	 */
	public int obtenirPoints(Client client) throws ClientInconnuException
	{
		if (!this.cartesDeFidelite.containsKey(client)) throw new ClientInconnuException();
		
		return this.cartesDeFidelite.get(client);
	}	
}
