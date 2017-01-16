package model;

import java.util.ArrayList;
import java.util.Arrays;

public class ReportGenerator
{
	private static ArrayList<StaffMember> sortedList;

	public ArrayList<StaffMember> generateReport(ArrayList<StaffMember> staffMemberList)
	{
		StaffMember[] staffMemberArray = convertArrayListToArray(staffMemberList);

		descendingSelectionSortAccordingToWorkHours(staffMemberArray);

		sortedList = new ArrayList<StaffMember>(Arrays.asList(staffMemberArray));
		return sortedList;
	}

	private void descendingSelectionSortAccordingToWorkHours(StaffMember[] staffMemberArray)
	{
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

			tempSm = staffMemberArray[first]; // swap smallest found with the
												// element in position i.
			staffMemberArray[first] = staffMemberArray[i];
			staffMemberArray[i] = tempSm;
		}
	}

	private static StaffMember[] convertArrayListToArray(ArrayList<StaffMember> staffMemberList)
	{
		StaffMember[] staffMemberArray;
		staffMemberArray = new StaffMember[staffMemberList.size()];
		staffMemberArray = staffMemberList.toArray(staffMemberArray);
		return staffMemberArray;
	}

}
