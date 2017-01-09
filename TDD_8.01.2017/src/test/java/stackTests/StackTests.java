package test.java.stackTests;

import org.junit.Test;

import main.java.stack.EmptyStackException;
import main.java.stack.NegativeStackSizeException;
import main.java.stack.Stack;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import main.java.stack.StackOutOfBoundsException;

public class StackTests {

	private Stack sMax2;
	private Stack sMax3;
	private Stack sMax0;

	@Before
	public void setUp() throws NegativeStackSizeException
	{
		sMax2 = new Stack(2);
		sMax3 = new Stack(3);
		sMax0 = new Stack(0);
	}
	
	@After
	public void tearDown()
	{
		
	}
	// Arrange Act Assert
	@Test
	public void givenNewStack_WhenCheckForEmptiness_ThenTrueIsReturned()
	{
		assertTrue(sMax2.isEmpty());
	}

	@Test
	public void givenStackNotEmpty_WhenCheckingForEmptiness_ThenFalseIsReturned() throws StackOutOfBoundsException
	{
		sMax2.push(42);
		
		assertFalse(sMax2.isEmpty());
	}
	
	@Test (expected = EmptyStackException.class)
	public void givenEmptyStack_WhenPopping_ThenExceptionIsThrown() throws EmptyStackException
	{
		sMax2.pop();
	}
	
	@Test
	public void givenStackNotEmpty_WhenPopping_ThenValueIsReturned() throws EmptyStackException, StackOutOfBoundsException
	{
		sMax2.push(10);
		
		assertEquals(10, sMax2.pop());
	}
	
	@Test
	public void givenStackNotEmpty_WhenPopping_ThenLastAddedValueIsReturned() throws EmptyStackException, StackOutOfBoundsException
	{	
		sMax2.push(10);
		sMax2.push(24);
		
		assertEquals(24, sMax2.pop());
	}
	
	@Test
	public void givenStackContains1Item_WhenPopping_ThenStackBecomesEmpty() throws EmptyStackException, StackOutOfBoundsException
	{
		sMax2.push(24);
		sMax2.pop();
		
		assertTrue(sMax2.isEmpty());
	}
	
	@Test
	public void givenStackWith2Elements_WhenPoppingSingleItem_ThenStackIsStillNotEmpty() throws EmptyStackException, StackOutOfBoundsException
	{
		sMax2.push(24);
		sMax2.push(12);
		sMax2.pop();
		
		assertFalse(sMax2.isEmpty());
	}

	@Test
	public void givenStackWith2Elements_WhenPoppingSecondItem_ThenFirstPushedValueIsReturned() throws EmptyStackException, StackOutOfBoundsException
	{
		sMax2.push(24);
		sMax2.push(12);
		sMax2.pop();
		
		assertEquals(24, sMax2.pop());
	}
	
	@Test
	public void givenNotEmptyStack_WhenClearIsUsed_ThenIsEmptyIsTrue() throws StackOutOfBoundsException
	{
		sMax2.push(10);
		sMax2.clear();
		
		assertTrue(sMax2.isEmpty());
	}	
	
	@Test
	public void givenStackIsEmpty_WhenGettingSize_Then0Returned()
	{
		assertEquals(0, sMax2.getSize());	
	}
	
	@Test
	public void givenStackIsNotEmpty_WhenGettingSize_ThenValueIsReturned() throws StackOutOfBoundsException
	{
		sMax2.push(1);
		sMax2.push(12);
		
		assertEquals(2, sMax2.getSize());
	}
	
	@Test
	public void givenStackIsFullAndCleared_WhenPushingTwoItems_ThenSizeShouldBe2() throws StackOutOfBoundsException
	{
		sMax2.push(1);
		sMax2.push(2);
		sMax2.clear();
		sMax2.push(3);
		
		assertEquals(1, sMax2.getSize());
		
	}
	
	@Test (expected = StackOutOfBoundsException.class)
	public void givenStackIsFull_WhenPushingNewItem_ThenExceptionIsThrown() throws StackOutOfBoundsException
	{
		sMax2.push(1);
		sMax2.push(2);
		sMax2.push(3);
	}
	
	@Test (expected = StackOutOfBoundsException.class)
	public void givenStackMaxSizeIs0_WhenPushingAnItem_ThenExceptionIsThrown() throws StackOutOfBoundsException
	{
		sMax0.push(17);
		
	}
	
	@Test
	public void givenStackContains3Items_WhenCheckingForSize_Then3IsReturned() throws StackOutOfBoundsException
	{
		sMax3.push(1);
		sMax3.push(2);
		sMax3.push(3);
		
		assertEquals(3, sMax3.getSize());
	}
	
	@Test (expected = NegativeStackSizeException.class)
	public void givenNewStackIsBeingCreated_WhenGivingItNegativeSize_ThenExceptionIsThrown() throws NegativeStackSizeException
	{
		Stack s = new Stack(-1);
	}
}
