
package meteorsiege.gamedata;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReferenceArray;

import org.newdawn.slick.Graphics;

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

	public void add(E item)
		{
		if (!freePlaceQueue.isEmpty())
			{
			this.getAndSet(freePlaceQueue.poll(), item);
			}
		}

	public void remove(int index)
		{
		// (if)securiter dans le cas ou deux thread reset le meme index pour ne pas
		// l'ajouter deux fois dans la queue des place libre
		if (this.getAndSet(index, null) != null)
			{
			freePlaceQueue.add(index);
			}
		}

	public void clear()
		{
		for(int i = 0; i < this.length(); i++)
			{
			this.remove(i);
			}
		}

	public void draw(Graphics g)
		{
		// TODO: Faire en sorte que le container se dessine lui même tout seul en entier.
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private ConcurrentLinkedQueue<Integer> freePlaceQueue;
	}
