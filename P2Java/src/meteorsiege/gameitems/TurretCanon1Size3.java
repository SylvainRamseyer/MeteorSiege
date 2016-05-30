
package meteorsiege.gameitems;

import org.newdawn.slick.Graphics;

import meteorsiege.gamedata.GameItemsContainer;
import meteorsiege.tools.ImageMagasin;

public class TurretCanon1Size3 extends Turret
	{


	public TurretCanon1Size3(float centerPointX, float centerPointY, float direction)
		{
		super(centerPointX, centerPointY, direction);
		turretLength = ImageMagasin.turretV3.getHeight();
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
		projectilsContainer.add(new ProjectileM3(this.getCenterX() + turretLength * (float)Math.sin(getDirection()), this.getCenterY() + turretLength * -(float)Math.cos(getDirection()), 1, (int)(power * damageMultiplier), (float)projectileSpeed, getDirection(), 5));
		}

	@Override
	public void draw(Graphics g)
		{
		float scale = 1.2f;
		g.rotate(this.getCenterX(), this.getCenterY(), 180 + (float)Math.toDegrees(getDirection()));
		g.drawImage(ImageMagasin.turretV3, this.getCenterX() - (ImageMagasin.turretV3.getWidth() / 2), this.getCenterY());
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
