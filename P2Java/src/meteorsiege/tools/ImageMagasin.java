
package meteorsiege.tools;

import org.newdawn.slick.Image;

/**
* Les images doivent se trouver dans un jar, et le jar dans le classpth!
* Le jar doit contenir le folder ressources. A l'interieur du folder ressource doit se trouver les images aux formats (jpg, voir mieux png pour la transparance)
*
* @author Julien M'Poy, Sylvain Ramseyer et Axel Roy, le 18.06.2016
*
*/
public class ImageMagasin
	{


	/*------------------------------------------------------------------*\
	|*		 Version Synchrone (bloquant)								*|
	\*------------------------------------------------------------------*/
	// background
	public static final Image backGround = Tools.loadImage("res/background.jpg");

	// station
	public static final Image baseStation = Tools.loadImage("res/ufoRed.png");
	public static final Image turret = Tools.loadImage("res/Parts/gun00.png");
	public static final Image turretV2 = Tools.loadImage("res/Parts/gun04-centred-bell.png");
	public static final Image turretV3 = Tools.loadImage("res/Parts/gun04-big-bell.png");
	public static final Image turretTop = Tools.loadImage("res/Parts/turretBase_small.png");
	public static final Image turretBigTop = Tools.loadImage("res/Parts/turretBase_big.png");

	// projectil
	public static final Image laserRed = Tools.loadImage("res/Lasers/laserRed16-bspline.png");
	public static final Image laserBlue = Tools.loadImage("res/Lasers/LaserBlue16.png");
	public static final Image laserGreen = Tools.loadImage("res/Lasers/LaserGreen13.png");

	// Upgrades
	public static final Image Turret1 = Tools.loadImage("res/EvolutionTree/LV1.png");
	public static final Image Turret2S = Tools.loadImage("res/EvolutionTree/LV2_S.png");
	public static final Image Turret2P = Tools.loadImage("res/EvolutionTree/LV2_P.png");
	public static final Image Turret3P = Tools.loadImage("res/EvolutionTree/LV3_P.png");
	public static final Image Turret3S = Tools.loadImage("res/EvolutionTree/LV3_S.png");
	public static final Image Turret3SP = Tools.loadImage("res/EvolutionTree/LV3_SP.png");

	// ennemis
	public static final Image meteorBrown = Tools.loadImage("res/Meteors/meteorBrown_big1.png");

	/*------------------------------------------------------------------*\
	|*		Version Asynchrone	(non bloquant)							*|
	\*------------------------------------------------------------------*/

	//public static final ImageIcon warning = ImageLoader.loadAsynchroneJar("ressources/warning.png");
	//public static final ImageIcon coffee = ImageLoader.loadAsynchroneJar("ressources/coffee_logo.png");
	//public static final ImageIcon linux = ImageLoader.loadAsynchroneJar("ressources/linux.png");

	}
