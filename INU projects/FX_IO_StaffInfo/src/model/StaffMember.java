package model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.Duration;
import java.time.LocalTime;

/**
 * Created by karol_000 on 13.01.2017.
 */
public class StaffMember {

    private String firstName;
    private String lastName;
    private int officeNumber;
    private String workingFrom;
    private String workingTo;
    private long workDuration;
    
    public StaffMember(String firstName, String lastName, int officeNumber, String workingFrom, String workingTo)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.officeNumber = officeNumber;
        this.workingFrom = workingFrom;
        this.workingTo = workingTo;
        workDuration = calculateWorkDuration();
    }

    public long calculateWorkDuration()
    {
    	LocalTime timeFrom = LocalTime.parse(workingFrom);
    	LocalTime timeTo = LocalTime.parse(workingTo);

    	workDuration = Duration.between(timeFrom, timeTo).toMinutes();
    	return workDuration;
    }

    public String getHoursFrom() {
    	String hhFrom;
		hhFrom = workingFrom.substring(0, 2);
		return hhFrom;
	}

	public String getMinutesFrom() {
		String mmFrom;
		mmFrom = workingFrom.substring(3, 5);
		return mmFrom;

	}

	public String getHoursTo() {
		String hhTo;
		hhTo = workingTo.substring(0, 2);
		return hhTo;

	}

	public String getMinutesTo() {
		String mmFTo;
		mmFTo = workingFrom.substring(3, 5);
		return mmFTo;

	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public int getOfficeNumber()
	{
		return officeNumber;
	}

	public String getWorkingFrom()
	{
		return workingFrom;
	}

	public String getWorkingTo()
	{
		return workingTo;
	}
}