package com.karolina;

public class Sloth extends Animal {
	private static String naturalHabitat = "trees";
	private String favoriteFood;

	public Sloth(String name, int age, String favoriteFood) {
		super(name, age);
		this.favoriteFood = favoriteFood;
	}
	
	public String getFavoriteFood(){
		return favoriteFood;
	}
	
	public static String getNaturalHabitat(){
		return naturalHabitat;
	}
	
	@Override
	public String getDescription() {
		
		String slothDescription = String.format("Hi, my name is %1$s and I'm %2$d years old. I love eating %3$s and I live on %4$s.", 
				super.getName(), 
				super.getAge(),
				getFavoriteFood(),
				getNaturalHabitat()
				);
		return slothDescription;
		}
	
	@Override
	public boolean equals(Object otherObject){
		if(!super.equals(otherObject))
			return false;
		
		Sloth other = (Sloth)otherObject;
		// super.equals checked that this and other belong to the same class
		
		return this.favoriteFood == other.favoriteFood;
			}
	
	@Override
	public String toString(){
		return super.toString() + "[favorite food=" + favoriteFood + ", natural habitat=" + naturalHabitat + "]";
	}
	
	
}
