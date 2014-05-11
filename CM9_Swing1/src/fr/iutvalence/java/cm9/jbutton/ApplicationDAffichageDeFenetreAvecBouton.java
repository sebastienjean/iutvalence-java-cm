package fr.iutvalence.java.cm9.jbutton;

import javax.swing.SwingUtilities;

/**
 * Une application affichant une fenêtre exposant un bouton
 * 
 * @author sebastienjean
 *
 */
public class ApplicationDAffichageDeFenetreAvecBouton
{
	/**
	 * Main de l'application 
	 * @param args (n/a)
	 */
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new TacheDAffichageDeFenetreAvecBouton());
	}
}
