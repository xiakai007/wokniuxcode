package com.woniu.mymall.service.impl;

import com.woniu.mymall.entity.pojo.Mymall;
import com.woniu.mymall.mapper.MymallMapper;
import com.woniu.mymall.service.MymallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MymallServiceImpl implements MymallService {
    @Autowired
    private MymallMapper mymallMapper;
    @Override
    public List<Mymall> selectMymallAll() {
        return mymallMapper.selectMymallAll();
    }
}
