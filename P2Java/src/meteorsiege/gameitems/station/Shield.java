
package meteorsiege.gameitems.station;

import org.newdawn.slick.Graphics;


/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * Bouclier de la station. absorbe des dégats tant qu'il n'est pas
 * vide une fois vide il revoie les dégats à la station. <br>
 * se recharche sur le temps
 * </p>
 */
public class Shield
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * @param life : quantitée de point de dégats que le bouclier peut absorber
	 * @param regen : vitesse de régénaration de la vie du bouclier
	 */
	public Shield(double life, double regen)
		{
		super();
		this.life = life;
		this.maxLife = life;
		this.regen = regen;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	/**
	 * pour faire subire des dégats au bouclier.<br>
	 * si il est vide(vie = 0) il retourne le reste de dégats
	 * @param damage : quantitée de dégats subit
	 * @return : le reste de dégats que le bouclier n'a pas pu absorber
	 */
	public double takeDamage(double damage)
		{
		life -= damage;
		if (life < 0)
			{
			double unabsorbedDamage = -life;
			life = 0;
			return unabsorbedDamage;
			}
		else
			{
			return 0;
			}
		}

	/**
	 * améliore la quantitée de vie maximal
	 * @param value : quantitée de point de vie ajouté
	 */
	public void upgradeLife(double value)
		{
		maxLife += value;
		life += value;
		}

	/**
	 * améliore la vitesse de régénération par seconde
	 * @param value : quantitée de point de vie ajouté par seconde
	 */
	public void upgradeRegen(double value)
		{
		regen += value;
		}

	/**
	 * régénaire la vie du bouclier
	 * @param deltaTime : delta de temps entre deux regen pour s'éffectuer de manière régulière
	 */
	public void regen(int deltaTime)
		{
		if (life < maxLife)
			{
			life += (double)deltaTime / 1000 * regen;
			}
		else
			{
			life = maxLife;
			}

		}

	/**
	 * <b>Pas encore implémenté</b> effet visuel du bouclier autours de la station
	 * @param g : contexte graphique
	 */
	public void draw(Graphics g)
		{
		// TODO dessiner l'effet du bouclier
		if (life <= 0)
			{
			// actif
			}
		else
			{
			// détruit
			}
		}

	/**
	 * redonne toute la vie au bouclier
	 */
	public void reset()
		{
		this.life = this.maxLife;
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	public void setCapacity(double value)
		{
		this.maxLife = value;
		}

	public void setRegen(double regen)
		{
		this.regen = regen;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	public double getLife()
		{
		return life;
		}

	public double getCapacity()
		{
		return maxLife;
		}

	public double getRegen()
		{
		return regen;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private double life;
	private double maxLife;
	private double regen;

	}
