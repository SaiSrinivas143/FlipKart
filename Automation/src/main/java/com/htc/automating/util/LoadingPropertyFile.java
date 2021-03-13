package com.htc.automating.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import com.htc.automating.globalvariables.GlobalVariables;

public class LoadingPropertyFile extends GlobalVariables {
	private Properties prop;
	private InputStream input;
	private void filesetting() {
		try {
			input = new FileInputStream(XL_INPUT_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop=new Properties();
		try {
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//filepath=prop.getProperty("path");
		//xlsheetname=prop.getProperty("sheetname");
		//System.out.println(xlsheetname);
	}
	public String getXlValue(String Key) {
		return prop.getProperty(Key); 
	}
}
