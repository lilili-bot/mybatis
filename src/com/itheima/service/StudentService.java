package com.itheima.service;

import com.itheima.bean.Student;

import java.util.List;

public interface StudentService {
    //查询全部
    public abstract List<Student> selectAll();

    //根据ID查询
    public abstract Student selectById(Integer sid);

    //新增数据
    public abstract Integer insert(Student stu);

    //根据ID修改数据
    public abstract Integer update(Student stu);

    //根据ID删除数据
    public abstract Integer deleteById(Integer sid);

    //根据条件选择出数据
    public abstract Student conditionSelect(Student stu);

    //根据ID选出数据
    public abstract List<Student> selectByIds(List<Integer> sids);

    //分页显示
    public abstract List<Student> selectPaging();
}
