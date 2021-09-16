package com.itheima.mybatis.io;

import java.io.InputStream;

/**
 * 使用类加载器读取配置文件的类
 */
public class Resources {

    /**
     * 用于加载xml文件，并且得到一个流对象
     * 根据传入的参数，获取一个字节输入流
     * @param filePath
     * @return
     * 在实际开发中读取配置文件：
     *      第一：使用类加载器，但是有要求：a.文件不能过大 b.文件必须在类路径下（classpath）
     *      第二：使用ServletContext的getRealPath()
     */
    public static InputStream getResourceAsStream(String filePath) {
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}