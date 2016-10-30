public class DogTest {
	
	public static void main(String[] args) {
		
		Dog szarik = new Dog ("Szarik", 5);
		Dog azor = szarik;
		Dog burek = new Dog ("Szarik", 5);
		Dog stefan = new Dog ("Stefan", 8);
		
		System.out.println("szarik == azor: " + (szarik == azor));
		System.out.println("szarik == burek: " + (szarik == burek));
		System.out.println("szarik.equals(burek): " + szarik.equals(burek));
		System.out.println("azor.equals(stefan): " + azor.equals(stefan));
		
		System.out.println("szarik.toString(): " + szarik.toString());
		System.out.println("azor.toString(): " + azor.toString());
		System.out.println("stefan.toString(): " + stefan.toString());
		
		System.out.println("szarik.hashCode(): " + szarik.hashCode());
		System.out.println("azor.hashCode(): " + azor.hashCode());
		System.out.println("burek.hashCode(): " + burek.hashCode());
		System.out.println("stefan.hashCode(): " + stefan.hashCode());
		
		
	}
}
