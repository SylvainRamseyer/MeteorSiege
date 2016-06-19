
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
 * Interface qui permet un couplement faible entre la station et les différantes tourelles
 * </p>
 */
public interface TurretInterface
	{

	/**
	 * fait tirer la tourelle (créer un nouveau projectile)
	 * @param damageMultiplier : multiplicateur de dégats
	 * @param projectileSpeed : vitesse de déplecement du projectile
	 * @param projectilsContainer : conteneur dans le quel le projectile va etre stocké
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
