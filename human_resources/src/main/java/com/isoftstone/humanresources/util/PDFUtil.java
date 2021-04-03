package com.isoftstone.humanresources.util;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * 功能 PDF读写类
 * @CreateTime 2019-11-26 下午02:44:11
 */
public class PDFUtil {

    /**
     * 通过PDFbox获取文章总页数
     *
     * @param filePath:文件路径
     * @return
     * @throws IOException
     */
    public static int getNumberOfPages(String filePath) throws IOException, InterruptedException {
        File file = new File(filePath);
        PDDocument pdDocument = PDDocument.load(new File(filePath));
        int pages = pdDocument.getNumberOfPages();
        pdDocument.close();
        return pages;
    }

    /**
     * 通过PDFbox获取文章内容
     *
     * @param filePath
     * @return
     */
    public static String getContent(String filePath) throws IOException {
        PDFParser pdfParser = new PDFParser(new org.apache.pdfbox.io.RandomAccessFile(new File(filePath), "rw"));
        pdfParser.parse();
        PDDocument pdDocument = pdfParser.getPDDocument();
        String text = new PDFTextStripper().getText(pdDocument);
        pdDocument.close();

        return text;
    }

    /**
     * 通过PDFbox生成文件的缩略图
     *
     * @param filePath：文件路径
     * @param outPath：输出图片路径
     * @throws IOException
     */
    public static void getThumbnails(String filePath, String outPath) throws IOException {
        // 利用PdfBox生成图像
        PDDocument pdDocument = PDDocument.load(new File(filePath));
        PDFRenderer renderer = new PDFRenderer(pdDocument);

        // 构造图片
        BufferedImage img_temp = renderer.renderImageWithDPI(0, 30, ImageType.RGB);
        // 设置图片格式
        Iterator<ImageWriter> it = ImageIO.getImageWritersBySuffix("png");
        // 将文件写出
        ImageWriter writer = (ImageWriter) it.next();
        ImageOutputStream imageout = ImageIO.createImageOutputStream(new FileOutputStream(outPath));
        writer.setOutput(imageout);
        writer.write(new IIOImage(img_temp, null, null));
        img_temp.flush();
        imageout.flush();
        imageout.close();
        //Warning: You did not close a PDF Document
        pdDocument.close();
    }

    /**
     * 测试pdf文件的创建
     * @param args
     */
    public static void main(String[] args) throws IOException, InterruptedException, TesseractException {
//        String content = getContent("D:\\教育部学历证书电子注册备案表.pdf");
//        System.out.println(content);

        File imageFile=new File("D:\\work\\2.png");
        ITesseract instance = new Tesseract();
        instance.setDatapath("D:\\tools\\Tesseract-OCR\\tessdata");//设置训练库的位置
        instance.setLanguage("chi_sim");//中文识别
        String result=instance.doOCR(imageFile);
        System.out.println(result);
    }
}
