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

	public ArrayList<StaffMember> deserialize()
	{
		Scanner in = null;
		ArrayList<StaffMember> staffList = new ArrayList<StaffMember>();

		try
		{
			in = new Scanner(Paths.get(PATH_TO_DATA_FILE));

			while (in.hasNext())
			{
				String firstName = in.next();
				String lastName = in.next();
				int officeNumber = in.nextInt();
				int workingFrom = in.nextInt();
				int workingTo = in.nextInt();

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
		return staffList;
	}

	public void serialize(ArrayList<StaffMember> staffList)
	{
		PrintWriter out = null;
		
		try
		{
			out = new PrintWriter(PATH_TO_DATA_FILE);

			for (StaffMember s : staffList)
			{
				out.printf("%s %s %d %d %d\n", 
						s.getFirstName(),
						s.getLastName(), 
						s.getOfficeNumber(),
						s.getWorkingFrom(), 
						s.getWorkingTo());
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
