package fr.iutvalence.java.cm9.jbuttonlistener;

import javax.swing.SwingUtilities;

/**
 * Une application affichant une fenêtre simple exposant un bouton dont les évenements sont observés
 * 
 * @author sebastienjean
 *
 */
public class ApplicationDAffichageDeFenetreAvecBoutonObserve
{
	/**
	 * Main de l'application 
	 * @param args (n/a)
	 */
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new TacheDAffichageDeFenetreAvecBoutonObserve());
	}
}
