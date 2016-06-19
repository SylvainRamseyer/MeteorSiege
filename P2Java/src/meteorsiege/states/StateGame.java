
package meteorsiege.states;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * Classe principale du jeu(Main) qui g�re les diff�rents �tats de l'application slick2d
 * </p>
 * <p>
 * initialise les param�tres de slick2d (r�solution, titre) et lance le thread principal
 * </p>
 *
 * <p>
 * initialise les �tats de jeux :
 * </p>
 *
 * <p>
 * 		{@link PlayGameState}(jeu en cours) <b>�tat initial</b> <br>
 * 		�tats suivants : <br>
 * 			- {@link MainScreenGameState} si le joueur appuie sur ESC <br>
 * 			- {@link GameOverState} si le joueur n'a plus de points de vie
 * </p>
 * <p>
 * 		{@link MainScreenGameState}(Menu principal)<br>
 * 		�tats suivants : <br>
 * 			- {@link PlayGameState} si le joueur click sur le bouton reprendre <br>
 * 			- {@link ResetGameState} si le joueur click sur le bouton nouveau jeu <br>
 * 			- Fermeture de la JVM si le joueur click sur le bouton quitter
 * </p>
 * <p>
 * 		{@link GameOverState}(Menu en cas fin de jeu)<br>
 * 		�tats suivants : <br>
 * 			- {@link ResetGameState} si le joueur click sur le bouton nouveau jeu <br>
 * 			- Fermeture de la JVM si le joueur click sur le bouton quitter
 * </p>
 * <p>
 * 		{@link ResetGameState}(met en place un nouveau jeu)<br>
 * 		�tat suivant : <br>
 * 			- {@link PlayGameState} une fois que le jeu est reset
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
	 D�finition des �tats du jeu
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
