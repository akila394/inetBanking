package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public String[][] readExcel(String filePath, String sheetName) throws IOException {
        FileInputStream fileInputStream = null;
        Workbook workbook = null;

        try {
            fileInputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheet(sheetName);

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getLastCellNum();
            String[][] data = new String[rows][cols];

            // Iterate over rows
            for (int r = 0; r < rows; r++) {
                Row row = sheet.getRow(r);

                // Iterate over cells
                for (int c = 0; c < cols; c++) {
                    Cell cell = row.getCell(c);
                    data[r][c] = cell.toString();
                }
            }

            return data;
        } finally {
            if (workbook != null) {
                workbook.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }
}
