package com.itheima.bean;

import java.util.Objects;

public class Student {
    private int sid;
    private String name;
    private int age;
    private String birthday;

    public Student() {
    }

    public Student(int sid, String name, int age, String birthday) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getSid() == student.getSid() &&
                getAge() == student.getAge() &&
                Objects.equals(getName(), student.getName()) &&
                Objects.equals(getBirthday(), student.getBirthday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSid(), getName(), getAge(), getBirthday());
    }
}
