package com.bcfx.java3;

import com.bcfx.java2.Employee;
import com.bcfx.java2.EmployeeData;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author yinxz
 * @Date 2022/10/2 21:22
 * @Description  Stream筛选与切片
 */
public class StreamAPITest1 {
    // 1、删选与切片
    @Test
    public void test1(){
        // filter(Predicate p) 接收 Lambda，从流中排除某些元素
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();
        // 测试，查询薪资高于5000的员工
        stream.filter(e -> e.getSalary() > 5000).forEach(System.out::println);
        System.out.println();

        // limit(n) ——截断流，使其元素不超过给定数量。
        list.stream().limit(3).forEach(System.out::println);
    }
}
