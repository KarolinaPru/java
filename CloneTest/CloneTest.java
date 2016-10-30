
public class CloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		
		Manager jim = new Manager("Jim Kowalsky", 80000, 2000, 12, 1);
		Manager jack = jim.clone();
		jack.raiseSalary(50);
		
		System.out.println("Jack earns: "+ jack.getSalary());
		System.out.println("JIm earns: " + jim.getSalary());

	}

}
