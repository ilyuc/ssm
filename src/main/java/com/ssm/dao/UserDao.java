package com.ssm.dao;

import com.ssm.pojo.User;

import java.util.List;
/**
 * @author ilyuc
 * @date 2020/6/7 15:10
 */
public interface UserDao {

    /**
     * 方法名 findUserById 需要与 mapper xml 中的 id 相同
     * @param userId
     * @return
     */
    User findUserById(String userId);

    List<User> findAllUser();

    void deleteById(String zhangsan);

    void addUser(User user);
}
