package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelParser {

	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static HashMap<String, String> testData = new HashMap<>();

	public static void setExcelFile(String filePath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(new FileInputStream(new File(filePath)));
			sheet = workbook.getSheet(sheetName);
			collectData();
		} catch (IOException e) {

		}
	}

	private static int getRowCount() {
		return sheet.getLastRowNum() + 1;
	}

	private static void collectData() {
		for (int i = 1; i < getRowCount(); i++) {
			if (sheet.getRow(i).getCell(1).getCellType() == CellType.NUMERIC) {
				testData.put(sheet.getRow(i).getCell(0).getStringCellValue(),
						String.valueOf(sheet.getRow(i).getCell(1).getNumericCellValue()));
			} else {
				testData.put(sheet.getRow(i).getCell(0).getStringCellValue(),
						sheet.getRow(i).getCell(1).getStringCellValue());
			}
		}

	}

	public static HashMap<String, String> getTestData() {
		return testData;
	}
}
