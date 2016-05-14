
package meteorsiege;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class LaunchMeteorSiege
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		try
			{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new MeteorSiege("Meteor Siege"));
			appgc.setDisplayMode(1900, 1000,false);
			appgc.setTargetFrameRate(Config.FRAMERATE);
			appgc.start();
			}
		catch (SlickException ex)
			{
			Logger.getLogger(MeteorSiege.class.getName()).log(Level.SEVERE, null, ex);
			}		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
