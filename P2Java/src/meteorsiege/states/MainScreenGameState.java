
package meteorsiege.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainScreenGameState extends BasicGameState
	{

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException
		{
		this.game = game;
		}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
		{
		//background.draw(0, 0, container.getWidth(), container.getHeight());
		/*
		g.drawImage(ImageMagasin.menuButton, 100, 100);
		g.drawImage(ImageMagasin.menuButton, 100, 150);
		g.drawImage(ImageMagasin.menuButton, 100, 200);
		*/
		g.drawString("Appuyer sur enter pour continuer", container.getWidth() / 2 - 150, container.getHeight() / 2);
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
	public static final int ID = 1;			//Doit être unique. On pourrait le générer depuis l'identifiant de la classe
	private StateBasedGame game;
	}
