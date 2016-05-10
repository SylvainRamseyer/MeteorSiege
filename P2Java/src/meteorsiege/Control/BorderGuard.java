
package meteorsiege.control;

import java.util.concurrent.atomic.AtomicBoolean;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import meteorsiege.gamedata.GameItemsContainer;
import meteorsiege.gameitems.GameItemInterface;

public class BorderGuard implements Runnable
	{



	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public BorderGuard(AtomicBoolean interupOrder, Rectangle border, GameItemsContainer<GameItemInterface> containerToRule)
		{
		super();
		this.interupOrder = interupOrder;
		this.border = border;
		this.containerToRule = containerToRule;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{

		while(!interupOrder.get())
			{
			for(int i = 0; i < containerToRule.length(); i++)
				{
				if (containerToRule.get(i) != null)
					{
					if (!border.intersects((Shape)containerToRule.get(i)))
						{
						containerToRule.remove(i);
						}
					}
				}
			}
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private AtomicBoolean interupOrder;
	private Rectangle border;
	private GameItemsContainer<GameItemInterface> containerToRule;

	}

