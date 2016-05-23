
package meteorsiege.states;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class StateGame extends StateBasedGame
	{


	public static void main(String[] args) throws SlickException
		{
		new AppGameContainer(new StateGame(), 1900, 1000, false).start();
		}

	public StateGame()
		{
		super("Meteor Siege");
		}

	/**
	 Définition des états du jeu
	 */
	@Override
	public void initStatesList(GameContainer container) throws SlickException
		{
		addState(new MainScreenGameState());
		addState(new PlayGameState("title"));
		}
	}
