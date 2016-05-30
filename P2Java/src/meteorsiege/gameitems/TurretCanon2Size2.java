
package meteorsiege.gameitems;

import org.newdawn.slick.Graphics;

import meteorsiege.gamedata.GameItemsContainer;
import meteorsiege.tools.ImageMagasin;

public class TurretCanon2Size2 extends Turret
	{


	public TurretCanon2Size2(float centerPointX, float centerPointY, float direction)
		{
		super(centerPointX, centerPointY, direction);
		turretLength = ImageMagasin.turretV2.getHeight();
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
		projectilsContainer.add(new ProjectileM2(this.getCenterX() + ImageMagasin.turretV2.getWidth() / 2 * (float)Math.cos(getDirection()) + turretLength * (float)Math.sin(getDirection()),
				this.getCenterY() + ImageMagasin.turretV2.getWidth() / 2 * (float)Math.sin(getDirection()) + turretLength * -(float)Math.cos(getDirection()), 1, (int)(power * damageMultiplier), (float)projectileSpeed, getDirection(), 3));
		projectilsContainer.add(new ProjectileM2(this.getCenterX() - ImageMagasin.turretV2.getWidth() / 2 * (float)Math.cos(getDirection()) + turretLength * (float)Math.sin(getDirection()),
				this.getCenterY() - ImageMagasin.turretV2.getWidth() / 2 * (float)Math.sin(getDirection()) + turretLength * -(float)Math.cos(getDirection()), 1, (int)(power * damageMultiplier), (float)projectileSpeed, getDirection(), 3));
		}

	@Override
	public void draw(Graphics g)
		{
		g.rotate(this.getCenterX(), this.getCenterY(), 180 + (float)Math.toDegrees(getDirection()));
		g.drawImage(ImageMagasin.turretV2, this.getCenterX(), this.getCenterY());
		g.drawImage(ImageMagasin.turretV2, this.getCenterX() - (ImageMagasin.turretV2.getWidth()), this.getCenterY());
		g.drawImage(ImageMagasin.turretBigTop, this.getCenterX() - (ImageMagasin.turretBigTop.getWidth() / 2), this.getCenterY() - ImageMagasin.turretBigTop.getHeight() / 2);
		g.resetTransform();
		}
	}
