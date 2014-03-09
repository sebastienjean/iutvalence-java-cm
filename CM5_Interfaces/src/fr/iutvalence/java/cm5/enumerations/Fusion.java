package fr.iutvalence.java.cm5.enumerations;

/**
 * Représente un processus de fusion dans une fonderie (fusion d'une série de pièces d'un même métal)
 * @author sebastienjean
 *
 */
public class Fusion
{	
	/**
	 * Le rapport de la fusion (métal, volume fondu, prix)
	 */
	private RapportFusion rapport;
		

	/**
	 * Démarrer un nouveau processus de fusion pour un métal donné
	 * @param metal le métal dont sont faites les pièces à fondre
	 */
	public Fusion(Metal metal)
	{
		this.rapport = new RapportFusion(metal);
	}	

	/**
	 * Fondre une pièce
	 * @param piece la pièce à fondre
	 */
	public void fondre(Piece piece)
	{
		this.rapport.mettreAJourAvec(piece);
	}
	
	/**
	 * Obtenir le rapport de fusion
	 * @return le rapport de fusion
	 */
	public RapportFusion obtenirRapport()
	{
		return this.rapport;
	}
}
