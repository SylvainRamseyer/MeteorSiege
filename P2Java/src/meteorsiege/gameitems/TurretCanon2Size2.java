
package meteorsiege.gameitems;

import org.newdawn.slick.Graphics;

import meteorsiege.gamedata.GameItemsContainer;
import meteorsiege.tools.ImageMagasin;

public class TurretCanon2Size2 extends Turret
	{

	public TurretCanon2Size2(float centerPointX, float centerPointY, float direction)
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
	public void shoot(double damageMultiplier, GameItemsContainer<GameItemInterface> projectilsContainer)
		{
		projectilsContainer.add(new ProjectileM2(this.getCenterX() + ImageMagasin.turret.getWidth()/2 + turretLength * (float)Math.sin(getDirection()), this.getCenterY() + ImageMagasin.turret.getWidth()/2 + turretLength * -(float)Math.cos(getDirection()), 1, (int)(power * damageMultiplier), speed, getDirection(),1));
		projectilsContainer.add(new ProjectileM2(this.getCenterX() - ImageMagasin.turret.getWidth()/2 + turretLength * (float)Math.sin(getDirection()), this.getCenterY() - ImageMagasin.turret.getWidth()/2 + turretLength * -(float)Math.cos(getDirection()), 1, (int)(power * damageMultiplier), speed, getDirection(),1));
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
	}

