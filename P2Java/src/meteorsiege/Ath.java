
package meteorsiege;

import org.newdawn.slick.Graphics;

import meteorsiege.gameitems.Station;

public class Ath
	{


	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public Ath(Station station)
		{
		super();
		this.station = station;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	public void draw(Graphics g)
		{
		drawLife(g);
		drawShilde(g);
		drawScore(g);
		drawMonney(g);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	private void drawLife(Graphics g)
		{
		// TODO dessiner la barre de vie
		}

	private void drawShilde(Graphics g)
		{
		// TODO dessiner la barre du bouclier
		}

	private void drawScore(Graphics g)
		{
		// TODO dessiner le Score
		}

	private void drawMonney(Graphics g)
		{
		// TODO dessiner la quantité d'argent du joueur
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private Station station;

	}
