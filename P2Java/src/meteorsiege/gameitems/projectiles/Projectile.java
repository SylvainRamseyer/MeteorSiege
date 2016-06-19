
package meteorsiege.gameitems.projectiles;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

import meteorsiege.gameitems.GameItemInterface;
import meteorsiege.tools.ImageMagasin;
import meteorsiege.tools.Tools;


/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * Projectile de base du jeu se déplace en ligne droite, multiplicateur de dégat : 1
 * </p>
 */
public class Projectile extends Circle implements GameItemInterface
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * @param x : position en x d'apparition
	 * @param y : position en y d'apparition
	 * @param life : quantité vie (quantité de dégats que l'item peut subir)
	 * @param damage quantité de dégats que l'item inflige
	 * @param speed : vitesse de déplacement
	 * @param direction : direction dans laquelle l'item se déplace
	 * @param size : taille de collision de l'item (Hit Box)
	 */
	public Projectile(float x, float y, int life, int damage, float speed, float direction, float size)
		{
		super(x, y, size);
		this.direction = direction;
		this.speedX = Tools.getXFromAngle(direction) * speed;
		this.speedY = -1 * Tools.getYFromAngle(direction) * speed;
		this.damage = damage;
		this.life = life;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public synchronized void draw(Graphics g)
		{
		g.rotate(this.getCenterX(), this.getCenterY(), (float)Math.toDegrees(direction));
		g.drawImage(ImageMagasin.laserGreen, this.getCenterX() - (ImageMagasin.laserGreen.getWidth() / 2), this.getCenterY() - ImageMagasin.laserGreen.getHeight());

		g.resetTransform();
		}

	@Override
	public synchronized void nextPosition(int deltaTime)
		{
		this.setCenterX(this.getCenterX() + this.getSpeedX() * deltaTime);
		this.setCenterY(this.getCenterY() + this.getSpeedY() * deltaTime);
		}

	@Override
	public synchronized double getDamage()
		{
		return damage;
		}

	@Override
	public synchronized boolean takeDamage(double value)
		{
		life -= value;
		return life <= 0;
		}

	@Override
	public synchronized void onDestroy()
		{
		// TODO Auto-generated method stub

		}

	@Override
	public String toString()
		{
		return "Meteor [speedX=" + this.speedX + ", speedY=" + this.speedY + "] Position = " + x + ";" + y;
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	public void setSpeedX(float speedX)
		{
		this.speedX = speedX;
		}

	public void setSpeedY(float speedY)
		{
		this.speedY = speedY;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	public float getSpeedX()
		{
		return this.speedX;
		}

	public float getSpeedY()
		{
		return this.speedY;
		}

	@Override
	public int getReward()
		{
		// les projectiles ne donne pas de bonus
		return 0;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private int damage;
	private int life;
	private float speedX;
	private float speedY;
	// protected car les enfants en on besoins pour se dessiner
	protected float direction;

	}
