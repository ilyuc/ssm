package com.ssm.controller;

import com.ssm.pojo.User;
import com.ssm.service.TestServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
/**
 * @author ilyuc
 * @date 2020/6/7 15:10
 */
@Controller
@RequestMapping("/abc")
public class TestSpringController {

    private static Logger logger= LoggerFactory.getLogger(TestSpringController.class);

    @Autowired
    private TestServiceInterface serviceInterface;

    @RequestMapping(method = RequestMethod.GET, value = "/allUser", headers = "Accept=application/json")
    public
    @ResponseBody
    List<User> allUser() {
        logger.info("success");
        return serviceInterface.findAllUser();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user", headers = "Accept=application/json")
    public
    @ResponseBody
    User user() {
        String userId = "zhangsan";
        return serviceInterface.findUserById(userId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/testTransaction", headers = "Accept=application/json")
    public
    @ResponseBody
    List<User> shiwu() {
        //测试注解事物
        serviceInterface.testTransaction();
        return serviceInterface.findAllUser();
    }
}
