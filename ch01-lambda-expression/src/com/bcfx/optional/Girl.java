package com.bcfx.optional;

/**
 * @author yinxz
 * @Date 2022/10/4 11:54
 * @Description
 */
public class Girl {
    private String name;

    public Girl(String name) {
        this.name = name;
    }

    public Girl() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}
