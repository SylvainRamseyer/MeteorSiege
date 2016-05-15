
package meteorsiege.gameitems;

import org.newdawn.slick.Graphics;

public interface GameItemInterface
	{
	public void draw(Graphics g);
	public void nextPosition(int deltaTime);
	public double getDamage();
	public boolean takeDamage(double value);
	public void destroy();
	public int getReward();
	}

