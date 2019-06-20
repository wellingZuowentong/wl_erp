package com.weiling.wl_erp.util;
import javax.print.DocFlavor;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.PrintRequestAttributeSet;
import java.util.ArrayList;
import java.util.List;

/***
 * 获取当前可用打印机和默认打印机
 * author:左文统
 * date:2019/6/20
 */

public class PrintServiceLookUpUtils {
    public static String getPrintServiceLookUp() {

        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.PNG;
        List printers = new ArrayList();
        //当前默认打印机
        PrintService PS = PrintServiceLookup.lookupDefaultPrintService();
        return PS.getName();
    }
    public static List getPrintServiceList(){
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.PNG;
        List<String> printers = new ArrayList();
        /* 可用的打印机列表(字符串集合) */
        PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
        for (int i = 0; i < printService.length; i++) {
            printers.add(printService[i].getName());
        }
        return printers;
    }
    public static void main(String args[]){
        System.out.println(getPrintServiceLookUp());
        List<String> arrayList = getPrintServiceList();
        for (String s:arrayList){
            System.out.println(s);
        }
    }
}