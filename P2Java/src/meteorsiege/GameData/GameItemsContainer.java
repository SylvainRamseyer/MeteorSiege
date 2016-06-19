
package meteorsiege.gamedata;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReferenceArray;


/**
 * @author Julien M'Poy, Sylvain Ramseyer et Axel Roy<br>
 *
 * <h1>
 * Description
 * </h1>
 *
 * <p>
 * classe container de taille fixe d�fini lors de la construction. ThreadSafe et travaille sur les r�f�rences de mani�re atomique
 * </p>
 *
 * <p>
 * H�rit� de la classe AtomicReferenceArray qui poss�de les avantages de rendre
 * atomique l'acc�s aux r�f�rences du container.
 * </p>
 *
 * <p>
 * *****************************************************<br>
 * ATTENTION! les items contenu doivent etre ThreadSafe!<br>
 * *****************************************************<br>
 * </p>
 *
 * <p>
 * les cases vides sont repr�sent�es par null
 * </p>
 *
 * <p>
 * <b>pour ajouter, supprimer des �l�ments, il est fortement conseill� d'utiliser les m�thodes sp�cialis�es
 * car cette classe poss�de l'avantage d'avoir une ConcurrentLinkedQueue avec les index libres
 * du tableau.</b>
 * <br>
 * si vous n'utilisez pas les m�thodes suivantes pour alt�rer le tableau, la queue des index libres ne
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

	/**
	 * Construit une ConcurrentLinkedQueue dans laquelle seront m�moris�s les emplacements libres de la collection
	 * @param size : taille fixe de la collection
	 */
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
	 * ajoute un item � un emplacement libre et garde � jour la queue des emplacements libres
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
	 * met � null la r�f�rence sp�cifi�e par l'index et garde � jour la queue des emplacements libres
	 * @param index de l'item � supprimer du container
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
	 * met � null toutes les cases du container et respectivement � jour la queue des places libres
	 */
	public void clear()
		{
		freePlaceQueue.clear();
		for(int i = 0; i < this.length(); i++)
			{
			this.remove(i);
			freePlaceQueue.add(i);
			}
		}

	/*
	public void draw(Graphics g)
		{
		// TODO: Faire en sorte que le container se dessine lui m�me tout seul en entier.
		// impossible pour le moment car ne poss�de pas le context openGL
		}
	*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	// Tools
	private ConcurrentLinkedQueue<Integer> freePlaceQueue;
	}
