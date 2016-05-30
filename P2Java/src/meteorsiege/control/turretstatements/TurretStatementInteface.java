
package meteorsiege.control.turretstatements;

import org.newdawn.slick.Image;

import meteorsiege.control.Upgrader;

public interface TurretStatementInteface
	{
	public void upgradeNbCanon(Upgrader upgrader);
	public void upgradeSizeCanon(Upgrader upgrader);
	public Image getImage();
	}

