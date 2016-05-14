
package meteorsiege.gameitems;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

import meteorsiege.ImageMagasin;
import meteorsiege.Tools;

public class Projectile extends Circle implements GameItemInterface
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * @param x position initial
	 * @param y position initial
	 * @param radius taille du projectile
	 * @param dammage
	 * @param speed
	 * @param direction en radian
	 */
	public Projectile(float x, float y,int life, int damage, float speed, float direction)
		{
		super(x, y, 1);
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
		g.drawImage(ImageMagasin.laserBlue, this.getCenterX() - (ImageMagasin.laserBlue.getWidth() / 2), this.getCenterY() - ImageMagasin.laserBlue.getHeight());

		g.resetTransform();
		}

	@Override
	public synchronized void nextPosition(int deltaTime)
		{
		this.setCenterX(this.getCenterX() + this.getSpeedX() * deltaTime);
		this.setCenterY(this.getCenterY() + this.getSpeedY() * deltaTime);
		}

	@Override
	public synchronized int getDamage()
		{
		return damage;
		}

	@Override
	public synchronized boolean takeDamage(int value)
		{
			life -= value;
			return life<=0;
		}

	@Override
	public synchronized void destroy()
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
		// les projectils ne donne pas de bonus
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
	private float direction;

	}
