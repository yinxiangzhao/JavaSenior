package com.bcfx.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @author yinxz
 * @Date 2022/10/4 11:59
 * @Description  测试 Optional 类
 *      Optional类：为了在程序中避免出现空指针异常而创建的，
 *      常用的方法：ofNullable(T t) 和 orElse(T t)
 */
public class OptionalTest {

    /**
     * 创建Optional类的方式：
     *      Optional.of(T t) : 创建一个 Optional 实例，t 必须非空;
     *      Optional.empty() : 创建一个空的 Optional 实例
     *      Optional.ofNullable(T t) : t 可以为 null
     */
    @Test
    public void test1(){
        Girl girl = new Girl();
        girl = null;
        // of(T t) : 保证 t 是非空的
        Optional<Girl> girlOptional = Optional.of(girl);
        System.out.println(girlOptional);
    }

    @Test
    public void test2(){
        Girl girl = new Girl();
        girl = null;
        // ofNullable(T t) : t 可以为null
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        System.out.println(girlOptional);

        // orElse(T t1)：如果当前的Optional内部封装的t是非空的，则返回内部的t。
        // 如果内部的t是空的，则返回orElse()方法中的参数t1。
        Girl girl1 = girlOptional.orElse(new Girl("蓝凤凰"));
        System.out.println(girl1);
    }

    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }

    // 空指针异常
    @Test
    public void test3(){
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    // 优化以后的getGirlName()
    public String getGirlName1(Boy boy) {
        if(boy != null) {
            Girl girl = boy.getGirl();
            if(girl != null) {
                return girl.getName();
            }
        }
        return null;
    }

    @Test
    public void test4(){
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }

    // 使用Optional类的getGirlName()
    public String getGirlName2(Boy boy) {
        Optional<Boy> optionalBoy = Optional.ofNullable(boy);
        // 此时的boy1一定非空
        Boy boy1 = optionalBoy.orElse(new Boy(new Girl("任盈盈")));
        Girl girl = boy1.getGirl();
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        // 此时的girl1一定非空
        Girl girl1 = optionalGirl.orElse(new Girl("岳灵珊"));
        return girl1.getName();
    }

    @Test
    public void test5(){
        // 空值情况
        Boy boy = null;
        boy = new Boy();
        // 正常情况
        boy = new Boy(new Girl("赵敏"));
        String girlName = getGirlName2(boy);
        System.out.println(girlName);
    }
}
