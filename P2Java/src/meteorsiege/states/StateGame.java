
package meteorsiege.states;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy, le 18.06.2016
 * <p>
 * état suivant : {@link ResetGameState} si le joueur choisi de recommencé ou fermeture de la JVM si il choisi de quitté
 * </p>
 */

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
		ResetGameState resetGameState = new ResetGameState(playGameState);
		GameOverState gameOverState = new GameOverState();

		mainScreenGameState.setPlayGameInstance(playGameState);

		addState(playGameState);
		addState(mainScreenGameState);
		addState(resetGameState);
		addState(gameOverState);
		}
	}
