package test.java.stackTests;

import org.junit.Test;

import main.java.stack.EmptyStackException;
import main.java.stack.Stack;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import main.java.stack.StackOutOfBoundsException;

public class StackTests {

	private Stack s;

	@Before
	public void setUp()
	{
		s = new Stack();
	}
	
	@After
	public void tearDown()
	{
		
	}
	// Arrange Act Assert
	@Test
	public void givenNewStack_WhenCheckForEmptiness_ThenTrueIsReturned()
	{
		Stack s = new Stack();
		
		assertTrue(s.isEmpty());
	}

	@Test
	public void givenStackNotEmpty_WhenCheckingForEmptiness_ThenFalseIsReturned() throws StackOutOfBoundsException
	{
		Stack s = new Stack();
		s.push(42);
		
		assertFalse(s.isEmpty());
	}
	
	@Test (expected = EmptyStackException.class)
	public void givenEmptyStack_WhenPopping_ThenExceptionIsThrown() throws EmptyStackException
	{
		Stack s = new Stack();
		s.pop();
	}
	
	@Test
	public void givenStackNotEmpty_WhenPopping_ThenValueIsReturned() throws EmptyStackException, StackOutOfBoundsException
	{
		Stack s = new Stack();
		
		s.push(10);
		
		assertEquals(10, s.pop());
	}
	
	@Test
	public void givenStackNotEmpty_WhenPopping_ThenLastAddedValueIsReturned() throws EmptyStackException, StackOutOfBoundsException
	{
		Stack s = new Stack();
		
		s.push(10);
		s.push(24);
		
		assertEquals(24, s.pop());
	}
	
	@Test
	public void givenStackNotEmpty_WhenPopping_ThenStackBecomesEmpty() throws EmptyStackException, StackOutOfBoundsException
	{
		Stack s = new Stack();
		
		s.push(24);
		s.pop();
		
		assertTrue(s.isEmpty());
	}
	
	@Test
	public void givenStackWith2Elements_WhenPoppingSingleItem_ThenStackIsStillNotEmpty() throws EmptyStackException, StackOutOfBoundsException
	{
		Stack s = new Stack();
		
		s.push(24);
		s.push(12);
		s.pop();
		
		assertFalse(s.isEmpty());
	}

	@Test
	public void givenStackWith2Elements_WhenPoppingSecondItem_ThenSecondAddedValueIsReturned() throws EmptyStackException, StackOutOfBoundsException
	{
		Stack s = new Stack();
		
		s.push(24);
		s.push(12);
		s.pop();
		
		assertEquals(24, s.pop());
	}
	
	@Test
	public void givenNotEmptyStack_WhenClearIsUsed_ThenIsEmptyIsTrue() throws StackOutOfBoundsException
	{
		Stack s = new Stack();
		
		s.push(10);
		s.clear();
		
		assertTrue(s.isEmpty());
	}
	
	@Test
	public void givenStackIsEmpty_WhenGettingSize_Then0Returned()
	{
		Stack s = new Stack();
		
		assertEquals(0, s.getSize());
		
	}
	
	@Test
	public void givenStackIsNotEmpty_WhenGettingSize_ThenValueIsReturned() throws StackOutOfBoundsException
	{
		Stack s = new Stack();
		s.push(1);
		s.push(12);
		
		assertEquals(2, s.getSize());
		
	}
	
	@Test (expected = StackOutOfBoundsException.class)
	public void givenStackIsFull_WhenPushingNewItem_ThenExceptionIsThrown() throws StackOutOfBoundsException
	{
		Stack s = new Stack();
		
		s.push(1);
		s.push(2);
		s.push(3);
	}
}
