package fr.iutvalence.java.cm9.convertisseur.ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import fr.iutvalence.java.cm9.convertisseur.interfaces.ControleDuConvertisseurBinDecHex;
import fr.iutvalence.java.cm9.convertisseur.interfaces.VueDuConvertisseurBinDecHex;
import fr.iutvalence.java.cm9.convertisseur.logique.Base;
import fr.iutvalence.java.cm9.convertisseur.logique.RepresentationDeNombre;

/**
 * Tâche gérant l'IHM du convertisseur. Le convertisseur est par la tâche comme
 * un controleur, la tâche est considérée par le convertisseur comme une vue. La
 * tâche capture et traite les évenèments liés aux boutons de saisie, de RAZ et
 * de sélection de base
 * 
 * @author sebastienjean
 * 
 */
public class TacheDAffichageDuConvertisseurBinDecHex implements Runnable, VueDuConvertisseurBinDecHex, ActionListener, KeyListener
{

	/**
	 * Le controleur du convertisseur
	 */
	private final ControleDuConvertisseurBinDecHex controleur;

	/**
	 * La suite de symboles courante
	 */
	private String symboles;

	/**
	 * Booléen indiquant si la saisie de la suite de symboles a (re)commencée
	 * (après un changement de base)
	 */
	private boolean saisieDesSymbolesCommencee;

	/**
	 * La fenêtre
	 */
	private JFrame fenetre;

	/**
	 * Le label où sont affichés les symboles
	 */
	private JLabel labelDeLaSuiteDeSymboles;

	/**
	 * Le panneau de saisie des symboles
	 */
	private PanneauDeSaisieDesDigitsDuConvertisseurBinDecHex panneauDeSaisieDesSymboles;

	/**
	 * Le panneau de sélection de la base
	 */
	private PanneauDeSelectionDeLaBaseDuConvertisseurBinDecHex panneauDeSelectionDeLaBase;

	/**
	 * Le bouton de remise à zéro
	 */
	private JButton boutonRemiseAZero;

	/**
	 * Le splitPane contenant le panneau de saisie
	 */
	private JSplitPane splitPaneInferieur;

	/**
	 * Création de la tâche de gestion de l'IHM du convertisseur
	 * 
	 * @param controleur
	 *            le controleur du convertisseur
	 */
	public TacheDAffichageDuConvertisseurBinDecHex(ControleDuConvertisseurBinDecHex controleur)
	{
		this.controleur = controleur;
		this.saisieDesSymbolesCommencee = false;
		this.symboles = "";
	}

	/**
	 * Methode interne permettant d'initialiser l'IHM
	 */
	private void initialiserLInterfaceGraphique()
	{
		this.fenetre = new JFrame();

		this.fenetre.setTitle("Convertisseur Bin/Dec/Hex");
		this.fenetre.setSize(250, 250);
		this.fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// Verouillage des dimensions de la fenêtre
		this.fenetre.setResizable(false);

		this.fenetre.setJMenuBar(new BarreDeMenuDuConvertisseurBinDecHex(this.fenetre));

		// Création du composant graphique associé au label
		// (pas de texte pour le moment)
		this.labelDeLaSuiteDeSymboles = new JLabel();

		// Modification de l'opacité du label (par défaut les labels sont
		// transparents)
		// (nécessaire pour pouvoir associer une couleur de fond qu label)
		this.labelDeLaSuiteDeSymboles.setOpaque(true);
		// Association d'une couleur de fond qu label
		this.labelDeLaSuiteDeSymboles.setBackground(new Color(100, 200, 100));
		// Alignement à droite du texte du label
		this.labelDeLaSuiteDeSymboles.setHorizontalAlignment(SwingConstants.RIGHT);

		// Création du composant graphique associé au bouton de RAZ
		this.boutonRemiseAZero = new JButton("Remise à zero");
		this.boutonRemiseAZero.setFocusable(false);
		this.boutonRemiseAZero.addActionListener(this);

		// Création du panneau de sélection de bae
		this.panneauDeSelectionDeLaBase = new PanneauDeSelectionDeLaBaseDuConvertisseurBinDecHex(this);

		// Création du panneau de saisie
		this.panneauDeSaisieDesSymboles = new PanneauDeSaisieDesDigitsDuConvertisseurBinDecHex(Base.DEC, this);

		// Création du couple de conteneurs verticaux situé dans la partie
		// inférieure de la fenêtre
		this.splitPaneInferieur = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

		// Ajout du panneau de saisie (partie haute)
		this.splitPaneInferieur.add(this.panneauDeSaisieDesSymboles);

		// Ajout du panneau du bouton de RAZ (partie basse)
		this.splitPaneInferieur.add(this.boutonRemiseAZero);

		// Désactivation de la séparation (elle restera figée)
		this.splitPaneInferieur.setEnabled(false);

		// Désactivation de la bordure
		this.splitPaneInferieur.setBorder(null);

		// Réduction de la taille du séparateur (il devient invisible)
		this.splitPaneInferieur.setDividerSize(0);

		// Maximisation relative de la partie haute
		// (la partie basse prend la place minimale)
		this.splitPaneInferieur.setResizeWeight(1.0);

		// (idem pour le couple de conteneurs verticaux situé dans la partie
		// médiane de la fenêtre)
		JSplitPane splitPaneIntermediaire = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPaneIntermediaire.add(this.panneauDeSelectionDeLaBase);
		splitPaneIntermediaire.add(this.splitPaneInferieur);
		splitPaneIntermediaire.setEnabled(false);
		splitPaneIntermediaire.setBorder(null);
		splitPaneIntermediaire.setDividerSize(0);

		// (idem pour le couple de conteneurs verticaux situé dans la partie
		// supérieure de la fenêtre)
		JSplitPane splitPaneSuperieur = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPaneSuperieur.add(this.labelDeLaSuiteDeSymboles);
		splitPaneSuperieur.add(splitPaneIntermediaire);
		splitPaneSuperieur.setEnabled(false);
		splitPaneSuperieur.setDividerSize(0);
		splitPaneSuperieur.setResizeWeight(0);

		// Ajout du couple de panneau supérieur au panneau principal de la
		// fenêtre
		this.fenetre.getContentPane().add(splitPaneSuperieur);

		this.controleur.remettreAZeroLaSuiteDeSymboles();
		this.saisieDesSymbolesCommencee = false;

		// Association de la tâche comme auditeur d'appuis touches
		this.fenetre.addKeyListener(this);

		this.fenetre.setVisible(true);
	}

