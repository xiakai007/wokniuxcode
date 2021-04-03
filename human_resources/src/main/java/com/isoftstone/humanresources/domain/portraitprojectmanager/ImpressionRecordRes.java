package com.isoftstone.humanresources.domain.portraitprojectmanager;

import java.io.Serializable;

/**
 * 印象返回标签
 * @author bwning
 *
 */
public class ImpressionRecordRes implements Serializable{

	private static final long serialVersionUID = 1L;
	private String labelImpre;					//印象标签
	private int impreCount;						//标签统计
	public String getLabelImpre() {
		return labelImpre;
	}
	public void setLabelImpre(String labelImpre) {
		this.labelImpre = labelImpre;
	}
	public int getImpreCount() {
		return impreCount;
	}
	public void setImpreCount(int impreCount) {
		this.impreCount = impreCount;
	}
}
