package com.sparta.sidhant.Controller;

import com.sparta.sidhant.Model.EmployeeDTO;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.sparta.sidhant.Controller.DuplicateRemover.cleanSet;

public class ThreadRunner extends Thread{

    public  void run(){
        long start = System.nanoTime();
        String url = "jdbc:mysql://localhost:3306/test";
        System.out.println("Connecting to DB!");
        System.out.println("Accessing the table!");
        System.out.println("Writing to the server!");
        try {
            Connection connection;
            Properties properties = new Properties();
            properties.load(new FileReader("src/main/resources/login.properties"));
            String username = properties.getProperty("userName");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url,username,password);

            connection.createStatement();
            for (EmployeeDTO e : cleanSet) {

                PreparedStatement preparedStatement = connection.prepareStatement("insert INTO `test`.`Employee_Table` " +
                        "(`Employee_ID`,`Name_Pre_Fix`,`First_Name`, `Middle_Initial`, `Last_Name`, `Gender`, `Email`, `Date_Of_Birth`, `Date_Of_Joining`, `Salary`) "
                        +
                        "values (?,?,?,?,?,?,?,?,?,?)");

                preparedStatement.setString(1,e.getEmp_ID());
                preparedStatement.setString(2,e.getNamePreFix());
                preparedStatement.setString(3, e.getFirstName());
                preparedStatement.setString(4,e.getMiddleInitial());
                preparedStatement.setString(5,e.getLastName());
                preparedStatement.setString(6,e.getGender());
                preparedStatement.setString(7,e.getEmail());
                preparedStatement.setString(8,e.getDob().toString());
                preparedStatement.setString(9,e.getDateOfJoining().toString());
                preparedStatement.setInt(10,e.getSalary());
                preparedStatement.execute();
            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Done writing to the server");
        System.out.println("Entries written: "+ (long) cleanSet.size());
        long finish = System.nanoTime();
        long totalTime = (finish - start);
        long convert = TimeUnit.SECONDS.convert(totalTime, TimeUnit.NANOSECONDS);
        System.out.println(convert + " seconds");
    }
}
