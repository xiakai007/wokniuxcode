package com.isoftstone.humanresources.util;

import java.util.Collections;
import java.util.List;

/**
 * 
 * <p>
 * 
 * @ClassName: ListPageUtils.java
 *             </p>
 *             <p>
 * @Description: list分页工具类
 *               </p>
 *               <p>
 * @Author: xuqiong
 *          </p>
 *          <p>
 * @date: 2018年12月18日 下午8:22:25
 *        </p>
 *        <p>
 * @Version: ISS-ISPS V100R001C03B101
 *           </p>
 */
public class ListPageUtils<T>
{
	/**
	 * 原集合
	 */
	private List<T> data;

	/**
	 * 上一页
	 */
	private int lastPage;

	/**
	 * 当前页
	 */
	private int pageNo;

	/**
	 * 下一页
	 */
	private int nextPage;

	/**
	 * 记录数
	 */
	private int pageSize;

	/**
	 * 总页数
	 */
	private int totalPage;

	/**
	 * 总数据条数
	 */
	private int totalCount;

	/**
	 * 
	 * @Title:ListPageUtils
	 * @Description:构造函数
	 * @param data
	 *            数据集合
	 * @param pageNo
	 *            当前页
	 * @param pageSize
	 *            记录数
	 */
	public ListPageUtils(List<T> data, int pageNo, int pageSize)
	{
		if (data == null || data.isEmpty())
		{
			throw new IllegalArgumentException("data must be not empty!");
		}

		this.data = data;
		this.pageSize = pageSize;
		this.pageNo = pageNo;
		this.totalCount = data.size();
		this.totalPage = (totalCount + pageSize - 1) / pageSize;
		this.lastPage = pageNo - 1 > 1 ? pageNo - 1 : 1;
		this.nextPage = pageNo >= totalPage ? totalPage : pageNo + 1;
	}

	/**
	 * 得到分页后的数据
	 *
	 * @param pageNum
	 *            页码
	 * @return 分页后结果
	 */
	public List<T> getPagedList()
	{
		int fromIndex = (pageNo - 1) * pageSize;
		if (fromIndex >= data.size())
		{
			return Collections.emptyList();// 空数组
		}
		if (fromIndex < 0)
		{
			return Collections.emptyList();// 空数组
		}
		int toIndex = pageNo * pageSize;
		if (toIndex >= data.size())
		{
			toIndex = data.size();
		}
		return data.subList(fromIndex, toIndex);
	}

	public int getPageSize()
	{
		return pageSize;
	}

	public List<T> getData()
	{
		return data;
	}

	public int getLastPage()
	{
		return lastPage;
	}

	public int getPageNo()
	{
		return pageNo;
	}

	public int getNextPage()
	{
		return nextPage;
	}

	public int getTotalPage()
	{
		return totalPage;
	}

	public int getTotalCount()
	{
		return totalCount;
	}
}
