
package meteorsiege.control;

import java.util.concurrent.atomic.AtomicBoolean;

import org.newdawn.slick.geom.Shape;

import meteorsiege.gamedata.GameItemsContainer;
import meteorsiege.gameitems.GameItemInterface;
import meteorsiege.gameitems.Station;

public class Collider implements Runnable
	{


	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public Collider(Station playerStation, GameItemsContainer<GameItemInterface> ennemisContainer, GameItemsContainer<GameItemInterface> projectilsContainer)
		{
		super();
		this.playerStation = playerStation;
		this.ennemisContainerToColide = ennemisContainer;
		this.projectilsContainerToColide = projectilsContainer;
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
				collide();
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

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	public void collide()
		{
		for(int i = 0; i < ennemisContainerToColide.length(); i++)
			{
			if (ennemisContainerToColide.get(i) != null)
				{

				GameItemInterface itemToColide = ennemisContainerToColide.get(i);

				// check collision avec la station
				if (((Shape)itemToColide).intersects(playerStation))
					{
					// TODO delet sysout
					System.out.println("[Collider]life   : " + playerStation.getLife());
					System.out.println("[Collider]shield : " + playerStation.getShield());
					playerStation.takeDammage(itemToColide.getDamage());
					ennemisContainerToColide.remove(i);
					}
				else
					{

					for(int j = 0; j < projectilsContainerToColide.length(); j++)
						{
						GameItemInterface itemToColideWith = projectilsContainerToColide.get(j);
						if (itemToColideWith != null)
							{

							// check collision avec un projectile
							if (((Shape)itemToColide).intersects((Shape)itemToColideWith))
								{
								if (itemToColide.takeDamage(itemToColideWith.getDamage()))
									{
									playerStation.addMoney(itemToColide.getReward());
									// TODO delet sysout
									System.out.println("[Collider]money : " + playerStation.getMoney());
									ennemisContainerToColide.remove(i);

									}
								projectilsContainerToColide.remove(j);
								}
							}
						}
					}
				}
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private AtomicBoolean interupOrder;

	private GameItemsContainer<GameItemInterface> ennemisContainerToColide;
	private GameItemsContainer<GameItemInterface> projectilsContainerToColide;
	private Station playerStation;
	private boolean pause;
	}
