package com.ptz.excel;

import com.ptz.domain.Employee;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ExcelWriterWithVariousData {

    private static final Path EXCEL_FILE_PATH = Paths.get("src", "main", "resources", "files", "employees.xlsx");

    public static void main(String[] args) {

        List<String> headerList = List.of("ID", "Name", "Position");

        List<Employee> employeeList = new ArrayList<>();
        Employee employee1 = new Employee(1, "John Doe", "Software Engineer");
        Employee employee2 = new Employee(2, "Jane Smith", "Project Manager");
        Employee employee3 = new Employee(3, "Anna", "Software Engineer");
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);

        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fileOut = new FileOutputStream(EXCEL_FILE_PATH.toFile())) {

            Sheet sheet = workbook.createSheet("Employees");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue(headerList.get(0));
            headerRow.createCell(1).setCellValue(headerList.get(1));
            headerRow.createCell(2).setCellValue(headerList.get(2));

            int rowNum = 1;

            for (Employee employee : employeeList) {
                Row dataRow = sheet.createRow(rowNum);
                dataRow.createCell(0).setCellValue(employee.getId());
                dataRow.createCell(1).setCellValue(employee.getName());
                dataRow.createCell(2).setCellValue(employee.getPosition());

                rowNum++;
            }

            workbook.write(fileOut);
        } catch (FileNotFoundException e) {
            System.out.println("Excel file not found: " + EXCEL_FILE_PATH);
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Fail to write excel: " + EXCEL_FILE_PATH);
            System.out.println("Error: " + e.getMessage());
        }



        ExcelWriterWithVariousData writer = new ExcelWriterWithVariousData();

    }

}
