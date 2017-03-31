package com.karolina;

import java.util.Objects;

public abstract class Animal implements Cloneable {
	private String name;
	
	public abstract String getDescription();
	
	public Animal(String name){
		this.setName(name);
	}

	public String getName(){
		return name;
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
		
		return Objects.equals(name, other.name);
		}

	@Override
	public String toString() {
		return getClass().getName() + "[name=" + getName() + "]";
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(getName());
	}
	
	public Animal clone() throws CloneNotSupportedException {
		Animal cloned = (Animal) super.clone();
		return cloned;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
