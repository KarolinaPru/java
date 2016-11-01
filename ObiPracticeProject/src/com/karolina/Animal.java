package com.karolina;

import java.util.Objects;

public abstract class Animal {
	private String name;
	private int age;
	
	public abstract String getDescription();
	
	public Animal(String name, int age){
		this.name = name;
		this.age = age;
	}

	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	@Override
	// Typem parametru musi być Object - w innym przypadku tworzymy zupełnie nową metodę, a nie przedefiniowujemy
	
	public boolean equals(Object otherObject){
		if (this == otherObject)
			return true;
		
		if (otherObject == null)
			return false;
		
		if (getClass() != otherObject.getClass())
			return false;
		
		Animal other = (Animal)otherObject;
		
		return Objects.equals(name, other.name) && age == other.age;
		}

	@Override
	public String toString() {
		return getClass().getName() + "[name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(name, age);
	}
	
}
