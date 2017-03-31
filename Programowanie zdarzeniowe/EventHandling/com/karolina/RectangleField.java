package com.karolina;
import java.util.Scanner;


public class RectangleField {

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        System.out.print("Podaj dugosc prostokata.");
	        int dlugosc = in.nextInt();
	        System.out.print("Podaj szerokosc prostokata. ");
	        int szerokosc = in.nextInt();
	        System.out.println("Pole Twojego prostokata to " + (dlugosc * szerokosc) + ".");
	        in.close();
	}
}
