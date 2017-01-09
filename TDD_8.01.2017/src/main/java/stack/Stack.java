package main.java.stack;

public class Stack {
	private int currentSize = 0;
	private int maxSize;
	private int[] values;

	public Stack (int maxSize)
	{
		this.maxSize = maxSize;
		values = new int[maxSize];
	}
	
	public boolean isEmpty()
	{
		return currentSize == 0;
	}
	
	public void push(int i) throws StackOutOfBoundsException
	{
		if(currentSize == maxSize)
		{
			throw new StackOutOfBoundsException();
		}
		
		values[currentSize++] = i;
	}
	
	public int pop() throws EmptyStackException
	{
		if (isEmpty())
		{
			throw new EmptyStackException();			
		}
		return values[--currentSize];
	}

	public void clear() 
	{
		values = new int[maxSize];
		currentSize = 0;
		
	}

	public int getSize() {
	
		return currentSize;
	}	
	
}

