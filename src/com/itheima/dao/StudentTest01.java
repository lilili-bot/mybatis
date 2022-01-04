package com.itheima.dao;

import com.itheima.bean.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentTest01 {

    //查询学生表中的全部数据
    @Test
    public void selectAll() {
        //加载核心配置文件
        try {
            //InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

            InputStream is = StudentTest01.class.getClassLoader().getResourceAsStream("MyBatisConfig.xml");
            // 获取SQLSession工厂加工对象
            SqlSessionFactory sqlFactory = new SqlSessionFactoryBuilder().build(is);
            // 通过SQL SESSION工厂加工对象获取SQL SESSION对象
            SqlSession ss = sqlFactory.openSession();
            //执行映射配置文件中的SQL语句，并接收结果
            List<Student> students = ss.selectList("StudentMapper.selectAll");
            //处理结果
            for (Student student : students) {
                System.out.println(student);
            }
            //释放资源
            ss.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectById() throws IOException {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        // 获取SQLSession工厂加工对象
        SqlSessionFactory sqlFactory = new SqlSessionFactoryBuilder().build(is);
        // 通过SQL SESSION工厂加工对象获取SQL SESSION对象
        SqlSession ss = sqlFactory.openSession();
        //执行映射配置文件中的SQL语句，并接收结果
        Student stu = ss.selectOne("StudentMapper.selectById", 1);
        //处理结果
        System.out.println(stu);
        //释放资源
        ss.close();
        is.close();
    }

    @Test
    public void insert() throws IOException {
        //1. 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
        //2.获取SQLSession工厂加工对象
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3. 通过SQL SESSION工厂加工对象获取SQL SESSION对象
        SqlSession sqlSession = build.openSession(true);
        //4.1 执行映射配置文件中的SQL语句，并接收结果
        Student stu = new Student(5, "WangWu", 34, "2000-09-01");
        //4.2 submit event, 如果前面的OPEN SESSION 给true的参数，这里不需要提交
        sqlSession.commit();
        //4.3 处理结果
        int insertResult = sqlSession.insert("StudentMapper.insert", stu);
        System.out.println(insertResult);
        //6. 释放资源
        sqlSession.close();
        resourceAsStream.close();
        selectAll();
    }

    @Test
    public void update() throws IOException {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        // 获取SQLSession工厂加工对象
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        // 通过SQL SESSION工厂加工对象获取SQL SESSION对象
        SqlSession sqlSession = build.openSession(true);
        //执行映射配置文件中的SQL语句，并接收结果
        Student stu = new Student(5, "WangWu", 35, "2000-09-01");
        int updateResult = sqlSession.update("StudentMapper.update", stu);
        // submit event, 如果前面的OPEN SESSION 给true的参数，这里不需要提交
        //处理结果
        System.out.println(updateResult);
        //释放资源
        sqlSession.close();
        is.close();
        //verify update result
        selectAll();
    }

    @Test
    public void deleteById() throws IOException {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        //获取SQLSession工厂加工对象
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        //通过SQL SESSION工厂加工对象获取SQL SESSION对象
        SqlSession sqlSession = build.openSession(true);
        //执行映射配置文件中的SQL语句，并接收结果
        int sid = 5;
        int deleteResult = sqlSession.delete("StudentMapper.deleteById", sid);
        //submit event, 如果前面的OPEN SESSION 给true的参数，这里不需要提交
        //处理结果
        System.out.println(deleteResult);
        selectAll();
        //释放资源
        sqlSession.close();
        is.close();

    }
}
