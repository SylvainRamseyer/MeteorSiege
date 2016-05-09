
package meteorsiege.gameitems;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;

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
	public Projectile(float x, float y, float radius, int damage, float speed, float direction)
		{
		super(x, y, radius);
		this.direction = direction;
		this.speedX = Tools.getXFromAngle(direction) * speed;
		this.speedY = -1 * Tools.getYFromAngle(direction) * speed;
		this.damage = damage;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public synchronized void draw(Graphics g)
		{
		g.rotate(this.getCenterX() - (image.getWidth() / 2), this.getCenterY() - (image.getHeight() / 2), (float)Math.toDegrees(direction));
		g.drawImage(image, this.getCenterX() - (image.getWidth() / 2), this.getCenterY() - image.getHeight() / 2);
		g.resetTransform();
		}

	@Override
	public synchronized void nextPosition(int deltaTime)
		{
		this.setCenterX(this.getCenterX() + this.getSpeedX() * deltaTime);
		this.setCenterY(this.getCenterY() + this.getSpeedY() * deltaTime);
		}

	@Override
	public synchronized int getDammage()
		{
		// TODO Auto-generated method stub
		return 0;
		}

	@Override
	public synchronized void takeDammage(int value)
		{
		// TODO Auto-generated method stub

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

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private float damage;
	private float speedX;
	private float speedY;
	private float direction;
	public static final Image image = Tools.loadImage("res/Lasers/LaserBlue07.png");

	}
