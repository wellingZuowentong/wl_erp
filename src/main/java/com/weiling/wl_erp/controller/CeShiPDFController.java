package com.weiling.wl_erp.controller;

import com.weiling.wl_erp.bean.Sell;
import com.weiling.wl_erp.service.SellService;
import com.weiling.wl_erp.util.TestPdf;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPrintable;
import org.apache.pdfbox.printing.Scaling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.print.PrintService;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.Sides;
import javax.servlet.http.HttpServletRequest;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * 作者：王怀朋
 * 日期：2019/6/20
 */
@Controller
public class CeShiPDFController {
    @Autowired
    public SellService sellService;
   /* public static void main(String[] args) throws Exception {
        String pdfFile = "D:\\tuhuo.pdf";//文件路径
        File file = new File(pdfFile);
        String printerName = "Brother DCP-7057 Printer (副本 1)";//打印机名包含字串
        PDFprint(file,printerName);
    }*/
    @RequestMapping("printSell")
    @ResponseBody
    public int ssss(HttpServletRequest request) throws Exception{
        Integer id = Integer.parseInt(request.getParameter("id"));
        Sell sell = sellService.findSellById(id);
        String goumairen = request.getParameter("goumairen");
        String beizhu = request.getParameter("beizhu");
        TestPdf.aaaa(request,sell,goumairen,beizhu);
       String pdfFile =request.getSession().getServletContext().getRealPath("pdf")+"testTable3.pdf";
        File file = new File(pdfFile);
        System.out.println((file==null)+"#################################");
        String printerName = "Brother DCP-7057 Printer (副本 1)";//打印机名包含字串
        PDFprint(file,printerName);
        return 1;
    }



    public static void PDFprint(File file ,String printerName) throws Exception {
        PDDocument document = null;
        try {
            document = PDDocument.load(file);
            PrinterJob printJob = PrinterJob.getPrinterJob();
            printJob.setJobName(file.getName());
            if (printerName != null) {
                // 查找并设置打印机
                //获得本台电脑连接的所有打印机
                PrintService[] printServices = PrinterJob.lookupPrintServices();                			 if(printServices == null || printServices.length == 0) {
                    System.out.print("打印失败，未找到可用打印机，请检查。");
                    return ;
                }
                PrintService printService = null;
                //匹配指定打印机
                for (int i = 0;i < printServices.length; i++) {
                    System.out.println(printServices[i].getName());
                    if (printServices[i].getName().contains(printerName)) {
                        printService = printServices[i];
                        break;
                    }
                }
                if(printService!=null){
                    printJob.setPrintService(printService);
                }else{
                    System.out.print("打印失败，未找到名称为" + printerName + "的打印机，请检查。");
                    return ;
                }
            }
            //设置纸张及缩放
            PDFPrintable pdfPrintable = new PDFPrintable(document, Scaling.ACTUAL_SIZE);
            //设置多页打印
            Book book = new Book();
            PageFormat pageFormat = new PageFormat();
            //设置打印方向
            pageFormat.setOrientation(PageFormat.PORTRAIT);//纵向
            pageFormat.setPaper(getPaper());//设置纸张
            book.append(pdfPrintable, pageFormat, document.getNumberOfPages());
            printJob.setPageable(book);
            printJob.setCopies(1);//设置打印份数
            //添加打印属性
            HashPrintRequestAttributeSet pars = new HashPrintRequestAttributeSet();
            pars.add(Sides.DUPLEX); //设置单双页
            printJob.print(pars);
        }finally {
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static Paper getPaper() {
        Paper paper = new Paper();
        // 默认为A4纸张，对应像素宽和高分别为 595, 842
        int width = 595;
        int height = 842;
        // 设置边距，单位是像素，10mm边距，对应 28px
        int marginLeft = 10;
        int marginRight = 0;
        int marginTop = 10;
        int marginBottom = 0;
        paper.setSize(width, height);
        // 下面一行代码，解决了打印内容为空的问题
        paper.setImageableArea(marginLeft, marginRight, width - (marginLeft + marginRight), height - (marginTop + marginBottom));
        return paper;
    }
}
