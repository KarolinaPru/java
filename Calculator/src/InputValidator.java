import java.util.ArrayList;
import java.util.Arrays;

public class InputValidator
{
	private String input = "";

	public static void main(String[] args)
	{
		InputValidator v = new InputValidator();
		v.unitTest("2+2", true);
		v.unitTest("2+2+", false);
		v.unitTest("2-2", true);
		v.unitTest("2--2", false);
		v.unitTest("--2", false);
		v.unitTest("+", false);
		v.unitTest("-", false);
		v.unitTest("7", true);
		v.unitTest("1+-2", false);
		v.unitTest("2/9", true);
		v.unitTest("2+5-7", true);
		v.unitTest("2+2+2", true);
		v.unitTest("0", false);
		v.unitTest("2,3,3", false);
		v.unitTest("2,1+3,2", true);
		
	}

	public boolean isValid(String characterString)
	{
		return isValid(characterString.charAt(0));
	}
	
	public boolean isValid(char character)
	{
		// TODO: zdefiniuj input validator
		// return false if
		// 1. last char in input is math operation and character is also a math
		// operation
		// 2. input is length == 0 and character is 0
		// 3. in number in between math operation char you can have only one
		// comma

		//&& character != '-';
		
	
		if (input.length() == 0 && !Character.isDigit(character) || Character.valueOf(character) == '0')

		{
			return false;
		}
		
		
		if (Character.valueOf(character) == ',' && input.contains(Character.toString(character)))
		{
			return false;
		}
		
		if (!Character.isDigit(character) && input.matches("[^0-9]$"))
		{
			return false;
		}
			
		input += character;
		return true;
	}

	public void clear()
	{
		input = "";
	}

	public void unitTest(String input, boolean expectedResult)
	{
		boolean wasNotValidOnceOrMore = false;
		for (int i = 0; i < input.length(); i++)
		{
			if (!this.isValid(input.charAt(i)))
			{
				wasNotValidOnceOrMore = true;
			}
		}


		boolean testPassed = (expectedResult != wasNotValidOnceOrMore);

		if (testPassed)
		{
			System.out.println(input + " " + expectedResult + " TEST PASSED");
		}
		else
		{
			System.out.println(input + " " + expectedResult + " TEST FAILED");
		}
		this.clear();
	}
}
