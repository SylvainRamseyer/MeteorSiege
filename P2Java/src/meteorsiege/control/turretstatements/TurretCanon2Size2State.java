
package meteorsiege.control.turretstatements;

import meteorsiege.control.Upgrader;

public class TurretCanon2Size2State implements TurretStatementInteface
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public TurretCanon2Size2State(Upgrader upgrader)
		{
		super();
		// TODO Init turret for this state here

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
	}

