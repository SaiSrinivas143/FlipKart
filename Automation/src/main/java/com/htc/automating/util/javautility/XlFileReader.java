package com.htc.automating.util.javautility;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlFileReader {
	
	private Sheet xlsheet;
	private Workbook xlbook;
	
	public Object[][] getDataArray(String path,String sheetname) throws MyException{
		Object[][] tabarray=null;
		try {
			Loggers.info(XlFileReader.class.getName(), "Opening the xl file... ");
			FileInputStream fis = new FileInputStream(path);
			xlbook= new XSSFWorkbook(fis);
			xlsheet = xlbook.getSheet(sheetname);
			int totalrow=xlsheet.getLastRowNum();
			int totalcol=xlsheet.getRow(1).getPhysicalNumberOfCells();
			tabarray=new Object[totalrow][1];
			Loggers.info(XlFileReader.class.getName(), "Reading the xl file");
			for(int i=0;i<totalrow;i++) {
			Map<Object,Object> datamap=new HashMap<>();
			for(int j=0;j<totalcol;j++) {
				datamap.put(xlsheet.getRow(0).getCell(j).toString(), xlsheet.getRow(i+1).getCell(j).getStringCellValue());
			}
			tabarray[i][0]=datamap;
			System.out.println(tabarray[i][0]);
		}
		}catch(Exception e) {
			throw new MyException(e.getMessage());
		}
	Loggers.info(XlFileReader.class.getName(), "Read the xl file" );
	return tabarray;
	}
}