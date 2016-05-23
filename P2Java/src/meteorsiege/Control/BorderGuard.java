
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
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{

		while(!Thread.currentThread().isInterrupted())
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

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private Rectangle border;
	private GameItemsContainer<GameItemInterface> containerToRule;

	}
