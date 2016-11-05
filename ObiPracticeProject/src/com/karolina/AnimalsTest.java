package com.karolina;


public class AnimalsTest {

	public static void main(String[] args) {
		
		Sloth stefan = new Sloth("Stefan", "leaves", 1999, 12, 06);
		Sloth benek = new Sloth("Stefan", "leaves", 1999, 12, 06);
		Sloth kristoff = new Sloth("Kristoff", "passion fruit", 2005, 06, 01);
		Sloth jozek = stefan;
		Animal zdenek = kristoff;
				
		System.out.println(stefan.getDescription());
		System.out.println(kristoff.getDescription());
		System.out.println(jozek.getDescription());
		System.out.println(zdenek.getDescription());
		
		System.out.println(stefan.toString());
		System.out.println(benek.toString());
		System.out.println(zdenek.toString());
		
		System.out.println("stefan.hashCode()=" + stefan.hashCode());
		System.out.println("benek.hashCode()=" + benek.hashCode());
		System.out.println("kristoff.hashCode()=" + kristoff.hashCode());
		System.out.println("jozek.hashCode()=" + jozek.hashCode());
		System.out.println("zdenek.hashCode()=" + zdenek.hashCode());
		
		System.out.println("stefan.equals(benek) = " + stefan.equals(benek));
		System.out.println("kristoff.equals(zdenek) = " + kristoff.equals(zdenek));
		System.out.println("jozek.equals(benek) = " + jozek.equals(benek));
		System.out.println("kristoff.equals(stefan) = " + kristoff.equals(stefan));
		
		System.out.println("jozek == stefan = " + (jozek == stefan));
		System.out.println("zdenek == kristoff = " + (zdenek == kristoff));
		System.out.println("jozek == benek = " + (jozek == benek));
	}

}
