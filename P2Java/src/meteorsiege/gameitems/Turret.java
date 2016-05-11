
package meteorsiege.gameitems;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

import meteorsiege.Config;
import meteorsiege.ImageMagasin;

public class Turret extends Circle
	{
	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Turret(float centerPointX, float centerPointY)
		{
		super(centerPointX, centerPointY, ImageMagasin.turretTop.getWidth() / 2);
		power = 1;
		speed = Config.DEFAULT_PROJECTILS_SPEED;
		direction = 0;
		turretLength = ImageMagasin.turret.getHeight();
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
		g.drawImage(ImageMagasin.turret, this.getCenterX() - (ImageMagasin.turret.getWidth() / 2), this.getCenterY());
		g.drawImage(ImageMagasin.turretTop, this.getCenterX() - (ImageMagasin.turretTop.getWidth() / 2), this.getCenterY() - ImageMagasin.turretTop.getHeight() / 2);
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
	}
