package meteorsiege.gameitems;

import org.newdawn.slick.Graphics;

import meteorsiege.gamedata.GameItemsContainer;
import meteorsiege.tools.ImageMagasin;

public class TurretCanon1Size2 extends Turret
	{

	public TurretCanon1Size2(float centerPointX, float centerPointY, float direction)
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
		projectilsContainer.add(new ProjectileM2(this.getCenterX() + turretLength * (float)Math.sin(getDirection()), this.getCenterY() + turretLength * -(float)Math.cos(getDirection()), 1, (int)(power * damageMultiplier), speed, getDirection(),3));
		}

	@Override
	public void draw(Graphics g)
		{
		float scale = 1.2f;
		g.rotate(this.getCenterX(), this.getCenterY(), 180 + (float)Math.toDegrees(getDirection()));
		g.drawImage(ImageMagasin.turret, this.getCenterX() - (ImageMagasin.turret.getWidth() / 2), this.getCenterY());
		g.drawImage(ImageMagasin.turretTop, this.getCenterX() - (ImageMagasin.turretTop.getWidth() / 2), this.getCenterY() - ImageMagasin.turretTop.getHeight()/ 2);
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

