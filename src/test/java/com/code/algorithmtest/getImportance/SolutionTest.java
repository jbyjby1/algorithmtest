package com.code.algorithmtest.getImportance;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void getImportance() {
        com.code.algorithmtest.getImportance.Solution solution = new com.code.algorithmtest.getImportance.Solution();
        Employee employeeA = new Employee();
        employeeA.id = 1;
        employeeA.importance = 2;
        employeeA.subordinates = new ArrayList<Integer>(){
            {
                add(2);
            }
        };
        Employee employeeB = new Employee();
        employeeB.id = 2;
        employeeB.importance = 3;
        employeeB.subordinates = Collections.emptyList();
        //solution.addBinary("11", "1");
        List<Employee> employees = new ArrayList<Employee>(){
            {
                add(employeeA);
                add(employeeB);
            }
        };
        System.out.println(solution.getImportance(employees, 1));
    }
}