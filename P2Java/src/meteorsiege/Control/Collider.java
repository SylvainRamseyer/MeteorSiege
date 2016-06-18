
package meteorsiege.control;

import org.newdawn.slick.geom.Shape;

import meteorsiege.gamedata.GameItemsContainer;
import meteorsiege.gameitems.GameItemInterface;
import meteorsiege.gameitems.station.Station;

/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * Classe qui permet de détecter les interactions physiques entre les
 * Items de deux Conatainers et la station.
 * </p>
 *
 * <p>
 * une fois une colision détecter les méthodes de modification nécésaire
 * des items sont appelé.
 * </p>
 *
 * <p>
 * à utiliser dans un thread
 * </p>
 */
public class Collider implements Runnable
	{


	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * @param playerStation -> La station du joueur
	 * @param ennemisContainer -> Contenaire d'item de type ennemis
	 * @param projectilsContainer -> Containaire d'item de type projectiles
	 */
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

	public void stop()
		{
		Thread.currentThread().interrupt();
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

	/**
	 * Parcours tous les items d'un container, regarde si il y a collision avec la station ou
	 * avec un des items de l'autre container.
	 */
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

	private GameItemsContainer<GameItemInterface> ennemisContainerToColide;
	private GameItemsContainer<GameItemInterface> projectilsContainerToColide;
	private Station playerStation;
	private boolean pause;
	}
