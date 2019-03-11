package org.koshik.jb.messenger.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.koshik.jb.messenger.model.Resource;

public class FileService {

	public void convertFile(String filepath,String filename) throws IOException  {
		
		String inputFilePath = filepath+"/"+filename+".xlsx";
		String outputFilePath=filepath+"/"+filename+".txt";
		
		//String excelFilePath = "C:/ReadFile.xlsx";
		FileInputStream inputStream;
		/*try {*/
			inputStream = new FileInputStream(new File(inputFilePath));
		
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		FileWriter writer = new FileWriter(outputFilePath, true);

		while (rowIterator.hasNext()) {
			Row nextRow = rowIterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();

				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING: {

					writer.write(cell.getStringCellValue());
					break;
				}
				case Cell.CELL_TYPE_BOOLEAN: {
					writer.write(cell.getStringCellValue());
					break;
				}
				case Cell.CELL_TYPE_NUMERIC: {
					writer.write(cell.getStringCellValue());
					break;
				}
				}
				writer.write(" | ");
			}
			writer.write("\r\n");

		}

		inputStream.close();
		writer.close();
		/*} catch (Exception e) {
			
			e.printStackTrace();
		}*/

	}



}
