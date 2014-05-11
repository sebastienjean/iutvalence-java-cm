package fr.iutvalence.java.cm9.convertisseur.interfaces;

import fr.iutvalence.java.cm9.convertisseur.logique.Base;
import fr.iutvalence.java.cm9.convertisseur.logique.RepresentationDeNombre;


/**
 * Interface permettant le contrôle du convertisseur
 * 
 * @author sebastienjean
 *
 */
public interface ControleDuConvertisseurBinDecHex
{
	/**
	 * Remise à zéro de la suite de symboles
	 */
	public void remettreAZeroLaSuiteDeSymboles();

	/**
	 * Modification de la suite de symboles
	 * @param symboles les nouveaux digits
	 */
	public void modifierLaSuiteDeSymboles(String symboles);
	
	/**
	 * Changement de base
	 * @param nouvelleBase la nouvelle base
	 */
	public void changerDeBase(Base nouvelleBase);
	
	/**
	 * Obtention de la représentation du nombre
	 * @return la représentation du nombre
	 */
	public RepresentationDeNombre obtenirLaRepresentationDuNombre();
}
