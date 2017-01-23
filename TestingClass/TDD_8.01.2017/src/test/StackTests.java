import org.junit.Test;

import stack.EmptyStackException;
import stack.NegativeStackSizeException;
import stack.Stack;
import static org.junit.Assert.*;

import org.junit.Before;
import stack.StackOutOfBoundsException;

public class StackTests {

	private Stack stackWithMaxSize2;
	private Stack stackWithMaxSize0;

	@Before
	public void setUp() throws NegativeStackSizeException
	{
		stackWithMaxSize2 = new Stack(2);
		stackWithMaxSize0 = new Stack(0);
	}

	@Test
	public void givenEmptyStack_WhenCheckedForEmptiness_ThenTrueIsReturned()
	{
		assertTrue(stackWithMaxSize2.isEmpty());
	}

	@Test
	public void givenNotEmptyStack_WhenCheckedForEmptiness_ThenFalseIsReturned() throws StackOutOfBoundsException
	{
		stackWithMaxSize2.push(42);
		
		assertFalse(stackWithMaxSize2.isEmpty());
	}
	
	@Test (expected = EmptyStackException.class)
	public void givenEmptyStack_WhenPopping_ThenEmptyStackExceptionIsThrown() throws EmptyStackException
	{
		stackWithMaxSize2.pop();
	}
	
	@Test
	public void givenEmptyStack_WhenPushingOneElement_ThenThatElementIsReturnedWhenPopped() throws EmptyStackException, StackOutOfBoundsException {
		int expectedValue = 10;

		stackWithMaxSize2.push(expectedValue);

		assertEquals(expectedValue, stackWithMaxSize2.pop());
	}
	
	@Test
	public void givenNotEmptyStack_WhenPopping_ThenLastAddedValueIsReturned() throws EmptyStackException, StackOutOfBoundsException
	{	
		stackWithMaxSize2.push(10);
		stackWithMaxSize2.push(24);
		
		assertEquals(24, stackWithMaxSize2.pop());
	}
	
	@Test
	public void givenStackContains1Item_WhenPopping_ThenStackBecomesEmpty() throws EmptyStackException, StackOutOfBoundsException
	{
		stackWithMaxSize2.push(24);
		stackWithMaxSize2.pop();
		
		assertTrue(stackWithMaxSize2.isEmpty());
	}
	
	@Test
	public void givenStackWith2Elements_WhenPoppingSingleItem_ThenStackIsStillNotEmpty() throws EmptyStackException, StackOutOfBoundsException
	{
		stackWithMaxSize2.push(24);
		stackWithMaxSize2.push(12);
		stackWithMaxSize2.pop();
		
		assertFalse(stackWithMaxSize2.isEmpty());
	}

	@Test
	public void givenStackWith2Elements_WhenPoppingSecondItem_ThenFirstPushedValueIsReturned() throws EmptyStackException, StackOutOfBoundsException
	{
		stackWithMaxSize2.push(24);
		stackWithMaxSize2.push(12);
		stackWithMaxSize2.pop();
		
		assertEquals(24, stackWithMaxSize2.pop());
	}
	
	@Test
	public void givenNotEmptyStack_WhenClearIsUsed_ThenIsEmptyIsTrue() throws StackOutOfBoundsException
	{
		stackWithMaxSize2.push(10);
		stackWithMaxSize2.clear();
		
		assertTrue(stackWithMaxSize2.isEmpty());
	}	
	
	@Test
	public void givenEmptyStack_WhenGettingSize_Then0IsReturned()
	{
		assertEquals(0, stackWithMaxSize2.getSize());
	}
	
	@Test
	public void givenStackIsNotEmpty_WhenGettingSize_ThenExpectedValueIsReturned() throws StackOutOfBoundsException
	{
		stackWithMaxSize2.push(1);
		stackWithMaxSize2.push(12);
		
		assertEquals(2, stackWithMaxSize2.getSize());
	}
	
	@Test
	public void givenStackIsFullAndCleared_WhenPushing1Item_ThenSizeShouldBe1() throws StackOutOfBoundsException
	{
		stackWithMaxSize2.push(1);
		stackWithMaxSize2.push(2);
		stackWithMaxSize2.clear();
		stackWithMaxSize2.push(3);
		
		assertEquals(1, stackWithMaxSize2.getSize());
		
	}
	
	@Test (expected = StackOutOfBoundsException.class)
	public void givenStackIsFull_WhenPushing1Item_ThenExceptionIsThrown() throws StackOutOfBoundsException
	{
		stackWithMaxSize2.push(1);
		stackWithMaxSize2.push(2);
		stackWithMaxSize2.push(3);
	}
	
	@Test (expected = StackOutOfBoundsException.class)
	public void givenStackMaxSizeIs0_WhenPushingAnItem_ThenExceptionIsThrown() throws StackOutOfBoundsException
	{
		stackWithMaxSize0.push(17);
		
	}

	@Test (expected = NegativeStackSizeException.class)
	public void givenNewStackIsBeingCreated_WhenGivingItNegativeSize_ThenExceptionIsThrown() throws NegativeStackSizeException
	{
		Stack s = new Stack(-1);
	}
}
