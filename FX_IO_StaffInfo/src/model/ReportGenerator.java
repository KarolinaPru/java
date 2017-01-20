package model;

import java.util.ArrayList;
import java.util.Arrays;

public class ReportGenerator
{
	private static ArrayList<StaffMember> sortedList;
	private StaffMember[] staffArray;
	private int min;


	public ArrayList<StaffMember> generateReport(ArrayList<StaffMember> staffMemberList)
	{
		StaffMember[] staffMemberArray = convertArrayListToArray(staffMemberList);

		descendingSelectionSortAccordingToWorkHours(staffMemberArray);
		sortedList = new ArrayList<StaffMember>(Arrays.asList(staffMemberArray));

		return sortedList;
	}

    private static StaffMember[] convertArrayListToArray(ArrayList<StaffMember> staffMemberList)
    {
        StaffMember[] staffMemberArray;
        staffMemberArray = new StaffMember[staffMemberList.size()];
        staffMemberArray = staffMemberList.toArray(staffMemberArray);
        return staffMemberArray;
    }

	private void descendingSelectionSortAccordingToWorkHours(StaffMember[] staffArray) {

        this.staffArray = staffArray;
		for (int i = this.staffArray.length - 1; i > 0; i--)
		{
		    min = 0;
			min = iterateThroughArrayToFindCurrentMinWorkDuration(i);
			placeCurrentMinAtTheEndOfTheSortedList(staffArray, i);
		}
	}

	private int iterateThroughArrayToFindCurrentMinWorkDuration(int i) {
		int j;
		long minWorkDuration;
		long currentWorkDuration;
		for (j = 1; j <= i; j++)
        {
            minWorkDuration = staffArray[min].calculateWorkDuration();
            currentWorkDuration = staffArray[j].calculateWorkDuration();

            if (currentWorkDuration < minWorkDuration)
            {
                min = j;
            }
        }
        return min;
	}

    private void placeCurrentMinAtTheEndOfTheSortedList(StaffMember[] staffArray, int i) {
        StaffMember smWithCurrentMin;

        smWithCurrentMin = staffArray[min];
        staffArray[min] = staffArray[i];
        staffArray[i] = smWithCurrentMin;
    }
}
