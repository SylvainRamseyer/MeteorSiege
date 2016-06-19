
package meteorsiege.tools;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * classe contenant des m�thodes statiques outils utiles � l'application
 * </p>
 */
public class Tools
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * donne un angle en radian en fonction d'un point
	 * @param x coordonn�e du point
	 * @param y coordonn�e du point
	 * @return angle en radian du vecteur origine/point
	 */
	public static double getAngle(double x, double y)
		{
		double angle = 0;

		// angle par d�faut pour (0,0)
		if ((x == 0) && (y == 0)) { return angle; }

		//1er quart
		if (x >= 0 && y > 0)
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

	/**
	 * donne un angle en radian en fonction d'un point
	 * @param x coordonn�e du point
	 * @param y coordonn�e du point
	 * @return angle en radian du vecteur origine/point
	 */
	public static float getAngle(float x, float y)
		{
		return (float)getAngle((double)x, (double)y);
		}

	/**
	 * donne x du vecteur unitaire dont la direction est donn�e par l'angle
	 * @param angle angle en radian
	 * @return x du vecteur unitaire de direction
	 */
	public static float getXFromAngle(float angle)
		{
		return (float)Math.sin(angle);
		}

	/**
	 * donne y du vecteur unitaire dont la direction est donn�e par l'angle
	 * @param angle angle en radian
	 * @return y du vecteur unitaire de direction
	 */
	public static float getYFromAngle(float angle)
		{
		return (float)Math.cos(angle);
		}

	/**
	 * charge une image
	 * @param path de l'image o� elle est stock�e
	 * @return l'image charg�e
	 */
	public static Image loadImage(String path)
		{
		Image image = null;
		try
			{
			image = new Image(path);
			}
		catch (SlickException e)
			{
			e.printStackTrace();
			}
		return image;
		}
	}
