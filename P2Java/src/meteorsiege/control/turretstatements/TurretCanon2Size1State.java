
package meteorsiege.control.turretstatements;

import meteorsiege.control.Upgrader;

public class TurretCanon2Size1State implements TurretStatementInteface
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public TurretCanon2Size1State(Upgrader upgrader)
		{
		super();
		// TODO Init turret for this state here

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
	}

