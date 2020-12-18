package com.sparta.sidhant.Controller;

import com.sparta.sidhant.Model.EmployeeDTO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader extends  DuplicateRemover {
     static ArrayList<String> EmpID = new ArrayList<>();

    public static void readEmployees(String path)throws Exception {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            line = bufferedReader.readLine();
            String[] first = line.split(",");
            EmpID.add(first[0]);
            //close the buffer reader in try catch block, close the buffer reader in the finally section.
            List<EmployeeDTO> empList = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                EmployeeDTO employee = new EmployeeDTO(
                        data[0],
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        data[5],
                        data[6],
                        data[7],
                        data[8],
                        data[9]);
                empList.add(employee);
            }
          duplicateList(empList);
            ThreadRunner dc=new ThreadRunner();
            dc.start();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
