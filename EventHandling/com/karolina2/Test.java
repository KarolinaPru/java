package com.karolina2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	public static void main(String[] args) throws IOException{
		   String line = "";
		   InputStreamReader converter = new InputStreamReader(System.in);
		   BufferedReader in = new BufferedReader(converter);
		   Converter upper = new Upper();
		   Converter lower = new Lower();
		   
		   
		   while (!(line.equals("quit"))){
		       line = in.readLine();
		       
		       char firstLetter = line.charAt(0);
		       if(Character.isLowerCase(firstLetter))
		    	   line = lower.convert(line);
		       if(Character.isUpperCase(firstLetter))
		    	   line = upper.convert(line);
		       System.out.println(line);
		   }
	}
}
