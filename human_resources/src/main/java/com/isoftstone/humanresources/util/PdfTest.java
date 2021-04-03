package com.isoftstone.humanresources.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.UUID;
import javax.imageio.ImageIO;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfTest {

    public static void testPdf() {
        String path = "D:\\教育部学历证书电子注册备案表.pdf";
        File file = new File(path);
        InputStream is = null;
        PDDocument document = null;
        try {
            if (path.endsWith(".pdf")) {
                document = PDDocument.load(file);
                int pageSize = document.getNumberOfPages();
                // 一页一页读取
                for (int i = 0; i < pageSize; i++) {
                    // 文本内容
                    PDFTextStripper stripper = new PDFTextStripper();
                    // 设置按顺序输出
                    stripper.setSortByPosition(true);
                    stripper.setStartPage(i + 1);
                    stripper.setEndPage(i + 1);
                    String text = stripper.getText(document);
                    System.out.println(text.trim());
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");

                    // 图片内容
                    PDPage page = document.getPage(i);
                    PDResources resources = page.getResources();
                    Iterable<COSName> cosNames = resources.getXObjectNames();
                    if (cosNames != null) {
                        Iterator<COSName> cosNamesIter = cosNames.iterator();
                        while (cosNamesIter.hasNext()) {
                            COSName cosName = cosNamesIter.next();
                            if (resources.isImageXObject(cosName)) {
                                PDImageXObject Ipdmage = (PDImageXObject) resources.getXObject(cosName);
                                BufferedImage image = Ipdmage.getImage();
                                FileOutputStream out = new FileOutputStream("D:\\work\\" + UUID.randomUUID() + ".png");
                                try {
                                    ImageIO.write(image, "png", out);
                                } catch (IOException e) {
                                } finally {
                                    try {
                                        out.close();
                                    } catch (IOException e) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (InvalidPasswordException e) {
        } catch (IOException e) {
        } finally {
            try {
                if (document != null) {
                    document.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
            }
        }
    }
//    public static void main(String[] args){
//        PdfTest.testPdf();
//    }
    public static void main(String [] args) throws IOException {
        BufferedImage img = ImageIO.read(new File("D:\\work\\dc0372f9-6add-44a8-9f32-bd64586a4596.png"));//读取图片
        char [] arr  ="$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/|()1{}[]?-_+~<>i!lI;:,^`'. ".toCharArray();//转换的文字
        int w = img.getWidth();
        int h = img.getHeight();
        int[] data = img.getRGB(0, 0, w, h, null, 0, w);
        for (int y = 0; y < h; y+=4) {
            for (int x = 0; x < w; x+=2) {
                int c = data[x + y * w];
                int R = (c >> 16) & 0xFF;
                int G = (c >> 8) & 0xFF;
                int B = (c >> 0) & 0xFF;
                int a = (int) (0.3f * R + 0.59f * G + 0.11f * B); //to gray
                System.out.print(arr[a%arr.length]+"");
            }
            System.out.println();
        }
    }
}
