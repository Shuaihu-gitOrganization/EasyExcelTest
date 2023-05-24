package com.atxiaohu.vip.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.atxiaohu.vip.mapper.StudentMapper;
import com.atxiaohu.vip.pojo.Student;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2023/5/19
 * @Author XiaoHu
 * @Description 学生相关服务提供类
 **/

@Service
public class StudentService {

    private final StudentMapper studentMapper;
    private static final String  FILE_PATH_READ="D:"+ File.separator+"TempExcel"+File.separator+"test.xlsx";
    private static final String  FILE_PATH_WRITE="D:"+ File.separator+"TempExcel"+File.separator+"学生信息表.xlsx";

    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    /**
     * 测试EasyExcel的简单读的基础功能
     * @return 读的时间以及将读出的数据，插入数据库对应表所需的时间
     */
    public long testRead(){

        List<List<Student>> lists = new ArrayList<>(10000000);
        long start=System.currentTimeMillis();//时间戳开始的时间节点
        //第一种方法---简单的读
        EasyExcel.read(FILE_PATH_READ, Student.class,
                new PageReadListener(list ->{//此时读出的数据会按照集合套集合的形式
                    lists.add((List<Student>)list);//将从Excel读出的数据，添加到新的集合当中
                })).sheet().doRead();


        Long count = 0L;//测试从Excel中读出的数据数量是否匹配
        long middle=System.currentTimeMillis();
        //将Excel读出的数据分批插入
        for (List<Student> list : lists) {
            studentMapper.batchInsert(list);//将集合中的数据以分批（1000条）的方式进行分批的插入数据库对应的数据表中
            count += list.size();
        }
        long end = System.currentTimeMillis();
        System.out.println("文件读取所需时间:"+(middle-start)/1000+"s"
                +"导入数据库耗时："+(end-middle)/1000+"s");
        return count;
    }

    /**
     * 测试EasyExcel的写的能力
     * @return 返回写出的数据是否成功，返回最终状态
     * @throws Exception 如果在写入的过程中，有异常抛出，以便定位原因
     */
    public String testWrite() throws Exception{
        String handlerMessage=null;
        File file=new File(FILE_PATH_WRITE);
        if (!file.exists()){//相关路径上的文件不存在，会创建对应的相关文件
            file.createNewFile();
        }
        try {
            EasyExcel.write(FILE_PATH_WRITE,Student.class).sheet("学生信息表").doWrite(()->{
                return studentMapper.findAll();//将数据库对应表的数据查出来，做成返回的数据
            });//做写入操作
            handlerMessage="Success";
        }catch (Exception e){
            e.printStackTrace();
            handlerMessage="Fail";
        }


        return handlerMessage;//返回的最终状态
    }


}
