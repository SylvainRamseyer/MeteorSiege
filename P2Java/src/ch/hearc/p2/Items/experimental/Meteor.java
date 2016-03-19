
package ch.hearc.p2.Items.experimental;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;

public class Meteor extends Circle
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

		if (Meteor.image == null)
			{
			try
				{
				Meteor.image = new Image("res/Meteors/meteorBrown_big1.png");
				}
			catch (SlickException e)
				{
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	public float getSpeedX()
		{
		return this.speedX;
		}

	public void setSpeedX(float speedX)
		{
		this.speedX = speedX;
		}

	public float getSpeedY()
		{
		return this.speedY;
		}

	public void setSpeedY(float speedY)
		{
		this.speedY = speedY;
		}

	public Image getImage()
		{
		return Meteor.image;
		}

	public float updateAngle()
		{
		angleAlpha += 0.1;
		return angleAlpha % 360;
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

	@Override
	public String toString()
		{
		return "Vaisseau [speedX=" + this.speedX + ", speedY=" + this.speedY + "] Position = " + x + ";" + y;
		}

	private float speedX;
	private float speedY;
	private static Image image;
	private float angleAlpha;
	}
