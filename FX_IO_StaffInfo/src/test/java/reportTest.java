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
	private StaffMember sm5;
	private StaffMember sm6;
	private StaffMember sm7;

	@Before
	
	public void setUp()
	{
		staffList = new ArrayList<StaffMember>();
		sortedList = new ArrayList<StaffMember>();
		
		sm1=new StaffMember("Jan","Kowalski",1,"09:00","11:00");	//120
		sm2=new StaffMember("Joanna","Krawczyk",2,"08:00","12:00");	//240
		sm3=new StaffMember("Jerzy","Halicki",3,"11:00","13:30");	//150
		sm4=new StaffMember("Helena","Nowak",5,"15:15","18:45"); //210
		sm5 = new StaffMember("Ola", "Olińska", 13, "10:15", "16:45"); //390
		sm6 = new StaffMember("Ela", "Nowak", 7, "11:00", "23:45");
		sm7 = new StaffMember("Igor", "Oliński", 10, "10:15", "09:40");
			
		rg = new ReportGenerator();

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
		
		sortedList = rg.generateReport(staffList);
		
		int staffListSize = staffList.size();
		int sortedListSize = sortedList.size();
		
		assertEquals(staffListSize, 4);
		assertEquals(staffListSize, sortedListSize);
	
	}
	
	@Test
	public void Given3SmsWithSm1WorkingShortestAndSm2Longest_WhenSorted_ThenOrderShouldBe231()
	{
		staffList.add(sm1);
		staffList.add(sm2);
		staffList.add(sm3);
		
		sortedList = rg.generateReport(staffList);
		
		StaffMember firstSorted = sortedList.get(0);
		StaffMember secondSorted = sortedList.get(1);
		StaffMember thirdSorted = sortedList.get(2);
		
		assertEquals(sm2, firstSorted);
		assertEquals(sm3, secondSorted);
		assertEquals(sm1, thirdSorted);
			
	}

	@Test
	public void Given7StaffMembers_WhenSortedInTermsOfHours_ThenTheOrderShouldBeDescending()
	{
		staffList.add(sm1);
		staffList.add(sm2);
		staffList.add(sm3);
		staffList.add(sm4);
		staffList.add(sm5);
		staffList.add(sm6);
		staffList.add(sm7);
		
		sortedList = rg.generateReport(staffList);
		
		assertTrue(sortedList.get(0).calculateWorkDuration() > sortedList.get(1).calculateWorkDuration()
				&& sortedList.get(1).calculateWorkDuration() >  sortedList.get(2).calculateWorkDuration()
				&& sortedList.get(2).calculateWorkDuration() >  sortedList.get(3).calculateWorkDuration()
				&& sortedList.get(3).calculateWorkDuration() >  sortedList.get(4).calculateWorkDuration()
				&& sortedList.get(4).calculateWorkDuration() >  sortedList.get(5).calculateWorkDuration()
				&& sortedList.get(5).calculateWorkDuration() >  sortedList.get(6).calculateWorkDuration());
		
	}
}
