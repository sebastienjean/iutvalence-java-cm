package fr.iutvalence.java.cm9.jmenu;

import javax.swing.SwingUtilities;

/**
 * Une application affichant une fenêtre avec barre de menu
 * 
 * @author sebastienjean
 * 
 */
public class ApplicationDAffichageDeFenetreAvecMenu
{
	/**
	 * Main de l'application
	 * 
	 * @param args
	 *            (n/a)
	 */
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new TacheDAffichageDeFenetreAvecMenu());
	}
}
