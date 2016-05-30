
package meteorsiege.control.turretstatements;

import org.newdawn.slick.Image;

import meteorsiege.control.Upgrader;
import meteorsiege.gameitems.TurretCanon2Size1;
import meteorsiege.tools.ImageMagasin;

public class TurretCanon2Size1State implements TurretStatementInteface
	{


	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public TurretCanon2Size1State(Upgrader upgrader)
		{
		super();
		upgrader.setTurret(new TurretCanon2Size1(upgrader.getCenterStationX(), upgrader.getCenterStationY(), upgrader.getTurretDirection()));

		// TODO delet sysout
		System.out.println("[TurretCanon2Size1State] turret upgraded");
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void upgradeNbCanon(Upgrader upgrader)
		{
		upgrader.setTurretState(new TurretCanon3Size1State(upgrader));
		}

	@Override
	public void upgradeSizeCanon(Upgrader upgrader)
		{
		upgrader.setTurretState(new TurretCanon2Size2State(upgrader));
		}

	@Override
	public Image getImage()
		{
		return ImageMagasin.Turret2S;
		}
	}
