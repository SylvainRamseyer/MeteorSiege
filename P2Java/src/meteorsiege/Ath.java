
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
		if (life > 0)
			{
			double alpha = life / Config.DEFAULT_START_LIFE;
			float lineWidth = g.getLineWidth();
			float minAngle = 135;
			float maxAngle = 225;
			float angle = (float)(alpha * (maxAngle - minAngle));

			Color color = g.getColor();
			g.setLineWidth(4);

			g.setColor(Color.green);
			g.drawArc(station.getX() - Config.ATH_LIFE_OFFSET, station.getY() - Config.ATH_LIFE_OFFSET, station.getWidth() + 2 * Config.ATH_LIFE_OFFSET, station.getHeight() + 2 * Config.ATH_LIFE_OFFSET, minAngle, minAngle + angle);

			g.setColor(color);
			g.setLineWidth(lineWidth);
			}
		else
			{
			life = 0;
			}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Vie : ");
		stringBuilder.append((int)life);
		g.drawString(stringBuilder.toString(), 25, 75);
		}

	private void drawShield(Graphics g)
		{
		double alpha = station.getShield() / station.getShieldCapacity();
		float minAngle = 315;
		float maxAngle = 405;
		float angle = (float)(alpha * (maxAngle - minAngle));

		Color color = g.getColor();
		g.setLineWidth(4);

		g.setColor(Color.cyan);
		float lineWidth = g.getLineWidth();
		g.drawArc(station.getX() - Config.ATH_LIFE_OFFSET, station.getY() - Config.ATH_LIFE_OFFSET, station.getWidth() + 2 * Config.ATH_LIFE_OFFSET, station.getHeight() + 2 * Config.ATH_LIFE_OFFSET, minAngle, minAngle + angle);

		g.setColor(color);
		g.setLineWidth(lineWidth);

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Bouclier : ");
		stringBuilder.append((int)station.getShield());
		g.drawString(stringBuilder.toString(), 25, 100);
		}

	private void drawScore(Graphics g)
		{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Score : ");
		stringBuilder.append(station.getScore());
		stringBuilder.append(" pts");
		g.drawString(stringBuilder.toString(), 25, 50);
		}

	private void drawMoney(Graphics g)
		{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Argent : ");
		stringBuilder.append(station.getMoney());
		stringBuilder.append(" $");
		g.drawString(stringBuilder.toString(), 25, 25);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private Station station;
	}
