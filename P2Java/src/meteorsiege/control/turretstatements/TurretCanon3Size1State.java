
package meteorsiege.control.turretstatements;

import org.newdawn.slick.Image;

import meteorsiege.control.Upgrader;
import meteorsiege.gameitems.turret.TurretCanon3Size1;
import meteorsiege.tools.ImageMagasin;

public class TurretCanon3Size1State implements TurretStatementInteface
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public TurretCanon3Size1State(Upgrader upgrader)
		{
		super();
		upgrader.setTurret(new TurretCanon3Size1(upgrader.getCenterStationX(), upgrader.getCenterStationY(), upgrader.getTurretDirection()));


		// TODO delet sysout
		System.out.println("[TurretCanon3Size1State] turret upgraded");
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
		return ImageMagasin.Turret3S;
		}
	}

