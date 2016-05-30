
package meteorsiege.control;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import meteorsiege.gamedata.GameItemsContainer;
import meteorsiege.gameitems.GameItemInterface;

public class BorderGuard implements Runnable
	{


	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

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
