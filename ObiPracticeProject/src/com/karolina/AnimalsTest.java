package com.karolina;

public class AnimalsTest {

	public static void main(String[] args) {
		
		Sloth stefan = new Sloth("Stefan", 5, "leaves");
		Sloth benek = new Sloth("Stefan", 5, "leaves");
		Sloth kristoff = new Sloth("Kristoff", 3, "passion fruit");
		Sloth jozek = stefan;
		Animal zdenek = kristoff;
				
		System.out.println(stefan.getDescription());
		System.out.println(stefan.toString());
		
	}

}
