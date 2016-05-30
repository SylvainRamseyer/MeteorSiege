
package meteorsiege.control.turretstatements;

import org.newdawn.slick.Image;

import meteorsiege.control.Upgrader;
import meteorsiege.gameitems.TurretCanon1Size2;
import meteorsiege.tools.ImageMagasin;

public class TurretCanon1Size2State implements TurretStatementInteface
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public TurretCanon1Size2State(Upgrader upgrader)
		{
		super();
		upgrader.setTurret(new TurretCanon1Size2(upgrader.getCenterStationX(), upgrader.getCenterStationY(), upgrader.getTurretDirection()));

		// TODO delet sysout
		System.out.println("[TurretCanon1Size2State] turret upgraded");
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void upgradeNbCanon(Upgrader upgrader)
		{
		upgrader.setTurretState(new TurretCanon2Size2State(upgrader));
		}

	@Override
	public void upgradeSizeCanon(Upgrader upgrader)
		{
		upgrader.setTurretState(new TurretCanon1Size3State(upgrader));
		}

	@Override
	public Image getImage()
		{
		return ImageMagasin.Turret2P;
		}
	}

