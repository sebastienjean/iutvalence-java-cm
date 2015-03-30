package fr.iutvalence.java.cm5.parametres;

/**
 * Application de test du calculateur à pile
 * @author sebastienjean
 *
 */
public class TestCalculateur
{
	/**
	 * Point d'entrée de l'application
	 * 
	 * @param args
	 *            les arguments de la ligne de commande (inutilisés ici)
	 */
	public static void main(String[] args)
	{
		try
		{
			Pile<Integer> pile = new PileListeChainee<Integer>();
			pile.empiler(4);
			pile.empiler(3);
			pile.empiler(2);
			pile.empiler(1);
			CalculateurAPile calculateur =  new CalculateurAPile(pile);
			System.out.println(calculateur.addition());
			System.out.println(calculateur.addition());
			System.out.println(calculateur.addition());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}

}
