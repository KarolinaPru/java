package com.karolina;

import java.util.Objects;

public abstract class Animal implements Cloneable {
	private String name;
	private int age;
	
	public abstract String getDescription();
	
	public Animal(String name, int age){
		this.setName(name);
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
		
		return Objects.equals(getName(), other.getName()) && age == other.age;
		}

	@Override
	public String toString() {
		return getClass().getName() + "[name=" + getName() + ", age=" + age + "]";
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(getName(), age);
	}
	
	public Animal clone() throws CloneNotSupportedException {
		Animal cloned = (Animal) super.clone();
		return cloned;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
		
	}
	
}
