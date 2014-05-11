package fr.iutvalence.java.cm9.jbuttonlistener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Tâche gérant l'IHM (création, affichage) 
 * 
 * @author sebastienjean
 *
 */
public class TacheDAffichageDeFenetreAvecBoutonObserve implements Runnable
{
	@Override
	public void run()
	{
		JFrame fenetre = new JFrame();

		fenetre.setTitle("Une fenêtre avec un bouton observé");
		fenetre.setSize(250, 100);
		fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		JButton bouton = new JButtonCompteurDeClic();

		fenetre.getContentPane().add(bouton);

		fenetre.setVisible(true);
	}
}
