package com.karolina;


public class AnimalCloneTest {

	public static void main(String[] args) {
		try {
			Sloth eryk = new Sloth("Eryk", 4, "corn");
			Sloth erykCopy = eryk.clone();
			
			erykCopy.setName("Bobek");
			erykCopy.setFavoriteFood("beans");
			erykCopy.setAge(10);
			
			System.out.println(eryk.getDescription());
			System.out.println(erykCopy.getDescription());
			
			
		} catch (CloneNotSupportedException e){
			e.printStackTrace();
		}

	}

}
