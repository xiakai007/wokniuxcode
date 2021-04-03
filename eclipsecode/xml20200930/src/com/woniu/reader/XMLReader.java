package com.woniu.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLReader {
	public static void main(String[] args) throws DocumentException, FileNotFoundException {
		SAXReader saxReader = new SAXReader();
		Document doc=saxReader.read(new FileInputStream(new File("src/web.xml")));
		//根元素rootEle
		Element rootEle=doc.getRootElement();
		List<Element> listEles=rootEle.elements();
		//rootEle的子元素ele
		for(Element ele:listEles){
			if(ele.getName().equals("servlet")){
				//ele的子元素servlet_name、servlet_class、servlet_name_mp、url_pattern
				Element servlet_name=ele.element("servlet-name");
				System.out.println("servlet:servlet-name:"+servlet_name.getData());
				Element servlet_class=ele.element("servlet-class");
				System.out.println("servlet:servlet-class:"+servlet_class.getData());
			}else if(ele.getName().equals("sevlet-mapping")){
				Element servlet_name_mp=ele.element("servlet-name");
				System.out.println("sevlet-mapping:servlet-name:"+servlet_name_mp.getData());
				Element url_pattern=ele.element("url-pattern");
				System.out.println("sevlet-mapping:url-pattern:"+url_pattern.getData());
			}
			
		}
	}

}
