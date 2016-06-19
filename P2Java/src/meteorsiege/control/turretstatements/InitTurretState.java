
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
 * état initial avec une tourrelle simple
 * </p>
 */
public class InitTurretState implements TurretStatementInteface
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * upgrade le nombre de canons de la tourelle<br>
	 * next State : {@link TurretCanon2Size1State}<br>
	 * @param upgrader : organisme qui gère les états
	 */
	@Override
	public void upgradeNbCanon(Upgrader upgrader)
		{
		upgrader.setTurretState(new TurretCanon2Size1State(upgrader));

		}

	/**
	 * essai d'upgrade la taille des canons de la tourelle<br>
	 * next State : {@link TurretCanon1Size2State} <br>
	 * @param upgrader : organisme qui gère les états
	 */
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

