
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
		v.unitTest("-", true);
		v.unitTest("7", true);
		
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
		if (input.length() == 0 && !Character.isDigit(character) && character != '-')
		{
			return false;
		}
		
			
		if (!Character.isDigit(character) && input.contains(Character.toString(character)))
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
