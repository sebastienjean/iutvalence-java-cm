package fr.iutvalence.java.cm9.convertisseur.logique;

import fr.iutvalence.java.cm9.convertisseur.interfaces.ControleDuConvertisseurBinDecHex;
import fr.iutvalence.java.cm9.convertisseur.interfaces.VueDuConvertisseurBinDecHex;


/**
 * Convertisseur binaire/décimal/hexadécimal (partie "métier"), permettant de convertir des
 * nombres entiers positifs et inférieurs ou égaux à 65535 (16 bits)
 * @author sebastienjean
 *
 */
public class ConvertisseurBinDecHex implements ControleDuConvertisseurBinDecHex
{
	/**
	 * Représentation du nombre courant
	 */
	private RepresentationDeNombre representationDuNombre;

	/**
	 * Vue à utiliser pour notifier les changements d'états
	 */
	private VueDuConvertisseurBinDecHex vue;

	/**
	 * Création d'un nouveau convertisseur
	 */
	public ConvertisseurBinDecHex()
	{
		this.representationDuNombre = new RepresentationDeNombre(Base.DEC, "0");
		this.vue = null;
	}

	/**
	 * Association d'une vue au convertisseur
	 * @param vue la vue à associer au convertisseur
	 */
	public void associerUneVue(VueDuConvertisseurBinDecHex vue)
	{
		this.vue = vue;
	}

	/**
	 * @see fr.iutvalence.java.cm9.convertisseur.interfaces.ControleDuConvertisseurBinDecHex#remettreAZeroLaSuiteDeSymboles()
	 */
	@Override
	public void remettreAZeroLaSuiteDeSymboles()
	{
		// RAZ de la suite de symboles associés au nombre (la base reste inchangée)
		this.representationDuNombre = new RepresentationDeNombre(this.representationDuNombre.obtenirLaBase(), "0");
		
		// Notification de la vue
		this.vue.notifierChangementDeRepresentationDuNombre(this.representationDuNombre);
	}

	/**
	 * @see fr.iutvalence.java.cm9.convertisseur.interfaces.ControleDuConvertisseurBinDecHex#modifierLaSuiteDeSymboles(java.lang.String)
	 */
	@Override
	public void modifierLaSuiteDeSymboles(String symboles)
	{
		// Calcul de la nouvelle représentation du nombre
		RepresentationDeNombre nouvelleRepresentationDuNombre = new RepresentationDeNombre(this.representationDuNombre.obtenirLaBase(), symboles.toUpperCase());;
		
		// Test de validité de la nouvelle représentation du nombre (limites) et, le
		// cas échéant, modificatio effective de la réprésentation courante du nombre
		if (nouvelleRepresentationDuNombre.obtenirLaValeur() < 65536)
			this.representationDuNombre = nouvelleRepresentationDuNombre;
		
		// Notification de la vue
		this.vue.notifierChangementDeRepresentationDuNombre(this.representationDuNombre);
	}

	
	/**
	 * @see fr.iutvalence.java.cm9.convertisseur.interfaces.ControleDuConvertisseurBinDecHex#changerDeBase(fr.iutvalence.java.cm9.convertisseur.logique.Base)
	 */
	@Override
	public void changerDeBase(Base nouvelleBase)
	{
		// Test du non-changement de base
		if (nouvelleBase == this.representationDuNombre.obtenirLaBase())
			return;
		
		// Calcul et mise à jour de la nouvelle suite de symboles associé au nombre
		int nombre = this.representationDuNombre.obtenirLaValeur();
		String nouveauxDigits = nouvelleBase.obtenirLaSuiteDeSymbolesDuNombre(nombre);
		this.representationDuNombre = new RepresentationDeNombre(nouvelleBase, nouveauxDigits);
		
		// Notification de la vue
		this.vue.notifierChangementDeRepresentationDuNombre(this.representationDuNombre);
	}

	/**
	 * @see fr.iutvalence.java.cm9.convertisseur.interfaces.ControleDuConvertisseurBinDecHex#obtenirLaRepresentationDuNombre()
	 */
	@Override
	public RepresentationDeNombre obtenirLaRepresentationDuNombre()
	{
		return this.representationDuNombre;
	}
}
