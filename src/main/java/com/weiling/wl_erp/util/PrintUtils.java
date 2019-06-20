package com.weiling.wl_erp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class PrintUtils {
    /**
     * 通过 IP+端口 连接打印机打印文件
     * @param filePath
     * @throws Exception
     */
    public static void print2(String filePath,String ip) throws Exception{
        File file = new File(filePath); // 获取选择的文件
        Socket socket =  new Socket(ip, 9100);

        OutputStream out = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(file);
        //建立数组
        byte[] buf = new byte[1024];
        int len = 0;
        //判断是否读到文件末尾
        while((len=fis.read(buf)) != -1)
        {
            out.write(buf, 0, len);
        }
        //告诉服务端，文件已传输完毕
        socket.shutdownOutput();
        socket.close();
        fis.close();
    }
}
