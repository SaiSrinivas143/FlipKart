package com.htc.automating.base;
import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.htc.automating.globalvariables.GlobalVariables;
import com.htc.dataprovider.XlFileReader;

public class BaseDataProvider{
	
	private XlFileReader dpu;
	
	@DataProvider(name="LoginCredentials")
	public Object[][] getDataArray() throws IOException{
		dpu = new XlFileReader();
		return dpu.getDataArray(GlobalVariables.XL_INPUT_PATH, GlobalVariables.SHEET_NAME);
	}
}


