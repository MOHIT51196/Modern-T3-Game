package org.ttt17.application.utils;

import java.io.InputStream;

final public class ResourceLoader {

	public static InputStream load(String path){
		
		InputStream input = ResourceLoader.class.getClassLoader().getResourceAsStream(path);
		if(input == null){
			path = "//"+path;
			input = ResourceLoader.class.getClassLoader().getResourceAsStream(path);
		}
		
		return input;
	}
}
