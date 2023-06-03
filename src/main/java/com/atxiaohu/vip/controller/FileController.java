package com.atxiaohu.vip.controller;

import com.atxiaohu.vip.constant.FilePath;
import com.atxiaohu.vip.utils.AsposeUtil;
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
    @RequestMapping("/jacobword")
    public String jacobword2pdf(){

        return JacobUtil.word2Pdf(WORD_PATH,PDF_PATH);
    }
    @RequestMapping("/jacobexcel")
    public String jacobexcel2pdf(){

        return JacobUtil.excel2Pdf(EXCEL_PATH,PDF_PATH);
    }
    @RequestMapping("/asposeword2pdf")
    public String asposeword2pdf()throws Exception{

        return AsposeUtil.word2Pdf(WORD_PATH,PDF_PATH);
    }
    @RequestMapping("/asposeexcel2pdf")
    public String asposeexcel2pdf()throws Exception{

        return AsposeUtil.excel2Pdf(EXCEL_PATH,PDF_PATH);
    }
    /**
     * 增加固定文件路径输出接口
     * @return 固定文件路径
     */
    @RequestMapping("/filepath")
    public String getfilePath(){
        
    return "WordPath："+FilePath.WORD_PATH+"ExcelPath："+FilePath.EXCEL_PATH
    +"PDFPath："+FilePath.PDF_PATH;
    }
}
