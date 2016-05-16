
package meteorsiege.gameitems;

import org.newdawn.slick.Graphics;

import meteorsiege.gamedata.GameItemsContainer;

public interface TurretInterface
	{
	public void shoot(double damageMultiplier, GameItemsContainer<GameItemInterface> projectilsContainer);
	public void draw(Graphics g);
	public void setDirection(float value);
	public void setProjectilsSpeed(float value);
	public float getDirection();
	public float getProjectilsSpeed();
	}

