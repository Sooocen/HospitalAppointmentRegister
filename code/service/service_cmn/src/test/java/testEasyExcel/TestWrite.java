package testEasyExcel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

public class TestWrite {
    public static void main(String[] args) {
        List<UserData> userlist = new ArrayList();
        for (int i = 0; i <10 ; i++) {
            UserData data = new UserData();
            data.setId(i);
            data.setUsername("这是第"+i+"个人");
            userlist.add(data);
        }
        //设置excel文件路径
        String path="/System/Volumes/Data/Users/DJAHa/01.xlsx";

        //调用easyexcel
        EasyExcel.write(path,UserData.class).sheet("用户信息").doWrite(userlist);
    }
}
