package test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.ReportGenerator;
import model.StaffMember;

public class reportTest
{
	private StaffMember sm1;
	private StaffMember sm2;
	private StaffMember sm3;
	private StaffMember sm4;
	private ArrayList<StaffMember> staffList;
	private ArrayList<StaffMember> sortedList;
	private ReportGenerator rg;
	private long sm1WorkInMinutes;
	private long sm2WorkInMinutes;
	private long sm3WorkInMinutes;
	private long sm4WorkInMinutes;

	@Before
	
	public void setUp()
	{
		staffList = new ArrayList<StaffMember>();
		sortedList = new ArrayList<StaffMember>();
		
		sm1=new StaffMember("Jan","Kowalski",1,"09:00","11:00");	//120
		sm2=new StaffMember("Joanna","Krawczyk",2,"08:00","12:00");	//240
		sm3=new StaffMember("Jerzy","Halicki",3,"11:00","13:30");	//150
		sm4=new StaffMember("Helena","Nowak",5,"15:15","18:45"); //210
		
		rg = new ReportGenerator();

	}
	
	private void printData()
	{
	System.out.println("work duration: " + sm1.getFirstName() + " " + sm1.workDuration);
	System.out.println("work duration: " + sm2.getFirstName() + " " + sm2.workDuration);
	System.out.println("work duration: " + sm3.getFirstName() + " " + sm3.workDuration);
	System.out.println("work duration: " + sm4.getFirstName() + " " + sm4.workDuration);
	System.out.println();
	}
	
	@Test
	public void GivenEmployeeWorksFrom9to11_WhenCalculatedWorkDuration_Then120minsShouldBeReturned()
	{
		sm1WorkInMinutes = sm1.calculateWorkDuration();
		assertEquals(120, sm1WorkInMinutes);
	}
	
	@Test
	public void GivenSm2WorksFrom8to12_WhenComparedWith9to11_ThenEmployee2worksLonger()
	{
		sm1WorkInMinutes = sm1.calculateWorkDuration();
		sm2WorkInMinutes = sm2.calculateWorkDuration();
		
		assertTrue(sm2WorkInMinutes > sm1WorkInMinutes);
	}
	
	@Test
	public void GivenOriginalListContains4Items_WhenSortedListCheckedForSize_ThenItsSizeIsEqual()
	{
		staffList.add(sm1);
		staffList.add(sm2);
		staffList.add(sm3);
		staffList.add(sm4);
		int staffListSize = staffList.size();
		
//		rg.sortStaffMembersAccordingToWorkDuration(staffList);
		
		int sortedListSize = staffList.size();
		
		assertEquals(staffListSize, 4);
		assertEquals(staffListSize, sortedListSize);
	
	}
	
	@Test
	public void Given3SmsWithSm1WorkingShortestAndSm2Longest_WhenSorted_ThenOrderShouldBe231()
	{
		staffList.add(sm1);
		staffList.add(sm2);
		staffList.add(sm3);
		
//		rg.sortStaffMembersAccordingToWorkDuration(staffList);
		
		StaffMember firstSorted = staffList.get(0);
		StaffMember secondSorted = staffList.get(1);
		StaffMember thirdSorted = staffList.get(2);
		
		for (StaffMember sm : staffList)
		{
			System.out.println("Sorting test: " + sm.getFirstName() + " " + sm.workDuration);
		}
		System.out.println();
		
		assertEquals(sm2, firstSorted);
		assertEquals(sm3, secondSorted);
		assertEquals(sm1, thirdSorted);
		
		
	}

}
