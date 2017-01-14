package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffMemberSerializer
{

	private static final String PATH_TO_DATA_FILE = "src/textFiles/StaffMembers.txt";
	private static Scanner in;
	private static PrintWriter out;
	private int id;
	private String firstName;
	private String lastName;
	private int officeNumber;
	private int workingFrom;
	private int workingTo;
	private ArrayList<StaffMember> staffList;

	public ArrayList<StaffMember> deserialize()
	{
		in = null;
		staffList = new ArrayList<StaffMember>();

		try
		{
			in = new Scanner(Paths.get(PATH_TO_DATA_FILE));

			while (in.hasNext())
			{
				firstName = in.next();
				lastName = in.next();
				officeNumber = in.nextInt();
				workingFrom = in.nextInt();
				workingTo = in.nextInt();

				StaffMember sm = new StaffMember(firstName, lastName, officeNumber, workingFrom, workingTo);

				staffList.add(sm);
			}
			
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			if (in != null)
			{
				in.close();
			}
		}
		out = null;
		return staffList;
	}

	public void serialize()
	{
		try
		{
			out = new PrintWriter(PATH_TO_DATA_FILE);

			for (int i = 0; i < staffList.size(); i++)
			{
				out.printf("%s, %s, %d, %d,. %d\n", staffList.get(i).getFirstName(),
						staffList.get(i).getLastName(), staffList.get(i).getOfficeNumber(),
						staffList.get(i).getWorkingFrom(), staffList.get(i).getWorkingTo());
			}
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();

		} finally
		{
			if (out != null)
			{
				out.close();
			}
		}
	}

}
