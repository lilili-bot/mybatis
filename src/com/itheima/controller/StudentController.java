package com.itheima.controller;

import com.itheima.bean.Student;
import com.itheima.service.StudentService;
import com.itheima.service.impl.StudentServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private StudentService service = new StudentServiceImpl();

    //查询功能
    @Test
    public void selectAll() {
        List<Student> students = service.selectAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    //根据ID查询功能
    @Test
    public void selectById() {
        Student student = service.selectById(1);
        System.out.println(student);
    }

    @Test
    public void insert() {
        int insertResult = service.insert(new Student(8, "Maga", 35, "1984-12-11"));
        System.out.println(insertResult);
    }

    @Test
    public void deleteById() {
        int delResult = service.deleteById(3);
        System.out.println(delResult);
    }

    @Test
    public void conditionSelect() {
        //测试动态SQL语句执行，重写mapper配置文件
        Student student = new Student();
        student.setSid(1);
        student.setName("zhangSan");
        //student.setAge(23);
        Student student1 = service.conditionSelect(student);
        System.out.println(student1);
    }

    @Test
    public void selectByIds() {
        List<Integer> sidList = new ArrayList<>();
        sidList.add(1);
        sidList.add(2);
        sidList.add(4);
        List<Student> students = service.selectByIds(sidList);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void selectPaging() {
        List<Student> students = service.selectPaging();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
