package fr.iutvalence.java.cm9.convertisseur.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Barre de menu associée à l'IHM du convertisseur
 * 
 * @author sebastienjean
 * 
 */
@SuppressWarnings("serial")
public class BarreDeMenuDuConvertisseurBinDecHex extends JMenuBar implements ActionListener
{
	/**
	 * La fenêtre à laquelle le menu est associé
	 */
	private JFrame fenetre;

	/**
	 * L'item de rubrique "à propos"
	 */
	private JMenuItem MenuItemAPropos;

	/**
	 * L'item de rubrique "fermer"
	 */
	private JMenuItem MenuItemFermer;

	/**
	 * Création de la barre de menu
	 * 
	 * @param fenetre
	 *            la fenêtre à laquelle le menu est associé
	 */
	public BarreDeMenuDuConvertisseurBinDecHex(JFrame fenetre)
	{
		this.fenetre = fenetre;
		JMenu menu = new JMenu("Menu");
		this.MenuItemAPropos = new JMenuItem("A propos");
		this.MenuItemFermer = new JMenuItem("Fermer");
		menu.add(this.MenuItemAPropos);
		menu.add(this.MenuItemFermer);
		this.MenuItemAPropos.addActionListener(this);
		this.MenuItemFermer.addActionListener(this);
		this.add(menu);
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		JMenuItem itemSelectionne = (JMenuItem) event.getSource();

		if (itemSelectionne == this.MenuItemAPropos)
		{
			JOptionPane.showMessageDialog(this.fenetre, "Une application de conversion Bin/Dec/Hex", "A propos", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		if (itemSelectionne == this.MenuItemFermer)
		{
			if (JOptionPane.showConfirmDialog(this.fenetre, "Fermer l'application ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
				this.fenetre.dispose();
			return;
		}
	}
}
