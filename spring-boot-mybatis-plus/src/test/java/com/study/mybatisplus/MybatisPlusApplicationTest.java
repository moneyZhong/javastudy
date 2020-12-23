package com.study.mybatisplus;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.mybatisplus.dao.UserMapper;
import com.study.mybatisplus.dao.dataobject.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MybatisPlusApplicationTest {
    @Resource
    private UserMapper userMapper;

    /**
     * 查询所有
     */
    @Test
    public void getAll(){
        //    @TableLogic  添加后自动去除了软删除记录
        List<User> userDOS = userMapper.selectList(null);
       userDOS.forEach(System.out::println);
    }

    /**
     * 根据id查询,某条记录
     */
    @Test
    public void getOne(){
        User user = userMapper.selectById(3);
        System.out.println(user);
    }

    /**
     * 根据id 查询多条
     */
    @Test
    public void getBatch(){

        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    /**
     * 条件查询
     */
    @Test
    public void testSelectByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Helen");//map中的key对应的是数据库中的列名
        map.put("age", 18);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    /**
     * 分页查询
     */
    @Test
    public void testSelectPage() {
        Page<User> page = new Page<>(1,5);
        userMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }

    @Test
    public void testQueryLogicDel(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("deleted","1");
        List list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    /**
     * 删除
     */
    @Test
    public void testDeleteById(){
        int result = userMapper.deleteById(5L);
        System.out.println(result);
    }

    /**
     * 批量删除
     */
    @Test
    public void testDeleteBatchIds() {
        int result = userMapper.deleteBatchIds(Arrays.asList(8, 9, 10));
        System.out.println(result);
    }


    /**
     * 条件删除
     */
    @Test
    public void testDeleteByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Helen");
        map.put("age", 18);
        int result = userMapper.deleteByMap(map);
        System.out.println(result);
    }

    /**
     * 测试 逻辑删除
     */
    @Test
    public void testLogicDelete() {
        int result = userMapper.deleteById(1L);
        System.out.println(result);
    }





    /**
     * 单条插入
     *
     *全局设置主键生成策略
     *mybatis-plus.global-config.db-config.id-type=auto
     */
    @Test
    public void insertData(){
        User user = new User();
        user.setName("Helen");
        user.setAge(18);
        user.setEmail("55317332@qq.com");
        int result = userMapper.insert(user);
        System.out.println(result); //影响的行数
        System.out.println(user); //id自动回填, 注意id为1338866830032216065,通过设置@TableId(type = IdType.AUTO)
    }

    /**
     * 更新
     */
    @Test
    public void testUpdateById(){
        User user = new User();
        user.setId(1L);
        user.setAge(28);
        int result = userMapper.updateById(user);
        System.out.println(result);
        //更新或者插入数据自动填充
        //@TableField(fill = FieldFill.INSERT_UPDATE)

    }

    @Test
    public void testUpdateByIdWithVersion(){
        User user = userMapper.selectById(2);
        System.out.println(user);
        user.setId(1L);
        user.setAge(280);
        user.setVersion(10);
        int result = userMapper.updateById(user);
        System.out.println(result);
        System.out.println(user);
        //更新或者插入数据自动填充
        //@TableField(fill = FieldFill.INSERT_UPDATE)

    }


    /**
     * 测试乐观锁插件 失败
     */
    @Test
    public void testOptimisticLockerFail() {
        //查询
        User user = userMapper.selectById(1L);
        //修改数据
        user.setName("Helen Yao1");
        user.setEmail("helen@qq.com1");
        //模拟取出数据后，数据库中version实际数据比取出的值大，即已被其它线程修改并更新了version
        user.setVersion(user.getVersion() - 1);
        //执行更新
        int i = userMapper.updateById(user);
        System.out.println("影响行数:"+i);
    }

}
