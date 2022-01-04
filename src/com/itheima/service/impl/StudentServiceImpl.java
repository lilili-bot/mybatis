package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.bean.Student;
import com.itheima.mapper.StudentMapper;
import com.itheima.service.StudentService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentServiceImpl implements StudentService {


    @Override
    public List<Student> selectAll() {
        InputStream is = null;
        List<Student> list = null;
        SqlSession sqlSession = null;
        try {
            //1. resource获取输入流对象，读取配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2. 获取SQL session工厂类对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            //3. 用工厂类对象获取SQL session对象
            sqlSession = build.openSession(true);
            //4. 获取student Mapper接口的实现类对象 ！！！！这里和自己写实现类的步骤有所不同。
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            // 这里是一个多态，相当于父类接口类型，接收实现类对象 StudentMapper mapper = new StudentMapperImpl()
            //5. 通过实现类对象调用方法，接收结果。这里有区别，不需要使用sqlSession,
            list = mapper.selectAll(); //sqlSession.select("StudentMapper.selectAll");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6. 关闭流,释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override
    public Student selectById(Integer sid) {
        InputStream is = null;
        Student student = null;
        SqlSession sqlSession = null;
        try {
            //1. resource获取输入流对象，读取配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2. 获取SQL session工厂类对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            //3. 用工厂类对象获取SQL session对象
            sqlSession = build.openSession(true);
            //4. 获取student Mapper接口的实现类对象 ！！！！这里和自己写实现类的步骤有所不同。
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            // 这里是一个多态，相当于父类接口类型，接收实现类对象 StudentMapper mapper = new StudentMapperImpl()
            //5. 通过实现类对象调用方法，接收结果。
            student = mapper.selectById(sid); //sqlSession.selectOne("StudentMapper.selectById",sid);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6. 关闭流,释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return student;
    }

    @Override
    public Integer insert(Student stu) {
        InputStream is = null;
        int result = 0;
        SqlSession sqlSession = null;
        try {
            //1. resource获取输入流对象，读取配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2. 获取SQL session工厂类对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            //3. 用工厂类对象获取SQL session对象
            sqlSession = build.openSession(true);
            //4. 获取student Mapper接口的实现类对象 ！！！！这里和自己写实现类的步骤有所不同。
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            // 这里是一个多态，相当于父类接口类型，接收实现类对象 StudentMapper mapper = new StudentMapperImpl()
            //5. 通过实现类对象调用方法，接收结果。
            result = mapper.insert(stu); //sqlSession.selectOne("StudentMapper.insert",stu);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6. 关闭流,释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public Integer update(Student stu) {
        InputStream is = null;
        int result = 0;
        SqlSession sqlSession = null;
        try {
            //1. resource获取输入流对象，读取配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2. 获取SQL session工厂类对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            //3. 用工厂类对象获取SQL session对象
            sqlSession = build.openSession(true);
            //4. 获取student Mapper接口的实现类对象 ！！！！这里和自己写实现类的步骤有所不同。
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            // 这里是一个多态，相当于父类接口类型，接收实现类对象 StudentMapper mapper = new StudentMapperImpl()
            //5. 通过实现类对象调用方法，接收结果。
            result = mapper.update(stu); //sqlSession.selectOne("StudentMapper.update",stu);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6. 关闭流,释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public Integer deleteById(Integer sid) {
        InputStream is = null;
        int result = 0;
        SqlSession sqlSession = null;
        try {
            //1. resource获取输入流对象，读取配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2. 获取SQL session工厂类对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            //3. 用工厂类对象获取SQL session对象
            sqlSession = build.openSession(true);
            //4. 获取student Mapper接口的实现类对象 ！！！！这里和自己写实现类的步骤有所不同。
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            // 这里是一个多态，相当于父类接口类型，接收实现类对象 StudentMapper mapper = new StudentMapperImpl()
            //5. 通过实现类对象调用方法，接收结果。
            result = mapper.deleteById(sid); //sqlSession.selectOne("StudentMapper.deleteById",stu);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6. 关闭流,释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public Student conditionSelect(Student stu) {
        InputStream is = null;
        Student student = null;
        SqlSession sqlSession = null;
        try {
            //1. resource获取输入流对象，读取配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2. 获取SQL session工厂类对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            //3. 用工厂类对象获取SQL session对象
            sqlSession = build.openSession(true);
            //4. 获取student Mapper接口的实现类对象 ！！！！这里和自己写实现类的步骤有所不同。
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            // 这里是一个多态，相当于父类接口类型，接收实现类对象 StudentMapper mapper = new StudentMapperImpl()
            //5. 通过实现类对象调用方法，接收结果。
            student = mapper.conditionSelect(stu); //sqlSession.selectOne("StudentMapper.conditionSelect",stu);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6. 关闭流,释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return student;
    }

    @Override
    public List<Student> selectByIds(List<Integer> sids) {
        InputStream is = null;
        List<Student> studentList = null;
        SqlSession sqlSession = null;
        try {
            //1. resource获取输入流对象，读取配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2. 获取SQL session工厂类对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            //3. 用工厂类对象获取SQL session对象
            sqlSession = build.openSession(true);
            //4. 获取student Mapper接口的实现类对象 ！！！！这里和自己写实现类的步骤有所不同。
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            // 这里是一个多态，相当于父类接口类型，接收实现类对象 StudentMapper mapper = new StudentMapperImpl()
            //5. 通过实现类对象调用方法，接收结果。
            studentList = mapper.selectByIds(sids); //sqlSession.selectOne("StudentMapper.selectByIds",stu);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6. 关闭流,释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return studentList;
    }

    @Override
    public List<Student> selectPaging() {
        InputStream is = null;
        List<Student> list = null;
        SqlSession sqlSession = null;
        try {
            //1. resource获取输入流对象，读取配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2. 获取SQL session工厂类对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            //3. 用工厂类对象获取SQL session对象
            sqlSession = build.openSession(true);
            //4. 获取student Mapper接口的实现类对象 ！！！！这里和自己写实现类的步骤有所不同。
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            // 这里是一个多态，相当于父类接口类型，接收实现类对象 StudentMapper mapper = new StudentMapperImpl()
            // 4.1 实现分页功能
            //PageHelper.startPage(1, 3);
            PageHelper.startPage(2, 3);
            //5. 通过实现类对象调用方法，接收结果。这里有区别，不需要使用sqlSession,
            list = mapper.selectAll(); //sqlSession.select("StudentMapper.selectAll");

            PageInfo<Student> studentPageInfo = new PageInfo<>(list);
            System.out.println("total data number " + studentPageInfo.getTotal());
            System.out.println("total pages " + studentPageInfo.getPages());
            System.out.println("data number of each page " + studentPageInfo.getPageSize());
            System.out.println("current page number " + studentPageInfo.getPageNum());
            System.out.println("next pages " + studentPageInfo.getNextPage());
            System.out.println("previous pages " + studentPageInfo.getPrePage());
            System.out.println("Is current page the first page? " + studentPageInfo.isIsFirstPage());
            System.out.println("Is current page the last page?  " + studentPageInfo.isIsLastPage());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6. 关闭流,释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
