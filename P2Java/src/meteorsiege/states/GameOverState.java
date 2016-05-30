
package meteorsiege.states;

import java.awt.Font;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOverState extends BasicGameState
	{


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
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException
		{
		fontsInit();
		}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g) throws SlickException
		{
		// TODO Auto-generated method stub
		int width = gc.getWidth();
		int height = gc.getHeight();
		titleFont.drawString(width / 2, height / 2, "Game Over!");
		}

	private void fontsInit()
		{
		Font font = new Font("Verdana", Font.BOLD, 45);
		titleFont = new TrueTypeFont(font, true);
		}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException
		{
		// TODO Auto-generated method stub

		}

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

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
	public static final int ID = 4;
	private static TrueTypeFont titleFont;
	}
