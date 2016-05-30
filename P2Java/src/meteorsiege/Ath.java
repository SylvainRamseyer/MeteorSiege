
package meteorsiege;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import meteorsiege.gameitems.Station;
import meteorsiege.tools.Config;

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
		// Calcul de la vie
		double life = station.getLife();
		double alpha = station.getLife() / Config.DEFAULT_START_LIFE;
		Color color = g.getColor();
		g.setLineWidth(4);

		g.setColor(Color.green);
		float lineWidth = g.getLineWidth();
		float minAngle = 135;
		float maxAngle = 225;
		float angle = (float)(alpha * (maxAngle - minAngle));
		g.drawArc(station.getX() - Config.ATH_LIFE_OFFSET, station.getY() - Config.ATH_LIFE_OFFSET, station.getWidth() + 2 * Config.ATH_LIFE_OFFSET, station.getHeight() + 2 * Config.ATH_LIFE_OFFSET, minAngle, minAngle + angle);

		g.setColor(color);
		g.setLineWidth(lineWidth);
		}

	private void drawShield(Graphics g)
		{
		// TODO dessiner la barre du bouclier
		double alpha = station.getShield() / station.getShieldCapacity();
		float minAngle = 315;
		float maxAngle = 405;
		float angle = (float)(alpha * (maxAngle - minAngle));

		Color color = g.getColor();
		g.setLineWidth(4);

		g.setColor(Color.blue);
		float lineWidth = g.getLineWidth();
		g.drawArc(station.getX() - Config.ATH_LIFE_OFFSET, station.getY() - Config.ATH_LIFE_OFFSET, station.getWidth() + 2 * Config.ATH_LIFE_OFFSET, station.getHeight() + 2 * Config.ATH_LIFE_OFFSET, minAngle, minAngle + angle);

		g.setColor(color);
		g.setLineWidth(lineWidth);
		}

	private void drawScore(Graphics g)
		{
		// TODO dessiner le Score
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Score : ");
		stringBuilder.append(station.getMoney());
		stringBuilder.append(" pts");
		g.drawString(stringBuilder.toString(), 25, 50);
		}

	private void drawMoney(Graphics g)
		{
		// TODO dessiner la quantité d'argent du joueur
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Money : ");
		stringBuilder.append(station.getMoney());
		stringBuilder.append(" $");
		g.drawString(stringBuilder.toString(), 25, 25);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private Station station;
	}
