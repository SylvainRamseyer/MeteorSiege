
package meteorsiege.control.turretstatements;

import meteorsiege.control.Upgrader;

public class TurretCanon1Size2State implements TurretStatementInteface
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public TurretCanon1Size2State(Upgrader upgrader)
		{
		super();
		// TODO Init turret for this state here

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
	}

