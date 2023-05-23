package com.atxiaohu.vip.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.atxiaohu.vip.mapper.StudentMapper;
import com.atxiaohu.vip.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2023/5/19
 * @Author XiaoHu
 * @Description
 **/
@Service
public class StudentService {

    private final StudentMapper studentMapper;
    private static final String  FILE_PATH_READ="D:"+ File.separator+"TempExcel"+File.separator+"test.xlsx";
    private static final String  FILE_PATH_WRITE="D:"+ File.separator+"TempExcel"+File.separator+"学生信息表.xlsx";

    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public long testRead(){

        List<List<Student>> lists = new ArrayList<>(10000000);
        long start=System.currentTimeMillis();
        //第一种方法
        EasyExcel.read(FILE_PATH_READ, Student.class,
                new PageReadListener(list ->{

                    //System.out.println(list);
                    lists.add((List<Student>)list);
                })).sheet().doRead();
        //System.out.println(lists.size());

        Long count = 0L;
        long middle=System.currentTimeMillis();
        for (List<Student> list : lists) {
//            System.out.println(list.size());
            //System.out.println(list);
            studentMapper.batchInsert(list);
            count += list.size();
        }
        long end = System.currentTimeMillis();
        System.out.println("文件读取所需时间:"+(middle-start)/1000+"s"
                +"导入数据库耗时："+(end-middle)/1000+"s");
        return count;
    }

    public String testWrite() throws Exception{
        String handlerMessage=null;
        File file=new File(FILE_PATH_WRITE);
        if (!file.exists()){
            file.createNewFile();
        }
        try {
            EasyExcel.write(FILE_PATH_WRITE,Student.class).sheet("学生信息表").doWrite(()->{
                return studentMapper.findAll();
            });
            handlerMessage="Success";
        }catch (Exception e){
            e.printStackTrace();
            handlerMessage="Fail";
        }


        return handlerMessage;
    }


}
