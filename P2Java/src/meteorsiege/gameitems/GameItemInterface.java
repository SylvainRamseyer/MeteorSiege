
package meteorsiege.gameitems;

import org.newdawn.slick.Graphics;


/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * Interface qui permet un couplement faible entre les containers d'items et les items
 * </p>
 */
public interface GameItemInterface
	{

	/**
	 * Dessine l'item sur le plan de jeu
	 * @param g : contexte graphique
	 */
	public void draw(Graphics g);

	/**
	 * calcule la prochaine position de l'item
	 * @param deltaTime : delta de temps entre deux mises à jour de la position pour avoir un déplacement régulier
	 */
	public void nextPosition(int deltaTime);

	/**
	 * @return la quantité de dégats que fait l'item
	 */
	public double getDamage();

	/**
	 * faire subir des dégats à l'item
	 * @param value : quantité de dégats subis
	 * @return si engendre la destruction de l'item true, sinon false
	 */
	public boolean takeDamage(double value);

	/**
	 * dernière action avant la destruction de l'item
	 */
	public void onDestroy();

	/**
	 * donne la récompense
	 * @return montant d'argent
	 */
	public int getReward();
	}

