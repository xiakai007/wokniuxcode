package com.woniu.servlets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/validateCode")
public class ValidateCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ValidateCodeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb=new StringBuilder();
		int width=100;
		int height=36;
		BufferedImage bi=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics=(Graphics2D) bi.getGraphics();
		graphics.setColor(Color.PINK);
		graphics.fillRect(0, 0, width, height);
		String content="qwer";
		Random random=new Random();
		Color[] colors={Color.BLACK};
		int[] fontstyles={Font.BOLD};
		for(int i=0;i<5;i++){
			graphics.setColor(colors[random.nextInt(colors.length)]);
			int x1=new Random().nextInt(width);
			int y1=new Random().nextInt(height);
			int x2=new Random().nextInt(width);
			int y2=new Random().nextInt(height);
			graphics.drawLine(x1, y1, x2, y2);
		}
		for(int i=1;i<5;i++){
			graphics.setColor(colors[random.nextInt(colors.length)]);
			int fontStyleIndex=random.nextInt(fontstyles.length);
			Font font=new Font("ËÎÌו", fontstyles[fontStyleIndex], 30);
			graphics.setFont(font);
			int contentIndex=random.nextInt(content.length());
			char ch=content.charAt(contentIndex);
			String chstr=String.valueOf(ch);
			sb.append(chstr);
			graphics.drawString(chstr, width/5*i, height/2);
		}
		request.getSession().setAttribute("vercode", sb.toString());
		ImageIO.write(bi, "JPEG", response.getOutputStream());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
