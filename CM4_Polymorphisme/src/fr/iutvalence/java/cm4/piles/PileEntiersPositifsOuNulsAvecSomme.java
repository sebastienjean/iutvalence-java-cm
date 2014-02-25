package fr.iutvalence.java.cm4.piles;


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
	 * @throws CapaciteInvalideException si la capacite est < 0
	 */
	public PileEntiersPositifsOuNulsAvecSomme(int capaciteInitiale) throws CapaciteInvalideException
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
	public void empiler(int elementAEmpiler) throws EntierNegatifException, PilePleineException
	{
		super.empiler(elementAEmpiler);
		this.somme = this.somme + elementAEmpiler;
	}

	/**
	 * @see PileEntiersPositifsOuNuls#depiler()
	 */
	@Override
	public int depiler() throws PileVideException
	{
		int resultat = super.depiler();
		this.somme = this.somme - resultat;
		return resultat;
	}
}
