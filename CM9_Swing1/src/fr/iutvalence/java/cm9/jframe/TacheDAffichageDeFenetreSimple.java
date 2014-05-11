package fr.iutvalence.java.cm9.jframe;

import javax.swing.JFrame;

/**
 * Tâche gérant l'IHM (création, affichage) 
 * 
 * @author sebastienjean
 *
 */
public class TacheDAffichageDeFenetreSimple implements Runnable
{
	@Override
	public void run()
	{
		// Création du composant graphique associé à la fenêtre
		// (à ce stade rien n'est affiché)
		JFrame fenetre = new JFrame();

		// Modification des propriétés de la fenêtre
		// Titre, dimensions (en pixel)
		fenetre.setTitle("Une simple fenêtre");
		fenetre.setSize(200, 100);

		// Affichage de la fenêtre
		fenetre.setVisible(true);
	}
}
