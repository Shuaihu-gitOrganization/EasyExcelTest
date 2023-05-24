package com.atxiaohu.vip.utils;

import com.aspose.cells.PdfSaveOptions;
import com.aspose.cells.Workbook;
import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @Date 2023/5/24
 * @Author XiaoHu
 * @Description 利用Aspose将EXCEL、Word转成PDF
 **/
public class AsposeUtil {
    /**
     * 读取License文件,返回结果
     * @return 读取License文件，返回结果，防止pdf有水印
     */
    public static boolean getWordLicense(){
        boolean result=false;
        try {
            InputStream resourceAsStream = AsposeUtil.class.getClassLoader().getResourceAsStream("License.xml");
            License license = new License();
            license.setLicense(resourceAsStream);
            result=true;
        }catch (Exception e){
            e.printStackTrace();

        }
        return result;
    }
    /**
     * 读取License文件,返回结果
     * @return 读取License文件，返回结果，防止pdf有水印
     */
    public static boolean getExcelLicense(){
        boolean result=false;
        try {
            InputStream resourceAsStream = AsposeUtil.class.getClassLoader().getResourceAsStream("License.xml");
            com.aspose.cells.License license = new com.aspose.cells.License();
            license.setLicense(resourceAsStream);
            result=true;
        }catch (Exception e){
            e.printStackTrace();

        }
        return result;
    }
    /**
     * Aspose实现word转pdf
     * @param doc
     * @param pdf
     * @return
     * @throws Exception
     */
    public static String word2Pdf(String doc,String pdf)throws Exception{
        if (!getWordLicense()){
            return "failed:can't find aspose license";
        }
        FileOutputStream fileOutputStream=null;
        try {
            long start = System.currentTimeMillis();
            File file = new File(pdf.replace(".pdf","")+System.currentTimeMillis()+".pdf");
          fileOutputStream=  new FileOutputStream(file);
            Document document = new Document(doc);
            document.save(fileOutputStream, SaveFormat.PDF);

            long end=System.currentTimeMillis();
            System.out.println("word转pdf耗时：" +(end - start)/1000+"s");
        }catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            if(fileOutputStream !=null){
                fileOutputStream.close();
            }
        }
        return "Success";
    }

    /**
     * Aspose实现Excel转PDF
     * @param excel excel路径
     * @param pdf 生成的pdf路径
     * @return 返回生成结果
     */
    public static String excel2Pdf(String excel, String pdf) throws Exception {
        if (!getExcelLicense()){
            return "failed:can't find aspose license";
        }
        FileOutputStream fileOutputStream=null;
        try {
            long start = System.currentTimeMillis();
            Workbook workbook = new Workbook(excel);
            File file = new File(pdf.replace(".pdf","")+System.currentTimeMillis()+".pdf");
            fileOutputStream=  new FileOutputStream(file);
            PdfSaveOptions pdfSaveOptions = new PdfSaveOptions();
            pdfSaveOptions.setOnePagePerSheet(false);

            //当excel中对应的sheet也宽度太大时，在PDF会拆断并分页，此处等比缩放
            int [] autoDrawSheets={3};
            autoDrawSheets(workbook,autoDrawSheets);
            //隐藏workbook中不需要的sheet页
            int showSheets []={0};

            printSheetPage(workbook,showSheets);
            workbook.save(fileOutputStream, SaveFormat.PDF);
            fileOutputStream.flush();
            long end=System.currentTimeMillis();
            System.out.println("excel转pdf耗时：" +(end - start)/1000+"s");
        }catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            if(fileOutputStream !=null){
                fileOutputStream.close();
            }
        }
        return "Success";
    }
    /**
     * 设置打印的sheet 自动拉伸比例
     * @param wb
     * @param page 自动拉伸的页的sheet数组
     */
    public static void autoDrawSheets(Workbook wb,int[] page){
        if(null!=page&&page.length>0){
            for (int i = 0; i < page.length; i++) {
                wb.getWorksheets().get(i).getHorizontalPageBreaks().clear();
                wb.getWorksheets().get(i).getVerticalPageBreaks().clear();
            }
        }
    }
    /**
     * 隐藏workbook中不需要的sheet页。
     * @param wb
     * @param page 显示页的sheet数组
     */
    public static void printSheetPage(Workbook wb,int[] page){
        for (int i= 1; i < wb.getWorksheets().getCount(); i++)  {
            wb.getWorksheets().get(i).setVisible(false);
        }
        if(null==page||page.length==0){
            wb.getWorksheets().get(0).setVisible(true);
        }else{
            for (int i = 0; i < page.length; i++) {
                wb.getWorksheets().get(i).setVisible(true);
            }
        }
    }

}
