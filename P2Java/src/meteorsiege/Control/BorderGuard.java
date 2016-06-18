
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
 * qui sortent de l'aire de jeux
 * </p>
 *
 * <p>
 * � utiliser dans un thread
 * </p>
 */
public class BorderGuard implements Runnable
	{


	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * @param border -> d�finit le rectangle dans le quel les items ne sont pas supprimer
	 * @param containerToRule -> Containaire sur le quel il va travailler
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

			while(!pause)
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

	public void pause()
		{
		pause = true;
		}

	public void resume()
		{
		pause = false;
		}

	public void stop()
		{
		Thread.currentThread().interrupt();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private Rectangle border;
	private GameItemsContainer<GameItemInterface> containerToRule;
	private boolean pause;

	}
