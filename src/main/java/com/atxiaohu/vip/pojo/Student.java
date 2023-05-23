package com.atxiaohu.vip.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;

/**
 * @Date 2023/5/19
 * @Author XiaoHu
 * @Description
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class Student {
    @ExcelProperty(value = "编号")
    private Integer id;
    @ExcelProperty(value = "姓名")
    private String name;
    @ExcelProperty(value = "年龄")
    private Integer age;
    @ExcelProperty(value = "性别")
    private String sex;
    @ExcelProperty(value = "爱好")
    private String habit;
    @ExcelProperty(value = "部门id")
    private Integer department_id;
    @ExcelProperty(value = "课程id")
    private Integer course_id;
}
