
package meteorsiege.control.turretstatements;

import meteorsiege.control.Upgrader;

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
	}

