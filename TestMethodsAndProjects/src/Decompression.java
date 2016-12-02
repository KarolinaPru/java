
public class Decompression {
	private static String input;

	public Decompression(){

	}

	public static void run() {

		if (input.matches("[A-Za-z0-9]+"))				// && toggle.getSelectedToggle() == rbtn2){
 
		{ 			
			StringBuffer decompressedString = new StringBuffer();
			char  lastChar = input.charAt(0);
			int count = 1;
			
			for (int i = 1; i < decompressedString.length(); i++){
				char currentChar = input.charAt(i);
				
				if(currentChar == lastChar){
					decompressedString.append(currentChar);
					count++;

					
				}
			}
		}

		}
		public static void main(String[] args) {
		
			
		}
	}