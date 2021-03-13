package com.htc.automating.base;
import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.htc.automating.globalvariables.GlobalVariables;
import com.htc.dataprovider.UtilityDataProvider;

public class BaseDataProvider{
	
	private UtilityDataProvider dpu;
	
	@DataProvider(name="LoginCredentials")
	public Object[][] getDataArray() throws IOException{
		dpu = new UtilityDataProvider();
		return dpu.getDataArray(GlobalVariables.XL_INPUT_PATH, GlobalVariables.SHEET_NAME);
	}
}


