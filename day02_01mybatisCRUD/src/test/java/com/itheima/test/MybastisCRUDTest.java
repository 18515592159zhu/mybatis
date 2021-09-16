package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 测试 mybatis 的 crud 操作
 */
public class MybastisCRUDTest {

    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before//在测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建构建者对象
        //3.创建 SqlSession 工厂对象
        factory = new SqlSessionFactoryBuilder().build(in);
        //4.创建 SqlSession 对象
        session = factory.openSession(true);
        //5.创建Dao的代理对象
        userDao = session.getMapper(IUserDao.class);
    }

    @After//在测试方法执行完成之后执行
    public void destroy() throws Exception {
        session.commit();
        //7.释放资源
        session.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<User> userList = userDao.findAll();
        for (User user:userList){
            System.out.println(user);
        }
    }

    @Test
    public void testFindById() {
        //6.执行操作
        User user = userDao.findById(41);
        System.out.println(user);
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUsername("modify User id_1");
        user.setAddress("北京市顺义区");
        user.setBirthday(new Date());
        user.setSex("女");
        System.out.println("保存操作之前：" + user);
        //执行保存操作
        userDao.saveUser(user);
        System.out.println("保存操作之后：" + user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(52);
        user.setUsername("mybastis update user");
        user.setAddress("北京市顺义区");
        user.setSex("女");
        user.setBirthday(new Date());
        //执行更新方法
        int res = userDao.updateUser(user);
        System.out.println(res);
    }

    @Test
    public void testDeleteUser() {
        //执行删除操作
        int res = userDao.deleteUser(53);
        System.out.println(res);
    }

    @Test
    public void testFindByName() {
        //执行操作
        List<User> userList = userDao.findByName("%mybatis%");
        //List<User> userList = userDao.findByName("mybatis");
        for (User user : userList)
            System.out.println(user);
    }

    @Test
    public void testFindTotal() {
        //执行操作
        int total = userDao.findTotal();
        System.out.println(total);
    }

    @Test
    public void testFindUserByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%mybatis%");
        vo.setUser(user);
        List<User> userList = userDao.findUserByVo(vo);
        for (User u : userList) {
            System.out.println(u);
        }
    }



}
