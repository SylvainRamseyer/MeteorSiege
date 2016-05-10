
package meteorsiege.gameitems;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;

import meteorsiege.Config;
import meteorsiege.Tools;

public class Turret extends Circle
	{
	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Turret(float centerPointX, float centerPointY, float radius)
		{
		super(centerPointX, centerPointY, radius);
		power = 1;
		speed = Config.DEFAULT_PROJECTILS_SPEED;
		direction = 0;
		turretLength = image.getHeight();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public Projectile shoot()
		{
		return new Projectile(this.getCenterX() + turretLength*(float)Math.sin(getDirection()), this.getCenterY()+ turretLength*-(float)Math.cos(getDirection()), 1, power, speed, getDirection());
		}

	public void draw(Graphics g)
		{
		g.rotate(this.getCenterX(), this.getCenterY(), 180 + (float)Math.toDegrees(getDirection()));
		g.drawImage(image, this.getCenterX() - (image.getWidth() / 2), this.getCenterY());
		g.drawImage(imageHat, this.getCenterX() - (imageHat.getWidth() / 2), this.getCenterY() - imageHat.getHeight() / 2);
		g.resetTransform();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	public synchronized void setDirection(float value)
		{
		direction = value;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	public synchronized float getDirection()
		{
		return direction;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private int power;
	private float speed;
	private float direction; // that an angle in radian
	private float turretLength;

	public static final Image image = Tools.loadImage("res/Parts/gun00.png");
	public static final Image imageHat = Tools.loadImage("res/Parts/turretBase_small.png");
	}
