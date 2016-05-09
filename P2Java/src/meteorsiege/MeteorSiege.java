
package meteorsiege;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import meteorsiege.GameData.GameItemsContainer;
import meteorsiege.gameitems.GameItemInterface;
import meteorsiege.gameitems.Station;
import meteorsiege.sounds.MeteorSiegeSoundStore;

public class MeteorSiege extends BasicGame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public MeteorSiege(String gamename)
		{
		super(gamename);
		soundStore = MeteorSiegeSoundStore.getInstance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
		{
		// draw the station
		station.draw(g);

		// draw projectils
		for(int i = 0; i < Config.SIZE_PROJECTILS_CONTAINER; i++)
			{
			if (projectilsContainer.get(i) != null)
				{
				projectilsContainer.get(i).draw(g);
				}
			}

		for(int i = 0; i < ennemisContainer.length(); i++)
			{
			if (ennemisContainer.get(i) != null)
				{
				ennemisContainer.get(i).draw(g);
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
	public void update(GameContainer gc, int deltaTime) throws SlickException
		{
			for(int i = 0; i < ennemisContainer.length(); i++)
				{
				if (ennemisContainer.get(i) != null)
					{
					ennemisContainer.get(i).nextPosition(deltaTime);
					}
				}

			for(int i = 0; i < projectilsContainer.length(); i++)
				{
				if (projectilsContainer.get(i) != null)
					{
					projectilsContainer.get(i).nextPosition(deltaTime);
					}
				}
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
		station.openFireMainTurret(projectilsContainer);
		MeteorSiegeSoundStore.turretBlaster.play();
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
	private MeteorSiegeSoundStore soundStore;

	}
