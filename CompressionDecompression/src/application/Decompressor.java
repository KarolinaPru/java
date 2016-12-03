package application;

public class Decompressor 
{
	private StringBuilder outputText;
	private String inputText;
	private char currentChar;
	private boolean isNextCharAvailable;
	private char nextChar;

	public static void main(String[] args) 
	{
		Decompressor d = new Decompressor();
		d.unitTest("a", "a");
		d.unitTest("a2", "aa");
		d.unitTest("ab", "ab");
		d.unitTest("abc", "abc");
		d.unitTest("ab2", "abb");
		d.unitTest("a2b", "aab");
		d.unitTest("a5b3", "aaaaabbb");
		d.unitTest("a2bc3d", "aabcccd");  
		d.unitTest("a10", "aaaaaaaaaa");
		d.unitTest("a100", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		d.unitTest("ab10c12", "abbbbbbbbbbcccccccccccc");
		d.unitTest("a11c3b", "aaaaaaaaaaacccb");
		d.unitTest("A5b2C", "AAAAAbbC");
	}   

	public void unitTest(String test, String result) {
		String decompressedText = this.decompress(test);
		System.out.print("Test: " + test + " Result: " + decompressedText + " - ");

		if (decompressedText.equals(result))
		{
			System.out.println("ok");
		}
		else
		{
			System.out.println("error");
		}
	}
	
	public String decompress (String input)
	{
		inputText = input;
		outputText = new StringBuilder();
		for (int i = 0; i < inputText.length(); i++) 
		{
			currentChar = inputText.charAt(i);
			
			if (Character.isLetter(currentChar))
			{
				appendCurrentLetter(i);
			}
		}
		return outputText.toString();
	}

	private void appendCurrentLetter(int i) {
		isNextCharAvailable = (i+1) < inputText.length();
		if (isNextCharAvailable)
		{
			appendLetterOnceOrMoreIfNeeded(i);
		} 
		else			
		{
			outputText.append(currentChar);
		}
	}

	private void appendLetterOnceOrMoreIfNeeded(int i) {
		nextChar = inputText.charAt(i+1);
		
		if(Character.isDigit(nextChar))
		{
			handleCaseWhenLetterShouldBeAppendedMoreThanOnce(i);
		}
		else 
		{
			outputText.append(currentChar);
		}
	}

	private void handleCaseWhenLetterShouldBeAppendedMoreThanOnce(int i) {
		int currentLetterCount = prepareLetterCount(i);
		appendLetterAppropriateNumberOfTimes(currentLetterCount);
	}

	private int prepareLetterCount(int i) {
		StringBuilder currentCharCountBuilder = new StringBuilder();
		currentCharCountBuilder.append(nextChar);
		
		for (int k = i+2; k < inputText.length(); k++)
		{
			char followingNumber = inputText.charAt(k);
			
			if (Character.isDigit(followingNumber))
			{
				currentCharCountBuilder.append(followingNumber);
			}
			else
			{
				break;
			}
		}
		
		return Integer.parseInt(currentCharCountBuilder.toString());
	}

	private void appendLetterAppropriateNumberOfTimes(int currentLetterCount) {
		for (int j = 0; j < currentLetterCount; j++)
		{
			outputText.append(currentChar);	
		}
	}
}