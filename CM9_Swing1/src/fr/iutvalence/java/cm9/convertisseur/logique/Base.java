package fr.iutvalence.java.cm9.convertisseur.logique;

/**
 * Enumération des 3 bases gérées par le convertisseur BIN/DEC/HEX
 * 
 * @author sebastienjean
 * 
 */
public enum Base
{
	/**
	 * Binaire
	 */
	BIN(2, new char[] { '0', '1' }),

	/**
	 * Décimal
	 */
	DEC(10, new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' }),

	/**
	 * Hexadécimal
	 */
	HEX(16, new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' });

	/**
	 * La base, sous forme de nombre
	 */
	private final int base;

	/**
	 * Ensemble de symboles, dans l'ordre, associés à la base. L'indice dans le
	 * tableau représente la valuer du symbole
	 */
	private final char[] symboles;

	/**
	 * Constructeur privé
	 * @param base le nombre associé à la base
	 * @param symboles l'ensemble des symboles associés à la base
	 */
	private Base(int base, char[] symboles)
	{
		this.base = base;
		this.symboles = symboles;
	}

	/**
	 * Obtention du nombre associé à la base
	 * @return le nombre associé à la base
	 */
	public int obtenirLaValeur()
	{
		return this.base;
	}

	/**
	 * Obtention des symboles associés
	 * @return les symboles associés
	 */
	public char[] obtenirLesSymboles()
	{
		return this.symboles;
	}
	
	/**
	 * Obtention de la suite de symbole permettant de représenter une valeur donnée
	 * @param nombre la valeur à représenter
	 * @return la suite de symbole permettant de représenter la valeur
	 */
	public String obtenirLaSuiteDeSymbolesDuNombre(int nombre)
	{
		switch (this)
		{
		case BIN:
			return Integer.toBinaryString(nombre);
		case DEC:
			return Integer.toString(nombre);
		case HEX:
		default:
			return Integer.toHexString(nombre).toUpperCase();
		}
	}

	/**
	 * Obtention de la base associée à un nom symbolique
	 * @param nomSymbolique le nom symbolique
	 * @return la base associée au nom symbolique
	 */
	public static Base obtenirLaBaseAPartirDuNomSymbolique(String nomSymbolique)
	{
		if (nomSymbolique.toLowerCase().equals("bin"))
			return Base.BIN;
		if (nomSymbolique.toLowerCase().equals("dec"))
			return Base.DEC;
		if (nomSymbolique.toLowerCase().equals("hex"))
			return Base.HEX;
		return null;
	}

	/**
	 * Test de validité d'un symbole
	 * @param digit le symbole
	 * @return <tt>true</tt> si le symbole est associé à la base
	 */
	public boolean estUnSymboleValide(char digit)
	{
		for (char digitBase : this.symboles)
			if (digitBase == digit)
				return true;
		return false;
	}
}
