
package meteorsiege;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import meteorsiege.GameData.GameItemsContainer;
import meteorsiege.gameitems.GameItemInterface;
import meteorsiege.gameitems.Station;

public class MeteorSiege extends BasicGame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public MeteorSiege(String gamename)
		{
		super(gamename);
		}


	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
		{
		// draw the station
		station.draw(g);

		// draw ennemis
		for(int i = 0; i < Config.SIZE_ENNEMIS_CONTAINER; i++)
			{
			if(ennemisContainer.get(i) != null)
				{
				ennemisContainer.get(i).draw(g);
				}
			}

		// draw projectils
		for(int i = 0; i < Config.SIZE_PROJECTILS_CONTAINER; i++)
			{
			if(projectilsContainer.get(i) != null)
				{
				projectilsContainer.get(i).draw(g);
				}
			}

		// TODO draw annimation

		}

	@Override
	public void init(GameContainer arg0) throws SlickException
		{
		ennemisContainer = new GameItemsContainer<GameItemInterface>(Config.SIZE_ENNEMIS_CONTAINER);
		projectilsContainer = new GameItemsContainer<GameItemInterface>(Config.SIZE_PROJECTILS_CONTAINER);

		//TODO dynamique size
		station = new Station(950, 500, 100);

		}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException
		{
		// TODO Auto-generated method stub

		}

	/*------------------------------------------------------------------*\
	|*							Controls Methodes						*|
	\*------------------------------------------------------------------*/
	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy)
		{
		//TODO taille dynamique
		station.setTurretDirection(Tools.getAngle(newx - 1900 / 2, -1 * (newy - 1000 / 2)));
		}

	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy)
		{
		//TODO taille dynamique
		station.setTurretDirection(Tools.getAngle(newx - 1900 / 2, -1 * (newy - 1000 / 2)));
		}

	@Override
	public void mouseReleased(int button, int x, int y)
		{
		station.ceaseFireMainTurret();
		}

	@Override
	public void mousePressed(int button, int x, int y)
		{
//		try
//			{
//			station.openFireMainTurret(projectilsContainer);
//			}
//		catch (InterruptedException e)
//			{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			}

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
	 private GameItemsContainer<GameItemInterface> ennemisContainer;
	 private GameItemsContainer<GameItemInterface> projectilsContainer;
	 private Station station;

	}

