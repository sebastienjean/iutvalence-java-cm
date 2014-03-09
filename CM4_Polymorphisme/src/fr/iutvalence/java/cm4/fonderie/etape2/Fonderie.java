package fr.iutvalence.java.cm4.fonderie.etape2;

/**
 * Représente une fonderie, dans laquelle sont fondus des pavés.
 * 
 * @author sebastienjean
 */
public class Fonderie
{
	/**
	 * Le volume total de pavés fondus depuis la mise en service de la fonderie, en cm3
	 */
	private double volumeCumuleDesPavesFondusEnCm3;
	
	/**
	 * Construire une fonderie, immédiatement mise en service
	 */
	public Fonderie()
	{
		this.volumeCumuleDesPavesFondusEnCm3 = 0;
	}
	
	/**
	 * Fondre une série de pavés
	 * @param paves les pavés à fondre
	 * @return le volume total de pavés fondus, en cm3
	 */
	public double fondre(Pave[] paves)
	{
		double volumeDesPavesFondusEnCm3 = 0;
		
		for (int indicePiece = 0; indicePiece < paves.length; indicePiece++)			
			volumeDesPavesFondusEnCm3 += paves[indicePiece].obtenirVolumeEnCm3();
		
		this.volumeCumuleDesPavesFondusEnCm3 += volumeDesPavesFondusEnCm3;
		
		return volumeDesPavesFondusEnCm3;
	}
	
	/**
	 * Obtenir le volume total de pavés fondus depuis la mise en service de la fonderie, en cm3
	 * @return le volume total de pavés fondus depuis la mise en service de la fonderie, en cm3
	 */
	public double obtenirVolumeCumuleDesPavesFondusEnCm3()
	{
		return this.volumeCumuleDesPavesFondusEnCm3;
	}
}
