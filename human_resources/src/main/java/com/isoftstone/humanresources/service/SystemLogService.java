package com.isoftstone.humanresources.service;

import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.domain.QuerySystemLogParam;
import com.isoftstone.humanresources.domain.SysLog;


import java.util.List;

public interface SystemLogService {
    /**
     * 保存日志
     * @param sysLog
     * @throws Exception
     */
    void add(SysLog sysLog) throws Exception;


    /**
     * 分页查询日志
     * @param querySystemLogParam
     * @return
     * @throws Exception
     */
    PageInfo<SysLog> queryLogList(QuerySystemLogParam querySystemLogParam) throws Exception;
}
