package com.htc.dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProviderUtility {
	private Sheet xlsheet;
	private Workbook xlbook;
	@SuppressWarnings("incomplete-switch")
	public String[][] getDataArray(String path,String sheetname) throws IOException{
		//Object path="C:\\Users\\Hp\\eclipse-workspace\\space\\browserAutomation\\src\\main\\resources\\userlogindetails.xlsx";
		String[][] tabarray=null;
		try {
			FileInputStream fis = new FileInputStream( path);
			xlbook= new XSSFWorkbook(fis);
			xlsheet = xlbook.getSheet(sheetname);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		int totalrow=xlsheet.getLastRowNum();
		int totalcol=xlsheet.getRow(1).getPhysicalNumberOfCells();
		tabarray=new String[totalrow][1];	
		for(int i=0;i<totalrow;i++) {
			Map<Object,Object> datamap=new HashMap<>();
			for(int j=0;j<totalcol;j++) {
				switch(xlsheet.getRow(i+1).getCell(j).getCellType()) {
				case NUMERIC:
					if(HSSFDateUtil.isCellDateFormatted(xlsheet.getRow(i+1).getCell(j))) {
						DateFormat df = new SimpleDateFormat("dd/MM/yyy");
						datamap.put(xlsheet.getRow(0).getCell(j).toString(), df.format(xlsheet.getRow(i+1).getCell(j).getDateCellValue()));
					}
					else {
						long number = (long) xlsheet.getRow(i+1).getCell(j).getNumericCellValue();
						datamap.put(xlsheet.getRow(0).getCell(j).toString(), number);
					}
					break;
					
				case STRING :
					datamap.put(xlsheet.getRow(0).getCell(j).toString(), xlsheet.getRow(i+1).getCell(j).toString());	
					break;
				}
			}
			tabarray[i][0]=datamap.toString();
			System.out.println(tabarray[i][0]);
		}
	return tabarray;
	}
}
