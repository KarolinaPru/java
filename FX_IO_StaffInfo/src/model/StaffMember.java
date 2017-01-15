package model;

/**
 * Created by karol_000 on 13.01.2017.
 */
public class StaffMember {
	private int id;
    private String firstName;
    private String lastName;
    private int officeNumber;
    private String workingFrom;
    private String workingTo;

    public StaffMember(String firstName, String lastName, int officeNumber, String workingFrom, String workingTo)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.officeNumber = officeNumber;
        this.workingFrom = workingFrom;
        this.workingTo = workingTo;
    }

	public int getId()
	{
		return id;
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