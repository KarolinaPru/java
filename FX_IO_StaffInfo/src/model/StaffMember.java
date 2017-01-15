package model;

import java.time.Duration;
import java.time.LocalTime;

/**
 * Created by karol_000 on 13.01.2017.
 */
public class StaffMember {

    private String firstName;
    private String lastName;
    private int officeNumber;
    public String workingFrom; 
    public String workingTo;
    public long workDuration;
    
    public StaffMember(String firstName, String lastName, int officeNumber, String workingFrom, String workingTo)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.officeNumber = officeNumber;
        this.workingFrom = workingFrom;
        this.workingTo = workingTo;
    }

    public long calculateWorkDuration()
    {
    	LocalTime timeFrom = LocalTime.parse(workingFrom);
    	LocalTime timeTo = LocalTime.parse(workingTo);

    	workDuration = Duration.between(timeFrom, timeTo).toMinutes();
    	return workDuration;
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