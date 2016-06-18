
package meteorsiege.control.turretstatements;

import org.newdawn.slick.Image;

import meteorsiege.control.Upgrader;
import meteorsiege.tools.ImageMagasin;


/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * état Initial avec une tourrel simple
 * </p>
 */
public class InitTurretState implements TurretStatementInteface
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * Tante d'upgrade le nombre de canons de la tourelle<br>
	 * @param upgrader -> organisme qui gère les états
	 */
	@Override
	public void upgradeNbCanon(Upgrader upgrader)
		{
		upgrader.setTurretState(new TurretCanon2Size1State(upgrader));

		}

	@Override
	public void upgradeSizeCanon(Upgrader upgrader)
		{
		upgrader.setTurretState(new TurretCanon1Size2State(upgrader));

		}

	@Override
	public Image getImage()
		{
		return ImageMagasin.Turret1;
		}
	}

