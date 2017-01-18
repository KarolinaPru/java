import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UsersGenerator
{
	
	private ArrayList<User> usersList;

	public static void main (String[] args) throws IOException
	{
		UsersGenerator ug = new UsersGenerator();
		generateUserList();
		saveUsersToFile(generateUserList());
		
	}

	private static ArrayList<User> generateUserList()
	{
		ArrayList<User> usersList = new ArrayList<User>();
		
		for (int i = 1; i < 300; i++)
		{
			usersList.add(new User("Student" + i, "S", "student" + i, "123", "mail@email"));		
		}
	
		return usersList;
		
	}

	private static void saveUsersToFile(ArrayList<User> list1) throws IOException
	{
	list1 = new ArrayList<User>();
	BufferedWriter br = new BufferedWriter(new FileWriter("generatedUsers.csv"));
	StringBuilder sb = new StringBuilder();
		
	for(User u: list1)
	{
		sb.append(u);
		sb.append(";");
	
	}
		 br.write(sb.toString());
		 br.close();
	}
}

