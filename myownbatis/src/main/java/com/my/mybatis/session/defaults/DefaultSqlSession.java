package com.my.mybatis.session.defaults;

import com.my.mybatis.binding.MapperRegistry;
import com.my.mybatis.session.SqlSession;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @ClassName DefaultSqlSession
 * @Author: huyang
 * @Email huyang@bonc.com.cn
 * @Date: 2022/7/7 9:12
 * @Version: V1.0
 */
@Slf4j
public class DefaultSqlSession implements SqlSession {

    /**
     * 映射器注册机
     */
    private MapperRegistry mapperRegistry;


    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }


    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + "方法：" + statement );
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type, this);
    }


}
