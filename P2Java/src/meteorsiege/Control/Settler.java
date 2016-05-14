
package meteorsiege.control;

import java.util.Random;

import meteorsiege.gamedata.GameItemsContainer;
import meteorsiege.gameitems.GameItemInterface;
import meteorsiege.gameitems.Meteor;

public class Settler implements Runnable
	{


	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public Settler(GameItemsContainer<GameItemInterface> containerToSettle)
		{
		super();
		this.containerToSettle = containerToSettle;
		randomGenerator = new Random();
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
				Thread.sleep(100);
				}
			catch (InterruptedException e)
				{
				e.printStackTrace();
				}
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
		containerToSettle.add(new Meteor(100, randomGenerator.nextInt(1000), 0f, 0, 50, 400));
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private GameItemsContainer<GameItemInterface> containerToSettle;
	private Random randomGenerator;

	}
