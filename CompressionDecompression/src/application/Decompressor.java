package application;

public class Decompressor 
{
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
	}   

	public void unitTest(String test, String result) {
		String decompressedText = this.decompress(test);
		System.out.print("Test: " + test + " Result: " + decompressedText + " - ");

		if (decompressedText.equals(result))
			System.out.println("ok");
		else
			System.out.println("error");
	}
	
	public String decompress (String inputText)
	{
		StringBuilder outputText = new StringBuilder();
		for (int i = 0; i < inputText.length(); i++) 
		{
			boolean isNextCharAvailable = (i+1) < inputText.length();
			char currentChar = inputText.charAt(i);

			if (Character.isLetter(currentChar))
			{
				if (isNextCharAvailable)
				{
					char nextChar = inputText.charAt(i+1);
	
					if(Character.isDigit(nextChar))
					{
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
						
						int currentCharCount = Integer.parseInt(currentCharCountBuilder.toString());
						for (int j = 0; j < currentCharCount; j++)
						{
							outputText.append(currentChar);	
						}
					}
					else 
					{
						outputText.append(currentChar);
					}
				} 
				else			
				{
					outputText.append(currentChar);
				}
			}
		}
		return outputText.toString();
	}
}