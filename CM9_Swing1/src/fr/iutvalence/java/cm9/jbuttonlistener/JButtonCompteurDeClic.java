package fr.iutvalence.java.cm9.jbuttonlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * Bouton évolué affichant (en guise de contenu texte) le nombre de clics
 * effectués depuis sa mise en activité. Cette classe est réalisée par extension
 * de la classe JButton. Les évenements (clic) sont capturés par le bouton
 * lui-même par implémentation de l'interface ActionListener
 * 
 * @author sebastienjean
 * 
 */
@SuppressWarnings("serial")
public class JButtonCompteurDeClic extends JButton implements ActionListener
{
	/**
	 * Compteur de nombre de clics
	 */
	private int compteurDeClics;

	/**
	 * Création d'un nouveau bouton. Le bouton est
	 */
	public JButtonCompteurDeClic()
	{
		// Initialisation du nombre de clics
		this.compteurDeClics = 0;

		// Association d'un icone à partir d'un image PNG situé dans le
		// répertoire courant
		this.setIcon(new ImageIcon("icon.png"));

		// Alignement du texte centré en bas du bouton
		// (par défaut, c'est le cas pour l'icone, l'alignement
		// vertical/horizontal vaut CENTER)
		this.setVerticalTextPosition(SwingConstants.BOTTOM);
		this.setHorizontalTextPosition(SwingConstants.CENTER);

		// Mise à jour du texte du bouton
		this.mettreAJourTexte();

		// Enregistrement du bouton comme auditeur des évenèments qu'il génère
		this.addActionListener(this);
	}

	/**
	 * Méthode interne permettant de mettre à jour le texte
	 */
	private void mettreAJourTexte()
	{
		// Modification du texte
		this.setText("Cliqué " + this.compteurDeClics + " fois");
	}

	/**
	 * Traitement des évenements standard liés au bouton (ici le clic)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		this.compteurDeClics++;
		this.mettreAJourTexte();
	}
}
