package com.sparta.sidhant.Controller;
import com.sparta.sidhant.Model.EmployeeDTO;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DuplicateRemover{
    static ArrayList<String> EmpID = new ArrayList<>();
  public  static Set<EmployeeDTO> cleanSet =null;
    public static void duplicateList(List<EmployeeDTO> empList) throws IOException {
//        System.out.println("juherfushv");
        Set<EmployeeDTO> empSet = new HashSet<>(empList);

        Set<String> cruptSet = new HashSet<>();

        int y = 0;
        String[] idx = new String[100000];
        for (EmployeeDTO e : empList) {
            EmpID.add(e.getEmp_ID());
            idx[y] = e.getEmp_ID();
            y++;
        }
        int ct = 0, j, bb;
        for (bb = 0; bb < empList.size(); bb++) {
            for (j = 0; j < EmpID.size(); j++) {
                if (EmpID.get(bb).equals(EmpID.get(j))) {
                    ct++;
                }
            }
            if (ct > 1) {
                cruptSet.add(idx[bb]);
            }
            ct = 0;
        }
        FileWriter fw = new FileWriter("src/main/resources/bad.txt");
        y = 0;
        for (String e : cruptSet) {
            for (EmployeeDTO g : empSet) {
                if (g.getEmp_ID().equals(e)) {
                    y++;
                    fw.write(g.getEmp_ID() +
                            "," + g.getNamePreFix() +
                            "," + g.getFirstName() +
                            "," + g.getMiddleInitial() +
                            "," + g.getLastName() +
                            "," + g.getDateOfJoining()+
                            "," + g.getDob()+
                            "," + g.getGender() +
                            "," + g.getEmail() +
                            "," + g.getSalary());
                    fw.write("\n");
//                    System.out.println("FORRR");
                }
            }

        }

        System.out.println("Total duplicates found: "+y);
        System.out.println("Writing duplicate entries to the bad.txt file!");
        fw.close();

        List<EmployeeDTO> cleanList = new ArrayList<>();
        //here now we are going to remove the value from
        y = 0;
        for (EmployeeDTO g : empSet) {
            for (String e : cruptSet) {
                if (g.getEmp_ID().equals(e)) {
                    y++;
                }
            }
            if (y == 0) {
                EmployeeDTO employee = new EmployeeDTO(
                        g.getEmp_ID(),
                        g.getNamePreFix(),
                        g.getFirstName(),
                        g.getMiddleInitial(),
                        g.getLastName(),
                        g.getGender(),
                        g.getEmail(),
                        g.getDob().toString(),
                        g.getDateOfJoining().toString(),
                        g.getSalary().toString());
                cleanList.add(employee);
            }
            y = 0;
        }
        cleanSet=new HashSet<>(cleanList);
    }
}
