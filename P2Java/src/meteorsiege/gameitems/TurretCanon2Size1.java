
package meteorsiege.gameitems;

import org.newdawn.slick.Graphics;

import meteorsiege.ImageMagasin;
import meteorsiege.gamedata.GameItemsContainer;

public class TurretCanon2Size1 extends Turret
	{

	public TurretCanon2Size1(float centerPointX, float centerPointY)
		{
		super(centerPointX, centerPointY);
		}

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void shoot(double damageMultiplier, GameItemsContainer<GameItemInterface> projectilsContainer)
		{
		projectilsContainer.add(new Projectile(this.getCenterX() + ImageMagasin.turret.getWidth()/2 + turretLength * (float)Math.sin(getDirection()), this.getCenterY() + ImageMagasin.turret.getWidth()/2 + turretLength * -(float)Math.cos(getDirection()), 1, (int)(power * damageMultiplier), speed, getDirection()));
		projectilsContainer.add(new Projectile(this.getCenterX() - ImageMagasin.turret.getWidth()/2 + turretLength * (float)Math.sin(getDirection()), this.getCenterY() - ImageMagasin.turret.getWidth()/2 + turretLength * -(float)Math.cos(getDirection()), 1, (int)(power * damageMultiplier), speed, getDirection()));
		}

	@Override
	public void draw(Graphics g)
		{
		g.rotate(this.getCenterX(), this.getCenterY(), 180 + (float)Math.toDegrees(getDirection()));
		g.drawImage(ImageMagasin.turret, this.getCenterX(), this.getCenterY());
		g.drawImage(ImageMagasin.turret, this.getCenterX() - (ImageMagasin.turret.getWidth()), this.getCenterY());
		g.drawImage(ImageMagasin.turretTop, this.getCenterX() - (ImageMagasin.turretTop.getWidth() / 2), this.getCenterY() - ImageMagasin.turretTop.getHeight() / 2);
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

