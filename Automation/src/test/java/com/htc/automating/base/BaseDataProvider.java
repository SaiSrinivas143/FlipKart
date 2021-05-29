package com.htc.automating.base;

import org.testng.annotations.DataProvider;
import com.htc.automating.globalvariables.GlobalVariables;
import com.htc.automating.util.javautility.MyException;
import com.htc.automating.util.javautility.XlFileReader;

public class BaseDataProvider{
	
	private XlFileReader xlfile;
	
	@DataProvider(name="madison_form_data")
	public Object[][] getDataArray() throws MyException{
		xlfile = new XlFileReader();
		return xlfile.getDataArray(GlobalVariables.XL_INPUT_PATH, GlobalVariables.SHEET_NAME);
	}
}