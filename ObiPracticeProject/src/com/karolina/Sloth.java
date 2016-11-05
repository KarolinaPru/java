package com.karolina;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Sloth extends Animal implements Cloneable {
	private static String naturalHabitat = "trees";
	private String favoriteFood;
	private Date birthday;

	public Sloth(String name, String favoriteFood, int year, int month, int day) {
		super(name);
		this.setFavoriteFood(favoriteFood);
		GregorianCalendar calendar = new GregorianCalendar(year, month -1, day);
		this.birthday = calendar.getTime();
	}

	public String getFavoriteFood(){
		return favoriteFood;
	}

	public static String getNaturalHabitat(){
		return naturalHabitat;
	}
	
	public void setFavoriteFood(String favoriteFood) {
		this.favoriteFood = favoriteFood;
	}
	public Date getBirthday(){
		return birthday;
	}
	
	public void setBirthday(int year, int month, int day) {
		Date newBirthday = new GregorianCalendar(year, month -1, day).getTime();
		birthday.setTime(newBirthday.getTime());
	}
	
	@Override
	public String getDescription() {

		String slothDescription = String.format("Hi, my name is %1$s and I live on %3$s. I love eating %2$s! I was born on %4$tF.", 
				super.getName(), 
				getFavoriteFood(),
				getNaturalHabitat(),
				getBirthday()
				);
		return slothDescription;
	}

	@Override
	public boolean equals(Object otherObject){
		if(!super.equals(otherObject))
			return false;

		Sloth other = (Sloth)otherObject;
		// super.equals checked that this and other belong to the same class

		return Objects.equals (favoriteFood, other.favoriteFood) && Objects.equals(birthday, other.birthday);
	}

	@Override
	public String toString(){
		return super.toString() + "[favorite food=" + getFavoriteFood() + ", natural habitat=" + naturalHabitat + ", birthday=" + birthday + "]";
	}

	@Override
	public int hashCode(){
		return super.hashCode() + favoriteFood.hashCode() + naturalHabitat.hashCode() + birthday.hashCode();
	}

	public Sloth clone() throws CloneNotSupportedException {
		Sloth cloned = (Sloth) super.clone();
		cloned.birthday = (Date) birthday.clone();
		return cloned;

	}

}

