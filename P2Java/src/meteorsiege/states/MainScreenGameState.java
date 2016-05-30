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
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import meteorsiege.tools.Config;
import meteorsiege.tools.ImageMagasin;

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
		upgradeCircleInit();
		}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
		{
		// Titre du jeu
		int gameWidth = Config.getGameWidth();
		titleFont.drawString(gameWidth / 2 - TITLELENGTH / 2, TOPTITLE, "Meteor Siege");

		// Menu
		drawMenu(g);

		// Score et argent
		drawInfos(g);

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

		if (cercleLv2P.contains(x, y))
			{
			if (instancePlayGame.getUpgrader().upgradeTurretCanonSize())
				{

				} else {

				}
			}

		if (cercleLv2S.contains(x, y))
			{
			if (instancePlayGame.getUpgrader().upgradeTurretNbCanon())
				{

				} else {

				}
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
	private void upgradeCircleInit()
		{
		int gameHeight = Config.getGameHeight();
		int gameWidth = Config.getGameWidth();
		int imageWidth = ImageMagasin.Turret1.getWidth();
		int imageHeight = ImageMagasin.Turret1.getHeight();
		circleRadius = imageWidth / 2 - 3;

		posLevel1Top = gameHeight / 4;
		posLevel1Left = gameWidth / 3 * 2 - imageWidth / 2;

		posLevel2Top = gameHeight / 2;
		posLevel2Left1 = posLevel1Left - imageWidth - imageWidth / 2;
		posLevel2Left2 = posLevel1Left + imageWidth + imageWidth / 2;

		posLevel3Top = gameHeight / 4 * 3;
		posLevel3Left1 = posLevel2Left1 - imageWidth;
		posLevel3Left2 = posLevel1Left;
		posLevel3Left3 = posLevel2Left2 + imageWidth + imageWidth / 2;

		// Certaines valeurs sont en dur car elles sont dues au correction de taille d'images, traité au cas par cas
		cercleLv1 = new Circle(posLevel1Left + imageWidth / 2, posLevel1Top + ((imageHeight + 15) / 2), circleRadius);

		cercleLv2S = new Circle(posLevel2Left1 + imageWidth / 2, posLevel2Top + ((imageHeight + 20) / 2), circleRadius);
		cercleLv2P = new Circle(posLevel2Left2 + imageWidth / 2, posLevel2Top + ((imageHeight + 20) / 2), circleRadius);

		cercleLv3S = new Circle(posLevel3Left1 + imageWidth / 2, posLevel3Top + ((imageHeight + 20) / 2), circleRadius);
		cercleLv3PS = new Circle(posLevel3Left2 + imageWidth / 2, posLevel3Top + ((imageHeight + 20) / 2), circleRadius);
		cercleLv3P = new Circle(posLevel3Left3 + imageWidth / 2, posLevel3Top + ((imageHeight + 30) / 2), circleRadius);

		// Positionnement des textes pour les prix d'améliorations
		posTextLv1Top = (int)(posLevel1Top + imageHeight + SPACINGTEXTUPGRADE);
		posTextLv2Top = (int)(posLevel2Top + imageHeight + SPACINGTEXTUPGRADE);
		posTextLv3Top = (int)(posLevel3Top + imageHeight + SPACINGTEXTUPGRADE);

		posTextLv1Left = (int)(posLevel1Left + imageWidth / 2 - 5);

		posTextLv2SLeft = (int)(posLevel2Left1 + imageWidth / 2 - 20);
		posTextLv2PLeft = (int)(posLevel2Left2 + imageWidth / 2 - 20);

		posTextLv3SLeft = (int)(posLevel3Left1 + imageWidth / 2 - 24);
		posTextLv3PLeft = (int)(posLevel3Left2 + imageWidth / 2 - 24);
		posTextLv3PSLeft = (int)(posLevel3Left3 + imageWidth / 2 - 24);


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

	private void drawUpgrades(Graphics g)
	{
		g.drawImage(ImageMagasin.Turret1, posLevel1Left, posLevel1Top);

		g.drawImage(ImageMagasin.Turret2S, posLevel2Left1, posLevel2Top - 7);
		g.drawImage(ImageMagasin.Turret2P, posLevel2Left2, posLevel2Top - 10);

		// Décalages manuels en hauteur car les images sont légèrement plus grandes
		g.drawImage(ImageMagasin.Turret3S, posLevel3Left1, posLevel3Top + 2);
		g.drawImage(ImageMagasin.Turret3SP, posLevel3Left2, posLevel3Top - 7);
		g.drawImage(ImageMagasin.Turret3P, posLevel3Left3, posLevel3Top - 22);

		g.drawString("0", posTextLv1Left, posTextLv1Top);

		g.drawString("2000", posTextLv2SLeft, posTextLv2Top);
		g.drawString("2000", posTextLv2PLeft, posTextLv2Top);

		g.drawString("10000", posTextLv3SLeft, posTextLv3Top);
		g.drawString("10000", posTextLv3PSLeft, posTextLv3Top);
		g.drawString("10000", posTextLv3PLeft, posTextLv3Top);
		}

	private void drawInfos(Graphics g)
		{
		g.drawString("Statistiques", scoreLeft , scoreTop);
		g.drawString("Argent : " + instancePlayGame.getStation().getMoney(), scoreLeft , scoreTop + 20);
		g.drawString("Score : " + instancePlayGame.getStation().getScore(), scoreLeft , scoreTop + 40);

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
		titleFont = new TrueTypeFont(font, true);

		font = new Font("Verdana", Font.BOLD, 30);
		menuFont = new TrueTypeFont(font, true);
		}

	private void scorePlacementInit()
		{
		scoreLeft = LEFTMENUSTART + RECTANGLETEXTWIDTH + SPACINGLEFTSCORE;
		scoreTop = (int)menuResume.getY();
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	// Global
	public static final int ID = 1; 					//Doit être unique. On pourrait le générer depuis l'identifiant de la classe

	// Upgrade
	private static final int SPACINGTEXTUPGRADE = 10;

	// Score
	private static final int SPACINGLEFTSCORE = 50;

	// Title
	private static final int TOPTITLE = 20;
	private static final int TITLELENGTH = 320;

	// Menu
	private static final int radius = 10;
	private static final int LEFTMENUSTART = 50;
	private static final int RECTANGLETEXTWIDTH = 210;
	private static final int RECTANGLETEXTHEIGHT = 40;
	private static final int RECTANGLEOFFSET = 10;

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private StateBasedGame game;
	private PlayGameState instancePlayGame;
	private TrueTypeFont titleFont;
	private TrueTypeFont menuFont;
	private GameContainer container;

	// Menu
	private Rectangle menuResume;
	private Rectangle menuNew;
	private Rectangle menuQuit;

	// Scores
	private int scoreTop;
	private int scoreLeft;

	// Upgrades
	private Circle cercleLv1;
	private Circle cercleLv2S;
	private Circle cercleLv2P;
	private Circle cercleLv3P;
	private Circle cercleLv3PS;
	private Circle cercleLv3S;

	private int posTextLv1Left;
	private int posTextLv2PLeft;
	private int posTextLv2SLeft;
	private int posTextLv3PLeft;
	private int posTextLv3PSLeft;
	private int posTextLv3SLeft;

	private int posTextLv1Top;
	private int posTextLv2Top;
	private int posTextLv3Top;

	private float posLevel1Top;
	private float posLevel1Left;

	private float posLevel2Top;
	private float posLevel2Left1;
	private float posLevel2Left2;

	private float posLevel3Top;
	private float posLevel3Left1;
	private float posLevel3Left2;
	private float posLevel3Left3;

	private float circleRadius;
	}
