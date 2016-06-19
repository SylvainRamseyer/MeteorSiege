
package meteorsiege.gameitems.turret;

import org.newdawn.slick.Graphics;

import meteorsiege.gamedata.GameItemsContainer;
import meteorsiege.gameitems.GameItemInterface;

/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * Interface qui permet un couplement faible entre la station et les diff�rantes tourelles
 * </p>
 */
public interface TurretInterface
	{

	/**
	 * fait tirer la tourelle (cr�er un nouveau projectile)
	 * @param damageMultiplier : multiplicateur de d�gats
	 * @param projectileSpeed : vitesse de d�plecement du projectile
	 * @param projectilsContainer : conteneur dans le quel le projectile va etre stock�
	 */
	public void shoot(double damageMultiplier, double projectileSpeed, GameItemsContainer<GameItemInterface> projectilsContainer);

	/**
	 * Dessine la tourelle sur le plan de jeu
	 * @param g : context graphique
	 */
	public void draw(Graphics g);

	/**
	 * @param value : angle en radiant
	 */
	public void setDirection(float value);

	/**
	 * @return angle en radiant
	 */
	public float getDirection();
	}
