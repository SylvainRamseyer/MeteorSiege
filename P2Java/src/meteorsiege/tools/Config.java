
package meteorsiege.tools;

public class Config
	{


	private static int gameWidth;
	private static int gameHeight;

	public static final int FRAMERATE = 100;
	public static final int SIZE_ENNEMIS_CONTAINER = 100000;
	public static final int SIZE_PROJECTILS_CONTAINER = 100000;
	public static final float DEFAULT_PROJECTILS_SPEED = 0.7f;

	// player default start settings
	public static final double DEFAULT_START_LIFE = 1000;
	public static final double DEFAULT_START_SHIELD = 1000;
	public static final double DEFAULT_START_SHIELD_REGEN = 50;
	public static final double DEFAULT_START_SHOOT_DELAY = 0.1;
	public static final double DEFAULT_START_DAMAGE_MULTIPLIER = 1;

	// money
	public static final double MONEY_MULTIPLIER = 1;

	// uprgrade starting price
	public static final int UPGRADE_SHIELD_INIT_PRICE = 100;
	public static final int UPGRADE_POWER_INIT_PRICE = 100;
	public static final int UPGRADE_FIRERATE_INIT_PRICE = 100;
	public static final int UPGRADE_PROJECTILS_SPEED_INIT_PRICE = 100;
	public static final int UPGRADE_SHIELD_REGEN_INIT_PRICE = 100;
	public static final int UPGRADE_TURRET_INIT_PRICE = 1000;

	// upgrade level max
	public static final int UPGRADE_TURRET_MAX_LEVEL = 3;

	// upgrade amount per lvl in %
	public static final double UPGRADE_SHIELD_AMOUNT = 10;
	public static final double UPGRADE_SHIELD_REGEN_AMOUNT = 50;
	public static final double UPGRADE_POWER_AMOUNT = 5;
	public static final double UPGRADE_FIRERATE_AMOUNT = 5;
	public static final double UPGRADE_PROJECTILS_SPEED_AMOUNT = 1;

	// turrets
	public static final int TURRET_BASE_DAMAGE = 10;

	// settler
	public static final int SETTLE_DELAY = 100;

	// ATH
	public static final int ATH_LIFE_OFFSET = 10;

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static int getGameWidth()
		{
		return gameWidth;
		}

	public static void setGameWidth(int gameWidth)
		{
		Config.gameWidth = gameWidth;
		}

	public static int getGameHeight()
		{
		return gameHeight;
		}

	public static void setGameHeight(int gameHeight)
		{
		Config.gameHeight = gameHeight;
		}

	public static final int BORDER_GUARD_TOLERANCE = 200;
	}
