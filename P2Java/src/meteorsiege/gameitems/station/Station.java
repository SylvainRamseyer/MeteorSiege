
package meteorsiege.gameitems.station;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

import meteorsiege.control.Upgrader;
import meteorsiege.gamedata.GameItemsContainer;
import meteorsiege.gameitems.GameItemInterface;
import meteorsiege.gameitems.turret.Turret;
import meteorsiege.gameitems.turret.TurretInterface;
import meteorsiege.tools.Config;
import meteorsiege.tools.ImageMagasin;

/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * cette classe représente un joueur et toute ses caractéristiques. <br>
 * gère un système d'argent, de score et de dégats via un bouclier et Upgrade via l'Upgrader <br>
 * </p>
 * @see Shield
 * @see Upgrader
 */
public class Station extends Circle
	{


	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * @param centerPointX : position de la station en x
	 * @param centerPointY : position de la station en y
	 * @param life : quantitée de vie de la station
	 * @param shield : quantitée de vie du bouclier
	 * @param shieldRegen : régénération par seconde de la vie du bouclier
	 */
	public Station(float centerPointX, float centerPointY, double life, double shield, double shieldRegen)
		{
		super(centerPointX, centerPointY, ImageMagasin.baseStation.getWidth() / 2);
		turret = new Turret(centerPointX, centerPointY, 0);
		timerTir = 0.0;

		// init de la vie;
		this.life = life;
		this.lifeMax = life;

		// init shield
		this.shield = new Shield(shield, shieldRegen);

		// init money and score
		this.money = 10000000;
		this.score = 0;

		this.damageMultiplier = Config.DEFAULT_START_DAMAGE_MULTIPLIER;
		this.shootDelay = Config.DEFAULT_START_SHOOT_DELAY;
		this.projectileSpeed = Config.DEFAULT_PROJECTILS_SPEED;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	/**
	 * Dessine l'item sur le plan de jeu
	 * @param g : context graphique
	 */
	public void draw(Graphics g)
		{
		g.drawImage(ImageMagasin.baseStation, this.getCenterX() - (ImageMagasin.baseStation.getWidth() / 2), this.getCenterY() - (ImageMagasin.baseStation.getHeight() / 2));
		turret.draw(g);
		shield.draw(g);
		g.resetTransform();
		}

	/**
	 * tire un projectile via la tourelle si le temps de rechargement est écoulé
	 * @param projectilsContainer : conteneur dans le quel on va mettre le nouveau projectile
	 */
	public void fireMainTurret(GameItemsContainer<GameItemInterface> projectilsContainer)
		{
		if (timerTir < 0.0)
			{
			//TODO: fix this in the configuration file
			timerTir = shootDelay;
			turret.shoot(damageMultiplier, projectileSpeed, projectilsContainer);
			}
		}

	/**
	 * décrémente le temps de recharge de la station
	 * @param deltaTime : delta de temps entre deux mise à jour
	 */
	public void decreaseTimerShoot(int deltaTime)
		{
		timerTir -= (deltaTime / 1000.0);
		}

	/**
	 * indique si la tourelle de la station peut tirer
	 * @return true si elle peut sinon false
	 */
	public boolean canShoot()
		{
		return timerTir < 0.0;
		}

	/**
	 * faire subire des dégats à la station
	 * @param damageValue : quantitée de dégats subit
	 * @return si engendre la mort de l'item true sinon false
	 */
	public boolean takeDammage(double damageValue)
		{
		// passe par l'absorbtion du bouclier
		life -= shield.takeDamage(damageValue);
		return life <= 0;
		}

	/**
	 * ajoute de l'argent au capital de la station et incrémente le score
	 * @param value quantitée d'argent à ajouter
	 */
	public void addMoney(int value)
		{
		this.score += value;
		this.money += value;
		}

	/**
	 * dépense de l'argent
	 * @param value quantitée d'argent
	 */
	public void spendMoney(int value)
		{
		this.money -= value;
		}

	/**
	 * régénaire la vie du bouclier
	 * @param deltaTime : delta de temps entre deux regen pour s'éffectuer de manière régulière
	 */
	public void regenShield(int deltaTime)
		{
		shield.regen(deltaTime);
		}

	/**
	 * reset la station pour un nouveau jeu <br>
	 * <b>Attention !</b> reset uniquement le bouclier, la vie, l'argent et le score <br>
	 * Pour le reste des caractéristiques voire : {@link Upgrader}
	 */
	public void reset()
		{
		shield.reset();
		life = lifeMax;
		money = 0;
		score = 0;
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	public void setTurretDirection(float angle)
		{
		turret.setDirection(angle);
		}

	public void setShootDelay(double value)
		{
		shootDelay = value;
		}

	public void setProjectilSpeed(double value)
		{
		this.projectileSpeed = value;
		}

	public void setShieldCapacity(double value)
		{
		shield.setCapacity(value);
		}

	public void setShieldRegen(double value)
		{
		shield.setRegen(value);
		}

	public void setDamageMultiplier(double value)
		{
		damageMultiplier = value;
		}

	public void setTurret(TurretInterface turret)
		{
		this.turret = turret;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	public float getTurretDirection()
		{
		return turret.getDirection();
		}

	public double getLife()
		{
		return life;
		}

	public double getLifeMax()
		{
		return lifeMax;
		}

	public double getShield()
		{
		return shield.getLife();
		}

	public double getShieldCapacity()
		{
		return shield.getCapacity();
		}

	public int getMoney()
		{
		return money;
		}

	public int getScore()
		{
		return score;
		}

	public double getShootDelay()
		{
		return shootDelay;
		}

	public double getDamageMultiplier()
		{
		return damageMultiplier;
		}

	public double getProjectilsSpeed()
		{
		return this.projectileSpeed;
		}

	public double getShieldRegen()
		{
		return shield.getRegen();
		}


	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private TurretInterface turret;
	private Shield shield;
	private double damageMultiplier;
	private double shootDelay;
	private double projectileSpeed;
	private double timerTir;
	private double life;
	private double lifeMax;
	private int money;
	private int score; // accumulation total de l'argent

	}
