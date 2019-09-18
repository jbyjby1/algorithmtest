package com.code.algorithmtest.getImportance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 /*
 // Employee info
 class Employee {
 // It's the unique id of each node;
 // unique id of this employee
 public int id;
 // the importance value of this employee
 public int importance;
 // the id of direct subordinates
 public List<Integer> subordinates;
 };
 *
 * @Date 2019/9/16 18:02
 * Version 1.0
 */
public class Solution {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> idEmployees = employees.stream().collect(Collectors.toMap(employ -> employ.id, Function.identity()));
        return this.getImportance(idEmployees, id);
    }

    public int getImportance(Map<Integer, Employee> idEmployees, int id) {
        int result = 0;
        if(!idEmployees.containsKey(id)){
            return result;
        }
        Employee currentEmployee = idEmployees.get(id);
        result += currentEmployee.importance;
        if(currentEmployee.subordinates == null || currentEmployee.subordinates.isEmpty()){
            return result;
        }
        Optional<Integer> subordinatesImportance = currentEmployee.subordinates.stream().map(subordinate -> {
            return getImportance(idEmployees, subordinate);
        }).reduce((a, b) -> a + b);
        if(subordinatesImportance.isPresent()){
            result += subordinatesImportance.get();
        }
        return result;
    }

}
