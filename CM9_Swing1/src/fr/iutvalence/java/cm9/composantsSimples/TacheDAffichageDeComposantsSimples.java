package fr.iutvalence.java.cm9.composantsSimples;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SwingConstants;

/**
 * Tâche gérant l'IHM (création, affichage)
 * 
 * @author sebastienjean
 * 
 */
public class TacheDAffichageDeComposantsSimples implements Runnable
{
	@Override
	public void run()
	{
		JFrame fenetreJLabel = new JFrame("Un label avec texte et image");
		fenetreJLabel.setSize(300, 100);
		JLabel jLabel = new JLabel("ceci est un label", new ImageIcon("icon.png"), SwingConstants.CENTER);
		jLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		jLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		fenetreJLabel.getContentPane().add(jLabel);
		fenetreJLabel.setVisible(true);

		JFrame fenetreJButton = new JFrame("Un bouton avec texte et image");
		fenetreJButton.setSize(300, 100);
		JButton jButton = new JButton("ceci est un bouton");
		jButton.setIcon(new ImageIcon("icon.png"));
		jButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		jButton.setHorizontalTextPosition(SwingConstants.CENTER);
		fenetreJButton.getContentPane().add(jButton);
		fenetreJButton.setVisible(true);

		JFrame fenetreJRadioButton = new JFrame("Un bouton radio texte");
		fenetreJRadioButton.setSize(300, 100);
		JRadioButton jRadioButton = new JRadioButton("ceci est un bouton radio");
		fenetreJRadioButton.getContentPane().add(jRadioButton);
		fenetreJRadioButton.setVisible(true);

		JFrame fenetreJCheckBox = new JFrame("Une case à cocher avec texte");
		fenetreJCheckBox.setSize(300, 100);
		JCheckBox jCheckBox = new JCheckBox("ceci est une case à cocher");
		fenetreJCheckBox.getContentPane().add(jCheckBox);
		fenetreJCheckBox.setVisible(true);

		JFrame fenetreJComboBox = new JFrame("Une liste de choix");
		fenetreJComboBox.setSize(300, 100);
		JComboBox jComboBox = new JComboBox(new String[] { "facile", "moyen", "difficile" });
		fenetreJComboBox.getContentPane().add(jComboBox);
		fenetreJComboBox.setVisible(true);

		JFrame fenetreJSlider = new JFrame("Un curseur coulissant");
		fenetreJSlider.setSize(300, 100);
		JSlider jSlider = new JSlider(0, 100, 50);
		jSlider.setPaintLabels(true);
		jSlider.setMajorTickSpacing(10);
		jSlider.setMinorTickSpacing(5);
		jSlider.setPaintTicks(true);
		fenetreJSlider.getContentPane().add(jSlider);
		fenetreJSlider.setVisible(true);

		JFrame fenetreJSpinner = new JFrame("Une liste de choix prec/suiv, éditable");
		fenetreJSpinner.setSize(350, 50);
		SpinnerModel spinnerModel = new SpinnerListModel(new String[] { "facile", "moyen", "difficile" });
		JSpinner jSpinner = new JSpinner(spinnerModel);
		fenetreJSpinner.getContentPane().add(jSpinner);
		fenetreJSpinner.setVisible(true);

		JFrame fenetreJTextField = new JFrame("Une ligne de texte éditable");
		fenetreJTextField.setSize(350, 50);
		JTextField jTextField = new JTextField("...");
		fenetreJTextField.getContentPane().add(jTextField);
		fenetreJTextField.setVisible(true);

		JFrame fenetreJTextArea = new JFrame("Une zone de texte éditable");
		fenetreJTextArea.setSize(800,100);
		JTextArea jTextArea = new JTextArea(
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n"
						+ "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. \n"
						+ "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \n"
						+ "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		fenetreJTextArea.getContentPane().add(jTextArea);
		fenetreJTextArea.setVisible(true);
		
		JFrame fenetreJProgressBar = new JFrame("Une barre de progression");
		fenetreJProgressBar.setSize(250,100);
		JProgressBar jProgressBar = new JProgressBar(0,100);
		jProgressBar.setValue(50);
		jProgressBar.setStringPainted(true);
		fenetreJProgressBar.getContentPane().add(jProgressBar);
		fenetreJProgressBar.setVisible(true);
		
	}
}
