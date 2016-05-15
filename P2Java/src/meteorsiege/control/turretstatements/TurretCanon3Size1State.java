
package meteorsiege.control.turretstatements;

import meteorsiege.control.Upgrader;

public class TurretCanon3Size1State implements TurretStatementInteface
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public TurretCanon3Size1State(Upgrader upgrader)
		{
		super();
		// TODO Init turret for this state here

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
	}

