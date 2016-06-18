
package meteorsiege.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import meteorsiege.tools.ImageMagasin;


/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * état du design pattern state qui gère les état de jeu et controle les threads de calcule et de rendu (Slick2D) <br>
 * état reset du jeux : ordonne au différant organe de mettre le jeu dans l'état initial
 * </p>
 */
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
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException
		{
		// draw background
		g.drawImage(ImageMagasin.backGround, 0, 0);

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
