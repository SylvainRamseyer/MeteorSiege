
package meteorsiege.gameitems;

import java.util.Random;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

import meteorsiege.ImageMagasin;

public class Meteor extends Circle implements GameItemInterface
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Meteor(float x, float y, float speedX, float speedY, int life, int damage)
		{
		super(x, y, ImageMagasin.meteorBrown.getWidth() / 2);
		this.life = life;
		this.damage = damage;
		this.speedX = speedX;
		this.speedY = speedY;
		this.angleAlpha = new Random().nextFloat() * 360;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public synchronized void draw(Graphics g)
		{
		g.rotate(this.getCenterX(), this.getCenterY(), this.updateAngle());
		g.drawImage(ImageMagasin.meteorBrown, this.getCenterX() - (ImageMagasin.meteorBrown.getWidth() / 2), this.getCenterY() - ImageMagasin.meteorBrown.getHeight() / 2);
		g.resetTransform();
		}

	@Override
	public String toString()
		{
		return "Meteor [speedX=" + this.speedX + ", speedY=" + this.speedY + "] Position = " + x + ";" + y;
		}

	public synchronized float updateAngle()
		{
		angleAlpha += 0.1;
		return angleAlpha % 360;
		}

	@Override
	public synchronized void nextPosition(int deltaTime)
		{
		this.setCenterX(this.getCenterX() + this.getSpeedX() * deltaTime);
		this.setCenterY(this.getCenterY() + this.getSpeedY() * deltaTime);
		}

	@Override
	public synchronized void destroy()
		{
		// TODO Auto-generated method stub

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

	private float speedX;
	private float speedY;
	private float angleAlpha;
	private int life;
	private int damage;
	}
