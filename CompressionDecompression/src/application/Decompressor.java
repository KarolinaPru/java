package application;

public class Decompressor 
{

	public Decompressor()
	{

	}

	public static void run() {

		String input = "";

		if (input.matches("[A-Za-z0-9]+"))  //&& toggle.getSelectedToggle() == rbtn2){

		{ 			
			StringBuffer str = new StringBuffer();
			char  lastChar = input.charAt(0);

			int count = 1;

			for (int i = 1; i < str.length(); i++){
				char currentChar = input.charAt(i);
				char nextChar = input.charAt(i+1);

				if (Character.isDigit(currentChar))
					if (!Character.isWhitespace(nextChar) && Character.isDigit(nextChar))
						count = Character.getNumericValue(currentChar);


				//str.append("" + lastChar * ??????);

					else
						str.append("" + lastChar);

				//lastChar = inputCharAt(i);
			}

			String decompressedString = str.toString();
			//textField1.setText(decompressedString);
			System.out.println(decompressedString);

		}
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
						int currentCharCount = Character.getNumericValue(nextChar);
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

	public static void main(String[] args) 
	{
		fact("a", "a");
		fact("a2", "aa");
		fact("ab", "ab");
		fact("abc", "abc");
		fact("ab2", "abb");
		fact("a2b", "aab");
		fact("a5b3", "aaaaabbb");
		fact("a2bc3d", "aabcccd");
		fact("a10", "aaaaaaaaaa");
	}

	private static void fact(String test, String result) {
		Decompressor decompressor = new Decompressor();
		String decompressedText = decompressor.decompress(test);
		System.out.print(decompressedText + " - ");

		if (decompressedText.equals(result))
			System.out.println("ok");
		else
			System.out.println("error");
	}
}