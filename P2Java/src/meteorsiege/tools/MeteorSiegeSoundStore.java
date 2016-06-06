
package meteorsiege.tools;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 *
 * @author julien
 *	Classe Singleton gérant les sons.
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

	public static MeteorSiegeSoundStore getInstance()
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

	private static MeteorSiegeSoundStore instance = null;
	public static Sound turretBlaster;
	}
