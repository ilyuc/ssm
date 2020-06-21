package com.ssm.dao.impl;

import com.ssm.dao.UserDao;
import com.ssm.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author ilyuc
 * @date 2020/6/7 15:10
 */
@Repository
public class UserDaoImpl extends CommonDao implements UserDao{

    @Override
    public User findUserById(String userId) {
        return this.getSqlSession().selectOne(userId);
        //两者都查的出来，因为方法名即可找到 xml 中 id
        //return this.getSqlSession().selectOne("findUserById",userId);
    }

    @Override
    public List<User> findAllUser() {
        return this.getSqlSession().selectList("");
        // 两者都查的出来
        // return this.getSqlSession().selectList("findAllUser");
    }

    @Override
    public void deleteById(String userId) {
        this.getSqlSession().delete("deleteUserId",userId);
//        this.getSqlSession().delete("deleteUserId",userId);
    }

    @Override
    public void addUser(User user) {
        this.getSqlSession().insert("addUser",user);
    }
}
