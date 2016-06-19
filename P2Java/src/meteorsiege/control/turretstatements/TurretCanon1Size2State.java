
package meteorsiege.control.turretstatements;

import org.newdawn.slick.Image;

import meteorsiege.control.Upgrader;
import meteorsiege.gameitems.turret.TurretCanon1Size2;
import meteorsiege.tools.ImageMagasin;


/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * état avec 1 tourrelle et de taille 2
 * </p>
 */
public class TurretCanon1Size2State implements TurretStatementInteface
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	/**
	 * action lorsque l'on rentre dans cet état (ordonne la mise à jours de la tourelle station)
	 * @param upgrader : organisme qui gère les états
	 */
	public TurretCanon1Size2State(Upgrader upgrader)
		{
		super();
		upgrader.setTurret(new TurretCanon1Size2(upgrader.getCenterStationX(), upgrader.getCenterStationY(), upgrader.getTurretDirection()));

		// TODO delet sysout
		System.out.println("[TurretCanon1Size2State] turret upgraded");
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/


	/**
	 * upgrade le nombre de canons de la tourelle<br>
	 * next State : {@link TurretCanon2Size2State}<br>
	 * @param upgrader : organisme qui gère les états
	 */
	@Override
	public void upgradeNbCanon(Upgrader upgrader)
		{
		upgrader.setTurretState(new TurretCanon2Size2State(upgrader));
		}

	/**
	 * Tante d'upgrade la taille des canons de la tourelle<br>
	 * next State : {@link TurretCanon1Size3State} <br>
	 * @param upgrader : organisme qui gère les états
	 */
	@Override
	public void upgradeSizeCanon(Upgrader upgrader)
		{
		upgrader.setTurretState(new TurretCanon1Size3State(upgrader));
		}

	/**
	 * @return l'image qui représente l'état
	 */
	@Override
	public Image getImage()
		{
		return ImageMagasin.Turret2P;
		}
	}

