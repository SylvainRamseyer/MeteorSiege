
package meteorsiege.gameitems;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;

import meteorsiege.Tools;
import meteorsiege.gamedata.GameItemsContainer;

public class Station extends Circle
	{
	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public Station(float centerPointX, float centerPointY, float radius)
		{
		super(centerPointX, centerPointY, radius);
		turret = new Turret(centerPointX, centerPointY, radius / 3);
		timerTir = 0.0;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	public void draw(Graphics g)
		{
		g.drawImage(Station.image, this.getCenterX() - (Station.image.getWidth() / 2), this.getCenterY() - Station.image.getHeight() / 2);
		turret.draw(g);
		g.resetTransform();
		}

	public void openFireMainTurret(GameItemsContainer<GameItemInterface> projectilsContainer)
		{
		if (timerTir < 0.0)
			{
			//TODO: fix this in the configuration file
			timerTir = 0.01;
			projectilsContainer.add(turret.shoot());
			}
		}

	public void ceaseFireMainTurret()
		{
		}

	public void decreaseTimerShoot(int deltaTime)
		{
		timerTir -= (deltaTime / 1000.0);
		}

	public boolean canShoot()
		{
		return timerTir < 0.0;
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	public void setTurretDirection(float angle)
		{
		turret.setDirection(angle);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	public float getTurretDirection()
		{
		return turret.getDirection();
		}


	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private Turret turret;
	public static final Image image = Tools.loadImage("res/ufoRed.png");
	private double timerTir;

	}
