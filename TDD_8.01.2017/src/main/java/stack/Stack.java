package main.java.stack;

public class Stack {
	private int size = 0;
	private int maxSize = 2;
	private int[] values = new int[maxSize];

	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public void push(int i) throws StackOutOfBoundsException
	{
		if(size == maxSize)
		{
			throw new StackOutOfBoundsException();
		}
		
		values[size++] = i;
	}
	
	public int pop() throws EmptyStackException
	{
		if (isEmpty())
		{
			throw new EmptyStackException();			
		}
		return values[--size];
	}

	public void clear() 
	{
		size = 0;
	}

	public int getSize() {
	
		return size;
	}	
}

