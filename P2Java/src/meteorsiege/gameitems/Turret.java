
package meteorsiege.gameitems;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

import meteorsiege.gamedata.GameItemsContainer;
import meteorsiege.tools.Config;
import meteorsiege.tools.ImageMagasin;

public class Turret extends Circle implements TurretInterface
	{
	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Turret(float centerPointX, float centerPointY, float direction)
		{
		super(centerPointX, centerPointY, ImageMagasin.turretTop.getWidth() / 2);
		power = Config.TURRET_BASE_DAMAGE;
		this.direction = direction;
		turretLength = ImageMagasin.turret.getHeight();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void shoot(double damageMultiplier, double projectileSpeed, GameItemsContainer<GameItemInterface> projectilsContainer)
		{
		projectilsContainer.add(new Projectile(this.getCenterX() + turretLength * (float)Math.sin(getDirection()), this.getCenterY() + turretLength * -(float)Math.cos(getDirection()), 1, (int)(power * damageMultiplier), (float)projectileSpeed, getDirection(),1));
		}

	@Override
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

	@Override
	public synchronized void setDirection(float value)
		{
		direction = value;
		}


	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	@Override
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
	protected int power;
	protected float direction; 					// that an angle in radian
	protected float turretLength;
	}
