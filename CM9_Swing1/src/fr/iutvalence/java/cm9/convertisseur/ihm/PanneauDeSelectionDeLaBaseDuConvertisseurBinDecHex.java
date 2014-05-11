package fr.iutvalence.java.cm9.convertisseur.ihm;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import fr.iutvalence.java.cm9.convertisseur.logique.Base;

/**
 * Panneau de sélection de la base du convertisseur
 * 
 * @author sebastienjean
 * 
 */
@SuppressWarnings("serial")
public class PanneauDeSelectionDeLaBaseDuConvertisseurBinDecHex extends JPanel
{
	/**
	 * Le bouton radio associé à la base binaire
	 */
	private JRadioButton binRadioButton;

	/**
	 * Le bouton radio associé à la base décimale
	 */
	private JRadioButton decRadioButton;

	/**
	 * Le bouton radio associé à la base hexadécimale
	 */
	private JRadioButton hexRadioButton;

	/**
	 * Création du panneau de sélection de la base
	 * 
	 * @param auditeurBoutons
	 *            l'auditeur d'évenements associés aux boutons
	 */
	public PanneauDeSelectionDeLaBaseDuConvertisseurBinDecHex(ActionListener auditeurBoutons)
	{
		// Association d'un layout de type "grille & ligne x 3 colonnes" au
		// panneau
		this.setLayout(new GridLayout(1, 3));

		// Création du composant graphique associé au bouton radio
		// "base binaire"
		this.binRadioButton = new JRadioButton("BIN");
		
		// Désactivation du focus sur le bouton (il ne sera jamais mis en
		// surbrillance)
		this.binRadioButton.setFocusable(false);
		
		// Desélection du bouton
		this.binRadioButton.setSelected(false);
		
		// Association de l'auditeur d'évènements au bouton
		this.binRadioButton.addActionListener(auditeurBoutons);
		
		// Ajout du bouton au panneau (l'ordre est important)
		this.add(this.binRadioButton);

		// (idem pour le bouton radio "base décimale")
		this.decRadioButton = new JRadioButton("DEC");
		this.decRadioButton.setFocusable(false);
		this.decRadioButton.setSelected(false);
		this.decRadioButton.addActionListener(auditeurBoutons);
		this.add(this.decRadioButton);

		// (idem pour le bouton radio "base hexadécimale")
		this.hexRadioButton = new JRadioButton("HEX");
		this.hexRadioButton.setFocusable(false);
		this.hexRadioButton.setSelected(false);
		this.hexRadioButton.addActionListener(auditeurBoutons);
		this.add(this.hexRadioButton);

		// Création d'un groupe (et ajout des boutons au groupe) pour garant
		// l'exclusivité
		// de la sélection
		ButtonGroup groupe = new ButtonGroup();
		groupe.add(this.binRadioButton);
		groupe.add(this.decRadioButton);
		groupe.add(this.hexRadioButton);
	}

	/**
	 * Sélection explicite du bouton associé à une base
	 * 
	 * @param base
	 *            la base
	 */
	public void forcerLaSelectionDeLaBase(Base base)
	{
		switch (base)
		{
		case BIN:
			this.binRadioButton.setSelected(true);
			break;
		case DEC:
			this.decRadioButton.setSelected(true);
			break;
		case HEX:
		default:
			this.hexRadioButton.setSelected(true);
			break;

		}
	}
}
