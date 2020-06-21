package com.ssm.service.impl;

import com.ssm.dao.UserDao;
import com.ssm.pojo.User;
import com.ssm.service.TestServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ilyuc
 * @date 2020/6/7 15:10
 */
@Service
public class TestServcieImp implements TestServiceInterface{

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserById(String userId) {
        return userDao.findUserById(userId);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    /**
     * Transactional 注解事物，异常后回滚必须手动回滚，加括号内容
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void testTransaction() {

        /**注解式事物
         * 1.导入包 spring-tx
         * 2.开启注解事物的支持 <tx:annotation-driven/>
         * 3.需要使用事物的方法或类上加注解 @Transactional(rollbackFor = Exception.class)
         */
        userDao.deleteById("wangwu");
        int i = 1/0;
        userDao.addUser(new User("shiwu","20200621","事物测试","123456","shiwu@qq.com"));

    }
}
