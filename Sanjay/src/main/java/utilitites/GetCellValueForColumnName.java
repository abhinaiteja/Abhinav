package utilitites;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetCellValueForColumnName {

	/*
	 * Description: Use this class file to get cell value for the column name passed
	 * Author: Zaheer Abbas Date created: 28th June 2019.
	 */

	//Workbook variales
	private static XSSFWorkbook workbook = null;
	private static XSSFSheet worksheet = null;
	private static int rowcount = 0;
	private static int columncount = 0;
	private static int columnIndex = 0;

	// Method variables to pass
	private static String workbookLocation = "/Users/zaheer/Documents/GitHub/Abhinav/Sanjay/src/main/java/Workbooks/SampleTest.xlsx";
	private static String worksheetName = "First";
	private final static int rowIndex = 0;
	private static String columnNameReference = "Name";
	private static int iteratorforloop = 0;

	public static void main(String[] args) {
		System.out.println("Value extracted from a particular cell is - "
				+ getCellValueAt(workbookLocation, worksheetName, columnNameReference, rowIndex));
	}

	private static String getCellValueAt(String workbookLocation, String worksheetName, String columnNameReference2,
			int rowindex) {
		System.out.println("Start data extraction from cells ");
		try {
			workbook = new XSSFWorkbook(workbookLocation);
//			workbook = new XSSFWorkbook("/Sanay/src/main/java/Workbooks/SampleTest.xlsx"); -- Throwing error for this relative path
		} catch (IOException e) {
			e.printStackTrace();
		}
		worksheet = workbook.getSheet(worksheetName);
		columncount = worksheet.getRow(0).getLastCellNum();
		System.out.println("Get count of columns in worksheet - " + columncount);

		for (iteratorforloop = 0; iteratorforloop <= columncount; iteratorforloop++) {
			System.out.println("Column names are - " + worksheet.getRow(0).getCell(iteratorforloop));
			if (worksheet.getRow(0).getCell(iteratorforloop).toString().equalsIgnoreCase(columnNameReference)) {
				columnIndex = iteratorforloop;
				System.out.println("Column found at index -" + columnIndex);
				break;
			}
		}

		rowcount = worksheet.getLastRowNum();
		System.out.println("Get count of rows in worksheet - " + rowcount);
		String dataExtracted = worksheet.getRow(rowindex).getCell(columnIndex).toString();
		System.out.println("rowdata is - " + dataExtracted);

		// Use below loop ENABLED for debugging purposes only
//		for (iteratorforloop = 1; iteratorforloop <= rowcount; iteratorforloop++) {
//			System.out.println("rowdata is - " + worksheet.getRow(iteratorforloop).getCell(columnIndex));
//		}

		return dataExtracted;
	}

}
