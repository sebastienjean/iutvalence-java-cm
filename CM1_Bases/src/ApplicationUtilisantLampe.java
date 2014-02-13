/**
 * Application Java manipulant des objets de la classe Lampe
 * 
 * @author sebastienjean
 * 
 */
public class ApplicationUtilisantLampe
{
	/**
	 * Le point d'entrée de l'application
	 * 
	 * @param args
	 *            les arguments de la ligne de commande (aucun ici)
	 */
	public static void main(String[] args)
	{
		// Déclaration d'une variable nommée maPremiereLampe, de type Lampe, destinée à contenir une
		// référence vers un objet de type Lampe
		Lampe maPremiereLampe;
		
		// Instanciation d'un nouvel objet de la classe Lampe (par appel au constructeur sans paramètre)
		// Affectation à la variable maPremiereLampe de la référence de l'objet créé
		maPremiereLampe = new Lampe();
				
		// Affichage sur la console de la puissance par défaut et de l'état de l'objet référencé par 
		// la variable maPremiereLampe
		System.out.println(Lampe.PUISSANCE_PAR_DEFAUT_EN_WATTS);
		System.out.println(maPremiereLampe.estAllumee());
		System.out.println(maPremiereLampe.obtenirPuissanceEnWatts());

		// Basculement de l'état allumée/éteinte de l'objet référencé par 
		// la variable maPremiereLampe
		if (maPremiereLampe.estAllumee())
			maPremiereLampe.eteindre();
		else
			maPremiereLampe.allumer();

		// Affichage sur la console de l'état de l'objet référencé par 
		// la variable maPremiereLampe
		System.out.println(maPremiereLampe.estAllumee());
		System.out.println(maPremiereLampe.obtenirPuissanceEnWatts());

		// Déclaration d'une variable nommée maPremiereLampe, de type Lampe, affectation à cette 
		// variable de la référence vers un objet de type Lampe créé par appel au constructeur
		// avec paramètre
		Lampe maSecondeLampe = new Lampe(50);
		
		// Affichage sur la console de l'état de l'objet référencé par 
		// la variable maSecondeLampe
		System.out.println(maSecondeLampe.estAllumee());
		System.out.println(maSecondeLampe.obtenirPuissanceEnWatts());
	}
}
