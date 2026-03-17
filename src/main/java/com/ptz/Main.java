package com.ptz;

import com.opencsv.CSVReader;
import com.ptz.excel.OpenCSVReader;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            OpenCSVReader openCSVReader = new OpenCSVReader();
            List<String[]> dataList = openCSVReader.readAllRows();

        for (String[] data: dataList) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println(data[0] + "|" + data[1] + "|" + data[2]);
        }
    }
}