
package meteorsiege.gameitems;

import org.newdawn.slick.Graphics;

public interface GameItemInterface
	{
	public void draw(Graphics g);
	public void nextPosition();
	public int getDammage();
	public void takeDammage(int value);
	public void destroy();
	}

