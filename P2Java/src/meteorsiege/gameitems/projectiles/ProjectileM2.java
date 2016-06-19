
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
 * Projectil Niveau 2 du jeu  ce déplace en ligne droite multiplicateur de dégat : 2x
 * </p>
 */
public class ProjectileM2 extends Projectile implements GameItemInterface
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * @param x : position en x d'apparition
	 * @param y : position en y d'apparition
	 * @param life : quantitée vie (quantitée de dégats que l'item peut subire)
	 * @param damage quantitée de dégats que l'item inflige
	 * @param speed : vitesse de déplacement
	 * @param direction : direction dans la quelle l'item se déplace
	 * @param size : taille de colision de l'item (Hit Box)
	 */
	public ProjectileM2(float x, float y, int life, int damage, float speed, float direction, float size)
		{
		super(x, y, life, damage*2, speed, direction, size);
		}


	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public synchronized void draw(Graphics g)
		{
		g.rotate(this.getCenterX(), this.getCenterY(), (float)Math.toDegrees(direction));
		g.drawImage(ImageMagasin.laserBlue, this.getCenterX() - (ImageMagasin.laserBlue.getWidth() / 2), this.getCenterY() - ImageMagasin.laserBlue.getHeight());

		g.resetTransform();
		}
	}

