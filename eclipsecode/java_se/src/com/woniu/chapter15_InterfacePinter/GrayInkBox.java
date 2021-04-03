package com.woniu.chapter15_InterfacePinter;
/**
 * 墨盒类-实现类
 * @author xiakai
 *
 */
public class GrayInkBox implements InkBox {

	@Override
	public String getColor() {
		return "黑白";
	}

}
