package com.ssm.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;
/**
 * mybatis 1.2.0 及以上版本必须自己注入 sqlSessionFactory
 * @author ilyuc
 * @date 2020/6/7 15:10
 */
public class CommonDao extends SqlSessionDaoSupport{

    @Resource//有些使用 Autowired 注解不起作用，可以试一下这个
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
