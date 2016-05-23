
package meteorsiege.states;

import java.util.concurrent.atomic.AtomicBoolean;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import meteorsiege.Ath;
import meteorsiege.control.BorderGuard;
import meteorsiege.control.Collider;
import meteorsiege.control.Settler;
import meteorsiege.control.Upgrader;
import meteorsiege.gamedata.GameItemsContainer;
import meteorsiege.gameitems.GameItemInterface;
import meteorsiege.gameitems.Station;
import meteorsiege.sounds.MeteorSiegeSoundStore;
import meteorsiege.tools.Config;
import meteorsiege.tools.Tools;

public class PlayGameState extends BasicGameState
	{
	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public PlayGameState(String gamename)
		{
		super();
		soundStore = MeteorSiegeSoundStore.getInstance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public int getID()
		{
		return ID;
		}


	@Override
	public void init(GameContainer gc, StateBasedGame state) throws SlickException
		{
		this.game = state;

		gc.setTargetFrameRate(Config.FRAMERATE);

		// TODO dynamique size
		station = new Station(950, 500, Config.DEFAULT_START_LIFE, Config.DEFAULT_START_SHIELD, Config.DEFAULT_START_SHIELD_REGEN);

		ath = new Ath(station);

		interupOrder = new AtomicBoolean(false);
		playerIsShooting = false;
		ennemisContainer = new GameItemsContainer<GameItemInterface>(Config.SIZE_ENNEMIS_CONTAINER);
		projectilsContainer = new GameItemsContainer<GameItemInterface>(Config.SIZE_PROJECTILS_CONTAINER);

		// init BorderGuards
		Rectangle border = new Rectangle(100, 100, gc.getWidth() - 200, gc.getHeight() - 200);
		ennemisBorderGuard = new BorderGuard(border, ennemisContainer);
		projectilsBorderGuard = new BorderGuard(border, projectilsContainer);

		Thread ennemisBorderGuardThread = new Thread(ennemisBorderGuard);
		Thread projectilsBorderGuardThread = new Thread(projectilsBorderGuard);

		// init Collider
		collider = new Collider(station, ennemisContainer, projectilsContainer);

		Thread colliderThread = new Thread(collider);

		// init Settler
		settler = new Settler(ennemisContainer);
		Thread settlerThread = new Thread(settler);

		// init upgrader
		upgrader = new Upgrader(station);

		// démarrage des Threads

		ennemisBorderGuardThread.start();
		projectilsBorderGuardThread.start();
		colliderThread.start();
		settlerThread.start();
		}

	@Override
	public void render(GameContainer gc, StateBasedGame state, Graphics g) throws SlickException
		{
		// draw the station
		station.draw(g);
		ath.draw(g);

		// draw projectils
		for(int i = 0; i < Config.SIZE_PROJECTILS_CONTAINER; i++)
			{
			GameItemInterface itemToDraw = projectilsContainer.get(i);
			if (itemToDraw != null)
				{
				itemToDraw.draw(g);
				}
			}

		for(int i = 0; i < ennemisContainer.length(); i++)
			{
			GameItemInterface itemToDraw = ennemisContainer.get(i);
			if (itemToDraw != null)
				{
				itemToDraw.draw(g);
				}
			}
		// TODO draw annimation

		}

	@Override
	public void update(GameContainer gc, StateBasedGame state, int deltaTime) throws SlickException
		{
		for(int i = 0; i < ennemisContainer.length(); i++)
			{
			GameItemInterface itemToMove = ennemisContainer.get(i);
			if (itemToMove != null)
				{
				itemToMove.nextPosition(deltaTime);
				}
			}

		for(int i = 0; i < projectilsContainer.length(); i++)
			{
			GameItemInterface itemToMove = projectilsContainer.get(i);
			if (itemToMove != null)
				{
				itemToMove.nextPosition(deltaTime);
				}
			}

		station.decreaseTimerShoot(deltaTime);
		if (station.canShoot() && playerIsShooting)
			{
			station.fireMainTurret(projectilsContainer);
			MeteorSiegeSoundStore.turretBlaster.play();
			}

		}

	/*------------------------------------------------------------------*\
	|*							Controls Methodes						*|
	\*------------------------------------------------------------------*/
	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy)
		{
		// TODO taille dynamique
		station.setTurretDirection(Tools.getAngle(newx - 1900 / 2, -1 * (newy - 1000 / 2)));
		}

	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy)
		{
		// TODO taille dynamique
		station.setTurretDirection(Tools.getAngle(newx - 1900 / 2, -1 * (newy - 1000 / 2)));
		}

	@Override
	public void mouseReleased(int button, int x, int y)
		{
		playerIsShooting = false;
		}

	@Override
	public void mousePressed(int button, int x, int y)
		{
		playerIsShooting = true;
		}

	@Override
	public void keyPressed(int key, char c)
		{
		if (key == Input.KEY_ESCAPE)
			{
			game.enterState(MainScreenGameState.ID);
			}


		if (key == Input.KEY_1)
			{
			if (upgrader.upgradeShield())
				{
				// TODO display succesfull message
				}
			else
				{
				// TODO display failing message
				}
			}
		if (key == Input.KEY_2)
			{
			if (upgrader.upgradeShieldRegen())
				{
				// TODO display succesfull message
				}
			else
				{
				// TODO display failing message
				}
			}
		if (key == Input.KEY_3)
			{
			if (upgrader.upgradeDamage())
				{
				// TODO display succesfull message
				}
			else
				{
				// TODO display failing message
				}
			}
		if (key == Input.KEY_4)
			{
			if (upgrader.upgradeFireRate())
				{
				// TODO display succesfull message
				}
			else
				{
				// TODO display failing message
				}
			}
		if (key == Input.KEY_5)
			{
			if (upgrader.upgradeProjectilsSpeed())
				{
				// TODO display succesfull message
				}
			else
				{
				// TODO display failing message
				}
			}

		if (key == Input.KEY_6)
			{
			if (upgrader.upgradeTurretNbCanon())
				{
				// TODO display succesfull message
				}
			else
				{
				// TODO display failing message
				}
			}

		if (key == Input.KEY_7)
			{
			if (upgrader.upgradeTurretCanonSize())
				{
				// TODO display succesfull message
				}
			else
				{
				// TODO display failing message
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
	private GameItemsContainer<GameItemInterface> ennemisContainer;
	private GameItemsContainer<GameItemInterface> projectilsContainer;
	private Station station;
	private MeteorSiegeSoundStore soundStore;
	private boolean playerIsShooting;
	private AtomicBoolean interupOrder;
	private BorderGuard ennemisBorderGuard;
	private BorderGuard projectilsBorderGuard;
	private Settler settler;
	private Collider collider;
	private Ath ath;
	private Upgrader upgrader;
	public static final int ID = 2;
	private StateBasedGame game;
	}
