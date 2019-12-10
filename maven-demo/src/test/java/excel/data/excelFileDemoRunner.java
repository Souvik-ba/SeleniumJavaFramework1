package excel.data;

public class excelFileDemoRunner {

	public static void main(String[] args) {
		String projectpath= System.getProperty("user.dir");
		excelFileDemo demo = new excelFileDemo(projectpath+"/excel/data.xlsx", "Sheet1");
		excelFileDemo.getStringData(2, 0);

	}

}
