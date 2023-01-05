package com.chen;

import com.chen.mapper.UserMapper;
import com.chen.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        User user = new User(3, "xiaojiansheng", "1812244934");
        userMapper.insert(user);
    }

    @Test
    void test02(){
        //查询全部
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList);
    }

}
