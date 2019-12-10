package excel.data;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.soap.SOAPArrayType;

public class excelFileDemo {
	
	public static String project_path;
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	
	//Constructor--> Excel Path set//
	public excelFileDemo(String excelPath, String sheetName){
		
		try{
		fis= new FileInputStream(excelPath);
		workbook= new XSSFWorkbook(fis);
		sheet= workbook.getSheet(sheetName);
		}catch(Exception exp2){
			exp2.getMessage();
			exp2.getCause();
			exp2.printStackTrace();
		}
	}
	//Function for Row Count//
	public static int getRowCount(){
		int rowcount=0;
		try{
		rowcount=sheet.getPhysicalNumberOfRows();
		}catch(Exception exp3){
			exp3.getMessage();
			exp3.getCause();
			exp3.printStackTrace();
		}
		return rowcount;
		
		
			
		}
	//Function for Column Count//
	public static int getColCount(){
		int colcount=0;
		try{
		colcount=sheet.getRow(0).getPhysicalNumberOfCells();
		}catch(Exception exp4){
			exp4.getMessage();
			exp4.getCause();
			exp4.printStackTrace();
		}
		return colcount;
	}
	
	
	
	
	
	
	//Method to read String Data from excel file//
	public static String getStringData(int rowIndex, int cellIndex){
		String cellValue=null;
		try{
			
//			int rowcount= sheet.getPhysicalNumberOfRows();
			cellValue= sheet.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		//	System.out.println("Value is : "+cellValue);
			
		}catch(Exception exp){
			exp.getMessage();
			exp.getCause();
			exp.printStackTrace();
		}
		
		return cellValue;
		
	}
	
	//Method to read numeric Data from excel file//
	public static void getNumericData(int rowIndex, int cellIndex){
		
		try{

			double cellValue= sheet.getRow(rowIndex).getCell(cellIndex).getNumericCellValue();
			System.out.println("Value is : "+cellValue);
			
		}catch(Exception exp1){
			exp1.getMessage();
			exp1.getCause();
			exp1.printStackTrace();
		}
	}

}
