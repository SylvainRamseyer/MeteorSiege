
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
	 * @param deltaTime : delta de temps entre deux mises � jour de la position pour avoir un d�placement r�gulier
	 */
	public void nextPosition(int deltaTime);

	/**
	 * @return la quantit� de d�gats que fait l'item
	 */
	public double getDamage();

	/**
	 * faire subir des d�gats � l'item
	 * @param value : quantit� de d�gats subis
	 * @return si engendre la destruction de l'item true, sinon false
	 */
	public boolean takeDamage(double value);

	/**
	 * derni�re action avant la destruction de l'item
	 */
	public void onDestroy();

	/**
	 * donne la r�compense
	 * @return montant d'argent
	 */
	public int getReward();
	}

