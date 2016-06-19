
package meteorsiege.gameitems.turret;

import org.newdawn.slick.Graphics;

import meteorsiege.gamedata.GameItemsContainer;
import meteorsiege.gameitems.GameItemInterface;
import meteorsiege.gameitems.projectiles.ProjectileM3;
import meteorsiege.tools.ImageMagasin;

/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * Tourelle qui possède 1 canon de taille 3
 * </p>
 */
public class TurretCanon1Size3 extends Turret
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * @param centerPointX : position du centre de la tourelle en x
	 * @param centerPointY : position du centre de la tourelle en y
	 * @param direction : direction en radian initial
	 */
	public TurretCanon1Size3(float centerPointX, float centerPointY, float direction)
		{
		super(centerPointX, centerPointY, direction);
		turretLength = ImageMagasin.turretV3.getHeight();
		}

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

	}
