package fr.iutvalence.java.cm9.jmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * Tâche gérant l'IHM (création, affichage)
 * 
 * @author sebastienjean
 * 
 */
public class TacheDAffichageDeFenetreAvecMenu implements Runnable, ActionListener
{
	/**
	 * La fenêtre
	 */
	private JFrame fenetre;

	/**
	 * L'item de menu "A propos"
	 */
	private JMenuItem menuItemAPropos;

	/**
	 * L'item de menu "Fermer"
	 */
	private JMenuItem menuItemFermer;

	@Override
	public void run()
	{
		this.fenetre = new JFrame();

		this.fenetre.setTitle("Une fenêtre avec menu");
		this.fenetre.setSize(250, 100);
		this.fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// Création du composant associé à la barre de menu
		JMenuBar barreDeMenu = new JMenuBar();

		// Création de la rubrique de menu "Menu"
		JMenu menu = new JMenu("Menu");

		// Création de l'item de rubrique "A propos"
		this.menuItemAPropos = new JMenuItem("A propos");

		// Association de la tâche comme auditeur d'évènement
		this.menuItemAPropos.addActionListener(this);

		// Ajout du premier item à la rubrique (l'ordre d'ajout est l'ordre
		// d'apparition)
		menu.add(this.menuItemAPropos);

		// (idem pour le second item de rubrique)
		this.menuItemFermer = new JMenuItem("Fermer");
		this.menuItemFermer.addActionListener(this);
		menu.add(this.menuItemFermer);

		// Ajout de la rubrique à la barre de menu
		barreDeMenu.add(menu);

		// Affectation de la barre de menu à la fenêtre
		this.fenetre.setJMenuBar(barreDeMenu);

		this.fenetre.setVisible(true);
	}

	/**
	 * Traitement des évènements associés aux items de rubriques
	 * 
	 * @param event
	 *            l'événement survenu
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		// Identification de l'item sélectionné, source de l'événement
		JMenuItem itemSelectionne = (JMenuItem) event.getSource();

		if (itemSelectionne == this.menuItemAPropos)
		{
			// Affichage d'un boite de dialogue délivrant un simple message
			JOptionPane.showMessageDialog(this.fenetre, "Une application qui dispose d'un menu", "A propos", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		if (itemSelectionne == this.menuItemFermer)
		{
			// Affichage d'un boite de dialogue proposant 2 options
			// (confirmer/annuler)
			if (JOptionPane.showConfirmDialog(this.fenetre, "Fermer l'application ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
				// destruction de la fenêtre en cas de confirmation de fermeture
				this.fenetre.dispose();
		}
	}
}
