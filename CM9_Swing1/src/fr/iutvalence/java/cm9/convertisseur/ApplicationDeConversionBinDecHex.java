package fr.iutvalence.java.cm9.convertisseur;

import javax.swing.SwingUtilities;

import fr.iutvalence.java.cm9.convertisseur.ihm.TacheDAffichageDuConvertisseurBinDecHex;
import fr.iutvalence.java.cm9.convertisseur.logique.ConvertisseurBinDecHex;

/**
 * Application graphique de conversion binaire/décimal/hexadécimal
 *  
 * @author sebastienjean
 *
 */
public class ApplicationDeConversionBinDecHex
{
	/**
	 * Le main de l'application
	 * @param args (n/a)
	 */
	public static void main(String[] args)
	{
		// Création de l'objet "métier" convertisseur
		ConvertisseurBinDecHex convertisseur = new ConvertisseurBinDecHex();
		
		// Création de la tâche gérant l'IHM et permettant de contrôler le convertisseur
		TacheDAffichageDuConvertisseurBinDecHex tacheDAffichageDuConvertisseurBinDecHex = new TacheDAffichageDuConvertisseurBinDecHex(convertisseur);
		
		// Association de la tâche comme vue pour l'affichage du convertisseur
		convertisseur.associerUneVue(tacheDAffichageDuConvertisseurBinDecHex);
		
		// Exécution de la tâche gérant l'IHM
		SwingUtilities.invokeLater(tacheDAffichageDuConvertisseurBinDecHex);
	}
}
