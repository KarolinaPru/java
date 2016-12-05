
public class InputValidator
{
	private String input;

	public boolean isValid(String character)
	{
		//TODO: zdefiniuj input validator
		// return false if
		// 1. last char in input is math operation and character is also a math operation
		// 2. input is length == 0 and character is 0
		// 3. in number in between math operation char you can have only one comma
		
		input += character;
		return true;
	}
	
	public void clear()
	{
		input = "";
	}
}
