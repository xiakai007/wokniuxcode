package com.isoftstone.humanresources.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 读取XML配置文件
 * 
 * @author hnhuc
 *
 */
public class GetXML
{
	// 业务线文件
	public static final String BUSI_FILENAME = "business_line.xml";
	// 日期（仅年月）文件
	public static final String DATE_FILENAME = "date_time.xml";

	/**
	 * 遍历xml文件获取元素
	 * 
	 * @param root
	 * @return
	 */
	public static Object parse(Element root)
	{
		@SuppressWarnings("unchecked")
		List<Element> childElements = root.elements();
		// 判断有无子元素
		if (childElements.size() == 0)
		{
			return root.getTextTrim();
		}
		else
		{
			boolean attr = false;
			for (Element element : childElements)
			{
				@SuppressWarnings("unchecked")
				List<Attribute> childAttr = element.attributes();
				if (childAttr.size() == 0)
				{
					attr = true;
				}
			}
			// 子元素个数为0时返回一个list
			if (attr)
			{
				List<Object> list = new ArrayList<Object>();
				for (Element element : childElements)
				{
					list.add(parse(element));
				}
				return list;
			}
			else
			{
				Map<String, Object> map = new HashMap<String, Object>();
				for (Element element : childElements)
				{
					@SuppressWarnings("unchecked")
					List<Attribute> childAttr = element.attributes();
					String strAttr = "";
					for (Attribute attri : childAttr)
					{
						if ("name" == attri.getName())
						{
							strAttr = attri.getValue();
						}
					}
					map.put(strAttr, parse(element));
				}
				return map;
			}

		}
	}

	/**
	 * 读取xml获取Map集合
	 * 
	 * @param filepath
	 * @return
	 * @throws DocumentException
	 */
	public static List<Map<String, Object>> getXMLMap(String filepath) throws DocumentException
	{
		SAXReader reader = new SAXReader();
		// 获取xml文件
		Document document = reader.read(new File(filepath));
		// 得到根元素
		Element root = document.getRootElement();
		// 递归得到总集合
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list = (List<Map<String, Object>>) parse(root);
		return list;
	}

	/**
	 * 读取xml获取List集合
	 * 
	 * @param filepath
	 * @return
	 * @throws DocumentException
	 */
	public static List<String> getXMLList(String filepath) throws DocumentException
	{
		SAXReader reader = new SAXReader();
		// 获取xml文件
		Document document = reader.read(new File(filepath));
		// 得到根元素
		Element root = document.getRootElement();
		// 递归得到总集合
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) parse(root);
		return list;
	}
}
