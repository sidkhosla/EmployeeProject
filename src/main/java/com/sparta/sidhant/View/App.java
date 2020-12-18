package com.sparta.sidhant.View;

import com.sparta.sidhant.Controller.CSVReader;
public class App{
    public static void main(String[] args) throws Exception {
        System.out.println("Reading the CSV file");
        CSVReader.readEmployees("src/main/resources/EmployeeRecords.csv");
    }
}