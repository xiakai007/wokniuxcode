package com.isoftstone.humanresources.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
//import org.apache.pdfbox.util.PDFTextStripper;

public class PdfReader {
    /**
     * simply reader all the text from a pdf file.
     * You have to deal with the format of the output text by yourself.
     * 2008-2-25
     * @param pdfFilePath file path
     * @return all text in the pdf file
     */
//    public static String getTextFromPDF(String pdfFilePath)
//    {
//        String result = null;
//        FileInputStream is = null;
//        PDDocument document = null;
//        try {
//            is = new FileInputStream(pdfFilePath);
//            PDFParser parser = new PDFParser(is);
//            parser.parse();
//            document = parser.getPDDocument();
//            PDFTextStripper stripper = new PDFTextStripper();
//            result = stripper.getText(document);
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } finally {
//            if (is != null) {
//                try {
//                    is.close();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//            if (document != null) {
//                try {
//                    document.close();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        }
//        return result;
//    }

    /**
     * 读取pdf中文字信息(全部)
     */
    public static void READPDF(String inputFile){
        //创建文档对象
        PDDocument doc =null;
        String content="";
        try {
            //加载一个pdf对象
            doc =PDDocument.load(new File(inputFile));
            //获取一个PDFTextStripper文本剥离对象
            PDFTextStripper textStripper =new PDFTextStripper();
            content=textStripper.getText(doc);
            // vo.setContent(content);
            System.out.println("内容:"+content);
            System.out.println("全部页数"+doc.getNumberOfPages());
            //关闭文档
            doc.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public  static void main(String[] args)
    {
        PdfReader.READPDF("D:\\教育部学历证书电子注册备案表.pdf");
//     System.out.println(str);

    }
}
