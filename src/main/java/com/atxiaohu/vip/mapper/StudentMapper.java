package com.atxiaohu.vip.mapper;

import com.atxiaohu.vip.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Date 2023/5/19
 * @Author XiaoHu
 * @Description
 **/
public interface StudentMapper {
    /**
     * 批量插入数据
     * @param list
     * @return
     */
    long batchInsert(@Param("list") List<Student> list);

    /**
     * 普通查询全部数据
     * @return
     */
    List<Student> findAll();

    /**
     * 存储过程调用proc_getallstudent
     * @return 所有学生信息
     */
    List<Student> getAllStudentByProc();
    /**
     * 存储过程调用proc_getallstudent
     * @return 所有学生信息
     */
    Student getAllStudentByIdByProc(@Param("id")Integer id);



}
