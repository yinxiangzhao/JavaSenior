package com.bcfx.stream;

import com.bcfx.functionInterface.Employee;
import com.bcfx.functionInterface.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yinxz
 * @Date 2022/10/3 16:40
 * @Description 归约操作 -- 匹配与查找
 */
public class StreamAPITest2 {
    /**
     * 1.匹配与查找
      */
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

        // allMatch(Predicate p) -- 检查是否匹配所有元素
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 20);
        System.out.println(allMatch);

        // anyMatch(Predicate p) -- 检查是否至少匹配一个元素
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 9000);
        System.out.println(anyMatch);

        // noneMatch(Predicate p) -- 检查是否没有匹配的元素
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().contains("令"));
        System.out.println(noneMatch);

        // findFirst -- 返回第一个元素
        Optional<Employee> employee = employees.stream().findFirst();
        System.out.println(employee);

        // findFirst -- 返回当前流中任意一个元素
        Optional<Employee> anyOne = employees.parallelStream().findAny();
        System.out.println(anyOne);
    }

    @Test
    public void test2() {
        List<Employee> employees = EmployeeData.getEmployees();

        // count -- 返回流中元素个数
        long count = employees.parallelStream().filter(e -> e.getSalary() > 5500).count();
        System.out.println(count);

        // max(Comparator com) -- 返回流中最大值
        Stream<Integer> ageSteam = employees.parallelStream().map(e -> e.getAge());
        Optional<Integer> max = ageSteam.max(Integer::compare);
        System.out.println(max);

        // min(Comparator com) -- 返回流中最大值
        Optional<Employee> min = employees.parallelStream()
                .min(((o1, o2) -> Integer.compare(o1.getAge(),o2.getAge())));
        System.out.println(min);
        System.out.println();

        // foreach(Consumer c) -- 内部迭代
        employees.stream().forEach(System.out::println);
        // 使用集合的遍历方法 -- 外部迭代
        employees.forEach(System.out::println);
    }

    /**
     * 2.归约
     */
    @Test
    public void test3(){
        // reduce (T identity, BinaryOperator) -- 可以将流中元素反复结合起来，得到一个值。返回T
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        // reduce(BinaryOperator) -- 可以将流中元素反复结合起来，得到一个值。返回Optional<T>
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);
        Optional<Double> sumSalary = salaryStream.reduce(Double::sum);
        System.out.println(sumSalary);
    }

    /**
     * 3.收集
     */
    @Test
    public void test4() {
        // collect(Collector c) -- 将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
        // 练习：查找年龄大于60岁的员工 ，结果返回一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> employeeList = employees.stream().filter(e -> e.getAge() > 60).collect(Collectors.toList());
        employeeList.forEach(System.out::println);
        System.out.println();

        Set<Employee> employeeSet = employees.stream().filter(e -> e.getAge() > 60).collect(Collectors.toSet());
        employeeSet.forEach(System.out::println);
    }
}
