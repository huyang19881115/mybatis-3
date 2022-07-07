package com.my.mybatis.binding;

import com.my.mybatis.session.SqlSession;
import lombok.extern.slf4j.Slf4j;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Description:
 * @ClassName MapperProxy
 * @Author: huyang
 * @Email huyang@bonc.com.cn
 * @Date: 2022/7/6 15:37
 * @Version: V1.0
 */
@Slf4j
public class MapperProxy<T> implements InvocationHandler, Serializable {
    private static final long serialVersionUID = -6424540398559729838L;

    private SqlSession sqlSession;
    private final Class<T> mapperInterface;

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        } else {
            return sqlSession.selectOne(method.getName(),args);
        }
    }






}
