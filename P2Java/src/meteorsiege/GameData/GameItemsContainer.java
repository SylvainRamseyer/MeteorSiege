
package meteorsiege.gamedata;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReferenceArray;

import org.newdawn.slick.Graphics;


/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * classe conteneur de taille fixe d�finit lors de la construction. ThreadSafe et travail atomic sur les r�f�rence
 * </p>
 *
 * <p>
 * H�rit� de la classe AtomicReferenceArray qui poss�de les avantage de rendre
 * atomique l'acc�s aux r�f�rence du conteneur.
 * </p>
 *
 * <p>
 * *****************************************************</br>
 * ATTENTION! les items contenu doivent etre ThreadSafe!</br>
 * *****************************************************</br>
 * </p>
 *
 * <p>
 * les cases vide sont repr�senter par null
 * </p>
 *
 * <p>
 * <b>pour ajouter, supprimer des �l�ments il est Fortement conseiller d'utiliser les m�todes sp�cialis�
 * car cette classe poss�de l'avantage d'avoir une ConcurrentLinkedQueue qui poss�de les indexes libre
 * du tableau.</b>
 * <br>
 * si vous n'utiliser pas les m�thodes suivante pour alt�rer le tableau la queue des indexes libre ne
 * sera plus � jour :<br>
 *    - public void add(E item)<br>
 *    - public void remove(int index)<br>
 *    - public void clear()<br>
 * </p>
 *
 * <p>
 * pour la consultation utilise le m�me fonctionnement que le parent
 * </p>
 */
public class GameItemsContainer<E> extends AtomicReferenceArray<E>
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public GameItemsContainer(E[] arg0)
		{
		super(arg0);
		}

	public GameItemsContainer(int size)
		{
		super(size);

		// cr�e une liste qui donner les index libre pour facilit� l'insertion de nouveau item
		freePlaceQueue = new ConcurrentLinkedQueue<Integer>();
		for(int i = 0; i < size; i++)
			{
			freePlaceQueue.add(i);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * ajoute un item � un emplacement libre et garde � jour la queux des emplacement libre
	 * @param item � stocker
	 */
	public void add(E item)
		{
		if (!freePlaceQueue.isEmpty())
			{
			this.getAndSet(freePlaceQueue.poll(), item);
			}
		}

	/**
	 * met � null la r�f�rence sp�cifi� par l'index et garde � jour la queux des emplacement libre
	 * @param index de l'item a supprimer du conteneur
	 */
	public void remove(int index)
		{
		// (if)securiter dans le cas ou deux thread reset le meme index pour ne pas
		// l'ajouter deux fois dans la queue des place libre
		if (this.getAndSet(index, null) != null)
			{
			freePlaceQueue.add(index);
			}
		}

	/**
	 * met a null toute les cases du conteneur
	 */
	public void clear()
		{
		for(int i = 0; i < this.length(); i++)
			{
			this.remove(i);
			}
		}

	public void draw(Graphics g)
		{
		// TODO: Faire en sorte que le container se dessine lui m�me tout seul en entier.
		// impossible pour le moment car ne poss�de pas le context openGL
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	// Tools
	private ConcurrentLinkedQueue<Integer> freePlaceQueue;
	}
