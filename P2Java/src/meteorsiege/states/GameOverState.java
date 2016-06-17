
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
import meteorsiege.tools.ImageMagasin;

public class GameOverState extends BasicGameState
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1) throws SlickException
		{
		// TODO Auto-generated method stub

		}

	@Override
	public int getID()
		{
		return ID;
		}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException
		{
		this.game = game;
		this.container = container;
		fontsInit();
		menuRectangleInit();
		}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g) throws SlickException
		{

		// draw background
		g.drawImage(ImageMagasin.backGround, 0, 0);

		int width = gc.getWidth();
		int height = gc.getHeight();
		titleFont.drawString(width / 2, height / 2, "Game Over!");
		drawMenu(g);
		}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException
		{
		// TODO Auto-generated method stub

		}

	@Override
	public void mousePressed(int button, int x, int y)
		{
		if (menuReplay.contains(x, y))
			{
			game.enterState(ResetGameState.ID);
			}

		if (menuQuit.contains(x, y))
			{
			container.exit();
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

	private void drawMenu(Graphics g)
		{
		int middleScreenHeight = Config.getGameHeight() / 2;

		g.setColor(Color.lightGray);
		g.drawRoundRect(menuReplay.getMinX(), menuReplay.getMinY(), menuReplay.getWidth(), menuReplay.getHeight(), radius);
		g.drawRoundRect(menuQuit.getMinX(), menuQuit.getMinY(), menuQuit.getWidth(), menuQuit.getHeight(), radius);

		g.fillRoundRect(menuReplay.getMinX(), menuReplay.getMinY(), menuReplay.getWidth(), menuReplay.getHeight(), radius);
		g.fillRoundRect(menuQuit.getMinX(), menuQuit.getMinY(), menuQuit.getWidth(), menuQuit.getHeight(), radius);

		menuFont.drawString(LEFTMENUSTART, middleScreenHeight - middleScreenHeight / 2, "Réessayer", Color.black);
		menuFont.drawString(LEFTMENUSTART, middleScreenHeight + middleScreenHeight / 2, "Quitter", Color.black);

		}

	private void menuRectangleInit()
		{
		int gameHeight = Config.getGameHeight();
		int middleScreenHeight = gameHeight / 2;

		menuReplay = new Rectangle(LEFTMENUSTART - RECTANGLEOFFSET, middleScreenHeight - middleScreenHeight / 2 - RECTANGLEOFFSET, RECTANGLETEXTWIDTH + 2 * RECTANGLEOFFSET, RECTANGLETEXTHEIGHT + 2 * RECTANGLEOFFSET);
		menuQuit = new Rectangle(LEFTMENUSTART - RECTANGLEOFFSET, middleScreenHeight + middleScreenHeight / 2 - RECTANGLEOFFSET, RECTANGLETEXTWIDTH + 2 * RECTANGLEOFFSET, RECTANGLETEXTHEIGHT + 2 * RECTANGLEOFFSET);
		}

	private void fontsInit()
		{
		Font font = new Font("Verdana", Font.BOLD, 45);
		titleFont = new TrueTypeFont(font, true);

		font = new Font("Verdana", Font.BOLD, 30);
		menuFont = new TrueTypeFont(font, true);
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	// Menu
	private static final int radius = 10;
	private static final int LEFTMENUSTART = 50;
	private static final int RECTANGLETEXTWIDTH = 210;
	private static final int RECTANGLETEXTHEIGHT = 40;
	private static final int RECTANGLEOFFSET = 10;

	private static TrueTypeFont titleFont;
	private static TrueTypeFont menuFont;

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	public static final int ID = 4;
	private StateBasedGame game;
	private GameContainer container;
	private Rectangle menuReplay;
	private Rectangle menuQuit;
	private PlayGameState playGameState;
	}
