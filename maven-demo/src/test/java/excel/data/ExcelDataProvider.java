package excel.data;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	
	@Test(dataProvider="test1Data")
	public void test(String Items, String Count){
		System.out.println(Items+"   "+Count);
		
	}
	
	
	@DataProvider(name="test1Data")
	private Object[][] test1() {
		Object data[][]=testData("C:/Users/USER/workspace/maven-demo/excel/data.xlsx", "Sheet1");
		return data;

	}
	
//	public static void main(String[] args) {
//		testData("C:/Users/USER/workspace/maven-demo/excel/data.xlsx", "Sheet1");
//	}
	
	private static Object[][] testData(String excelPath, String sheetName) {
		excelFileDemo 	excel= new excelFileDemo(excelPath, sheetName);
		int rowCount= excel.getRowCount();
		int colCount= excel.getColCount();
		Object[][] data= new Object[rowCount-1][colCount];
		for(int i=1; i<rowCount; i++){
			for(int j=0; j<colCount; j++){
				String celldata=excel.getStringData(i, j);
				System.out.print(celldata+"  ");
				
				data[i-1][j]= celldata;
			}
		}
		return data;

	}

}
