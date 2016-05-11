
package meteorsiege.control;

import java.util.concurrent.atomic.AtomicBoolean;

import meteorsiege.gamedata.GameItemsContainer;
import meteorsiege.gameitems.GameItemInterface;
import meteorsiege.gameitems.Meteor;

public class Settler implements Runnable
	{


	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public Settler(AtomicBoolean interupOrder, GameItemsContainer<GameItemInterface> containerToSettle)
		{
		super();
		this.interupOrder = interupOrder;
		this.containerToSettle = containerToSettle;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		while(!interupOrder.get())
			{
			settle();
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
	private void settle()
		{
		try
			{
			Thread.sleep(1500);
			}
		catch (InterruptedException e)
			{
			e.printStackTrace();
			}

		containerToSettle.add(new Meteor(100, 500, 0.1f, 0, 50, 400));
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private GameItemsContainer<GameItemInterface> containerToSettle;
	private AtomicBoolean interupOrder;

	}
