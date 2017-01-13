package model;

/**
 * Created by karol_000 on 13.01.2017.
 */
public class StaffMember {
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

    public StaffMember (String firstName, String lastName, int officeNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.officeNumber = officeNumber;
    }

    public StaffMember(String firstName, String lastName, int workingFrom, int workingTo)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.workingFrom = workingFrom;
        this.workingTo = workingTo;
    }
}