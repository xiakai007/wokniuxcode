package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.QuerySystemLogParam;
import com.isoftstone.humanresources.domain.SysLog;

import java.util.List;

public interface SystemLogDao {
    /**
     * 保存日志
     * @param sysLog
     * @throws Exception
     */
    void add(SysLog sysLog) throws Exception;

    /**
     * 查询日志
     * @param querySystemLogParam
     * @return
     * @throws Exception
     */
    List<SysLog> queryLogList(QuerySystemLogParam querySystemLogParam) throws Exception;



    void deleteSysLog()throws Exception;
}
