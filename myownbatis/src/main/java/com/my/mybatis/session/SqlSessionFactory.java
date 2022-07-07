package com.my.mybatis.session;

/**
 * @Description:
 * @ClassName SqlSessionFactory
 * @Author: huyang
 * @Email huyang@bonc.com.cn
 * @Date: 2022/7/7 9:12
 * @Version: V1.0
 */
public interface SqlSessionFactory {

    /**
     * 打开一个 session
     * @return SqlSession
     */
    SqlSession openSession();
}
