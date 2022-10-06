package com.bcfx.stream;

import com.bcfx.functionInterface.Employee;
import com.bcfx.functionInterface.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author yinxz
 * @Date 2022/10/2 21:22
 * @Description  Stream筛选与切片
 */
public class StreamAPITest1 {
    /**
     * 1、删选与切片
     */
    @Test
    public void test1(){
        // filter(Predicate p) 接收 Lambda，从流中排除某些元素
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();
        // 测试，查询薪资高于5000的员工
        stream.filter(e -> e.getSalary() > 5000).forEach(System.out::println);
        System.out.println();

        // limit(n) —— 截断流，使其元素不超过给定数量。
        list.stream().limit(3).forEach(System.out::println);
        System.out.println();

        // skip(n) -- 跳过元素，返回一个扔掉了前n个元素的流。
        // 若流中元素不足n个,则返回一个空流。与limit(n)互补
        list.stream().skip(3).forEach(System.out::println);
        System.out.println();

        // distinct -- 筛选，通过流所生成元素的 hashcode() 和 equals() 去除重复元素
        list.add(new Employee(1009,"向问天",55,7324.12));
        list.add(new Employee(1009,"向问天",55,7324.12));
        System.out.println(list);
        System.out.println();

        list.stream().distinct().forEach(System.out::println);
    }

    /**
     * 2、映射
     */
    @Test
    public void test2(){
        // map(function f) -- 接收一个函数作为参数，将元素转换成其他形式或提取信息，
        // 该函数会被应用到每个元素上，并将其映射成一个新的元素

        List<String> list = Arrays.asList("aa","bb","cc","dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        System.out.println();

        // 练习1：获取员工姓名长度大于3的员工的姓名
        List<Employee> employeeList = EmployeeData.getEmployees();
        Stream<Employee> employeeStream = employeeList.stream();
        employeeStream.map(Employee::getName).filter(str -> str.length() > 2)
                .forEach(System.out::println);
        System.out.println();

        // flatMap(Function f) -- 接收一个函数作为参数，将流中的每个值都换成另一个流，
        // 然后把所有流连接成一个流。

        // 练习2：
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToStream);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });
        System.out.println();

        // flatMap() 类似于 addAll()
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest1::fromStringToStream);
        characterStream.forEach(System.out::println);
    }

    /**
     * 将字符串中的多个字符构成的集合转换为对应的Stream的实例
     * @param str
     * @return Stream<Character>
     */
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for(Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test3(){
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list2 = new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        // list1.add(list2);
        list1.addAll(list2);
        System.out.println(list1);
    }

    /**
     * 3.排序
     */
    @Test
    public void test4(){
        // sorted -- 自然排序
        List<Integer> list = Arrays.asList(12, 43, 56, 23, 41, 16, 78, -54, 0);
        list.stream().sorted().forEach(System.out::println);
        System.out.println();

        // sorted(Comparator com) -- 定制排序
        List<Employee> employeeList = EmployeeData.getEmployees();
        employeeList.stream().sorted((o1, o2) -> Integer.compare(o1.getAge(),o2.getAge()))
                .forEach(System.out::println);
    }
}
