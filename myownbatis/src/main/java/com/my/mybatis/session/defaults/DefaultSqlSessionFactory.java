package com.my.mybatis.session.defaults;

import com.my.mybatis.binding.MapperRegistry;
import com.my.mybatis.session.SqlSession;
import com.my.mybatis.session.SqlSessionFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @ClassName DefaultSqlSessionFactory
 * @Author: huyang
 * @Email huyang@bonc.com.cn
 * @Date: 2022/7/7 9:13
 * @Version: V1.0
 */
@Slf4j
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }


    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
