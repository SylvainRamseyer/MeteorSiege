
package meteorsiege.GameData;

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
			this.set(freePlaceQueue.poll(), item);
			}

		}

	public void remove(int index)
		{
		this.getAndSet(index, null);
		freePlaceQueue.add(index);
		}

	public void draw(Graphics g)
		{
		/*
		for(int i = 0; i < this.length(); i++)
			{
			if (this.get(i) != null)
				{
				(this.get(i).;
				}
			}
		*/
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private ConcurrentLinkedQueue<Integer> freePlaceQueue;
	}
