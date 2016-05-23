
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
		drawShield(g);
		drawScore(g);
		drawMoney(g);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	private void drawLife(Graphics g)
		{
		// TODO dessiner la barre de vie
		//		g.drawArc(100, 100, 100, 100, 0, 270);
		}

	private void drawShield(Graphics g)
		{
		// TODO dessiner la barre du bouclier
		}

	private void drawScore(Graphics g)
		{
		// TODO dessiner le Score
		}

	private void drawMoney(Graphics g)
		{
		// TODO dessiner la quantité d'argent du joueur
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private Station station;
	}
