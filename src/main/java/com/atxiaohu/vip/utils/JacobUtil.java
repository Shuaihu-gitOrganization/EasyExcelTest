package com.atxiaohu.vip.utils;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import org.springframework.stereotype.Component;

/**
 * @Date 2023/5/24
 * @Author XiaoHu
 * @Description Jacob处理Word转成PDF
 **/
@Component
public class JacobUtil {
    //定义PDF装换的格式
    private static final int PDFFormat=17;
    public static String word2Pdf(String word,String pdf){
        ComThread.InitMTA(true);
        ActiveXComponent app=null;
        Dispatch doc=null;
        String handerMessage=null;
        try{
            app=new ActiveXComponent("Word.Application");//创建一个Word对象
            app.setProperty("Visible",new Variant(false));//不可见打开word
            app.setProperty("AutomationSecurity",new Variant(3));//禁用宏
            Dispatch documents = app.getProperty("Documents").toDispatch();
            doc=Dispatch.call(documents,"Open",word,false,true).toDispatch();
            Dispatch.call(doc,"SaveAs",pdf,PDFFormat);
            return handerMessage="Success";
        }catch (Exception exception){
            exception.printStackTrace();
            return handerMessage="Fail";
        }finally {
            Dispatch.call(doc,"Close",false);
            if(app!=null){
                app.invoke("Quit",new Variant[]{});
            }
        ComThread.Release();
        ComThread.quitMainSTA();
        }

    }
}
