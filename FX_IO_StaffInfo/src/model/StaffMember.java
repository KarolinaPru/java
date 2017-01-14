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

    public StaffMember(int id, String firstName, String lastName, int officeNumber, int workingFrom, int workingTo)
    {
    	this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setOfficeNumber(officeNumber);
        this.setWorkingFrom(workingFrom);
        this.setWorkingTo(workingTo);
    }

    public StaffMember (String firstName, String lastName, int officeNumber)
    {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setOfficeNumber(officeNumber);
    }

    public StaffMember(String firstName, String lastName, int workingFrom, int workingTo)
    {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setWorkingFrom(workingFrom);
        this.setWorkingTo(workingTo);
    }

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public int getOfficeNumber()
	{
		return officeNumber;
	}

	public void setOfficeNumber(int officeNumber)
	{
		this.officeNumber = officeNumber;
	}

	public int getWorkingFrom()
	{
		return workingFrom;
	}

	public void setWorkingFrom(int workingFrom)
	{
		this.workingFrom = workingFrom;
	}

	public int getWorkingTo()
	{
		return workingTo;
	}

	public void setWorkingTo(int workingTo)
	{
		this.workingTo = workingTo;
	}
}