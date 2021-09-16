package com.itheima.mybatis.sqlsession;

/**
 * SqlSessionFactory 的接口
 */
public interface SqlSessionFactory {

    /**
     * 用于打开一个新的SqlSession对象
     * @return
     */
    SqlSession openSession();
}
