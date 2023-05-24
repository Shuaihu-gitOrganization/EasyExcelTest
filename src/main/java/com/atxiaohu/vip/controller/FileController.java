package com.atxiaohu.vip.controller;

import com.atxiaohu.vip.utils.JacobUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2023/5/24
 * @Author XiaoHu
 * @Description 文件测试
 **/
@Controller
@RestController
@RequestMapping("/file")
public class FileController {
    private static final String WORD_PATH="D:/TempExcel/pdf/test.doc";
    private static final String  EXCEL_PATH="D:/TempExcel/pdf/test.xlsx";
    private static final String  PDF_PATH="D:/TempExcel/pdf/test.pdf";
    @RequestMapping("/jacob")
    public String jacobword2pdf(){

        return JacobUtil.word2Pdf(WORD_PATH,PDF_PATH);
    }
}
