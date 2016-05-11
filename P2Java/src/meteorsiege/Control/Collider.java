
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
	public Collider(AtomicBoolean interupOrder, Station playerStation, GameItemsContainer<GameItemInterface> ennemisContainer, GameItemsContainer<GameItemInterface> projectilsContainer)
		{
		super();
		this.interupOrder = interupOrder;
		this.playerStation = playerStation;
		this.containerToColide = ennemisContainer;
		this.containerToColideWith = projectilsContainer;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		while(!interupOrder.get())
			{
			collide();
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
	public void collide()
		{
		for(int i = 0; i < containerToColide.length(); i++)
			{
			if (containerToColide.get(i) != null)
				{

				GameItemInterface itemToColide = containerToColide.get(i);

				// check collision avec la station
				if (((Shape)itemToColide).intersects(playerStation))
					{
					playerStation.takeDammage(itemToColide.getDamage());
					containerToColide.remove(i);
					}
				else
					{

					for(int j = 0; j < containerToColideWith.length(); j++)
						{
						GameItemInterface itemToColideWith = containerToColideWith.get(j);
						if (itemToColideWith != null)
							{

							// check collision avec un projectile
							if (((Shape)itemToColide).intersects((Shape)itemToColideWith))
								{
								if(itemToColide.takeDamage(itemToColideWith.getDamage()))
									{
									containerToColide.remove(i);
									}
								containerToColideWith.remove(j);
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

	private GameItemsContainer<GameItemInterface> containerToColide;
	private GameItemsContainer<GameItemInterface> containerToColideWith;
	private Station playerStation;
	}
