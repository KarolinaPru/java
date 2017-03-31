package com.karolina2;
	
public class Lower implements Converter {

	@Override
	public String convert(String src) {
		return src.toLowerCase();
	}
}
