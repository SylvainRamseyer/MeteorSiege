
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
 * Bouclier de la station. absorbe des d�gats tant qu'il n'est pas
 * vide une fois vide il revoie les d�gats � la station. <br>
 * se recharche sur le temps
 * </p>
 */
public class Shield
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * @param life : quantit�e de point de d�gats que le bouclier peut absorber
	 * @param regen : vitesse de r�g�naration de la vie du bouclier
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
	 * pour faire subire des d�gats au bouclier.<br>
	 * si il est vide(vie = 0) il retourne le reste de d�gats
	 * @param damage : quantit�e de d�gats subit
	 * @return : le reste de d�gats que le bouclier n'a pas pu absorber
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
	 * am�liore la quantit�e de vie maximal
	 * @param value : quantit�e de point de vie ajout�
	 */
	public void upgradeLife(double value)
		{
		maxLife += value;
		life += value;
		}

	/**
	 * am�liore la vitesse de r�g�n�ration par seconde
	 * @param value : quantit�e de point de vie ajout� par seconde
	 */
	public void upgradeRegen(double value)
		{
		regen += value;
		}

	/**
	 * r�g�naire la vie du bouclier
	 * @param deltaTime : delta de temps entre deux regen pour s'�ffectuer de mani�re r�guli�re
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
	 * <b>Pas encore impl�ment�</b> effet visuel du bouclier autours de la station
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
			// d�truit
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
