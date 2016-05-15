
package meteorsiege.control.turretstatements;

import meteorsiege.control.Upgrader;

public class TurretCanon1Size3State implements TurretStatementInteface
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public TurretCanon1Size3State(Upgrader upgrader)
		{
		super();
		// TODO Init turret for this state here

		// TODO delet sysout
		System.out.println("[TurretCanon1Size3State] turret upgraded");
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
