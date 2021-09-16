package com.example;

import com.example.dao.StudentDao;
import com.example.domain.Student;
import com.example.utils.MyBatisUtils;
import com.example.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMyBatis {

    @Test
    public void testSelectStudentById() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = dao.selectStudentById(1006);

        System.out.println("student=" + student);
    }

    @Test
    public void testSelectMultiParam() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectMultiParam("小乔", 28);

        for (Student stu : students) {
            System.out.println("学生=" + stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiObject() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        QueryParam param = new QueryParam();
        param.setParamName("小乔");
        param.setParamAge(28);
        List<Student> students = dao.selectMultiObject(param);

        for (Student stu : students) {
            System.out.println("学生=" + stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
        student.setName("小乔");
        student.setAge(28);

        List<Student> students = dao.selectMultiStudent(student);

        for (Student stu : students) {
            System.out.println("学生=" + stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiPosition() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectMultiPosition("李四", 28);

        for (Student stu : students) {
            System.out.println("学生=" + stu);
        }
        sqlSession.close();
    }


    @Test
    public void testSelectMultiByMap() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Map<String, Object> data = new HashMap<>();
        data.put("myname", "李飞");
        data.put("age1", 28);

        List<Student> students = dao.selectMultiByMap(data);

        for (Student stu : students) {
            System.out.println("学生=" + stu);
        }
        sqlSession.close();
    }


    @Test
    public void testSelectUse$() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectUse$("'盾山'");

        for (Student stu : students) {
            System.out.println("学生=" + stu);
        }
        sqlSession.close();
    }


    @Test
    public void testSelectUse$Order() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectUse$Order("age");

        for (Student stu : students) {
            System.out.println("学生=" + stu);
        }
        sqlSession.close();
    }
}
