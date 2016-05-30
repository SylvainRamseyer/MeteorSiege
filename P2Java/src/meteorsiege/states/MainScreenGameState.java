/**
 * Classe de présentation et de gestion du menu.
 * Positionnement implémenté de manière entièrement dynamique afin de gérer les résolutions allant de 1024px à 1920px de largeur.
 * Elle contient beaucoup d'attributs pour le positionnement afin d'éviter de recalculer la position de ceux ci
 * à chaque boucle de rendu.
 *
 */

package meteorsiege.states;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import meteorsiege.tools.Config;

public class MainScreenGameState extends BasicGameState
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException
		{
		this.game = game;
		this.container = container;
		Config.setGameHeight(container.getHeight());
		Config.setGameWidth(container.getWidth());

		fontsInit();
		menuRectangleInit();
		scorePlacementInit();
		statusPositionInit();
		upgradeRectangleInit();
		}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
		{
		// Titre du jeu
		int gameWidth = Config.getGameWidth();
		mainTitleFont.drawString(gameWidth / 2 - TITLELENGTH / 2, TOPTITLE, "Meteor Siege");

		// Menu
		drawMenu(g);

		// Score et argent
		drawInfos(g);

		// Status de la tourelle
		drawTurretStatus(g);

		// Upgrades
		drawUpgrades(g);
		}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
		{

		}

	public void setPlayGameInstance(PlayGameState playGameState)
		{
		this.instancePlayGame = playGameState;
		}

	@Override
	public void mousePressed(int button, int x, int y)
		{
		if (menuNew.contains(x, y))
			{
			instancePlayGame.resetGame();
			game.enterState(PlayGameState.ID);
			}
		if (menuResume.contains(x, y))
			{
			game.enterState(PlayGameState.ID);
			}

		if (menuQuit.contains(x, y))
			{
			container.exit();
			}

		if (upgradePowerStation.contains(x, y))
			{
			instancePlayGame.getUpgrader().upgradeDamage();
			}

		if (upgradeFireRate.contains(x, y))
			{
			instancePlayGame.getUpgrader().upgradeFireRate();
			}

		if (upgradeNbTurret.contains(x, y))
			{
			instancePlayGame.getUpgrader().upgradeTurretNbCanon();
			}

		if (upgradeShield.contains(x, y))
			{
			instancePlayGame.getUpgrader().upgradeShield();
			}

		if (upgradeTurretPower.contains(x, y))
			{
			instancePlayGame.getUpgrader().upgradeTurretCanonSize();
			}
		}

	@Override
	public int getID()
		{
		return ID;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	private void upgradeRectangleInit()
		{
		posTitleUpgradeLeft = scoreLeft;
		posTitleUpgradeTop = posTitleTurretStatusTop + IMAGEHEIGHT + 60;

		upgradeTurretPower = new Rectangle(posTitleUpgradeLeft, posTitleUpgradeTop + 60, RECTANGLEUPDATEWIDTH, RECTANGLEUPDATEHEIGHT);
		upgradeNbTurret = new Rectangle(posTitleUpgradeLeft, upgradeTurretPower.getY() + RECTANGLEUPDATEHEIGHT + UPGRADEMENUSPACING, RECTANGLEUPDATEWIDTH, RECTANGLEUPDATEHEIGHT);
		upgradeFireRate = new Rectangle(posTitleUpgradeLeft, upgradeNbTurret.getY() + RECTANGLEUPDATEHEIGHT + UPGRADEMENUSPACING, RECTANGLEUPDATEWIDTH, RECTANGLEUPDATEHEIGHT);
		upgradeShield = new Rectangle(posTitleUpgradeLeft, upgradeFireRate.getY() + RECTANGLEUPDATEHEIGHT + UPGRADEMENUSPACING, RECTANGLEUPDATEWIDTH, RECTANGLEUPDATEHEIGHT);
		upgradePowerStation = new Rectangle(posTitleUpgradeLeft, upgradeShield.getY() + RECTANGLEUPDATEHEIGHT + UPGRADEMENUSPACING, RECTANGLEUPDATEWIDTH, RECTANGLEUPDATEHEIGHT);
		}

	private void drawMenu(Graphics g)
		{
		int middleScreenHeight = Config.getGameHeight() / 2;

		g.setColor(Color.lightGray);
		g.drawRoundRect(menuResume.getMinX(), menuResume.getMinY(), menuResume.getWidth(), menuResume.getHeight(), radius);
		g.drawRoundRect(menuQuit.getMinX(), menuQuit.getMinY(), menuQuit.getWidth(), menuQuit.getHeight(), radius);
		g.drawRoundRect(menuNew.getMinX(), menuNew.getMinY(), menuNew.getWidth(), menuNew.getHeight(), radius);

		g.fillRoundRect(menuResume.getMinX(), menuResume.getMinY(), menuResume.getWidth(), menuResume.getHeight(), radius);
		g.fillRoundRect(menuNew.getMinX(), menuNew.getMinY(), menuNew.getWidth(), menuNew.getHeight(), radius);
		g.fillRoundRect(menuQuit.getMinX(), menuQuit.getMinY(), menuQuit.getWidth(), menuQuit.getHeight(), radius);

		menuFont.drawString(LEFTMENUSTART, middleScreenHeight - middleScreenHeight / 2, "Reprendre", Color.black);
		menuFont.drawString(LEFTMENUSTART, middleScreenHeight, "Nouveau jeu", Color.black);
		menuFont.drawString(LEFTMENUSTART, middleScreenHeight + middleScreenHeight / 2, "Quitter", Color.black);
		}

	private void drawTurretStatus(Graphics g)
		{
		titleFont.drawString(posTitleTurretStatusLeft, posTitleTurretStatusTop, "Status de la tourelle");
		g.drawImage(instancePlayGame.getUpgrader().getImage(), posTitleTurretStatusLeft, posTitleTurretStatusTop + 60);
		}

	private void drawUpgrades(Graphics g)
		{
		titleFont.drawString(posTitleUpgradeLeft, posTitleUpgradeTop, "Amélioration des statistiques");
		g.setColor(Color.lightGray);
		g.drawRoundRect(upgradePowerStation.getX(), upgradePowerStation.getY(), upgradePowerStation.getWidth(), upgradePowerStation.getHeight(), radius);
		g.drawRoundRect(upgradeFireRate.getX(), upgradeFireRate.getY(), upgradeFireRate.getWidth(), upgradeFireRate.getHeight(), radius);
		g.drawRoundRect(upgradeNbTurret.getX(), upgradeNbTurret.getY(), upgradeNbTurret.getWidth(), upgradeNbTurret.getHeight(), radius);
		g.drawRoundRect(upgradeShield.getX(), upgradeShield.getY(), upgradeShield.getWidth(), upgradeShield.getHeight(), radius);
		g.drawRoundRect(upgradeTurretPower.getX(), upgradeTurretPower.getY(), upgradeTurretPower.getWidth(), upgradeTurretPower.getHeight(), radius);


		g.fillRoundRect(upgradePowerStation.getX(), upgradePowerStation.getY(), upgradePowerStation.getWidth(), upgradePowerStation.getHeight(), radius);
		g.fillRoundRect(upgradeFireRate.getX(), upgradeFireRate.getY(), upgradeFireRate.getWidth(), upgradeFireRate.getHeight(), radius);
		g.fillRoundRect(upgradeNbTurret.getX(), upgradeNbTurret.getY(), upgradeNbTurret.getWidth(), upgradeNbTurret.getHeight(), radius);
		g.fillRoundRect(upgradeShield.getX(), upgradeShield.getY(), upgradeShield.getWidth(), upgradeShield.getHeight(), radius);
		g.fillRoundRect(upgradeTurretPower.getX(), upgradeTurretPower.getY(), upgradeTurretPower.getWidth(), upgradeTurretPower.getHeight(), radius);

		menuUpgradeFont.drawString(upgradeTurretPower.getX() + 10, upgradeTurretPower.getY() + 5, "Augmenter la puissance du canon", Color.black);
		menuUpgradeFont.drawString(upgradePowerStation.getX() + 10, upgradePowerStation.getY() + 5, "Augmenter la puissance", Color.black);
		menuUpgradeFont.drawString(upgradeFireRate.getX() + 10, upgradeFireRate.getY() + 5, "Réduire le délai rechargement", Color.black);
		menuUpgradeFont.drawString(upgradeNbTurret.getX() + 10, upgradeNbTurret.getY() + 5, "Augmenter le nombre de tourelles", Color.black);
		menuUpgradeFont.drawString(upgradeShield.getX() + 10, upgradeShield.getY() + 5, "Augmenter le bouclier", Color.black);
		}

	private void drawInfos(Graphics g)
		{
		titleFont.drawString(scoreLeft, scoreTop, "Statistiques");

		g.drawString("Argent : " + instancePlayGame.getStation().getMoney() + " $", scoreLeft, scoreTop + 2 * SCORELINESPACING);
		g.drawString("Score  : " + instancePlayGame.getStation().getScore() + " pts", scoreLeft, scoreTop + 3 * SCORELINESPACING);
		g.drawString("Vitesse de tir  : " + String.format("%.3f", instancePlayGame.getStation().getShootDelay()), scoreLeft, scoreTop + 4 * SCORELINESPACING);
		g.drawString("Puissance station : " + String.format("%.2f", instancePlayGame.getStation().getDamageMultiplier()), scoreLeft, scoreTop + 5 * SCORELINESPACING);
		g.drawString("Bouclier : " + String.format("%.2f", instancePlayGame.getStation().getShieldCapacity()), scoreLeft, scoreTop + 6 * SCORELINESPACING);
		}

	private void menuRectangleInit()
		{
		int gameHeight = Config.getGameHeight();
		int middleScreenHeight = gameHeight / 2;

		menuResume = new Rectangle(LEFTMENUSTART - RECTANGLEOFFSET, middleScreenHeight - middleScreenHeight / 2 - RECTANGLEOFFSET, RECTANGLETEXTWIDTH + 2 * RECTANGLEOFFSET, RECTANGLETEXTHEIGHT + 2 * RECTANGLEOFFSET);
		menuNew = new Rectangle(LEFTMENUSTART - RECTANGLEOFFSET, middleScreenHeight - RECTANGLEOFFSET, RECTANGLETEXTWIDTH + 2 * RECTANGLEOFFSET, RECTANGLETEXTHEIGHT + 2 * RECTANGLEOFFSET);
		menuQuit = new Rectangle(LEFTMENUSTART - RECTANGLEOFFSET, middleScreenHeight + middleScreenHeight / 2 - RECTANGLEOFFSET, RECTANGLETEXTWIDTH + 2 * RECTANGLEOFFSET, RECTANGLETEXTHEIGHT + 2 * RECTANGLEOFFSET);
		}

	private void fontsInit()
		{
		Font font = new Font("Verdana", Font.BOLD, 45);
		mainTitleFont = new TrueTypeFont(font, true);

		font = new Font("Verdana", Font.BOLD, 30);
		titleFont = new TrueTypeFont(font, true);

		font = new Font("Verdana", Font.BOLD, 25);
		menuFont = new TrueTypeFont(font, true);

		font = new Font("Verdana", Font.BOLD, 15);
		menuUpgradeFont = new TrueTypeFont(font, true);
		}

	private void scorePlacementInit()
		{
		scoreLeft = LEFTMENUSTART + RECTANGLETEXTWIDTH + SPACINGLEFTSCORE;
		scoreTop = (int)menuResume.getY() - 25;
		}

	private void statusPositionInit()
		{
		posTitleTurretStatusLeft = scoreLeft;
		posTitleTurretStatusTop = scoreTop + 8 * SCORELINESPACING;
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	// Global
	public static final int ID = 1; //Doit être unique. On pourrait le générer depuis l'identifiant de la classe

	// Upgrade
	private final int RECTANGLEUPDATEWIDTH = 300;
	private final int RECTANGLEUPDATEHEIGHT = 35;
	private static final int IMAGEHEIGHT = 140;
	private static final float UPGRADEMENUSPACING = 15;

	// Score
	private final int SPACINGLEFTSCORE = 50;
	private final int SCORELINESPACING = 20;

	// Title
	private final int TOPTITLE = 20;
	private final int TITLELENGTH = 320;

	// Menu
	private final int radius = 10;
	private final int LEFTMENUSTART = 50;
	private final int RECTANGLETEXTWIDTH = 210;
	private final int RECTANGLETEXTHEIGHT = 40;
	private final int RECTANGLEOFFSET = 10;

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private StateBasedGame game;
	private PlayGameState instancePlayGame;
	private TrueTypeFont mainTitleFont;
	private TrueTypeFont titleFont;
	private TrueTypeFont menuFont;
	private TrueTypeFont menuUpgradeFont;
	private GameContainer container;

	// Menu
	private Rectangle menuResume;
	private Rectangle menuNew;
	private Rectangle menuQuit;

	// Statistiques
	private int scoreTop;
	private int scoreLeft;

	// Infos tourelles
	private int posTitleTurretStatusLeft;
	private int posTitleTurretStatusTop;

	// Upgrades
	private int posTitleUpgradeLeft;
	private int posTitleUpgradeTop;
	private Rectangle upgradePowerStation;
	private Rectangle upgradeNbTurret;
	private Rectangle upgradeFireRate;
	private Rectangle upgradeShield;
	private Rectangle upgradeTurretPower;
	}
