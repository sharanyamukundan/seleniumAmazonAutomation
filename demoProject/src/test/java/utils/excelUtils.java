package utils;



import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import test.amazonHomeTest;

public class excelUtils {
	
	public static void main(String args[]) {
		
		getRowCount();
		getData();
	}
	
	public static void getRowCount() {

		try {
			
			String path = System.getProperty("user.dir");
			XSSFWorkbook workbook = new XSSFWorkbook(path+"\\excel\\data.xlsx");
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println(rowCount);
			
		}catch(Exception exp){
			
			
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
			
		}
				
	}
	
	public static void getData(){
		
		try {
			
			String path = System.getProperty("user.dir");
			XSSFWorkbook workbook = new XSSFWorkbook(path+"\\excel\\data.xlsx");
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			
			//getting data from sheet
			String username = sheet.getRow(1).getCell(0).getStringCellValue();
			String pass = sheet.getRow(1).getCell(1).getStringCellValue();
			String searchText= sheet.getRow(1).getCell(2).getStringCellValue();
			
			//passing data to test
			amazonHomeTest.username= username;
			amazonHomeTest.pass = pass;
			amazonHomeTest.search = searchText;
			System.out.println(pass);
			System.out.println(username);
			
		}catch(Exception exp){
			
			
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
			
		}
		
		
		
	}
	

		
		

}
