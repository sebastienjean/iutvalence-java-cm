package fr.iutvalence.java.cm9.convertisseur.ihm;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.iutvalence.java.cm9.convertisseur.logique.Base;

/**
 * Panneau de saisie de la suite de symboles du convertisseur
 * @author sebastienjean
 *
 */
@SuppressWarnings("serial")
public class PanneauDeSaisieDesDigitsDuConvertisseurBinDecHex extends JPanel
{
	/**
	 * Créatio du panneau de saisie de la suite de symboles du convertisseur
	 * @param base la base 
	 * @param auditeurBoutons l'auditeur d'évènements des boutons du panneau
	 */
	public PanneauDeSaisieDesDigitsDuConvertisseurBinDecHex(Base base, ActionListener auditeurBoutons)
	{
		switch (base)
		{
		case BIN:
			this.ajouterUneGrilleDeBoutons(1, 2, Base.BIN.obtenirLesSymboles(), auditeurBoutons);
			break;
		case DEC:
			this.ajouterUneGrilleDeBoutons(2, 5, Base.DEC.obtenirLesSymboles(), auditeurBoutons);
			break;
		case HEX:
		default:
			this.ajouterUneGrilleDeBoutons(4, 4, Base.HEX.obtenirLesSymboles(), auditeurBoutons);
			break;
		}
	}

	/**
	 * Methode interne permettant d'ajouter une grille de boutons au panneau, en fonction de la base
	 * @param nombreDeLignes le nombre de lignes de boutons
	 * @param nombreDeColonnes le nombre de colonnes de boutons
	 * @param labels les labels associés aux boutons
	 * @param auditeurBoutons l'auditeur d'évènements associé aux boutons
	 */
	private void ajouterUneGrilleDeBoutons(int nombreDeLignes, int nombreDeColonnes, char[] labels, ActionListener auditeurBoutons)
	{
		this.setLayout(new GridLayout(nombreDeLignes, nombreDeColonnes));
		
		for (int numeroDeBouton = 0; numeroDeBouton<labels.length; numeroDeBouton++)
		{
			JButton bouton = new JButton(""+labels[numeroDeBouton]);
			bouton.setFocusable(false);
			bouton.addActionListener(auditeurBoutons);
			this.add(bouton);	
		}
	}
}
