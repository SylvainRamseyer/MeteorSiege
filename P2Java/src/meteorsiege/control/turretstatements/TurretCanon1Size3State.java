
package meteorsiege.control.turretstatements;

import org.newdawn.slick.Image;

import meteorsiege.control.Upgrader;
import meteorsiege.gameitems.turret.TurretCanon1Size3;
import meteorsiege.tools.ImageMagasin;


/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * état avec 1 tourrelle et de taille 3
 * </p>
 */
public class TurretCanon1Size3State implements TurretStatementInteface
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public TurretCanon1Size3State(Upgrader upgrader)
		{
		super();
		upgrader.setTurret(new TurretCanon1Size3(upgrader.getCenterStationX(), upgrader.getCenterStationY(), upgrader.getTurretDirection()));

		// TODO delet sysout
		System.out.println("[TurretCanon1Size3State] turret upgraded");
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void upgradeNbCanon(Upgrader upgrader)
		{
		// no next state

		}

	@Override
	public void upgradeSizeCanon(Upgrader upgrader)
		{
		// no next state

		}

	@Override
	public Image getImage()
		{
		return ImageMagasin.Turret3P;
		}
	}
