package com.chen;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chen.mapper.UserMapper;
import com.chen.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class WrapperTest {
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询name不为空，并且密码不为空的用户，id大于等于110
     */
    @Test
    void test01(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name").isNotNull("password").ge("id",130);
        List<User> users = userMapper.selectList(wrapper);
        System.out.println("*********************************");
        System.out.println(users.size());
    }

    /**
     *  查询name = 陈宇超
     */
    @Test
    void test02(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("max(id) as maxId");
        wrapper.eq("name","陈宇超");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user.getMaxId());
    }
}
