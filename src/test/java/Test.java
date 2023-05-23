import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.atxiaohu.vip.mapper.StudentMapper;
import com.atxiaohu.vip.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.spec.OAEPParameterSpec;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2023/5/19
 * @Author XiaoHu
 * @Description
 **/
public class Test {

    @Autowired
    private StudentMapper studentMapper;
    private static final String  FILE_PATH_READ="D:"+File.separator+"TempExcel"+File.separator+"test.xlsx";
    private static final String  FILE_PATH_WRITE="D:"+File.separator+"TempExcel"+File.separator+"学生信息表.xlsx";
    @org.junit.jupiter.api.Test
    public void testRead(){
        List<List<Student>> lists = new ArrayList<>();

        //第一种方法
        EasyExcel.read(FILE_PATH_READ, Student.class,
                new PageReadListener(list ->{

                    //System.out.println(list);
                    lists.add((List<Student>)list);
                })).sheet().doRead();
        System.out.println(lists.size());

        Long count = 0L;

        for (List<Student> list : lists) {
//            System.out.println(list.size());
            //studentMapper.batchInsert(list);
            //count += list.size();
        }
        System.out.println("count ------> " + count);
        //studentMapper.batchInsert(lists);

    }
    @org.junit.jupiter.api.Test
    public void testWrite()throws Exception{

        /*File file=new File(FILE_PATH_WRITE);
        if (!file.exists()){
            file.createNewFile();
        }
        EasyExcel.write(FILE_PATH_WRITE,Student.class).sheet("学生信息表").doWrite(()->{
            return studentMapper.findAll();
        });*/

    }
}
