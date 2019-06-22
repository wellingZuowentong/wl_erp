package com.weiling.wl_erp.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.weiling.wl_erp.bean.Sell;
import com.weiling.wl_erp.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * 作者：王怀朋
 * 日期：2019/6/22
 */

public class TestPdf {

    public static void aaaa(HttpServletRequest request,Sell sell,String goumairen,String beizhu) throws Exception {
        TestPdf pdf = new TestPdf();
        String path = request.getSession().getServletContext().getRealPath("pdf");
        File file1 =new File(path);
        //如果文件夹不存在则创建
        if(!file1 .exists()  && !file1 .isDirectory()){
            file1 .mkdir();
        }
        System.out.println(file1 .exists()&&file1 .isDirectory());
        String filename = path+"testTable3.pdf";
        pdf.createPDF(filename,sell,goumairen,beizhu);
        System.out.println("打印完成");

    }
    public static PdfPTable createTable(PdfWriter writer,Sell sell,String goumairen,String beizhu) throws DocumentException, IOException{
        String pname = sell.getPname();
        String cname = sell.getCname();
        BigDecimal jiage = sell.getOverprice();
        PdfPTable table = new PdfPTable(3);//生成一个两列的表格
        Font font = new Font(BaseFont.createFont( "STSongStd-Light" ,"UniGB-UCS2-H",BaseFont.NOT_EMBEDDED));
        PdfPCell cell;
        int size = 30;
        cell = new PdfPCell(new Phrase("商品名：    "+pname,font));
        cell.setFixedHeight(size);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("数量:    "+sell.getOksell(),font));
        cell.setFixedHeight(size);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("销售总价："+jiage+"元",font));
        cell.setFixedHeight(size);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("购买方:",font));
        cell.setColspan(3);
        cell.setFixedHeight(size);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("收款单位盖章：",font));
        cell.setFixedHeight(size);//设置高度
        /*cell.setHorizontalAlignment(Element.ALIGN_CENTER);//设置水平居中
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂居中直*/
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("收款人签章：",font));
        cell.setFixedHeight(size);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("备注",font));
        cell.setFixedHeight(size);
        table.addCell(cell);
        return table;
    }

    public void createPDF(String filename,Sell sell,String goumairen,String beizhu) throws IOException {
        Document document = new Document(PageSize.A4);
        try {
            Font font = new Font(BaseFont.createFont( "STSongStd-Light" ,"UniGB-UCS2-H",BaseFont.NOT_EMBEDDED));
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.addTitle("example of PDF");
            document.open();
            document.add(new Paragraph("                                                                                    销售单据",font));
            document.add(new Paragraph("                          "));
            document.add(new Paragraph("                       销售日期： "+DateUtil.formatNormalDateString(sell.getSelltime())+"                      订单编号："+sell.getOrdercode(),font));
            document.add(new Paragraph("                          "));
            PdfPTable table = createTable(writer,sell,goumairen,beizhu);
            document.add(table);
            document.add(new Paragraph("                          "));
            document.add(new Paragraph("                                                                                    销售单据",font));
            document.add(new Paragraph("                          "));
            document.add(new Paragraph("                       销售日期： "+DateUtil.formatNormalDateString(sell.getSelltime())+"                      订单编号："+sell.getOrdercode(),font));
            document.add(new Paragraph("                          "));
            document.add(table);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}