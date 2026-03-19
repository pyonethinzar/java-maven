package com.ptz.excel;

import com.ptz.constant.ExcelMappingConstants;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ExcelWriterWithTemplate {

    private static final Path TEMPLATE_FILE_PATH = Paths.get("src", "main", "resources", "files", "employee_template.xlsx");

    public static Map<String, String> prepareDataMapping() {
        Map<String, String> dataMapping = new HashMap<>();

        for (Map.Entry<String, String> entry : ExcelMappingConstants.EMPLOYEE_FIELD_MAPPING.entrySet()) {
            dataMapping.put(entry.getKey(), entry.getValue());
        }

        LocalDate now = LocalDate.now();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String formattedTime = sdf.format(now);

        for (Map.Entry<String, String> entry : ExcelMappingConstants.TIME_FIELD_MAPPING.entrySet()) {
            if (entry.getKey().equals("Current Time")) {
                dataMapping.put(entry.getKey(), formattedTime);
            }
        }

        return dataMapping;
    }


    public static void main(String[] args) {
        Map<String, String> dataMapping = prepareDataMapping();

        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fileOut = new FileOutputStream(TEMPLATE_FILE_PATH.toFile())) {

        } catch (Exception e) {
            System.out.println("Fail to write excel: " + TEMPLATE_FILE_PATH);
            System.out.println("Error: " + e.getMessage());
        }

    }
}
