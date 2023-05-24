package com.atxiaohu.vip.constant;

/**
 * @Date 2023/5/24
 * @Author XiaoHu
 * @Description
 **/
public enum FilePath {
    WORD_PATH("D:/TempExcel/pdf/test.doc"),
    EXCEL_PATH("D:/TempExcel/pdf/test.xlsx"),
    PDF_PATH("D:/TempExcel/pdf/test.pdf");
    private String path;

    FilePath(String path) {
        this.path=path;
    }

    public String getPath() {
        return path;
    }

}
