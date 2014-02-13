
/**
 * Classe permettant de représenter et manipuler une lampe. Une lampe est caractérisée 
 * par sa puissance en Watts et le fait qu'elle puisse être allumée ou non.
 * @author sebastienjean
 *
 */
public class Lampe
{
	/**
	 * La puissance par défaut d'une lampe, en Watts
	 */
	public static final int PUISSANCE_PAR_DEFAUT_EN_WATTS = 100;

	/**
	 * La puissance de la lampe, en Watts
	 */
	private final int puissanceEnWatts;
	
	/**
	 * La caractère allumée ou non de la lampe
	 */
	private boolean estAllumee;
	
	/**
	 * Retourne une nouvelle lampe, de puissance par défaut, initialement éteinte
	 */
	public Lampe()
	{
		this.puissanceEnWatts = Lampe.PUISSANCE_PAR_DEFAUT_EN_WATTS;
		this.estAllumee = false;
	}
	
	/**
	 * Retourne une nouvelle lampe, de puissance donnée, initialement éteinte
	 * @param puissanceInitialeEnWatts la puissance de la lampe, en Watts
	 */
	
	public Lampe(int puissanceInitialeEnWatts)
	{
		this.puissanceEnWatts = puissanceInitialeEnWatts;
		this.estAllumee = false;
	}

	/**
	 * Allumer la lampe
	 */
	public void allumer()
	{
		this.estAllumee = true;
	}
	
	/**
	 * Eteindre la lampe
	 */
	public void eteindre()
	{
		this.estAllumee = false;
	}

	/**
	 * Obtenir la puissance de la lampe, en Watts
	 * @return la puissance de la lampe, en Watts
	 */
	public int obtenirPuissanceEnWatts()
	{
		return this.puissanceEnWatts;
	}

	/**
	 * Savoir si la lampe est allumée
	 * @return <tt>true</tt> si la lampe est allumée, <tt>false</tt> sinon
	 */
	public boolean estAllumee()
	{
		return this.estAllumee;
	}	
}
