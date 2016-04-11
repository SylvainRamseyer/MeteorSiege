/**
 * Classe fournissant une structure pour gérer les
 */

package ch.hearc.p2.structure.ennemies;

public class ObjectsStructure
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public ObjectsStructure()
		{
		objectArray = new Object[500];
		}

	public ObjectsStructure(int size)
		{
		objectArray = new Object[size];
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public int getSize()
		{
		return objectArray.length;
		}

	public synchronized boolean add(Object object)
		{
		boolean placeFound = false;
		int index = 0;

		while(!placeFound && index < objectArray.length)
			{
			placeFound = objectArray[index] == null;

			if (!placeFound)
				{
				index++;
				}
			}

		if (placeFound)
			{
			objectArray[index] = object;
			}

		return placeFound;
		}

	public synchronized boolean remove(Object object)
		{
		boolean objectFound = false;
		int index = 0;

		while(!objectFound && index < objectArray.length)
			{
			objectFound = objectArray[index] == object;

			if (!objectFound)
				{
				index++;
				}
			}

		if (objectFound)
			{
			objectArray[index] = null;
			}

		return objectFound;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public synchronized Object getAtIndex(int index)
		{
		if (index >= 0 && index < objectArray.length) { return objectArray[index]; }
		return null;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private Object[] objectArray;
	}
