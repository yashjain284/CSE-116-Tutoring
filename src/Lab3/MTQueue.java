package Lab3;

import java.util.concurrent.Semaphore;

public class MTQueue
{
	// allow only one thread at a time to use this queue
	private Semaphore sem = new Semaphore(1);
	
	// define a static queue
	private java.util.Queue<String> statQ;
	
	public MTQueue()
	{
		// create the queue itself
		statQ = new java.util.LinkedList<String>();
	}

	// insert a String into the queue safely
	public void MTPut(String qe)
	{
		try
		{
			sem.acquire();			// get permission to proceed 
			statQ.offer(qe);		// insert the String into the queue
		}
		catch(InterruptedException ex)
		{			
		}
		finally						// no matter what happened
		{
			sem.release();			// release the permission
		}
	}

	// retrieve a String from the queue safely
	public String MTGet()
	{
		String retVal = new String();
		try
		{
			sem.acquire();			// get permission to proceed
			
			//Do stuff now with the Queue
									
			retVal = statQ.poll();	// retrieve the String from the queue
		}
		catch(InterruptedException ex)
		{			
		}
		finally						// no matter what happened
		{
			sem.release();			// release the permission
		}
		return retVal;
	}
}
