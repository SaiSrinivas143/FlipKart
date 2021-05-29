package com.htc.automating.util.javautility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class LoadPropertyFile {
	
	private static LoadPropertyFile file ;
	private LoadPropertyFile() {}
	
	public static LoadPropertyFile getInstance() {
		if(file==null) {
			file = new LoadPropertyFile();
		}
		return file;
	}
	
	private Properties prop;
	private InputStream input;
	
	public Properties getProperty(String filepath) throws MyException {
		try {
			input = new FileInputStream(filepath);
			prop=new Properties();
			prop.load(input);
		} catch (Exception e) {
			throw new MyException(e.getMessage());
		}
		return prop;
	}
}