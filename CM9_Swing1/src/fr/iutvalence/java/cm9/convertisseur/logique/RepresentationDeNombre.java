package fr.iutvalence.java.cm9.convertisseur.logique;

/**
 * Classe permettant de représenter un nombre (base, suite de symboles)
 * 
 * @author sebastienjean
 *
 */
public class RepresentationDeNombre
{
	/**
	 * La base
	 */
	private final Base base;

	/**
	 * La suite de symboles représentant le nombre (sous-entendue la base)
	 */
	private final String digits;

	/**
	 * Création d'une nouvelle réprésentation de nombre
	 * @param base la base
	 * @param digits la suite de symboles représentant le nombre (sous-entendue la base)
	 */
	public RepresentationDeNombre(Base base, String digits)
	{
		this.base = base;
		this.digits = digits;
	}

	/**
	 * Obtention de la base
	 * @return la base
	 */
	public Base obtenirLaBase()
	{
		return this.base;
	}

	/**
	 * Obtention de la suite de symboles représentant le nombre (sous-entendue la base)
	 * @return la suite de symboles représentant le nombre
	 */
	public String obtenirLesDigits()
	{
		return this.digits;
	}

	/**
	 * Obtention de la valeur du nombre
	 * @return la valeur du nombre
	 */
	public int obtenirLaValeur()
	{
		return Integer.parseInt(this.digits, this.base.obtenirLaValeur());
	}
}
