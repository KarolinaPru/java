package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
	private static Scanner in;
	private static PrintWriter out;

	public static void main(String[] args)
	{
		in = null;
		int id;
		String firstName;
		String lastName;
		
		// Rozwiązanie szybkie; bardziej eleganckie - klasa Person
		ArrayList<Integer> idList = new ArrayList();
		ArrayList<String> firstNameList = new ArrayList();
		ArrayList<String> lastNameList = new ArrayList();
		
		try
		{
		//	in = new Scanner(Paths.get("/home/users/xkprusac/workspace/INU_7.01_FileIO/text.txt"));
			in = new Scanner(Paths.get("C:/src/projects/java/INU_7.01_FileIO/text.txt"));
			
			// Dopóki plik zawiera jakieś dane
			while (in.hasNext())
			{
				id = in.nextInt();
				firstName = in.next();
				lastName = in.next();
				
				// Nieeleganckie! Lepiej zrobić odrębną klasę Person
				idList.add(id);
				firstNameList.add(firstName);
				lastNameList.add(lastName);
				
				System.out.printf(
					"Wczytano dane: id: %d, imię: %s, nazwisko: %s\n",
					id, firstName, lastName
					);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (in != null)
			{
				in.close();				
			}
		}
		
		out = null;
		
		try
		{
			// Będziemy wpisywac informacje do nowego pliku
			//out = new PrintWriter("/home/users/xkprusac/workspace/INU_7.01_FileIO/outputText.txt");
			out = new PrintWriter("C:/src/projects/java/INU_7.01_FileIO/outputText.txt");
			
			for (int i = 0; i < idList.size(); i++)
			{
				out.printf("Wczytano dane: id: %d, imię: %s, nazwisko: %s\n",
				idList.get(i),
				firstNameList.get(i),
				lastNameList.get(i)
				);
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			
		}
		finally
		{
			if (out != null)
			{
				out.close();
			}
		}
	}
}
