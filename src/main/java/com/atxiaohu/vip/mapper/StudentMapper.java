package com.atxiaohu.vip.mapper;

import com.atxiaohu.vip.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * @Date 2023/5/19
 * @Author XiaoHu
 * @Description
 **/
public interface StudentMapper {

    long batchInsert(@Param("list") List<Student> list);

    List<Student> findAll();
}
