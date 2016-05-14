
package meteorsiege.gameitems;

import org.newdawn.slick.Graphics;

public class Shield
	{


	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public Shield(int life, int regen)
		{
		super();
		this.life = life;
		this.maxLife = life;
		this.regen = regen;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	public int takeDamage(int damage)
		{
		life -= damage;
		if (life < 0)
			{
			int unabsorbedDamage = -life;
			life = 0;
			return unabsorbedDamage;
			}
		else
			{
			return 0;
			}
		}

	public void upgradeLife(int value)
		{
		maxLife += value;
		life += value;
		}

	public void upgradeRegen(int value)
		{
		regen += value;
		}

	public void regen(int deltaTime)
		{
		// TODO r�g�neration du bouclier en fonction de la vitesse de r�g�n�ration
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
			// d�truit
			}
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	public void setCapacity(int value)
		{
		this.maxLife = value;
		}

	public void setRegen(int regen)
		{
		this.regen = regen;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	public int getLife()
		{
		return life;
		}

	public int getCapacity()
		{
		return maxLife;
		}

	public int getRegen()
		{
		return regen;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private int life;
	private int maxLife;
	private int regen;

	}
