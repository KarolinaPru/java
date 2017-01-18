import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UsersGenerator {
    private static final String FILE_HEADER = "firstName,lastName,username,password,email";
    private static final String NEW_LINE_SEPARATOR = "\n";


    public static void main (String[] args) throws IOException {
        ArrayList<User> generatedList;
        generatedList = generateUserList(300);

        for (User u : generatedList)
        {
            System.out.println(u.getFirstName());
        }

        saveUsersToFile(generatedList);
    }

	private static ArrayList<User> generateUserList(int numberOfUsers) {
		ArrayList<User> usersList = new ArrayList<>();
		
		for (int i = 1; i < numberOfUsers; i++)
		{
			usersList.add(new User("Student" + i, "S", "student" + i, "123", "mail@email"));
		}

		return usersList;

	}

	private static void saveUsersToFile(ArrayList<User> listOfUsers) throws IOException {
        FileWriter fileWriter = null;

        try {

            fileWriter = new FileWriter("generatedUsers.csv");

            fileWriter.append(FILE_HEADER.toString());
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (User u : listOfUsers) {
                fileWriter.append(u.getFirstName()).append(";");
                fileWriter.append(u.getLastName()).append(";");
                fileWriter.append(u.getUsername()).append(";");
                fileWriter.append(u.getPassword()).append(";");
                fileWriter.append(u.getEmail()).append(";");
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            System.out.println("Success, check your file!");
        }
        catch (EOFException e) {
            System.out.println("Oops, something went wrong!");
            e.printStackTrace();
        }
        finally {
           fileWriter.flush();
           fileWriter.close();
        }
    }
}

