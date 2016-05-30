
package meteorsiege.states;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class StateGame extends StateBasedGame
	{


	public static void main(String[] args) throws SlickException
		{
		new AppGameContainer(new StateGame(), 1920, 1024, false).start();
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
		PlayGameState playGameState = new PlayGameState();
		MainScreenGameState mainScreenGameState = new MainScreenGameState();
		ResetGameState resetGameState = new ResetGameState();
		GameOverState gameOverState = new GameOverState();

		mainScreenGameState.setPlayGameInstance(playGameState);

		addState(playGameState);
		addState(mainScreenGameState);
		addState(resetGameState);
		addState(gameOverState);
		}
	}
