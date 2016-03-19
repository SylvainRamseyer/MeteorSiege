
package ch.hearc.p2.Items.experimental;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;

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

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	private static Image loadImage()
		{
			Image image = null;
			try
				{
				image = new Image("res/ufoRed.png");
				}
			catch (SlickException e)
				{
				e.printStackTrace();
				}
			return image;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private Turret turret;
	public static final Image image = loadImage() ;
	}
