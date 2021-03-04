package com.code.algorithmtest.getImportance;

import java.util.*;
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
        //重要度
        int importance = 0;

        importance = this.getImportance(employees,Arrays.asList(id));

        return importance;
    }

    public Integer getImportance(List<Employee> employees,List<Integer> employeeIdList){
        Integer importance  = 0;
        List<Employee> employeeAnother = new ArrayList<>();
        for(Integer employeeId:employeeIdList){
            List<Integer> collect = employees.stream().filter(employee -> employee.id == employeeId)
                    .map(employee -> employee.importance).collect(Collectors.toList());
            employeeAnother = employees.stream().filter(employee -> !employee.subordinates.isEmpty()).collect(Collectors.toList());
            for(Integer integer:collect){
                importance = integer + importance;
            }
        }
        Integer importance1 = 0;
        if(!employeeAnother.isEmpty()){
            importance1 = this.getImportance(employeeAnother, employeeAnother.stream().map(employee -> {
                return employee.id;
            }).collect(Collectors.toList()));

        }else {
            return importance;
        }
        return importance1+  importance;
    }
}
