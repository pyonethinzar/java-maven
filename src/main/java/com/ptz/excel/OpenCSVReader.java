package com.ptz.excel;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class OpenCSVReader {
    private static  final String CSV_FILE_PATH = "/files/employees.csv";

    public List<String[]> readAllRows(){
        InputStream inputStream = getClass().getResourceAsStream("/files/employees.csv");
        if(inputStream == null){
            throw new IllegalStateException("File not found in resources:" + CSV_FILE_PATH);
        }
        try(InputStreamReader inputStreamReader = new InputStreamReader(inputStream)){
            CSVReader csvReader = new CSVReader(inputStreamReader);
            return csvReader.readAll();

        } catch (IOException | CsvException e) {
            throw new IllegalStateException("File not found in resources:" + CSV_FILE_PATH,e);
        }
    }
}
