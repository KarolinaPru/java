import java.util.Objects;

public class Dog {

	private String name;
	private int age;

	public Dog (String n, int a) {
		name = n;
		age = a;		
	}

	public boolean isOld() { // metoda
		if (age > 10)
			return true;
		return false;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setName(String newName) {
		name = newName;
	}
	public void setAge(int newAge) {
		age = newAge;
	}
	public void birthday() {
		age++;
	}

	public boolean equals(Object otherObject){

		if (this == otherObject)
			return true;

		if (otherObject == null)
			return false;

		if(getClass() != otherObject.getClass())
			return false;

		Dog other = (Dog) otherObject;

		return Objects.equals(name,  other.name) && age == other.age;

	}

	public int hashCode() {
		return Objects.hash(name, age);
	}


	public String toString() {
		return getClass().getName() + "[name=" + name + ",age=" + age + "]";
	}

}


	
	


