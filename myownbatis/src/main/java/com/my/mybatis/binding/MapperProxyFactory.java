package com.my.mybatis.binding;

import com.my.mybatis.session.SqlSession;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @Description:
 * @ClassName MapperProxyFactory
 * @Author: huyang
 * @Email huyang@bonc.com.cn
 * @Date: 2022/7/7 8:50
 * @Version: V1.0
 */
@Slf4j
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;


    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(SqlSession sqlSession){
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);


    }
}
