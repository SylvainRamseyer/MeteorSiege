
package meteorsiege.tools;

import org.newdawn.slick.Image;

/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * magasin qui charge les images utiles à l'application et qui donne accès à elles via des constantes statiques publiques
 * </p>
 *
 * <p>
 * Les images doivent se trouver dans un jar, et le jar dans le classpth! <br>
 * Le jar doit contenir le folder ressources. A l'intérieur du folder ressource doit se trouver les images aux formats (jpg, voir mieux png pour la transparence)
 * </p>
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

	}
