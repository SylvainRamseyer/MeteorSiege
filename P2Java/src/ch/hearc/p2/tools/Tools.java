
package ch.hearc.p2.tools;

public class Tools
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static double getAngle(double x, double y)
		{
		double angle = 0;

		// angle par d�faut pour (0,0)
		if ((x == 0) && (y == 0)) {
			return angle;
			}

		//1er quart
		if(x>=0 && y>0)
			{
			angle = Math.atan(Math.abs(x / y));
			}
		//2eme quart
		else if (x > 0 && y <= 0)
			{
			angle = Math.PI / 2 + Math.atan(Math.abs(y / x));
			}

		//3eme quart
		else if (x <= 0 && y < 0)
			{
			angle = Math.PI + Math.atan(Math.abs(x / y));
			}

		//4eme quart
		else if (x < 0 && y >= 0)
			{
			angle = Math.PI * 1.5 + Math.atan(Math.abs(y / x));
			}

		return angle;
		}

	public static float getAngle(float x, float y)
		{
		return (float)getAngle((double)x, (double)y);
		}
	}
