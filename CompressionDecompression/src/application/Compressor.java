package application;

public class Compressor 
{
	private String inputText;
	private StringBuilder outputText;
	private char lastChar;
	private int lastLetterCount;

	public static void main (String[] args)
	{
		Compressor c = new Compressor();
		c.unitTest("a", "a");
		c.unitTest("ab", "ab");
		c.unitTest("aa", "a2");
		c.unitTest("ababa", "ababa");
		c.unitTest("abbb", "ab3");
		c.unitTest("aabb", "a2b2");
		c.unitTest("aabbbccc", "a2b3c3");
		c.unitTest("aabbccccd", "a2b2c4d");
		c.unitTest("AAbCCccc", "A2bC2c3");
	}
	
	public void unitTest (String test, String result)
	{
		String compressedText = this.compress(test);
		System.out.print("Test: " + test + " Result: " + compressedText + " - ");
		
		if (compressedText.equals(result))
		{
			System.out.println("ok");
		}
		else
		{
			System.out.println("error");
		}
	}
	
	public String compress(String input) 
	{
		inputText = input;
		outputText = new StringBuilder();
		lastChar = inputText.charAt(0);
		lastLetterCount = 1;

		for (int i = 1; i < inputText.length(); i++)
		{	
			char currentChar = inputText.charAt(i);
			
			if (currentChar == lastChar)
			{
				lastLetterCount++;	
			}
			else 
			{
				appendLastLetterWithNumberOfOccurrences();
				lastLetterCount = 1;
				lastChar = currentChar;
			}
		}
		appendLastLetterWithNumberOfOccurrences();
		return outputText.toString();
	}

	private void appendLastLetterWithNumberOfOccurrences() 
	{
		if (lastLetterCount > 1)
		{
			outputText.append(lastChar + Integer.toString(lastLetterCount));
		}
		else
		{
			outputText.append(lastChar);		
		}
	}
}