
package ch.hearc.p2.Items.experimental;

import org.newdawn.slick.geom.Circle;

public class Turret extends Circle
	{
	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Turret(float centerPointX, float centerPointY, float radius)
		{
		super(centerPointX, centerPointY, radius);
		power = 1;
		speed = 1;
		rateFire = 1;
		direction = 0;
		}

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
	private int power;
	private int speed;
	private float rateFire;
	private float direction; // that an angle

	}

