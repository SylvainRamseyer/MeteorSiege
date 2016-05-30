
package meteorsiege.control.turretstatements;

import org.newdawn.slick.Image;

import meteorsiege.control.Upgrader;
import meteorsiege.tools.ImageMagasin;

public class InitTurretState implements TurretStatementInteface
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

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

