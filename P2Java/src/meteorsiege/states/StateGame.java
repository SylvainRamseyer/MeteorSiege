
package meteorsiege.states;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class StateGame extends StateBasedGame
	{


	public static void main(String[] args) throws SlickException
		{
		new AppGameContainer(new StateGame(), 1024, 768, false).start();
		}

	public StateGame()
		{
		super("Meteor Siege");
		}

	/**
	 D�finition des �tats du jeu
	 */
	@Override
	public void initStatesList(GameContainer container) throws SlickException
		{
		addState(new PlayGameState());
		addState(new MainScreenGameState());
		addState(new ResetGameState());
		}
	}
