
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
		fireRateLevel = 1;
		projectilSpeedLevel = 1;
		powerLevel = 1;
		shieldRegenLevel = 1;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public boolean upgradeShield()
		{
		if (station.getMoney() < shieldLevel * Config.UPGRADE_SHIELD_INIT_PRICE)
			{
			// TODO delet sysout
			System.out.println("[Upgrader] not enought money");
			return false;
			}
		else
			{
			station.spendMoney(shieldLevel * Config.UPGRADE_SHIELD_INIT_PRICE);
			station.setShieldCapacity(station.getShieldCapacity() + station.getShieldCapacity() * Config.UPGRADE_SHIELD_AMOUNT / 100);
			shieldLevel++;

			// TODO delet sysout
			System.out.println("[Upgrader] shield upgraded to lvl " + shieldLevel + " (" + station.getShieldCapacity() + ")");
			return true;
			}
		}

	public boolean upgradeShieldRegen()
		{
		if (station.getMoney() < shieldRegenLevel * Config.UPGRADE_SHIELD_REGEN_INIT_PRICE)
			{
			// TODO delet sysout
			System.out.println("[Upgrader] not enought money");
			return false;
			}
		else
			{
			station.spendMoney(shieldRegenLevel * Config.UPGRADE_SHIELD_REGEN_INIT_PRICE);
			station.setShieldRegen(station.getShieldRegen() + station.getShieldRegen()* Config.UPGRADE_SHIELD_REGEN_AMOUNT / 100);
			shieldRegenLevel++;

			// TODO delet sysout
			System.out.println("[Upgrader] Shield regen upgraded to lvl " + shieldRegenLevel + " (" + station.getShieldRegen() + ")");
			return true;
			}
		}

	public boolean upgradeDamage()
		{
		if (station.getMoney() < powerLevel * Config.UPGRADE_POWER_INIT_PRICE)
			{
			// TODO delet sysout
			System.out.println("[Upgrader] not enought money");
			return false;
			}
		else
			{
			station.spendMoney(powerLevel * Config.UPGRADE_POWER_INIT_PRICE);
			station.setDamageMultiplier(station.getDamageMultiplier() + station.getDamageMultiplier() * Config.UPGRADE_POWER_AMOUNT / 100);
			powerLevel++;

			// TODO delet sysout
			System.out.println("[Upgrader] Power upgraded to lvl " + powerLevel + " (" + station.getDamageMultiplier() + ")");
			return true;
			}
		}

	public boolean upgradeFireRate()
		{
		if (station.getMoney() < fireRateLevel * Config.UPGRADE_FIRERATE_INIT_PRICE)
			{
			// TODO delet sysout
			System.out.println("[Upgrader] not enought money");
			return false;
			}
		else
			{
			station.spendMoney(fireRateLevel * Config.UPGRADE_FIRERATE_INIT_PRICE);
			station.setShootDelay(station.getShootDelay() - station.getShootDelay() * Config.UPGRADE_FIRERATE_AMOUNT / 100);
			fireRateLevel++;

			// TODO delet sysout
			System.out.println("[Upgrader] Firerate upgraded to lvl " + fireRateLevel  + " (" + station.getShootDelay() + ")");
			return true;
			}
		}

	public boolean upgradeProjectilsSpeed()
		{
		if (station.getMoney() < projectilSpeedLevel * Config.UPGRADE_PROJECTILS_SPEED_INIT_PRICE)
			{
			// TODO delet sysout
			System.out.println("[Upgrader] not enought money");
			return false;
			}
		else
			{
			station.spendMoney(projectilSpeedLevel * Config.UPGRADE_PROJECTILS_SPEED_INIT_PRICE);
			station.setProjectilSpeed(station.getProjectilsSpeed() + station.getProjectilsSpeed()* Config.UPGRADE_PROJECTILS_SPEED_AMOUNT / 100);
			projectilSpeedLevel++;

			// TODO delet sysout
			System.out.println("[Upgrader] Projetils speed upgraded to lvl " + projectilSpeedLevel  + " (" + station.getProjectilsSpeed() + ")");
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
	private int fireRateLevel;
	private int projectilSpeedLevel;
	private int powerLevel;
	private int shieldRegenLevel;

	}
