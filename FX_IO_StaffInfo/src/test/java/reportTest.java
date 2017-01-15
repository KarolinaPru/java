package test.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.StaffMember;

public class reportTest
{
	private StaffMember sm1;
	private StaffMember sm2;

	@Before
	
	public void setUp()
	{
		sm1 = new StaffMember("Jan", "Kowalski", 1, "09:00", "11:00");
		sm2 = new StaffMember("Joanna", "Krawczyk", 2, "08:00", "12:00");
		
	}
	
	@Test
	public void GivenEmployeeWorksFrom9to11_WhenCalculatedWorkDuration_Then120minsShouldBeReturned()
	{
		long janWorksInMinutes = sm1.calculateWorkDuration();
		assertEquals(120, janWorksInMinutes);
	}

}
