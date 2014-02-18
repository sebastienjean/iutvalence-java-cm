
/**
 * Classe réalisée par extension de <tt>PileEntiersPositifsOuNuls</tt> qui ajoute le calcul incrémental
 * de la somme des éléments.
 * @author sebastienjean
 *
 */
public class PileEntiersPositifsOuNulsAvecSomme extends PileEntiersPositifsOuNuls
{
	
	/**
	 * Somme des éléments de la pile
	 */
	private int somme;

	/**
	 * Retourne une nouvelle pile, de capacité par défaut, initialement vide, dont la somme des 
	 * éléments est nulle
	 */
	public PileEntiersPositifsOuNulsAvecSomme()
	{
		super();
		this.somme = 0;
	}

	/**
	 * Retourne une nouvelle pile, de capacité donnée, initialement vide, dont la somme des 
	 * éléments est nulle
	 * @param capaciteInitiale la capacité de la pile
	 */
	public PileEntiersPositifsOuNulsAvecSomme(int capaciteInitiale)
	{
		super(capaciteInitiale);
		this.somme = 0;
	}

	/**
	 * Obtenir la somme des éléments de la pile
	 * @return la somme des éléments de la pile
	 */
	public int obtenirSomme()
	{
		return this.somme;
	}

	/**
	 * @see PileEntiersPositifsOuNuls#empiler(int)
	 */
	@Override
	public int empiler(int elementAEmpiler)
	{
		int resultat = super.empiler(elementAEmpiler);
		if (resultat == SUCCES)
			this.somme = this.somme + elementAEmpiler;
		return resultat;
	}

	/**
	 * @see PileEntiersPositifsOuNuls#depiler()
	 */
	@Override
	public int depiler()
	{
		int resultat = super.depiler();
		if (!(resultat == PILE_VIDE)) 
			this.somme = this.somme - resultat;
		return resultat;
	}
}
