package com.woniu.mapper;

import com.woniu.pojo.TranRecord;

public interface TranRecordMapper {
    /**
     * 动账记录
     * @param record
     */
    public void insertTranRecord(TranRecord record);
}
