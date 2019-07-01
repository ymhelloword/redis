package ym.springRedis.entity;

import java.io.Serializable;

/**
 * @Author zjl
 * @Date 2019/6/30 17:07
 * 0.2
 */
public class User implements Serializable {
    private String name;
    private int age ;

    public String getName( ) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge( ) {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString( ) {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