	@Override
	public void run()
	{
		this.initialiserLInterfaceGraphique();
	}

	/**
	 * @see fr.iutvalence.java.cm9.convertisseur.interfaces.VueDuConvertisseurBinDecHex#notifierChangementDeRepresentationDuNombre(fr.iutvalence.java.cm9.convertisseur.logique.RepresentationDeNombre)
	 */
	@Override
	public void notifierChangementDeRepresentationDuNombre(RepresentationDeNombre representationDuNombre)
	{
		this.symboles = representationDuNombre.obtenirLesDigits();
		this.labelDeLaSuiteDeSymboles.setText(this.symboles);
		this.panneauDeSelectionDeLaBase.forcerLaSelectionDeLaBase(representationDuNombre.obtenirLaBase());
	}

	/**
	 * Methode interne permettant de traiter l'évenement lié à la RAZ
	 */
	public void traiterRemiseAZero()
	{
		this.controleur.remettreAZeroLaSuiteDeSymboles();
		this.saisieDesSymbolesCommencee = false;
	}

	/**
	 * Methode interne permettant de traiter l'évenement lié à la saisie d'un
	 * digit
	 * 
	 * @param digit
	 *            le digit saisi
	 */
	public void traiterSaisieDigit(char digit)
	{
		if (!this.controleur.obtenirLaRepresentationDuNombre().obtenirLaBase().estUnSymboleValide(digit))
			return;

		if (!this.saisieDesSymbolesCommencee)
			this.symboles = "0";
		if (this.symboles.equals("0"))
			this.symboles = "";
		this.symboles = this.symboles + digit;

		this.controleur.modifierLaSuiteDeSymboles(this.symboles);
		this.saisieDesSymbolesCommencee = true;
	}

	/**
	 * Methode interne permettant de traiter l'évenement lié à la sélection
	 * d'une base
	 * 
	 * @param base
	 *            la base
	 */
	public void traiterChangementDeLaBase(Base base)
	{
		this.controleur.changerDeBase(base);

		// Remplacement du panneau de saisie avec celui adapté à la base
		this.panneauDeSaisieDesSymboles = new PanneauDeSaisieDesDigitsDuConvertisseurBinDecHex(base, this);
		this.splitPaneInferieur.setTopComponent(this.panneauDeSaisieDesSymboles);

		this.saisieDesSymbolesCommencee = false;
	}

	/**
	 * Traitement des évènements associés aux boutons
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		// Identification de la source
		JComponent source = (JComponent) event.getSource();

		if (source == this.boutonRemiseAZero)
		{
			traiterRemiseAZero();
			return;
		}

		// Cas où le bouton appartient au panneau de saisie
		if (source.getParent() == this.panneauDeSaisieDesSymboles)
		{
			traiterSaisieDigit(((JButton) event.getSource()).getText().charAt(0));
			return;
		}

		// Cas où le bouton appartient au panneau de sélection
		if (source.getParent() == this.panneauDeSelectionDeLaBase)
		{
			traiterChangementDeLaBase(Base.obtenirLaBaseAPartirDuNomSymbolique(((JRadioButton) source).getText()));
			return;
		}
	}

	/**
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e)
	{
		// Evènement ignoré
	}

	/**
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e)
	{
		// Evènement ignoré
	}

	/**
	 * Traitement de l'évènement associé à l'appui d'une touche
	 * 
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e)
	{
		// Remarque : le caractère associé à la touche est identifié via
		// l'évènement
		traiterSaisieDigit(e.getKeyChar());
	}
}
