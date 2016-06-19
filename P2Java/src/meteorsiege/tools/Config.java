
package meteorsiege.tools;

/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * Classe contenant toute la configuration par défaut pour l'application majoritairement composée de constantes
 * </p>
 */
public class Config
	{


	private static int gameWidth;
	private static int gameHeight;

	/**
	 * nombre de frame par seconde (calculs et rendu)
	 */
	public static final int FRAMERATE = 100;

	/**
	 * taille du container d'ennemis (ennemis max sur l'aire de jeu)
	 */
	public static final int SIZE_ENNEMIS_CONTAINER = 100000;

	/**
	 * taille du container de projectiles (ennemis max sur l'aire de jeu)
	 */
	public static final int SIZE_PROJECTILS_CONTAINER = 100000;


	// player default start settings
	//////////////////////////////////////////////////////////////

	/**
	 * vitesse des projectiles par défaut
	 */
	public static final float DEFAULT_PROJECTILS_SPEED = 0.7f;

	/**
	 * quantité de vie de départ du joueur
	 */
	public static final double DEFAULT_START_LIFE = 1000;

	/**
	 * quantité de bouclier de départ
	 */
	public static final double DEFAULT_START_SHIELD = 1000;

	/**
	 * vitesse de régénération par seconde par défaut
	 */
	public static final double DEFAULT_START_SHIELD_REGEN = 50;

	/**
	 * temps entre chaque projectile tiré par défaut
	 */
	public static final double DEFAULT_START_SHOOT_DELAY = 0.1;

	/**
	 * multiplicateur de dégats par défaut de la station
	 */
	public static final double DEFAULT_START_DAMAGE_MULTIPLIER = 1;

	// money
	/////////////////////////////////////////////////////////////

	/**
	 * Multiplicateur de gain d'argent par défaut pour équilibrage
	 */
	public static final double MONEY_MULTIPLIER = 1;

	// uprgrade starting price
	////////////////////////////////////////////////////////////
	/**
	 * prix pour augmenter la capacité du bouclier (coût pour passer au prochain niveau = lvl*prix)
	 */
	public static final int UPGRADE_SHIELD_INIT_PRICE = 100;

	/**
	 * prix pour augmenter le multiplicateur de dégats de la station (coût pour passer au prochain niveau = lvl*prix)
	 */
	public static final int UPGRADE_POWER_INIT_PRICE = 100;

	/**
	 * prix pour reduire le temps entre chaque tir de la station (coût pour passer au prochain niveau = lvl*prix)
	 */
	public static final int UPGRADE_FIRERATE_INIT_PRICE = 100;

	/**
	 * prix pour augmenter la vitesse des projectiles tirés par la station (coût pour passer au prochain niveau = lvl*prix)
	 */
	public static final int UPGRADE_PROJECTILS_SPEED_INIT_PRICE = 100;

	/**
	 * prix pour augmenter la vitesse de régénération par seconde du bouclier de la station (coût pour passer au prochain niveau = lvl*prix)
	 */
	public static final int UPGRADE_SHIELD_REGEN_INIT_PRICE = 100;

	/**
	 * prix pour monter d'un level dans l'arbre d'évolution des tourelles de la station (coût pour passer au prochain niveau = lvl*prix)
	 */
	public static final int UPGRADE_TURRET_INIT_PRICE = 1000;

	// upgrade level max
	/**
	 * niveau maximum d'évolution pour la tourelle de la station
	 */
	public static final int UPGRADE_TURRET_MAX_LEVEL = 3;

	// upgrade amount per lvl in %

	/**
	 * Capacité du bouclier de la station : pourcentage d'augmentation par niveau d'amélioration
	 */
	public static final double UPGRADE_SHIELD_AMOUNT = 10;

	/**
	 * vitesse de régénaration de la station : pourcentage d'augmentation par niveau d'amélioration
	 */
	public static final double UPGRADE_SHIELD_REGEN_AMOUNT = 50;

	/**
	 * Multiplicateur de dégats de la station : pourcentage d'augmentation par niveau d'amélioration
	 */
	public static final double UPGRADE_POWER_AMOUNT = 5;

	/**
	 * vitesse de tir de la station : pourcentage d'augmentation par niveau d'amélioration
	 */
	public static final double UPGRADE_FIRERATE_AMOUNT = 5;

	/**
	 * vitesse des projectiles tirés par la station : pourcentage d'augmentation par niveau d'amélioration
	 */
	public static final double UPGRADE_PROJECTILS_SPEED_AMOUNT = 1;

	// turrets
	/**
	 * dégats de base de la tourelle avant prise en compte des différents multiplicateurs
	 */
	public static final int TURRET_BASE_DAMAGE = 10;

	// settler
	/**
	 * vitesse de peuplage de l'aire de jeu par le settler en ms
	 */
	public static final int SETTLE_DELAY = 10;

	/**
	 * la zone de spawn définie moins cet offset pour ne pas donner directement au borderguard les gros items
	 */
	static public final float SETTLE_OFFSET = 150;

	/**
	 * vitesse max des ennemis
	 */
	static public final float MAX_ENNEMIS_SPEED = 0.5f;

	/**
	 * vitesse max des ennemis
	 */
	static public final float MIN_ENNEMIS_SPEED = 0.01f;

	// borderGuard
	/**
	 * zone de tolérance pour le BorderGuard (objectif ne pas voir disparaître les gros items alors qu'ils sont encore dans l'aire de jeu)
	 */
	public static final int BORDER_GUARD_TOLERANCE = 200;

	// ATH
	/**
	 * décalage pour mettre un espace entre la barre de vie et la station (rendu graphique)
	 */
	public static final int ATH_LIFE_OFFSET = 10;

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * @return donne la largeur de l'écran de jeu en pixel
	 */
	public static int getGameWidth()
		{
		return gameWidth;
		}

	/**
	 * set la largeur de l'écran de jeu en pixel
	 * @param gameWidth : largeur de l'écran de jeu en pixel
	 */
	public static void setGameWidth(int gameWidth)
		{
		Config.gameWidth = gameWidth;
		}

	/**
	 * @return donne la hauteur de l'écran de jeu en pixel
	 */
	public static int getGameHeight()
		{
		return gameHeight;
		}

	/**
	 * set la hauteur de l'écran de jeu en pixel
	 * @param gameHeight : hauteur de l'écran de jeu en pixel
	 */
	public static void setGameHeight(int gameHeight)
		{
		Config.gameHeight = gameHeight;
		}
	}
