
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
 * classe container de taille fixe défini lors de la construction. ThreadSafe et travaille sur les références de manière atomique
 * </p>
 *
 * <p>
 * Hérité de la classe AtomicReferenceArray qui possède les avantages de rendre
 * atomique l'accès aux références du container.
 * </p>
 *
 * <p>
 * *****************************************************<br>
 * ATTENTION! les items contenu doivent etre ThreadSafe!<br>
 * *****************************************************<br>
 * </p>
 *
 * <p>
 * les cases vides sont représentées par null
 * </p>
 *
 * <p>
 * <b>pour ajouter, supprimer des éléments, il est fortement conseillé d'utiliser les méthodes spécialisées
 * car cette classe possède l'avantage d'avoir une ConcurrentLinkedQueue avec les index libres
 * du tableau.</b>
 * <br>
 * si vous n'utilisez pas les méthodes suivantes pour altérer le tableau, la queue des index libres ne
 * sera plus à jour :<br>
 *    - public void add(E item)<br>
 *    - public void remove(int index)<br>
 *    - public void clear()<br>
 * </p>
 *
 * <p>
 * pour la consultation utilise le même fonctionnement que le parent
 * </p>
 */
public class GameItemsContainer<E> extends AtomicReferenceArray<E>
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * Construit une ConcurrentLinkedQueue dans laquelle seront mémorisés les emplacements libres de la collection
	 * @param size : taille fixe de la collection
	 */
	public GameItemsContainer(int size)
		{
		super(size);

		// crée une liste qui donner les index libre pour facilité l'insertion de nouveau item
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
	 * ajoute un item à un emplacement libre et garde à jour la queue des emplacements libres
	 * @param item à stocker
	 */
	public void add(E item)
		{
		if (!freePlaceQueue.isEmpty())
			{
			this.getAndSet(freePlaceQueue.poll(), item);
			}
		}

	/**
	 * met à null la référence spécifiée par l'index et garde à jour la queue des emplacements libres
	 * @param index de l'item à supprimer du container
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
	 * met à null toutes les cases du container et respectivement à jour la queue des places libres
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
		// TODO: Faire en sorte que le container se dessine lui même tout seul en entier.
		// impossible pour le moment car ne possède pas le context openGL
		}
	*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	// Tools
	private ConcurrentLinkedQueue<Integer> freePlaceQueue;
	}
