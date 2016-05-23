
package meteorsiege.states;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import meteorsiege.tools.Config;

public class MainScreenGameState extends BasicGameState
	{


	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException
		{
		this.game = game;
		Config.setGameHeight(container.getHeight());
		Config.setGameWidth(container.getWidth());

		fontsInit();
		menuRectangleInit();
		}

	private void menuRectangleInit()
		{
		int gameHeight = Config.getGameHeight();
		int middleScreenHeight = gameHeight/2;

		menuResume = new Rectangle(LEFTMENUSTART - RECTANGLEOFFSET,
				   				   middleScreenHeight - middleScreenHeight/2 - RECTANGLEOFFSET,
				   				   RECTANGLETEXTWIDTH + 2*RECTANGLEOFFSET,
				   				   RECTANGLETEXTHEIGHT + 2*RECTANGLEOFFSET);

		}

	private void fontsInit()
		{
		Font font = new Font("Verdana", Font.BOLD, 45);
		titleFont = new TrueTypeFont(font, true);

		font = new Font("Verdana", Font.BOLD, 30);
		menuFont = new TrueTypeFont(font, true);
		}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
		{
		//Titre du jeu
		int gameWidth = Config.getGameWidth();
		titleFont.drawString(gameWidth / 2 - TITLELENGTH /2, TOPTITLE, "Meteor Siege");

		//Menu
		drawMenu(g);

		g.drawString("Appuyer sur enter pour continuer", container.getWidth() / 2 - 150, container.getHeight() / 2);
		}

	private void drawMenu(Graphics g)
		{
		int gameHeight = Config.getGameHeight();
		int middleScreenHeight = gameHeight/2;

		g.setColor(Color.white);
		g.drawRect(menuResume.getMinX(),
				   menuResume.getMinY(),
				   menuResume.getWidth(),
				   menuResume.getHeight());


		menuFont.drawString(LEFTMENUSTART, middleScreenHeight - middleScreenHeight/2, "Reprendre", Color.white);
		menuFont.drawString(LEFTMENUSTART, middleScreenHeight, "Nouveau jeu", Color.white);
		menuFont.drawString(LEFTMENUSTART, middleScreenHeight + middleScreenHeight/2, "Quitter", Color.white);
		}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
		{
		}

	@Override
	public void keyReleased(int key, char c)
		{
		if (key == Input.KEY_ENTER)
			{
			game.enterState(PlayGameState.ID);
			}
		}

	@Override
	public int getID()
		{
		return ID;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	public static final int ID = 1; //Doit être unique. On pourrait le générer depuis l'identifiant de la classe
	private StateBasedGame game;
	private TrueTypeFont titleFont;
	private TrueTypeFont menuFont;

	//Menu
	private static final int LEFTMENUSTART = 50;
	private static final int RECTANGLETEXTWIDTH = 210;
	private static final int RECTANGLETEXTHEIGHT = 40;
	private static final int RECTANGLEOFFSET = 10;
	private static Rectangle menuResume;
	private static Rectangle menuNew;
	private static Rectangle menuQuit;


	//Title
	private static final int TOPTITLE = 20;
	private static final int TITLELENGTH = 320;


	}
