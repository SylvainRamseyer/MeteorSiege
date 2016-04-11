
package ch.hearc.p2.structure.ennemies;

public class UseObjectsStructure
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
			ObjectsStructure structureObjet= new ObjectsStructure(50);

			Thread t1 = new Thread(new productAndConsumeThread(structureObjet), "Thread 1");
			Thread t2 = new Thread(new productAndConsumeThread(structureObjet), "Thread 2");

			t1.start();
			t2.start();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}

