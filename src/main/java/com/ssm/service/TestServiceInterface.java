package com.ssm.service;

import com.ssm.pojo.User;

import java.util.List;

/**
 * @author ilyuc
 * @date 2020/6/7 15:10
 */
public interface TestServiceInterface {

    /**
     * 根据 userId 查询出对应的 user
     * @param userId 用户英文简称
     * @return
     */
    User findUserById(String userId);

    /**
     * 查询出所有的用户
     * @return
     */
    List<User> findAllUser();

    /**
     * 测试注解事物
     */
    void testTransaction();

}
