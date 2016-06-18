
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

	public void upgradeLife(double value)
		{
		maxLife += value;
		life += value;
		}

	public void upgradeRegen(double value)
		{
		regen += value;
		}

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
