package utilitites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class GetCellValueForColumnName {

	/*
	 * Description: Use this class file to get cell value for the column name passed
	 * Author: Zaheer Abbas Date created: 28th June 2019.
	 */

	// Workbook variales
	private static XSSFWorkbook workbook = null;
	private static XSSFSheet worksheet = null;
	private static XSSFRow row=null;
	private static Cell cellData=null;
	private static Cell rowCell=null;
	private static int rowcount = 0;
	private static int columncount = 0;
	private static int columnIndex = 0;
    
	private static FileOutputStream fos;

	// Method variables to pass
	private static String workbookLocation = "/Users/zaheer/Documents/GitHub/Abhinav/Sanjay/src/main/java/Workbooks/Master.xlsx";
	private static String worksheetName = "Custom";
	private final static int rowIndex = 0;
	private static String columnNameReference = "Name";
	private static int iteratorforloop = 0;

	public static void main(String[] args) throws Exception {
//		System.out.println("Value extracted from a particular cell is - "
//				+ getCellValueAt(workbookLocation, worksheetName, columnNameReference, rowIndex));

		
		System.out.println("Write cell values - ");
		writeCellValues(workbookLocation, worksheetName, columnNameReference, rowIndex);
		
//		System.out.println("Create a new excel workbook at given location - ");
//		create_new_Excel(System.getProperty("user.dir"));
		
//		System.out.println("Create a new worksheet inside current workbook.");
//		create_new_worksheet("master.xlsx");
		
//		System.out.println("Get Row data in variables");
//		getRowDatainVariables();
	}

	private static void getRowDatainVariables() throws FileNotFoundException, IOException {
		System.out.println("Get Row data from variables");
		workbook = new XSSFWorkbook(new FileInputStream("CKB_Object_Mapping_Document Master v2017.2 - Editable.xlsm"));
		worksheet = workbook.getSheet("Planogram Position");
		System.out.println("Sheet is accessible");
	
		int rowCount = worksheet.getLastRowNum();
		System.out.println("Get row count -"+rowCount);
		int indexcolumnb=0;
		row = worksheet.getRow(2);
		System.out.println("Get all column names");
		columncount = row.getPhysicalNumberOfCells();
		System.out.println(columncount);
		for (int i = 0; i < columncount; i++) {
			String cellValue = row.getCell(i).toString();
			System.out.println("Column names are - "+cellValue);
			
			if(cellValue.equalsIgnoreCase("Overriding Name"))
			{
				indexcolumnb=i;
				System.out.println("Found column name at index - "+indexcolumnb);
				break;
			}
		}

		System.out.println("Enter data into a 2D array");
		String[][] data=new String[rowCount][2];
		for (int i = 0; i < rowCount; i++) {
			data[i][0]=worksheet.getRow(i).getCell(0).toString();
			data[i][1]=worksheet.getRow(i).getCell(indexcolumnb).toString();
		}
		System.out.println("Print array values");
		for (int i = 2; i < rowCount; i++) {
			System.out.println(data[i][0]+" - "+ data[i][1]);
		}
		
		
	

		System.out.println("Closing workbook");
		workbook.close();
	}

	private static void create_new_worksheet(String string) throws Exception {

		System.out.println("Location of workbook to create is " + string);
		
		try {
			workbook = new XSSFWorkbook(new File(string));
		} catch (Exception e) {
			System.out.println("Exception while accessing workbook.");
		}

		String sheetname = "Dynamo";

		System.out.println("Sheet is not present. Create a new worksheet");
		
		worksheet = workbook.createSheet(sheetname);
		fos = new FileOutputStream(new File(string));
		workbook.write(fos);
		fos.close();
		
		System.out.println("Closing FileOutputStream connection.");
	}

	/*
	 * Description: Use this method to dynamcially create a new excel workbook at given location
	 * Author: Zaheer Abbas
	 * Creation date: 6th July, 2019
	 */
	private static void create_new_Excel(String property) throws FileNotFoundException {

		System.out.println("Location to create excel workbook is : " + property);
		workbook = new XSSFWorkbook();
		FileOutputStream fos = new FileOutputStream(new File("master.xlsx"));

		try {
			workbook.write(fos);
			fos.close();
		} catch (Exception e) {
			System.out.println("Created new workbook succesfully.");
		}

		System.out.println("Continue with remaining integration of program.");

	}

	/*
	 * Description: use this method to write data to specific cell by passing
	 * workbook details 
	 * Author: Zaheer Abbas 
	 * Creation Date: 28TH JUNE,2019
	 */
	private static void writeCellValues(String workbookLocation, String worksheetName, String columnNameReference2,
			int rowindex) throws IOException {

		System.out.println("Workbooklocation is " + workbookLocation);
		File fileObj = new File(workbookLocation);

		System.out.println("File location is " + fileObj.getAbsolutePath());

		System.out.println("Check if file exists - " + fileObj.exists() + "  -  " + fileObj.isFile());

		if (fileObj.exists() == true && fileObj.isFile() == true) {
			System.out.println("File exists....");
		} else {
			System.out.println("File does not exist. Creating a new file with same name");
			FileOutputStream fosObj = new FileOutputStream(fileObj);
			fosObj.close();
		}

		workbookLocation = fileObj.getAbsolutePath();
		System.out.println("Workbooklocation is " + workbookLocation);

		try {
			workbook = new XSSFWorkbook(workbookLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}

		worksheet = workbook.getSheet(worksheetName);
		System.out.println("Check if worksheet is null - " + worksheet.getSheetName());
		if (worksheet == null) {
			System.out.println("Sheet does not exist. Create a new worksheet.");
			worksheet = workbook.createSheet(worksheetName);
		}

//		System.out.println("Check if the cell value exists");
//		extracted(columncount, columnNameReference, rowindex);

//		rowCell = workbook.getSheet(worksheetName).getRow(rowindex).getCell(5);
//		try {
//			System.out.println(rowCell.toString());
//
//		} catch (Exception e) {
//			System.out.println("String is empty. Start writing data");
//			rowCell.setCellValue("Hello Zaheer");
//		}

		System.out.println("Create new columns");
		workbook.getSheet(worksheetName).getRow(0).createCell(0).setCellValue("Field");
		workbook.getSheet(worksheetName).getRow(0).createCell(1).setCellValue("Override");
		workbook.getSheet(worksheetName).getRow(0).createCell(2).setCellValue("Status");
		
		System.out.println("Writing File Output Stream");
		FileOutputStream fos = new FileOutputStream(fileObj);
		workbook.write(fos);

		System.out.println("Closing FOS and Workbook");
		fos.close();
		workbook.close();
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
