
package meteorsiege.control.turretstatements;

import org.newdawn.slick.Image;

import meteorsiege.control.Upgrader;


/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * Interface pour un couplement faible des states
 * </p>
 */
public interface TurretStatementInteface
	{
	/**
	 * Tante d'upgrade le nombre de canons de la tourelle
	 * @param upgrader -> organisme qui g�re les �tats
	 */
	public void upgradeNbCanon(Upgrader upgrader);

	/**
	 * Tante d'upgrade la taille des canons de la tourelle
	 * @param upgrader
	 */
	public void upgradeSizeCanon(Upgrader upgrader);

	/**
	 * @return l'image qui repr�sente l'�tat
	 */
	public Image getImage();
	}

