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

	// Workbook variales
	private static XSSFWorkbook workbook = null;
	private static XSSFSheet worksheet = null;
	private static Cell rowCell=null;
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
//		System.out.println("Value extracted from a particular cell is - "
//				+ getCellValueAt(workbookLocation, worksheetName, columnNameReference, rowIndex));

		
		System.out.println("Write cell values - ");
		writeCellValues(workbookLocation, worksheetName, columnNameReference, rowIndex);

	}

	/*
	 * Description: use this method to write data to specific cell by passing
	 * workbook details 
	 * Author: Zaheer Abbas 
	 * Creation Date: 28TH JUNE,2019
	 */
	private static void writeCellValues(String workbookLocation, String worksheetName, String columnNameReference2,
			int rowindex) {

		try {
			workbook = new XSSFWorkbook(workbookLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		worksheet = workbook.getSheet(worksheetName);
		System.out.println("Check if the cell value exists");
		
		extracted(columncount,columnNameReference,rowindex);
		
		rowCell = workbook.getSheet(worksheetName).getRow(rowindex).getCell(5);
		
		try {
			System.out.println(rowCell.toString());
			
		} catch (Exception e) {
			System.out.println("String is empty. Start writing data");
			rowCell.setCellValue("Hello Zaheer");
		}
		

	}

	private static void extracted(int columncount, String columnNameReference, int rowIndex) {
		for (iteratorforloop = 0; iteratorforloop <= columncount; iteratorforloop++) {
			System.out.println("Column names are - " + worksheet.getRow(rowIndex).getCell(iteratorforloop).toString());
			if (worksheet.getRow(0).getCell(iteratorforloop).toString().equalsIgnoreCase(columnNameReference)) {
				columnIndex = iteratorforloop;
				System.out.println("Column found at index -" + columnIndex);
				break;
			}
		}
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

		extracted(columncount,columnNameReference,2 );

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
