package api.utilies;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "testData")
	public static String[][] readExcelTo2DArray() throws IOException {
		String ProjectPath = System.getProperty("user.dir")+"\\TestData\\ApiData.xlsx";
		//localpath
		//String Localpath ="C:\\Users\\mwisl\\OneDrive\\Documents\\Batch01\\ApiData.xlsx";
		///API_Framework/ExeclData/ApiData.xlsx
		//String[][] data = null;
        //C:\Users\mwisl\git\api_framework\API_Framework
		//XL_Utilities ut = new XL_Utilities(ProjectPath);
		FileInputStream file = new FileInputStream(new File(ProjectPath));

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Get the number of rows and columns in the sheet
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

		// Initialize the 2D array with dimensions
		String[][] data = new String[rowCount][colCount];

		// Iterate through the rows and cells to populate the 2D array
	    for (int i = 1; i < rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			if (row != null) {
				for (int j = 0; j < colCount; j++) {
					XSSFCell cell = row.getCell(j);
					if (cell != null) {
						// Handle different types of cells
						switch (cell.getCellType()) {
						case STRING:
							data[i][j] = cell.getStringCellValue();
							break;
						case NUMERIC:
							if (DateUtil.isCellDateFormatted(cell)) {
								data[i][j] = cell.getDateCellValue().toString();
							} else {
								data[i][j] = String.valueOf(cell.getNumericCellValue());
							}
							break;
						case BOOLEAN:
							data[i][j] = String.valueOf(cell.getBooleanCellValue());
							break;
						default:
							System.out.println("no data");
							//data[i][j] = "";
							break;
						}
					}
				}
			}
		}
		workbook.close(); // Close the workbook

		return data;

	}
}
