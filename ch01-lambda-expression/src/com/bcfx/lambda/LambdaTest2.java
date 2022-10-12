package com.bcfx.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author yinxz
 * @Date 2022/9/28 20:27
 * @Description
 *
 *  java内置的4大核心函数接口
 *  消费型  Consumer中的 void accept(T t)
 *  供给型  Supplier中的 T get()
 *  函数型  Function 中的 R apply(T t)
 *  断定型  Predicate 中的 boolean test(T t)
 */
public class LambdaTest2 {

    @Test
    public void test1() {
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习太累了，去天上人间买了瓶矿泉水，价格为：" + aDouble);
            }
        });

        System.out.println("********************************");

        happyTime(400, money -> System.out.println("学习太累了，去天上人间买了瓶矿泉水，价格为：" + money));
    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京","南京","东京","天津");
        List<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });

        System.out.println(filterStrs);
        System.out.println("********************************");

        List<String> filterStrs1 = filterString(list, s -> s.contains("京"));
        System.out.println(filterStrs1);
    }

    // 根据给定的规则,过滤集合中的字符串。此规则由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();
        for(String s : list){
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
}
