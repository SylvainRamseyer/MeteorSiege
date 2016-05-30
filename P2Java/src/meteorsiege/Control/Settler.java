
package meteorsiege.control;

import java.util.Random;

import org.newdawn.slick.geom.Rectangle;

import meteorsiege.gamedata.GameItemsContainer;
import meteorsiege.gameitems.GameItemInterface;
import meteorsiege.gameitems.Meteor;
import meteorsiege.tools.Config;

public class Settler implements Runnable
	{


	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public Settler(GameItemsContainer<GameItemInterface> containerToSettle, Rectangle border)
		{
		super();
		this.containerToSettle = containerToSettle;
		this.randomGenerator = new Random();
		this.border = border;
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
				try
					{
					Thread.sleep(SETTLE_DELAY);
					}
				catch (InterruptedException e)
					{
					e.printStackTrace();
					}
				settle();
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

	public float generateRandomSpeed()
		{
		return randomGenerator.nextFloat() * (MAXSPEED - MINSPEED) + MINSPEED;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	private void settle()
		{
		int cote = randomGenerator.nextInt(4);
		float x = 0;
		float y = 0;
		float speedX = 0;
		float speedY = 0;
		switch(cote)
			{
			// top
			case 0:
				y = -SETTLE_OFFSET;
				x = randomGenerator.nextInt(Config.getGameWidth());
				speedY = generateRandomSpeed();
				speedX = generateRandomSpeed();
				break;
			// right
			case 1:
				x = Config.getGameWidth() + SETTLE_OFFSET;
				y = randomGenerator.nextInt(Config.getGameHeight());
				speedY = generateRandomSpeed();
				speedX = -generateRandomSpeed();
				break;
			// bottom
			case 2:
				y = Config.getGameHeight() + SETTLE_OFFSET;
				x = randomGenerator.nextInt(Config.getGameWidth());
				speedY = -generateRandomSpeed();
				speedX = -generateRandomSpeed();
				break;
			// left
			default:
				x = -SETTLE_OFFSET;
				y = randomGenerator.nextInt(Config.getGameHeight());
				speedY = generateRandomSpeed();
				speedX = generateRandomSpeed();
			}
		containerToSettle.add(new Meteor(x, y, speedX, speedY, 20, 400));
		}


	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	static private final float SETTLE_OFFSET = 150;
	static private final float MAXSPEED = 0.5f;
	static private final float MINSPEED = 0f;
	static private final int SETTLE_DELAY = 350;

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private GameItemsContainer<GameItemInterface> containerToSettle;
	private Random randomGenerator;
	private Rectangle border;
	private boolean pause;
	}
