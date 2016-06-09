
package meteorsiege.control.turretstatements;

import org.newdawn.slick.Image;

import meteorsiege.control.Upgrader;
import meteorsiege.gameitems.turret.TurretCanon2Size2;
import meteorsiege.tools.ImageMagasin;

public class TurretCanon2Size2State implements TurretStatementInteface
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public TurretCanon2Size2State(Upgrader upgrader)
		{
		super();
		upgrader.setTurret(new TurretCanon2Size2(upgrader.getCenterStationX(), upgrader.getCenterStationY(), upgrader.getTurretDirection()));


		// TODO delet sysout
		System.out.println("[TurretCanon2Size2State] turret upgraded");
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
		return ImageMagasin.Turret3SP;
		}
	}

