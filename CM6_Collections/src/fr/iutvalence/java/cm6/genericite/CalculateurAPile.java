package fr.iutvalence.java.cm6.genericite;

/**
 * Embryon incomplet de calculateur à pile, où les opérandes sont dépilés et les résultats
 * empilés en cours de calcul
 * @author sebastienjean
 *
 */
public class CalculateurAPile
{
	/**
	 * La pile (d'entiers) utilisée pour les calculs
	 */
	private Pile pile;

	/**
	 * Création d'un nouveau calculateur à pile, utilisant une pile spécifique pour les calculs
	 * @param pilePourCalculs la pile utilisée pour les calculs
	 */
	public CalculateurAPile(Pile pilePourCalculs)
	{
		this.pile = pilePourCalculs;
	}

	/**
	 * Calcul d'une addition de 2 nombres entiers. LEs 2 entiers sont pris sur la pile. 
	 * Le résultat est remis sur la pile et retourné
	 * @return le résultat du calcul.
	 * @throws PileVideException si les opérandes n'ont pas pu être dépilés (pile vide)
	 * @throws PilePleineException si le résultat n'a pu être empilé (pile pleine)
	 */
	public int addition() throws PileVideException, PilePleineException
	{
		int resultat = (Integer) this.pile.depiler() + (Integer) this.pile.depiler();
	
		this.pile.empiler(resultat);

		return resultat;
	}
}
