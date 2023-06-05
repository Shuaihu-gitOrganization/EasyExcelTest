package com.atxiaohu.vip.controller;

import com.atxiaohu.vip.pojo.Student;
import com.atxiaohu.vip.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Date 2023/5/19
 * @Author XiaoHu
 * @Description
 **/
@RestController
@Controller
@RequestMapping("/Student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/upload")
    public long testRead(){
        return studentService.testRead();
    }
    @RequestMapping("/write")
    public String testWrite()throws Exception{
        return studentService.testWrite();
    }
    @RequestMapping("/getallstudentbyproc")
    public List<Student> getAllStudentByProc(){
        return studentService.getAllStudentByProc();
    }
    @RequestMapping("/getallstudentbyidbyproc/{id}")
    public Student getAllStudentByByIdProc(@PathVariable("id") Integer id){
        return studentService.getAllStudentByIdByProc(id);
    }
}
