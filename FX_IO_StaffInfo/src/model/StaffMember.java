package model;

/**
 * Created by karol_000 on 13.01.2017.
 */
public class StaffMember {
	private int id;
    private String firstName;
    private String lastName;
    private int officeNumber;
    private int workingFrom;
    private int workingTo;

    public StaffMember(String firstName, String lastName, int officeNumber, int workingFrom, int workingTo)
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

	public int getWorkingFrom()
	{
		return workingFrom;
	}

	public int getWorkingTo()
	{
		return workingTo;
	}
}