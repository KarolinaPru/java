package com.karolina;


public class AnimalCloneTest {

	public static void main(String[] args) {
		try {
			Sloth eryk = new Sloth("Eryk", "corn", 2010, 9, 18);
			Sloth erykCopy = eryk.clone();
			
			erykCopy.setName("Bobek");
			erykCopy.setFavoriteFood("beans");
			erykCopy.setBirthday(2013, 5, 14);
			
			System.out.println(eryk.getDescription());
			System.out.println(erykCopy.getDescription());
			
			
		} catch (CloneNotSupportedException e){
			e.printStackTrace();
		}

	}

}
