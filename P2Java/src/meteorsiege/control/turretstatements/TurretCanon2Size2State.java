
package meteorsiege.control.turretstatements;

import org.newdawn.slick.Image;

import meteorsiege.control.Upgrader;
import meteorsiege.gameitems.turret.TurretCanon2Size2;
import meteorsiege.tools.ImageMagasin;


/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * état avec 2 tourelles et de taille 2
 * </p>
 */
public class TurretCanon2Size2State implements TurretStatementInteface
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * action lorsque l'on rentre dans cet état (ordonne la mise à jour de la tourelle de la station)
	 * @param upgrader : organisme qui gère les états
	 */
	public TurretCanon2Size2State(Upgrader upgrader)
		{
		super();
		upgrader.setTurret(new TurretCanon2Size2(upgrader.getCenterStationX(), upgrader.getCenterStationY(), upgrader.getTurretDirection()));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * ne fait rien car pas d'état suivant
	 */
	@Override
	public void upgradeNbCanon(Upgrader upgrader)
		{
		// no next state
		}

	/**
	 * ne fait rien car pas d'�tat suivant
	 */
	@Override
	public void upgradeSizeCanon(Upgrader upgrader)
		{
		// no next state
		}

	@Override
	public Image getImage()
		{
		return ImageMagasin.Turret3SP;
		}
	}

