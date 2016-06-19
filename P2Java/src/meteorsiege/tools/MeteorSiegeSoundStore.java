
package meteorsiege.tools;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;


/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * magasin qui charge les diff�rents sons et qui donne acc�s � eux via des constantes statiques. <br>
 * classe qui impl�mente in Singleton
 * </p>
 */
public class MeteorSiegeSoundStore
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/


	private MeteorSiegeSoundStore()
		{
		try
			{
			turretBlaster = new Sound("res/sounds/laser.ogg");
			}
		catch (SlickException e)
			{
			e.printStackTrace();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * construit l'objet si c'est la premi�re fois que l'on demande (Singleton)
	 * @return instance de l'objet
	 */
	public synchronized static MeteorSiegeSoundStore getInstance()
		{
		if (instance == null)
			{
			return new MeteorSiegeSoundStore();
			}
		else
			{
			return instance;
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs        						*|
	\*------------------------------------------------------------------*/

	private static MeteorSiegeSoundStore instance = null;

	// sons
	public static Sound turretBlaster;
	}
