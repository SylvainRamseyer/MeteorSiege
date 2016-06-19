
package meteorsiege.gameitems.ennemies;

import java.util.Random;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

import meteorsiege.gameitems.GameItemInterface;
import meteorsiege.tools.Config;
import meteorsiege.tools.ImageMagasin;

/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * Ennemis de base du jeu (skin astéroid) ce déplace en ligne droite
 * et tourne sur lui-meme.
 * </p>
 */
public class Meteor extends Circle implements GameItemInterface
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * @param x : position en x d'apparition
	 * @param y : position en y d'apparition
	 * @param speedX : vitesse de déplacement en x
	 * @param speedY : vitesse de déplacement en x
	 * @param life : quantitée vie (quantitée de dégats que l'item peut subire)
	 * @param damage : quantitée de dégats que l'item inflige
	 */
	public Meteor(float x, float y, float speedX, float speedY, double life, double damage)
		{
		super(x, y, ImageMagasin.meteorBrown.getWidth() / 2);
		this.life = life;
		this.reward = (int)life;
		this.damage = damage;
		this.speedX = speedX;
		this.speedY = speedY;
		this.angleAlpha = new Random().nextFloat() * 360;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public synchronized void draw(Graphics g)
		{
		g.rotate(this.getCenterX(), this.getCenterY(), this.updateAngle());
		g.drawImage(ImageMagasin.meteorBrown, this.getCenterX() - (ImageMagasin.meteorBrown.getWidth() / 2), this.getCenterY() - ImageMagasin.meteorBrown.getHeight() / 2);
		g.resetTransform();
		}

	@Override
	public String toString()
		{
		return "Meteor [speedX=" + this.speedX + ", speedY=" + this.speedY + "] Position = " + x + ";" + y;
		}

	/**
	 * Met à jour l'angle pour l'annimation de la rotation
	 * @return le nouvelle angle de l'item
	 */
	public synchronized float updateAngle()
		{
		angleAlpha += 0.1;
		return angleAlpha % 360;
		}

	@Override
	public synchronized void nextPosition(int deltaTime)
		{
		this.setCenterX(this.getCenterX() + this.getSpeedX() * deltaTime);
		this.setCenterY(this.getCenterY() + this.getSpeedY() * deltaTime);
		}

	@Override
	public synchronized void onDestroy()
		{
		// TODO: exemple annimation de déstruction

		}

	@Override
	public synchronized double getDamage()
		{
		return damage;
		}

	@Override
	public synchronized boolean takeDamage(double value)
		{
		life -= value;
		return life <= 0;
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setSpeedX(float speedX)
		{
		this.speedX = speedX;
		}

	public void setSpeedY(float speedY)
		{
		this.speedY = speedY;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public float getSpeedX()
		{
		return this.speedX;
		}

	public float getSpeedY()
		{
		return this.speedY;
		}

	@Override
	public synchronized int getReward()
		{
		return (int)(reward * Config.MONEY_MULTIPLIER);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private float speedX;
	private float speedY;
	private float angleAlpha;
	private double life;
	private double damage;
	private int reward;
	}
