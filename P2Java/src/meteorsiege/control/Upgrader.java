
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
 * Classe qui g�re les améliorations des statistiques, chaque amélioration a un coût défini dans la Config
 * si l'utilisateur n'a pas assez d'argent, l'upgrade est refusé. A chaque niveau d'amélioration le prix augmente
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
	 * @param station : station du joueur à améliorer
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
	 * reset les améliorations de la station pour un nouveau jeu par exemple
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
	 * tente d'améliorer la taille du canon (débite de l'argent si succès)
	 * @return true si l'am�lioration a été effectuée
	 */
	public boolean upgradeTurretCanonSize()
		{
		if (station.getMoney() < turretLevel * Config.UPGRADE_TURRET_INIT_PRICE)
			{
			return false;
			}
		else if (turretLevel == Config.UPGRADE_TURRET_MAX_LEVEL)
			{
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
	 * tente d'augmenter le nombre de canon (débite de l'argent si succ�s)
	 * @return true si l'amélioration a été effectuée
	 */
	public boolean upgradeTurretNbCanon()
		{
		if (station.getMoney() < turretLevel * Config.UPGRADE_TURRET_INIT_PRICE)
			{
			return false;
			}
		else if (turretLevel == Config.UPGRADE_TURRET_MAX_LEVEL)
			{
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
	 * tente d'améliorer la capacité du bouclier (débite de l'argent si succès)
	 * @return true si l'amélioration a été effectuée
	 */
	public boolean upgradeShield()
		{
		if (station.getMoney() < shieldLevel * Config.UPGRADE_SHIELD_INIT_PRICE)
			{
			return false;
			}
		else
			{
			station.spendMoney(shieldLevel * Config.UPGRADE_SHIELD_INIT_PRICE);
			station.setShieldCapacity(station.getShieldCapacity() + station.getShieldCapacity() * Config.UPGRADE_SHIELD_AMOUNT / 100);
			shieldLevel++;

			return true;
			}
		}


	/**
	 * tente d'améliorer la vitesse de régénération du bouclier (débite de l'argent si succès)
	 * @return true si l'amélioration a été effectuée
	 */
	public boolean upgradeShieldRegen()
		{
		if (station.getMoney() < shieldRegenLevel * Config.UPGRADE_SHIELD_REGEN_INIT_PRICE)
			{
			return false;
			}
		else
			{
			station.spendMoney(shieldRegenLevel * Config.UPGRADE_SHIELD_REGEN_INIT_PRICE);
			station.setShieldRegen(station.getShieldRegen() + station.getShieldRegen() * Config.UPGRADE_SHIELD_REGEN_AMOUNT / 100);
			shieldRegenLevel++;

			return true;
			}
		}

	/**
	 * tente de d'améliorer les dégats de la tourelle (débite de l'argent si succès)
	 * @return true si l'amélioration a été effectuée
	 */
	public boolean upgradeDamage()
		{
		if (station.getMoney() < powerLevel * Config.UPGRADE_POWER_INIT_PRICE)
			{
			return false;
			}
		else
			{
			station.spendMoney(powerLevel * Config.UPGRADE_POWER_INIT_PRICE);
			station.setDamageMultiplier(station.getDamageMultiplier() + station.getDamageMultiplier() * Config.UPGRADE_POWER_AMOUNT / 100);
			powerLevel++;

			return true;
			}
		}

	/**
	 * tente d'améliorer la vitesse de tir de la tourelle (débite de l'argent si succès)
	 * @return true si l'am�lioration a été effectuée
	 */
	public boolean upgradeFireRate()
		{
		if (station.getMoney() < fireRateLevel * Config.UPGRADE_FIRERATE_INIT_PRICE)
			{
			return false;
			}
		else
			{
			station.spendMoney(fireRateLevel * Config.UPGRADE_FIRERATE_INIT_PRICE);
			station.setShootDelay(station.getShootDelay() - station.getShootDelay() * Config.UPGRADE_FIRERATE_AMOUNT / 100);
			fireRateLevel++;

			return true;
			}
		}

	/**
	 * tente d'améliorer la vitesse des projectiles tirés par la tourelle (débite de l'argent si succès)
	 * @return true si l'amélioration a été effectuée
	 */
	public boolean upgradeProjectilsSpeed()
		{
		if (station.getMoney() < projectilSpeedLevel * Config.UPGRADE_PROJECTILS_SPEED_INIT_PRICE)
			{
			return false;
			}
		else
			{
			station.spendMoney(projectilSpeedLevel * Config.UPGRADE_PROJECTILS_SPEED_INIT_PRICE);
			station.setProjectilSpeed(station.getProjectilsSpeed() + station.getProjectilsSpeed() * Config.UPGRADE_PROJECTILS_SPEED_AMOUNT / 100);
			projectilSpeedLevel++;

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
