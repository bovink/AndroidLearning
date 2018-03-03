package com.bovink.androidlearning;

/**
 * com.bovink.androidlearning
 *
 * @author bovink
 * @since 2018/3/3
 */

public class User {

    private final String name;
    private final String age;

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
