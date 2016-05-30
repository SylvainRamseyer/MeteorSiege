
package meteorsiege.gameitems;

import org.newdawn.slick.Graphics;

import meteorsiege.gamedata.GameItemsContainer;
import meteorsiege.tools.ImageMagasin;

public class TurretCanon2Size1 extends Turret
	{

	public TurretCanon2Size1(float centerPointX, float centerPointY, float direction)
		{
		super(centerPointX, centerPointY, direction);
		}

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void shoot(double damageMultiplier, double projectileSpeed, GameItemsContainer<GameItemInterface> projectilsContainer)
		{
		projectilsContainer.add(new Projectile(this.getCenterX() + ImageMagasin.turret.getWidth()/2 *(float)Math.cos(getDirection()) + turretLength * (float)Math.sin(getDirection()), this.getCenterY() + ImageMagasin.turret.getWidth()/2*(float)Math.sin(getDirection()) + turretLength * -(float)Math.cos(getDirection()), 1, (int)(power * damageMultiplier), (float)projectileSpeed, getDirection(),1));
		projectilsContainer.add(new Projectile(this.getCenterX() - ImageMagasin.turret.getWidth()/2 *(float)Math.cos(getDirection()) + turretLength * (float)Math.sin(getDirection()), this.getCenterY() - ImageMagasin.turret.getWidth()/2*(float)Math.sin(getDirection()) + turretLength * -(float)Math.cos(getDirection()), 1, (int)(power * damageMultiplier), (float)projectileSpeed, getDirection(),1));
		}

	@Override
	public void draw(Graphics g)
		{
		g.rotate(this.getCenterX(), this.getCenterY(), 180 + (float)Math.toDegrees(getDirection()));
		g.drawImage(ImageMagasin.turret, this.getCenterX(), this.getCenterY()+14);
		g.drawImage(ImageMagasin.turret, this.getCenterX() - (ImageMagasin.turret.getWidth()), this.getCenterY()+14);
		g.drawImage(ImageMagasin.turretBigTop, this.getCenterX() - (ImageMagasin.turretBigTop.getWidth() / 2), this.getCenterY() - ImageMagasin.turretBigTop.getHeight() / 2);
		g.resetTransform();
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
	}

