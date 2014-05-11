package fr.iutvalence.java.cm9.jframe;

import javax.swing.SwingUtilities;

/**
 * Une application affichant une fenêtre simple
 * 
 * @author sebastienjean
 *
 */
public class ApplicationDAffichageDeFenetreSimple
{
	/**
	 * Main de l'application 
	 * @param args (n/a)
	 */
	public static void main(String[] args)
	{
		// Exécution de la tâche de gestion de l'IHM dans le thread "event dispatch" de Swing
		SwingUtilities.invokeLater(new TacheDAffichageDeFenetreSimple());
		System.out.println("fin du main !");
	}
}
