
package meteorsiege.control;

import meteorsiege.Config;
import meteorsiege.gameitems.Station;

public class Upgrader
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Upgrader(Station station)
		{
		super();
		this.station = station;
		shieldLevel = 1;
		rateFireLevel = 1;
		projectilSpeedLevel = 1;
		powerLevel = 1;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public boolean upgradeShield()
		{
		if(station.getMoney()< shieldLevel*Config.UPGRADE_SHIELD_INIT_PRICE)
			{
			// TODO delet sysout
			System.out.println("[Upgrader] not enought money");
			return false;
			}
		else
			{


			station.spendMoney(shieldLevel* Config.UPGRADE_SHIELD_INIT_PRICE);
			station.addShield(Config.UPGRADE_SHIELD_AMOUNT);
			shieldLevel++;

			// TODO delet sysout
			System.out.println("[Upgrader] shield upgraded to lvl "+ shieldLevel);
			return true;
			}
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private Station station;
	private int shieldLevel;
	private int rateFireLevel;
	private int projectilSpeedLevel;
	private int powerLevel;


	}

