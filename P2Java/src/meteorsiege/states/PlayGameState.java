
package meteorsiege.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import meteorsiege.control.BorderGuard;
import meteorsiege.control.Collider;
import meteorsiege.control.Settler;
import meteorsiege.control.Upgrader;
import meteorsiege.gamedata.GameItemsContainer;
import meteorsiege.gameitems.GameItemInterface;
import meteorsiege.gameitems.station.Station;
import meteorsiege.gui.Ath;
import meteorsiege.tools.Config;
import meteorsiege.tools.ImageMagasin;
import meteorsiege.tools.MeteorSiegeSoundStore;
import meteorsiege.tools.Tools;


/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * état du design pattern state qui gère les état de jeu et controle les threads de calcule et de rendu (Slick2D) <br>
 * état de jeu dans le quel le joueur peut jouer. (mise à jour et colision des items)
 * </p>
 */
public class PlayGameState extends BasicGameState
	{
	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public PlayGameState()
		{
		super();
		soundStore = MeteorSiegeSoundStore.getInstance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void resetGame()
		{
		settler.pause();
		upgrader.resetStats();
		ennemisContainer.clear();
		projectilsContainer.clear();
		settler.resume();
		}

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

		station = new Station(Config.getGameWidth() / 2, Config.getGameHeight() / 2, Config.DEFAULT_START_LIFE, Config.DEFAULT_START_SHIELD, Config.DEFAULT_START_SHIELD_REGEN);

		ath = new Ath(station);

		playerIsShooting = false;
		ennemisContainer = new GameItemsContainer<GameItemInterface>(Config.SIZE_ENNEMIS_CONTAINER);
		projectilsContainer = new GameItemsContainer<GameItemInterface>(Config.SIZE_PROJECTILS_CONTAINER);

		// init BorderGuards
		Rectangle border = new Rectangle(-Config.BORDER_GUARD_TOLERANCE, -Config.BORDER_GUARD_TOLERANCE, Config.getGameWidth() + 2 * Config.BORDER_GUARD_TOLERANCE, Config.getGameHeight() + 2 * Config.BORDER_GUARD_TOLERANCE);
		ennemisBorderGuard = new BorderGuard(border, ennemisContainer);
		projectilsBorderGuard = new BorderGuard(border, projectilsContainer);

		Thread ennemisBorderGuardThread = new Thread(ennemisBorderGuard);
		Thread projectilsBorderGuardThread = new Thread(projectilsBorderGuard);

		// init Collider
		collider = new Collider(station, ennemisContainer, projectilsContainer);

		Thread colliderThread = new Thread(collider);

		// init Settler
		Rectangle borderToSettle = new Rectangle(0, 0, Config.getGameWidth(), Config.getGameHeight());
		settler = new Settler(ennemisContainer, borderToSettle);
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
	public void enter(GameContainer container, StateBasedGame game) throws SlickException
		{
		super.enter(container, game);
		collider.resume();
		ennemisBorderGuard.resume();
		projectilsBorderGuard.resume();
		settler.resume();
		}

	@Override
	public void leave(GameContainer container, StateBasedGame game) throws SlickException
		{
		collider.pause();
		ennemisBorderGuard.pause();
		projectilsBorderGuard.pause();
		settler.pause();

		super.leave(container, game);
		}

	@Override
	public void render(GameContainer gc, StateBasedGame state, Graphics g) throws SlickException
		{
		// draw background
		g.drawImage(ImageMagasin.backGround, 0, 0);

		// draw the station
		station.draw(g);

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
		ath.draw(g);
		}

	@Override
	public void update(GameContainer gc, StateBasedGame state, int deltaTime) throws SlickException
		{

		if (station.getLife() < 0)
			{
			game.enterState(GameOverState.ID);
			}
		station.regenShield(deltaTime);

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
		station.setTurretDirection(Tools.getAngle(newx - Config.getGameWidth() / 2, -1 * (newy - Config.getGameHeight() / 2)));
		}

	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy)
		{
		// TODO taille dynamique
		station.setTurretDirection(Tools.getAngle(newx - Config.getGameWidth() / 2, -1 * (newy - Config.getGameHeight() / 2)));
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
			//
			game.enterState(MainScreenGameState.ID);
			}
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public Upgrader getUpgrader()
		{
		return this.upgrader;
		}

	public Station getStation()
		{
		return this.station;
		}

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
	private BorderGuard ennemisBorderGuard;
	private BorderGuard projectilsBorderGuard;
	private Settler settler;
	private Collider collider;
	private Ath ath;
	private Upgrader upgrader;
	public static final int ID = 2;
	private StateBasedGame game;
	}
