
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
 * Interface qui permet un couplement faible entre les conteneur d'item et les items
 * </p>
 */
public interface GameItemInterface
	{

	/**
	 * Dessine l'item sur le plan de jeu
	 * @param g : context graphique
	 */
	public void draw(Graphics g);

	/**
	 * calcule la prochaine position de l'item
	 * @param deltaTime : delta de temps entre deux mise a jour de la position pour avoir un déplacement régulier
	 */
	public void nextPosition(int deltaTime);

	/**
	 * @return la quantitée de dégats que fait l'item
	 */
	public double getDamage();

	/**
	 * faire subire des dégats à l'item
	 * @param value : quantitée de dégats subit
	 * @return si engendre la mort de l'item true sinon false
	 */
	public boolean takeDamage(double value);

	/**
	 * dernière action avant la déstruction de l'item
	 */
	public void onDestroy();

	/**
	 * donne la récompence
	 * @return montant d'argent
	 */
	public int getReward();
	}

