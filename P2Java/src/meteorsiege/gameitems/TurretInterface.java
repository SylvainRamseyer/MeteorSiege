
package meteorsiege.gameitems;

import org.newdawn.slick.Graphics;

import meteorsiege.gamedata.GameItemsContainer;

public interface TurretInterface
	{
	public void shoot(double damageMultiplier, double projectileSpeed, GameItemsContainer<GameItemInterface> projectilsContainer);
	public void draw(Graphics g);
	public void setDirection(float value);
	public float getDirection();
	}

