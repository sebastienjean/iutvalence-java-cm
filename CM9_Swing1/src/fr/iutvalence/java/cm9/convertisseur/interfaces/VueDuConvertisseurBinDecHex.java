package fr.iutvalence.java.cm9.convertisseur.interfaces;

import fr.iutvalence.java.cm9.convertisseur.logique.RepresentationDeNombre;


/**
 * Interface permettant la notification des changements d'état du convertisseur
 * 
 * @author sebastienjean
 *
 */
public interface VueDuConvertisseurBinDecHex
{
	/**
	 * Notification du changement de la représentation du nombre
	 * @param representationDuNombre la nouvelle représentation du nombre
	 */
	public void notifierChangementDeRepresentationDuNombre(RepresentationDeNombre representationDuNombre);
}
