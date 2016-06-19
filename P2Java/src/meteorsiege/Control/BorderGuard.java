
package meteorsiege.control;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import meteorsiege.gamedata.GameItemsContainer;
import meteorsiege.gameitems.GameItemInterface;

/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 * <br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * Classe qui permet de supprimer les items d'un GameItemsContainer
 * qui sortent de l'aire de jeu
 * </p>
 *
 * <p>
 * l'utiliser dans un thread
 * </p>
 */
public class BorderGuard implements Runnable
	{


	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * @param border : définit le rectangle dans lequel les items ne sont pas supprimés
	 * @param containerToRule : conteneur sur lequel il va travailler
	 */
	public BorderGuard(Rectangle border, GameItemsContainer<GameItemInterface> containerToRule)
		{
		super();
		this.border = border;
		this.containerToRule = containerToRule;
		this.pause = false;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{

		while(!Thread.currentThread().isInterrupted())
			{
			try
				{
				Thread.sleep(50);
				}
			catch (InterruptedException e)
				{
				e.printStackTrace();
				}

			while(!pause && !Thread.currentThread().isInterrupted())
				{

				for(int i = 0; i < containerToRule.length(); i++)
					{

					GameItemInterface item = containerToRule.get(i);
					if (item != null)
						{
						if (!border.intersects((Shape)item))
							{
							containerToRule.remove(i);
							}
						}
					}
				}
			}
		}

	/**
	 * met en pause l'activité du thread
	 */
	public void pause()
		{
		pause = true;
		}

	/**
	 * reprend l'activité du thread
	 */
	public void resume()
		{
		pause = false;
		}

	/**
	 * stop proprement le thread
	 */
	public void stop()
		{
		Thread.currentThread().interrupt();
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private Rectangle border;
	private GameItemsContainer<GameItemInterface> containerToRule;
	private boolean pause;

	}
