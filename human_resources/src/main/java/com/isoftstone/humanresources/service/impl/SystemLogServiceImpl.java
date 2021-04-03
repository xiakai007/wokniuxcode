package com.isoftstone.humanresources.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isoftstone.humanresources.dao.SystemLogDao;
import com.isoftstone.humanresources.domain.QuerySystemLogParam;
import com.isoftstone.humanresources.domain.SysLog;
import com.isoftstone.humanresources.service.SystemLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemLogServiceImpl implements SystemLogService {
    private final static Logger logger = LoggerFactory.getLogger(SystemLogService.class);
    @Autowired
    private SystemLogDao systemLogDao;
    @Override
    public void add(SysLog sysLog){
        try {
            systemLogDao.add(sysLog);
        } catch (Exception e) {
            logger.error("存入日志数据异常",e);
        }
    }

    @Override
    public PageInfo<SysLog> queryLogList(QuerySystemLogParam querySystemLogParam) {
        logger.info("----------查询日志列表信息service接入参数------{}", querySystemLogParam);
        PageInfo<SysLog> sysLogPageInfo = new PageInfo<>();
        try {
            Integer page = querySystemLogParam.getPage();                     //当前页
            Integer pageSize = querySystemLogParam.getPageSize();             //每页显示的条数
            if (page != null && pageSize != null) {
                PageHelper.startPage(page, pageSize);                     //分页
                //调用dao接口查询日志列表
                List<SysLog> sysLogs = systemLogDao.queryLogList(querySystemLogParam);
                if (sysLogs != null & sysLogs.size() > 0) {
                    sysLogPageInfo = new PageInfo<>(sysLogs);
                }
            }

        } catch (Exception e) {
            logger.error("查询日志数据异常",e);
        }
        logger.info("----------查询日志列表service返回参数------{}", sysLogPageInfo);
        return sysLogPageInfo;
    }
}
