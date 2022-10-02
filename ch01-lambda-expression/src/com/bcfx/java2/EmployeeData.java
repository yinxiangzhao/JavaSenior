package com.bcfx.java2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yinxz
 * @Date 2022/10/2 17:17
 * @Description
 */
public class EmployeeData {
    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();

        list.add(new Employee(1001,"风清扬",80,6000.38));
        list.add(new Employee(1002,"曲洋",60,9876.12));
        list.add(new Employee(1003,"刘正风",45,3000.82));
        list.add(new Employee(1004,"莫大",72,7567.31));
        list.add(new Employee(1005,"令狐冲",25,5555.32));
        list.add(new Employee(1006,"依琳",18,9500.43));
        list.add(new Employee(1007,"桃谷六仙",21,4333.32));
        list.add(new Employee(1008,"方证",67,2500.34));

        return list;
    }
}
