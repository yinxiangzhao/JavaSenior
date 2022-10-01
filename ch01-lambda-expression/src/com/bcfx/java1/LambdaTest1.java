package com.bcfx.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author yinxz
 * @Date 2022/9/27 21:34
 * @Description Lambda表达式的使用
 *
 *
 * Lambda表达式的本质： 作为函数式接口的实例
 *        如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口
 * Lambda表达式的使用： 分为6种情况
 *
 * 总结：所以以前用匿名函数实现类表示的现在都可以用Lambda表达式来写
 */
public class LambdaTest1 {
    // 语法格式一： 无参，无返回值
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello bcfx!");
            }
        };
        r1.run();
        System.out.println("***********************************");
        Runnable r2 = () -> {
            System.out.println("Hello yinxz!");
        };
        r2.run();
    }

    // 第二种情况：Lambda需要一个参数，但是没有返回值
    @Test
    public void test2(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("hello yinxz");
        System.out.println("***********************************");
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("hello lambda");
    }

    // 语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
    @Test
    public void test3(){
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("hello lambda");

        System.out.println("***********************************");

        Consumer<String> con2 = (s) -> {
            System.out.println(s);
        };
        con2.accept("hello liuzhengfeng");
    }

    @Test
    public void test4(){
        // 类型推断
        ArrayList<String> list = new ArrayList<>();

        int[] arr = {1,2,3};
    }


    // 语法格式四：Lambda若只需要一个参数时， 参数的小括号可以省略
    @Test
    public void test5(){
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("hello quyang");

        System.out.println("***********************************");

        Consumer<String> con2 = s -> {
            System.out.println(s);
        };
        con2.accept("hello liuzhengfeng");
    }

    // 语法格式五：Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test6(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);

        System.out.println("***********************************");

        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        int compare2 = com2.compare(21, 12);
        System.out.println(compare2);
    }

    // 语法格式六 ： 当Lambda体只有一条语句时，return与大括号若有， 都可以省略
    @Test
    public void test7(){
        Comparator<Integer> com1 = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        int compare1 = com1.compare(21, 12);
        System.out.println(compare1);

        System.out.println("***********************************");

        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(9, 12));
    }

}
