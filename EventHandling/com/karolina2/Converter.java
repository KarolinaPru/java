package com.karolina2;

public interface Converter {
	String convert(String src);

}

class Upper implements Converter {

	@Override
	public String convert(String src) {
		return src.toUpperCase();
	}
}	
