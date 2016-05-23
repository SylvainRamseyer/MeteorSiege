
package meteorsiege.control;

import java.util.Random;

import org.newdawn.slick.geom.Rectangle;

import meteorsiege.gamedata.GameItemsContainer;
import meteorsiege.gameitems.GameItemInterface;
import meteorsiege.gameitems.Meteor;

public class Settler implements Runnable
	{


	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public Settler(GameItemsContainer<GameItemInterface> containerToSettle, Rectangle border)
		{
		super();
		this.containerToSettle = containerToSettle;
		randomGenerator = new Random();
		this.border = border;
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
<<<<<<< HEAD
				Thread.sleep(20);
=======
				Thread.sleep(SETTLE_DELAY);
>>>>>>> 7f5d56fa018b9d5e60b8638d73553519a773554c
				}
			catch (InterruptedException e)
				{
				e.printStackTrace();
				}
			settle();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	private void settle()
		{
<<<<<<< HEAD
		containerToSettle.add(new Meteor(100, randomGenerator.nextInt(1000), 0.1f, 0, 50, 400));
=======
		int cote = randomGenerator.nextInt(4);
		float x = 0;
		float y = 0;
		float speedX = 0;
		float speedY = 0;
		//		System.out.println(cote);
		switch(cote)
			{
			// top
			case 0:
				//				System.out.println("top");
				y = -SETTLE_OFFSET;
				x = randomGenerator.nextInt((int)border.getWidth());
				speedY = generateRandomSpeed();
				speedX = generateRandomSpeed();
				System.out.println("top: " + speedX + " " + speedY);
				break;
			// right
			case 1:
				//				System.out.println("right");
				x = (int)border.getWidth() + SETTLE_OFFSET;
				y = randomGenerator.nextInt((int)border.getHeight());
				speedY = generateRandomSpeed();
				speedX = -generateRandomSpeed();
				break;
			// bottom
			case 2:
				//				System.out.println("bottom");
				y = (int)border.getHeight() + SETTLE_OFFSET;
				x = randomGenerator.nextInt((int)border.getWidth());
				speedY = -generateRandomSpeed();
				speedX = -generateRandomSpeed();
				break;
			// left
			default:
				//				System.out.println("left");
				x = -SETTLE_OFFSET;
				y = randomGenerator.nextInt((int)border.getHeight());
				speedY = generateRandomSpeed();
				speedX = generateRandomSpeed();
			}
		containerToSettle.add(new Meteor(x, y, speedX, speedY, 20, 400));
>>>>>>> 7f5d56fa018b9d5e60b8638d73553519a773554c
		}

	public float generateRandomSpeed()
		{
		return randomGenerator.nextFloat() * (MAXSPEED - MINSPEED) + MINSPEED;
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
	}
