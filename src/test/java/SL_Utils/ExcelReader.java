package SL_Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import SL_Config.TestConfig;

public class ExcelReader {

	public static void main(String[] args) {
		// Specify the path to your Excel file
		//String filePath1 = "C:\\DHANESH\\Automation\\SauceLabExcel.xlsx";

				TestConfig sc=new TestConfig();	
				String filePath= (sc.TEST_DATA_EXCEL_PATH);

		// Initialize FileInputStream and Workbook objects
		FileInputStream fis = null;
		Workbook workbook = null;

		try {
			// Read the Excel file
			fis = new FileInputStream(new File(filePath));
			workbook = WorkbookFactory.create(fis);

			// Get the first sheet of the Excel file
			Sheet sheet = workbook.getSheetAt(0);  // SHEET page No. and name in excel


			// Iterate through each row of the sheet
			for (Row row : sheet) {

				String username = row.getCell(0).getStringCellValue();
				String password = row.getCell(1).getStringCellValue();

				System.out.println("USERNAME IS : "+ username);
				System.out.println("PASSWORD IS : " + password); 

				// Iterate through each cell of the row  
				for (Cell cell : row) {
 
					// Print the cell value
					//System.out.print(cell.toString() + "\t");
				}
				System.out.println(); // Move to the next line for the next row
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// Close the FileInputStream and Workbook objects
				if (fis != null) {
					fis.close();
				}
				if (workbook != null) {
					workbook.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
}

