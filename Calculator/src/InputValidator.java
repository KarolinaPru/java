public class InputValidator
{
	public String lastValidInput = "";

	public static void main(String[] args)
	{
		InputValidator v = new InputValidator();
		v.unitTest("2.3.3", false);
		v.unitTest("1,2", false);
		v.unitTest("0", true);
		v.unitTest("7", true);
		v.unitTest("2..2", false);
		v.unitTest("2.2", true);
		v.unitTest("00", false);
		v.unitTest("00.asdfa", false);
		v.unitTest("12345", true);
		v.unitTest("12345asdf", false);
		v.unitTest("asdf12345", false);
		v.unitTest("+2", false);
	}
	
	public boolean isValidNumber(char newInput){
		return isValidNumber(String.valueOf(newInput));
	}

	public boolean isValidNumber(String newInput)
	{
		String inputCandidate = lastValidInput + newInput; 

		// a number with a comma as a decimal separator
		if(!inputCandidate.matches("^\\d*\\.?\\d*$"))
			return false;
		
		// more than 2 zeros at the beginning
		if(inputCandidate.matches("^0{2,}"))
			return false;

		lastValidInput = inputCandidate;
		return true;
	}

	public void clear()
	{
		lastValidInput = "";
	}

	public void unitTest(String input, boolean expectedResult)
	{
		boolean wasNotValidOnceOrMore = false;
		for (int i = 0; i < input.length(); i++)
		{
			if (!this.isValidNumber(input.charAt(i)))
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
