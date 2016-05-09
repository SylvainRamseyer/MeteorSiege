
package meteorsiege.gameitems;

import java.util.Random;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;

import meteorsiege.Tools;

public class Meteor extends Circle implements GameItemInterface
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Meteor(float x, float y, float width, float height, float speedX, float speedY)
		{
		super(x, y, width);

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
		g.drawImage(image, this.getCenterX() - (image.getWidth() / 2), this.getCenterY() - image.getHeight() / 2);
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
	public static final Image image = Tools.loadImage("res/Meteors/meteorBrown_big1.png");
	private float angleAlpha;
	}
