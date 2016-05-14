
package meteorsiege.gameitems;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

import meteorsiege.Config;
import meteorsiege.ImageMagasin;
import meteorsiege.gamedata.GameItemsContainer;

public class Station extends Circle
	{


	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public Station(float centerPointX, float centerPointY, int life, int shield, int shieldRegen)
		{
		super(centerPointX, centerPointY, ImageMagasin.baseStation.getWidth() / 2);
		turret = new Turret(centerPointX, centerPointY);
		timerTir = 0.0;

		// init de la vie;
		this.life = life;
		lifeMax = life;

		// init shield
		this.shield = new Shield(shield, shieldRegen);

		// init money and score
		this.money = 10000000;
		this.score = 0;

		this.damageMultiplier = Config.DEFAULT_START_DAMAGE_MULTIPLIER;
		this.shootDelay = Config.DEFAULT_START_SHOOT_DELAY;

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	public void draw(Graphics g)
		{
		g.drawImage(ImageMagasin.baseStation, this.getCenterX() - (ImageMagasin.baseStation.getWidth() / 2), this.getCenterY() - (ImageMagasin.baseStation.getHeight() / 2));
		turret.draw(g);
		shield.draw(g);
		g.resetTransform();
		}

	public void fireMainTurret(GameItemsContainer<GameItemInterface> projectilsContainer)
		{
		if (timerTir < 0.0)
			{
			//TODO: fix this in the configuration file
			timerTir = shootDelay;
			projectilsContainer.add(turret.shoot(damageMultiplier));
			}
		}

	public void decreaseTimerShoot(int deltaTime)
		{
		timerTir -= (deltaTime / 1000.0);
		}

	public boolean canShoot()
		{
		return timerTir < 0.0;
		}

	public boolean takeDammage(int damageValue)
		{
		// passe par l'absorbtion du bouclier
		life -= shield.takeDamage(damageValue);
		return life <= 0;
		}

	public void addMoney(int value)
		{
		this.score += value;
		this.money += value;
		}

	public void spendMoney(int value)
		{
		this.money -= value;
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
		turret.setProjectilsSpeed((float)value);
		}

	public void setShieldCapacity(int value)
		{
		shield.setCapacity(value);
		}

	public void setShieldRegen(int value)
		{
		shield.setRegen(value);
		}

	public void setDamageMultiplier(int value)
		{
		damageMultiplier = value;
		}


	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	public float getTurretDirection()
		{
		return turret.getDirection();
		}

	public int getLife()
		{
		return life;
		}

	public int getShield()
		{
		return shield.getLife();
		}

	public int getShieldCapacity()
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
		return turret.getProjectilsSpeed();
		}

	public int getShieldRegen()
		{
		return shield.getRegen();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private Turret turret;
	private Shield shield;
	private double damageMultiplier;
	private double shootDelay;
	private double timerTir;
	private int life;
	private int lifeMax;
	private int money;
	private int score; // accumulation total de l'argent

	}
