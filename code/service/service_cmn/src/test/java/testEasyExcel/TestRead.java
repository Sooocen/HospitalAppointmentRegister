package testEasyExcel;

import com.alibaba.excel.EasyExcel;

public class TestRead {

    public static void main(String[] args) {
        String path="/System/Volumes/Data/Users/DJAHa/01.xlsx";

        //读取
        EasyExcel.read(path, UserData.class,new excelListener()).sheet().doRead();
    }
}
