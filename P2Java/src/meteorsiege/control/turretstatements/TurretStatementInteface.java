
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
 * Interface pour un couplement faible des states de la tourelle
 * </p>
 */
public interface TurretStatementInteface
	{
	/**
	 * Tante d'upgrade le nombre de canons de la tourelle<br>
	 * passe à un autre état si existant<br>
	 * @param upgrader : organisme qui gère les états
	 */
	public void upgradeNbCanon(Upgrader upgrader);

	/**
	 * Tante d'upgrade la taille des canons de la tourelle<br>
	 * passe à un autre état si existant<br>
	 * @param upgrader : organisme qui gère les états
	 */
	public void upgradeSizeCanon(Upgrader upgrader);

	/**
	 * @return l'image qui représente l'état
	 */
	public Image getImage();
	}

