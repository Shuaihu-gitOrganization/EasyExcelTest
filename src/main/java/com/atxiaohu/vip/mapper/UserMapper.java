package com.atxiaohu.vip.mapper;

import com.atxiaohu.vip.pojo.User;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Date 2023/4/21
 * @Author XiaoHu
 * @Description
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Override
    int insert(User entity);

    int insertUser(User user);

    @Override
    List<User> selectList(Wrapper<User> queryWrapper);

    List<User> selectUsers();


    int updateUser(User entity);

    @Override
    int delete(Wrapper<User> queryWrapper);
}
