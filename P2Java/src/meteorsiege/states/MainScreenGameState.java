
package meteorsiege.states;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import meteorsiege.tools.Config;

public class MainScreenGameState extends BasicGameState
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException
		{
		this.game = game;
		this.container = container;
		Config.setGameHeight(container.getHeight());
		Config.setGameWidth(container.getWidth());

		fontsInit();
		menuRectangleInit();
		}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
		{
		//Titre du jeu
		int gameWidth = Config.getGameWidth();
		titleFont.drawString(gameWidth / 2 - TITLELENGTH / 2, TOPTITLE, "Meteor Siege");

		//Menu
		drawMenu(g);

		//Score et argent
		drawInfos(g);
		}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
		{

		}

	@Override
	public void mousePressed(int button, int x, int y)
		{
		if (menuResume.contains(x, y))
			{
			game.enterState(PlayGameState.ID);
			}

		if (menuQuit.contains(x, y))
			{
			container.exit();
			}
		}

	private void drawMenu(Graphics g)
		{
		int gameHeight = Config.getGameHeight();
		int middleScreenHeight = gameHeight / 2;

		g.setColor(Color.lightGray);
		g.drawRoundRect(menuResume.getMinX(), menuResume.getMinY(), menuResume.getWidth(), menuResume.getHeight(), radius);
		g.drawRoundRect(menuQuit.getMinX(), menuQuit.getMinY(), menuQuit.getWidth(), menuQuit.getHeight(), radius);
		g.drawRoundRect(menuNew.getMinX(), menuNew.getMinY(), menuNew.getWidth(), menuNew.getHeight(), radius);

		g.fillRoundRect(menuResume.getMinX(), menuResume.getMinY(), menuResume.getWidth(), menuResume.getHeight(), radius);
		g.fillRoundRect(menuNew.getMinX(), menuNew.getMinY(), menuNew.getWidth(), menuNew.getHeight(), radius);
		g.fillRoundRect(menuQuit.getMinX(), menuQuit.getMinY(), menuQuit.getWidth(), menuQuit.getHeight(), radius);

		menuFont.drawString(LEFTMENUSTART, middleScreenHeight - middleScreenHeight / 2, "Reprendre", Color.black);
		menuFont.drawString(LEFTMENUSTART, middleScreenHeight, "Nouveau jeu", Color.black);
		menuFont.drawString(LEFTMENUSTART, middleScreenHeight + middleScreenHeight / 2, "Quitter", Color.black);
		}

	private void drawInfos(Graphics g)
		{
		g.drawString("Score : ", LEFTMENUSTART + RECTANGLETEXTWIDTH + 50, 100);
		}

	@Override
	public int getID()
		{
		return ID;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void menuRectangleInit()
		{
		int gameHeight = Config.getGameHeight();
		int middleScreenHeight = gameHeight / 2;

		menuResume = new Rectangle(LEFTMENUSTART - RECTANGLEOFFSET, middleScreenHeight - middleScreenHeight / 2 - RECTANGLEOFFSET, RECTANGLETEXTWIDTH + 2 * RECTANGLEOFFSET, RECTANGLETEXTHEIGHT + 2 * RECTANGLEOFFSET);
		menuNew = new Rectangle(LEFTMENUSTART - RECTANGLEOFFSET, middleScreenHeight - RECTANGLEOFFSET, RECTANGLETEXTWIDTH + 2 * RECTANGLEOFFSET, RECTANGLETEXTHEIGHT + 2 * RECTANGLEOFFSET);
		menuQuit = new Rectangle(LEFTMENUSTART - RECTANGLEOFFSET, middleScreenHeight + middleScreenHeight / 2 - RECTANGLEOFFSET, RECTANGLETEXTWIDTH + 2 * RECTANGLEOFFSET, RECTANGLETEXTHEIGHT + 2 * RECTANGLEOFFSET);
		}

	private void fontsInit()
		{
		Font font = new Font("Verdana", Font.BOLD, 45);
		titleFont = new TrueTypeFont(font, true);

		font = new Font("Verdana", Font.BOLD, 30);
		menuFont = new TrueTypeFont(font, true);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	public static final int ID = 1; //Doit être unique. On pourrait le générer depuis l'identifiant de la classe
	private StateBasedGame game;
	private TrueTypeFont titleFont;
	private TrueTypeFont menuFont;
	private GameContainer container;

	//Menu
	private static final int LEFTMENUSTART = 50;
	private static final int RECTANGLETEXTWIDTH = 210;
	private static final int RECTANGLETEXTHEIGHT = 40;
	private static final int RECTANGLEOFFSET = 10;
	private static Rectangle menuResume;
	private static Rectangle menuNew;
	private static Rectangle menuQuit;
	private static final int radius = 10;

	//Title
	private static final int TOPTITLE = 20;
	private static final int TITLELENGTH = 320;
	}
