
package meteorsiege.gameitems.projectiles;

import org.newdawn.slick.Graphics;

import meteorsiege.gameitems.GameItemInterface;
import meteorsiege.tools.ImageMagasin;


/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * Projectil Niveau 3 du jeu  ce d�place en ligne droite multiplicateur de d�gat : 3x
 * </p>
 */
public class ProjectileM3 extends Projectile implements GameItemInterface
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * @param x : position en x d'apparition
	 * @param y : position en y d'apparition
	 * @param life : quantit�e vie (quantit�e de d�gats que l'item peut subire)
	 * @param damage quantit�e de d�gats que l'item inflige
	 * @param speed : vitesse de d�placement
	 * @param direction : direction dans la quelle l'item se d�place
	 * @param size : taille de colision de l'item (Hit Box)
	 */
	public ProjectileM3(float x, float y, int life, int damage, float speed, float direction, float size)
		{
		super(x, y, life, damage*3, speed, direction, size);
		}


	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public synchronized void draw(Graphics g)
		{
		g.rotate(this.getCenterX(), this.getCenterY(), (float)Math.toDegrees(direction));
		g.drawImage(ImageMagasin.laserRed, this.getCenterX() - (ImageMagasin.laserRed.getWidth() / 2), this.getCenterY() - ImageMagasin.laserRed.getHeight());

		g.resetTransform();
		}
	}
