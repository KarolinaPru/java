package com.karolina;

public class Sloth extends Animal implements Cloneable {
	private static String naturalHabitat = "trees";
	private String favoriteFood;

	public Sloth(String name, int age, String favoriteFood) {
		super(name, age);
		this.setFavoriteFood(favoriteFood);
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
		
		return this.getFavoriteFood() == other.getFavoriteFood();
			}
	
	@Override
	public String toString(){
		return super.toString() + "[favorite food=" + getFavoriteFood() + ", natural habitat=" + naturalHabitat + "]";
	}
	
	@Override
	public int hashCode(){
		return super.hashCode() + getFavoriteFood().hashCode() + naturalHabitat.hashCode();
	}
	
	public Sloth clone() throws CloneNotSupportedException {
		Sloth cloned = (Sloth) super.clone();
		return cloned;
		
	}

	public void setFavoriteFood(String favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

}
