package fr.iutvalence.java.cm9.jbutton;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Tâche gérant l'IHM (création, affichage) 
 * 
 * @author sebastienjean
 *
 */
public class TacheDAffichageDeFenetreAvecBouton implements Runnable
{
	@Override
	public void run()
	{
		JFrame fenetre = new JFrame();

		fenetre.setTitle("Une fenêtre avec un bouton");
		fenetre.setSize(250, 100);
		
		// Spécification du comportement à la fermeture de la fenêtre (ici, destruction)
		fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// Création du composant graphique associé au bouton
		// un contenu texte est associé au bouton (mais pas d'icone)
		JButton bouton = new JButton("Inutile de cliquer !");

		// Ajout du bouton dans le conteneur principal associé à la fenêtre
		// (c'est le seul composant)
		fenetre.getContentPane().add(bouton);

		fenetre.setVisible(true);
	}
}
