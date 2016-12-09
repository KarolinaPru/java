public class InputValidator
{
	private String input = "";

	public static void main(String[] args)
	{
		InputValidator v = new InputValidator();
		v.unitTest("2,3,3", false);
		v.unitTest("0", true);
		v.unitTest("20/4", true);
		v.unitTest("10*4/2", true);

		v.unitTest("32*23", true);
		v.unitTest("2+2", true);
		v.unitTest("2+2+", true);
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
		v.unitTest("2,1+3,2", true);
		v.unitTest("2,,2", false);
		v.unitTest("2,2", true);
		v.unitTest("12,1234+134,1245", true);

	}
	
//	public boolean isNumber(String text)
//	{
//		if (text.matches("\\d+") || text.matches("\\d+\\,\\d+"))
//		{
//		return true;
//		}
//		
//		return false;
//		
//	}
	
	public boolean isValid(String characterString)
	{
		return isValid(characterString.charAt(0));
	}

	public boolean isValid(char character)
	{
			// Pierwszy znak nie może być znakiem lub zerem
			if (input.length() == 0 && !Character.isDigit(character))						 // || Character.valueOf(character) == '0')
			{
				return false;
			}

			// Jeśli input nie jest pusty i ostatni znak jest operatorem i nowy
			// też
			// Ignoruj nowy znak
			
			if (input.length()!= 0 && !Character.isDigit(input.charAt(input.length() - 1))
					&& !Character.isDigit(character))
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
		} else
		{
			System.out.println(input + " " + expectedResult + " TEST FAILED");
		}
		this.clear();
	}
}
