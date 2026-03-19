package com.ptz.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExcelWriter {

    private static final Path EXCEL_FILE_PATH = Paths.get("src", "main", "resources", "files", "students.xlsx");

    public static void main(String[] args) throws Exception {

        Files.createDirectories(EXCEL_FILE_PATH.getParent());

        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fileOut = new FileOutputStream(EXCEL_FILE_PATH.toFile())) {

            Sheet sheet = workbook.createSheet("Students");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Name");
            header.createCell(2).setCellValue("Score");

            Row row1 = sheet.createRow(1);
            row1.createCell(0).setCellValue(1);
            row1.createCell(1).setCellValue("Alice");
            row1.createCell(2).setCellValue(85);

            Row row2 = sheet.createRow(2);
            row2.createCell(0).setCellValue(2);
            row2.createCell(1).setCellValue("Bob");
            row2.createCell(2).setCellValue(90);

            workbook.write(fileOut);
        }
    }
}
