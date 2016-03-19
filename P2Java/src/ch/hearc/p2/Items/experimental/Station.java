
package ch.hearc.p2.Items.experimental;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;

import ch.hearc.p2.tools.Tools;

public class Station extends Circle
	{

	public Station(float centerPointX, float centerPointY, float radius)
		{
		super(centerPointX, centerPointY, radius);
		turret = new Turret(centerPointX,centerPointY,radius/3);
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
	public Image getTurretImage()
		{
		return Turret.image;
		}


	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private Turret turret;
	public static final Image image = Tools.loadImage("res/ufoRed.png") ;
	}

