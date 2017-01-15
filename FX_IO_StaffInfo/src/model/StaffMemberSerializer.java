package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffMemberSerializer
{
	public ArrayList<StaffMember> deserialize(String pathToFile) throws DeserializationFailedException
	{
		Scanner in = null;
		ArrayList<StaffMember> staffList = new ArrayList<StaffMember>();

		try
		{
			in = new Scanner(Paths.get(pathToFile));

			while (in.hasNext())
			{
				String firstName = in.next();
				String lastName = in.next();
				int officeNumber = in.nextInt();
				String workingFrom = in.next();
				String workingTo = in.next();

				StaffMember sm = new StaffMember(firstName, lastName, officeNumber, workingFrom, workingTo);

				staffList.add(sm);
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (Exception e)
		{
			throw new DeserializationFailedException();
		} finally
		{
			if (in != null)
			{
				in.close();
			}
		}
		return staffList;
	}

	public void serialize(ArrayList<StaffMember> staffList, String pathToFile)
	{
		PrintWriter out = null;

		try
		{
			out = new PrintWriter(pathToFile);

			for (StaffMember s : staffList)
			{
				out.printf("%s %s %d %s %s \n", s.getFirstName(), s.getLastName(), s.getOfficeNumber(),
						s.getWorkingFrom(), s.getWorkingTo());
			}
		} catch (FileNotFoundException e)
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
