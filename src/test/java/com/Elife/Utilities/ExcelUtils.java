package com.Elife.Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {
      public static List<List<String>> getColumnDataFromExcel(String filePath, String sheetName) {
            List<List<String>> tableData = new ArrayList<>();

            try (FileInputStream fis = new FileInputStream(new File(filePath));
                 Workbook workbook = new XSSFWorkbook(fis)) {

                  Sheet sheet = workbook.getSheet(sheetName);

                  for (Row row : sheet) {
                        List<String> rowData = new ArrayList<>();

                        for (Cell cell : row) {
                              rowData.add(convertCellToString(cell));
                        }

                        tableData.add(rowData);
                  }
            } catch (IOException e) {
                  e.printStackTrace();
            }

            return tableData;
      }

      // Method to convert a cell's content to a string
      private static String convertCellToString(Cell cell) {
            switch (cell.getCellType()) {
                  case STRING:
                        return cell.getStringCellValue().trim();
                  case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                              return cell.getDateCellValue().toString();
                        } else {
                              return String.valueOf(cell.getNumericCellValue());
                        }
                  case BOOLEAN:
                        return String.valueOf(cell.getBooleanCellValue());
                  case FORMULA:
                        return cell.getCellFormula();
                  default:
                        return "";
            }
      }

      public static List<Map<String, String>> getTripDetailsFromExcel(String excelFilePath, String sheetName) throws IOException {
            List<Map<String, String>> data = new ArrayList<>();

            FileInputStream file = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheet(sheetName);

            Row headerRow = sheet.getRow(0);
            int numOfCols = headerRow.getPhysicalNumberOfCells();

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                  Row row = sheet.getRow(i);
                  Map<String, String> rowData = new HashMap<>();

                  for (int j = 0; j < numOfCols; j++) {
                        String header = headerRow.getCell(j).getStringCellValue();
                        Cell cell = row.getCell(j);
                        String value = "";

                        if (cell != null) {
                              switch (cell.getCellType()) {
                                    case STRING:
                                          value = cell.getStringCellValue();
                                          break;
                                    case NUMERIC:
                                          value = String.valueOf((int) cell.getNumericCellValue());
                                          break;
                                    default:
                                          value = "";
                              }
                        }
                        rowData.put(header, value);
                  }
                  data.add(rowData);
            }

            workbook.close();
            file.close();

            return data;
      }
}

