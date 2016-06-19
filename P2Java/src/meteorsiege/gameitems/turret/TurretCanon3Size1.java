package meteorsiege.gameitems.turret;

import org.newdawn.slick.Graphics;

import meteorsiege.gamedata.GameItemsContainer;
import meteorsiege.gameitems.GameItemInterface;
import meteorsiege.gameitems.projectiles.Projectile;
import meteorsiege.tools.ImageMagasin;


/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * Tourelle qui possède 3 canons de taille 1
 * </p>
 */
public class TurretCanon3Size1 extends Turret
	{


	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * @param centerPointX : position du centre de la tourelle en x
	 * @param centerPointY : position du centre de la tourelle en y
	 * @param direction : direction en radiant initial
	 */
	public TurretCanon3Size1(float centerPointX, float centerPointY, float direction)
		{
		super(centerPointX, centerPointY, direction);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void shoot(double damageMultiplier, double projectileSpeed, GameItemsContainer<GameItemInterface> projectilsContainer)
		{
		projectilsContainer.add(new Projectile(this.getCenterX() + ImageMagasin.turret.getWidth()/2*(float)Math.cos(getDirection()) + turretLength * (float)Math.sin(getDirection()), this.getCenterY() + ImageMagasin.turret.getWidth()/2*(float)Math.sin(getDirection()) + turretLength * -(float)Math.cos(getDirection()), 1, (int)(power * damageMultiplier), (float)projectileSpeed, getDirection(),1));
		projectilsContainer.add(new Projectile(this.getCenterX() + turretLength * (float)Math.sin(getDirection()), this.getCenterY() + turretLength * -(float)Math.cos(getDirection()), 1, (int)(power * damageMultiplier), (float)projectileSpeed, getDirection(),1));
		projectilsContainer.add(new Projectile(this.getCenterX() - ImageMagasin.turret.getWidth()/2*(float)Math.cos(getDirection()) + turretLength * (float)Math.sin(getDirection()), this.getCenterY() - ImageMagasin.turret.getWidth()/2 *(float)Math.sin(getDirection()) + turretLength * -(float)Math.cos(getDirection()), 1, (int)(power * damageMultiplier), (float)projectileSpeed, getDirection(),1));

		}

	@Override
	public void draw(Graphics g)
		{
		g.rotate(this.getCenterX(), this.getCenterY(), 180 + (float)Math.toDegrees(getDirection()));
		g.drawImage(ImageMagasin.turret, this.getCenterX(), this.getCenterY()+14);
		g.drawImage(ImageMagasin.turret, this.getCenterX() - (ImageMagasin.turret.getWidth()), this.getCenterY()+14);
		g.drawImage(ImageMagasin.turret, this.getCenterX() - (ImageMagasin.turret.getWidth() / 2), this.getCenterY()+14);

		g.drawImage(ImageMagasin.turretBigTop, this.getCenterX() - (ImageMagasin.turretBigTop.getWidth() / 2), this.getCenterY() - ImageMagasin.turretBigTop.getHeight() / 2);
		g.resetTransform();
		}
	}
