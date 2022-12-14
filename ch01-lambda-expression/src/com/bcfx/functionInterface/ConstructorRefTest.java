package com.bcfx.functionInterface;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author yinxz
 * @Date 2022/10/1 17:48
 * @Description  构造器引用
 *
 * 一、构造器引用
 *      和方法引用类似，函数式接口的抽象方法的形参列表 和构造器的形参列表一致。
 *      抽象方法的返回值的类型即为构造器所属的类的类型
 *
 * 二、数组引用
 *      可以把数组看作是一个特殊的类，则写法与构造器引用一致。
 */
public class ConstructorRefTest {

    /**
     * 构造器引用
     * Supplier中的 T get()
     */
    @Test
    public void test1(){
        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println(sup.get());

        System.out.println("**************************");

        Supplier<Employee> sup1 = () -> new Employee();
        System.out.println(sup1.get());

        System.out.println("**************************");

        Supplier<Employee> sup2 = Employee::new;
        System.out.println(sup2.get());
    }

    /**
     * Function 中的 R apply(T t)
     */
    @Test
    public void test2(){
        Function<Integer, Employee> func = new Function<Integer, Employee>() {
            @Override
            public Employee apply(Integer id) {
                return new Employee(id);
            }
        };
        System.out.println(func.apply(1000));

        System.out.println("**************************");

        Function<Integer, Employee> func1 = id -> new Employee(id);
        System.out.println(func1.apply(1001));

        System.out.println("**************************");

        Function<Integer, Employee> func2 = Employee::new;
        System.out.println(func2.apply(1002));
    }

    /**
     * BiFunction 中的 R apply(T t, U u)
     */
    @Test
    public void test3(){
        BiFunction<Integer, String, Employee> func1 = (id, name) -> new Employee(id, name);
        System.out.println(func1.apply(1001, "Jack"));

        System.out.println("**************************");

        BiFunction<Integer, String, Employee> func2 = Employee::new;
        System.out.println(func2.apply(1002, "Michael"));
    }

    /**
     * 数组引用
     * Function 中的 R apply (T t)
     */
    @Test
    public void test4() {
        Function<Integer, String[]> func1 = length -> new String[length];
        String[] arr1 = func1.apply(5);
        System.out.println(Arrays.toString(arr1));

        System.out.println("**************************");

        Function<Integer, String[]> func2 = String[]::new;
        String[] arr2 = func2.apply(6);
        System.out.println(Arrays.toString(arr2));
    }
}
