package com.code.algorithmtest.getImportance;

import java.util.List;

/**
 * ClassName Employee
 * Description TODO
 *
 * @Date 2019/9/16 18:02
 * Version 1.0
 */
public class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}
