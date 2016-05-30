
package meteorsiege.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class ResetGameState extends BasicGameState
	{


	public ResetGameState(PlayGameState playGameState)
		{
		this.playGameState = playGameState;
		}

	@Override
	public void enter(GameContainer gc, StateBasedGame game) throws SlickException
		{
		playGameState.resetGame();
		game.enterState(PlayGameState.ID);
		}

	@Override
	public int getID()
		{
		return ID;
		}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException
		{

		}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException
		{
		// TODO Auto-generated method stub

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
	public static final int ID = 3;
	private PlayGameState playGameState;
	}
