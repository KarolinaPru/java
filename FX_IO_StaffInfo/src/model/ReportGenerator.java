package model;

import java.util.ArrayList;

public class ReportGenerator
{
	private StaffMember sm1;
	private StaffMember sm2;
	private StaffMember sm3;
	private StaffMember sm4;
	private long minutesOfWork;
	private static ArrayList<StaffMember> staffMemberList = new ArrayList<StaffMember>();

	
	public static void main (String[] args)
	{
		ReportGenerator rg = new ReportGenerator();
		rg.initializeTheList();
		rg.determineWorkDurationOfEachStaffMember(staffMemberList);
		rg.sortStaffMembersAccordingToWorkDuration();
	}

	private ArrayList<StaffMember> initializeTheList()
	{
		sm1=new StaffMember("Jan","Kowalski",1,"09:00","11:00");
		sm2=new StaffMember("Joanna","Krawczyk",2,"08:00","12:00");
		sm3=new StaffMember("Jerzy","Kowalski",3,"11:00","13:30");
		sm4=new StaffMember("Joanna","Krawczyk",5,"15:15","18:45");
		
		staffMemberList.add(sm1);
		staffMemberList.add(sm2);
		staffMemberList.add(sm3);
		staffMemberList.add(sm4);
		
		return staffMemberList;
	}
	
	public ArrayList<StaffMember> sortStaffMembersAccordingToWorkDuration()
	{
		ArrayList<StaffMember> sortedList = new ArrayList<StaffMember>();
		
		long currentSmWorkDuration;
		long nextSmWorkDuration;
		boolean isNextSmAvailable;
		StaffMember currentSm;
		StaffMember nextSm;
		
		for (int i = 0; i < staffMemberList.size(); i++)
		{
			currentSm = staffMemberList.get(i);
			currentSmWorkDuration = staffMemberList.get(i).workDuration;
			
			isNextSmAvailable = (i+1) < staffMemberList.size();
			
			if (isNextSmAvailable)
			{
				nextSm = staffMemberList.get(i+1);
				nextSmWorkDuration =  staffMemberList.get(i+1).workDuration;
				
				if (nextSmWorkDuration > currentSmWorkDuration)
				{
					sortedList.add(nextSm);	
					nextSm = currentSm;
				}
				sortedList.add(currentSm);
			}
			else
			{
				sortedList.add(currentSm);
			}
		}	
		
		for (StaffMember sm : sortedList)
		{
			System.out.println(sm.workDuration);	
		}
		return sortedList;
		
	}


	private void determineWorkDurationOfEachStaffMember(ArrayList<StaffMember> staffMemberList)
	{
		for (StaffMember sm : staffMemberList)
		{
			minutesOfWork = sm.calculateWorkDuration();		
	//		System.out.println(minutesOfWork);
		}
	}
}
