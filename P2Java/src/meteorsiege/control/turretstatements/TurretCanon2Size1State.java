
package meteorsiege.control.turretstatements;

import org.newdawn.slick.Image;

import meteorsiege.control.Upgrader;
import meteorsiege.gameitems.turret.TurretCanon2Size1;
import meteorsiege.tools.ImageMagasin;


/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * état avec 2 tourrelles et de taille 1
 * </p>
 */
public class TurretCanon2Size1State implements TurretStatementInteface
	{


	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * action lorsque l'on rentre dans cet état (ordonne la mise à jours de la tourelle station)
	 * @param upgrader : organisme qui gère les états
	 */
	public TurretCanon2Size1State(Upgrader upgrader)
		{
		super();
		upgrader.setTurret(new TurretCanon2Size1(upgrader.getCenterStationX(), upgrader.getCenterStationY(), upgrader.getTurretDirection()));

		// TODO delet sysout
		System.out.println("[TurretCanon2Size1State] turret upgraded");
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * upgrade le nombre de canons de la tourelle<br>
	 * next State : {@link TurretCanon3Size1State}<br>
	 * @param upgrader : organisme qui gère les états
	 */
	@Override
	public void upgradeNbCanon(Upgrader upgrader)
		{
		upgrader.setTurretState(new TurretCanon3Size1State(upgrader));
		}

	/**
	 * Tante d'upgrade la taille des canons de la tourelle<br>
	 * next State : {@link TurretCanon2Size2State} <br>
	 * @param upgrader : organisme qui gère les états
	 */
	@Override
	public void upgradeSizeCanon(Upgrader upgrader)
		{
		upgrader.setTurretState(new TurretCanon2Size2State(upgrader));
		}

	@Override
	public Image getImage()
		{
		return ImageMagasin.Turret2S;
		}
	}
