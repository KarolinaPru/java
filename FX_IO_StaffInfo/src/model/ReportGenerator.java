package model;

import java.util.ArrayList;
import java.util.Arrays;

public class ReportGenerator
{
	private static ArrayList<StaffMember> staffMemberList = new ArrayList<StaffMember>();
	private static ArrayList<StaffMember> sortedList;

	public static void main(String[] args)
	{
		generateReport();
	}

	private static void generateReport()
	{
		ReportGenerator rg = new ReportGenerator();
		rg.initializeTheList();
		descendingSelectionSortAccordingToWorkDuration(staffMemberList);
	}

	private ArrayList<StaffMember> initializeTheList()
	{
	StaffMember sm1 = new StaffMember("Jan", "Kowalski", 1, "09:00", "11:00"); // 120
	StaffMember	sm2 = new StaffMember("Joanna", "Krawczyk", 2, "08:00", "12:00"); // 240
	StaffMember	sm3 = new StaffMember("Jerzy", "Halicki", 3, "11:00", "13:30"); // 150
	StaffMember	sm4 = new StaffMember("Helena", "Nowak", 5, "15:15", "18:45"); // 210
	StaffMember	sm5 = new StaffMember("Ola", "Oliñska", 13, "10:15", "16:45"); // 390

		staffMemberList.add(sm1);
		staffMemberList.add(sm2);
		staffMemberList.add(sm3);
		staffMemberList.add(sm4);
		staffMemberList.add(sm5);

		return staffMemberList;
	}

	public static ArrayList<StaffMember> descendingSelectionSortAccordingToWorkDuration(ArrayList<StaffMember> staffMemberList)
	{
		StaffMember[] staffMemberArray = convertArrayListToArray(staffMemberList);

		int i, j, first;
		StaffMember tempSm;
		long firstSmWorkDuration;
		long currentSmWorkDuration;

		for (i = staffMemberArray.length - 1; i > 0; i--)
		{
			first = 0;

			for (j = 1; j <= i; j++)
			{
				firstSmWorkDuration = staffMemberArray[first].calculateWorkDuration();
				currentSmWorkDuration = staffMemberArray[j].calculateWorkDuration();

				if (currentSmWorkDuration < firstSmWorkDuration)
				{
					first = j;
				}
			}

			tempSm = staffMemberArray[first]; // swap smallest found with the element in position i.
												
			staffMemberArray[first] = staffMemberArray[i];
			staffMemberArray[i] = tempSm;
		}

		sortedList = new ArrayList<StaffMember>(Arrays.asList(staffMemberArray));
		
		for (StaffMember sm : sortedList)
		{
			System.out.println("Sorted: " + sm.getFirstName() + " " + sm.workDuration);
		}
		return sortedList;
	}

	private static StaffMember[] convertArrayListToArray(ArrayList<StaffMember> staffMemberList)
	{
		StaffMember[] staffMemberArray;
		staffMemberArray = new StaffMember[staffMemberList.size()];
		staffMemberArray = staffMemberList.toArray(staffMemberArray);
		return staffMemberArray;
	}

}
