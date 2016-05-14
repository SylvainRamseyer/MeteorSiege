
package meteorsiege.gameitems;

import org.newdawn.slick.Graphics;

public interface GameItemInterface
	{
	public void draw(Graphics g);
	public void nextPosition(int deltaTime);
	public int getDamage();
	public boolean takeDamage(int value);
	public void destroy();
	public int getReward();
	}

