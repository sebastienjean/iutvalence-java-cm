package fr.iutvalence.java.cm9.composantsSimples;

import javax.swing.SwingUtilities;

/**
 * Une application affichant des fenêtres exposant des composants simples
 * 
 * @author sebastienjean
 *
 */
public class ApplicationDAffichageDeComposantsSimples
{
	/**
	 * Main de l'application 
	 * @param args (n/a)
	 */
	public static void main(String[] args)
	{
		// Exécution de la tâche de gestion de l'IHM dans le thread "event dispatch" de Swing
		SwingUtilities.invokeLater(new TacheDAffichageDeComposantsSimples());
		System.out.println("fin du main !");
	}
}
