package com.chen;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.mapper.UserMapper;
import com.chen.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    private UserMapper userMapper;

    /**
     * 插入
     */
    @Test
    void contextLoads() {
        for (int i = 101; i < 300; i++) {
            userMapper.insert(new User(i, "xiaojiansheng", "1812244934",0,0));
        }

    }

    /**
     * 根据id更新
     */
    @Test
    void test02(){
        //查询全部
//        userMapper.updateById(new User(4, "3333", "1812244934",0));
    }

    /**
     * 查询操作
     * 根据id查询
     */
    @Test
    void test03(){
        User user = userMapper.selectById(4);
        System.out.println(user);
    }

    /**
     * 根据多个id查询
     */
    @Test
    void test04(){
        List<User> userList = userMapper.selectBatchIds(Arrays.asList(1, 2, 3, 4));
        System.out.println(userList);
    }

    /**
     * 条件查询
     */
    @Test
    void test05(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","3333");
        map.put("id","2");
        List<User> users = userMapper.selectByMap(map);
        System.out.println(users);
    }

    /**
     * 分页查询
     */
    @Test
    void Test06(){
        Page<User> userPage = new Page<User>(1, 50);
        IPage<User> userIPage = userMapper.selectPage(userPage, null);
        System.out.println(userIPage.getRecords());
    }

    /**
     * 删除
     */
    @Test
    void test07(){
        int deleteById = userMapper.deleteById(10);
        System.out.println(deleteById);
    }

    /**
     * 批量删除
     */
    @Test
    void test08(){
        int deleteBatchIds = userMapper.deleteBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(deleteBatchIds);
    }

    /**
     * 多条件删除 条件之间为and
     */
    @Test
    void test09(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","xiaojiansheng2");
        map.put("password","1812244d");
        int delete = userMapper.deleteByMap(map);
        System.out.println(delete);
    }

    /**
     * 条件构造器
     */
    @Test
    void test10(){

    }

}
