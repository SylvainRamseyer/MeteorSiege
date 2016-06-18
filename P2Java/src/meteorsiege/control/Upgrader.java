
package meteorsiege.control;

import org.newdawn.slick.Image;

import meteorsiege.control.turretstatements.InitTurretState;
import meteorsiege.control.turretstatements.TurretStatementInteface;
import meteorsiege.gameitems.station.Station;
import meteorsiege.gameitems.turret.Turret;
import meteorsiege.gameitems.turret.TurretInterface;
import meteorsiege.tools.Config;

/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * Classe qui peuple l'aire de jeux avec des ennemis
 * </p>
 *
 * <p>
 * Classe qui gère les améliorations des statistiques chaque amélioration a un cout définit dans la Config
 * si l'utilisateur na pas assez d'argent l'upgrade est refusé. à chaque niveau d'amélioration le prix augmente
 * </p>
 *
 * <p>
 * utilise le design pattern state pour régire les améliorations en arbre de la tourelle
 * </p>
 */
public class Upgrader
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * @param station -> station du joueur à améliorer
	 */
	public Upgrader(Station station)
		{
		super();
		this.station = station;
		currentTurretState = new InitTurretState();
		shieldLevel = 1;
		fireRateLevel = 1;
		projectilSpeedLevel = 1;
		powerLevel = 1;
		shieldRegenLevel = 1;
		turretLevel = 1;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * reset les améliorations de la station pour un nouveau jeux par exemple
	 */
	public void resetStats()
		{
		currentTurretState = new InitTurretState();

		shieldLevel = 1;
		fireRateLevel = 1;
		projectilSpeedLevel = 1;
		powerLevel = 1;
		shieldRegenLevel = 1;
		turretLevel = 1;

		setTurret(new Turret(this.getCenterStationX(), this.getCenterStationY(), this.getTurretDirection()));
		station.setShieldCapacity(Config.DEFAULT_START_SHIELD);
		station.setShieldRegen(Config.DEFAULT_START_SHIELD_REGEN);
		station.setShootDelay(Config.DEFAULT_START_SHOOT_DELAY);
		station.setDamageMultiplier(Config.DEFAULT_START_DAMAGE_MULTIPLIER);
		station.setProjectilSpeed(Config.DEFAULT_PROJECTILS_SPEED);

		station.reset();

		}


	/**
	 * tante de d'améliorer la taille du canon (débite de l'argent si succes)
	 * @return true si l'amélioration à été effectué
	 */
	public boolean upgradeTurretCanonSize()
		{
		if (station.getMoney() < turretLevel * Config.UPGRADE_TURRET_INIT_PRICE)
			{
			// TODO delet sysout
			System.out.println("[Upgrader] not enought money");
			return false;
			}
		else if (turretLevel == Config.UPGRADE_TURRET_MAX_LEVEL)
			{
			// TODO delet sysout
			System.out.println("[Upgrader] turret allready reach the lvl max");
			return false;
			}
		else
			{
			station.spendMoney(turretLevel * Config.UPGRADE_TURRET_INIT_PRICE);
			currentTurretState.upgradeSizeCanon(this);
			turretLevel++;

			return true;
			}
		}


	/**
	 * tante d'augmenter le nombre de canon (débite de l'argent si succes)
	 * @return true si l'amélioration à été effectué
	 */
	public boolean upgradeTurretNbCanon()
		{
		if (station.getMoney() < turretLevel * Config.UPGRADE_TURRET_INIT_PRICE)
			{
			// TODO delet sysout
			System.out.println("[Upgrader] not enought money");
			return false;
			}
		else if (turretLevel == Config.UPGRADE_TURRET_MAX_LEVEL)
			{
			// TODO delet sysout
			System.out.println("[Upgrader] turret allready reach the lvl max");
			return false;
			}
		else
			{
			station.spendMoney(turretLevel * Config.UPGRADE_TURRET_INIT_PRICE);
			currentTurretState.upgradeNbCanon(this);
			turretLevel++;

			return true;
			}
		}


	/**
	 * tente d'améliorer la capacité du bouclier (débite de l'argent si succes)
	 * @return true si l'amélioration à été effectué
	 */
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


	/**
	 * tante de d'améliorer la vitesse de régénration du bouclier (débite de l'argent si succes)
	 * @return true si l'amélioration à été effectué
	 */
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
			station.setShieldRegen(station.getShieldRegen() + station.getShieldRegen() * Config.UPGRADE_SHIELD_REGEN_AMOUNT / 100);
			shieldRegenLevel++;

			// TODO delet sysout
			System.out.println("[Upgrader] Shield regen upgraded to lvl " + shieldRegenLevel + " (" + station.getShieldRegen() + ")");
			return true;
			}
		}

	/**
	 * tante de d'améliorer les dégats de la tourelle (débite de l'argent si succes)
	 * @return true si l'amélioration à été effectué
	 */
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

	/**
	 * tante de d'améliorer la vitesse de tire de la tourelle (débite de l'argent si succes)
	 * @return true si l'amélioration à été effectué
	 */
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
			System.out.println("[Upgrader] Firerate upgraded to lvl " + fireRateLevel + " (" + station.getShootDelay() + ")");
			return true;
			}
		}

	/**
	 * tante de d'améliorer la vitesse des projectiles tiré par la tourelle (débite de l'argent si succes)
	 * @return true si l'amélioration à été effectué
	 */
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
			station.setProjectilSpeed(station.getProjectilsSpeed() + station.getProjectilsSpeed() * Config.UPGRADE_PROJECTILS_SPEED_AMOUNT / 100);
			projectilSpeedLevel++;

			// TODO delet sysout
			System.out.println("[Upgrader] Projetils speed upgraded to lvl " + projectilSpeedLevel + " (" + station.getProjectilsSpeed() + ")");
			return true;
			}
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setTurretState(TurretStatementInteface turretState)
		{
		this.currentTurretState = turretState;
		}

	public void setTurret(TurretInterface turret)
		{
		station.setTurret(turret);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public float getCenterStationX()
		{
		return station.getCenterX();
		}

	public float getCenterStationY()
		{
		return station.getCenterY();
		}

	public float getTurretDirection()
		{
		return station.getTurretDirection();
		}

	public Image getImage()
		{
		return currentTurretState.getImage();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private Station station;
	private TurretStatementInteface currentTurretState;
	private int shieldLevel;
	private int fireRateLevel;
	private int projectilSpeedLevel;
	private int powerLevel;
	private int shieldRegenLevel;
	private int turretLevel;

	}
