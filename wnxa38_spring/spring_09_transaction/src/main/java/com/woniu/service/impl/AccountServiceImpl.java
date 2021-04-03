package com.woniu.service.impl;

import com.woniu.mapper.AccountMapper;
import com.woniu.mapper.TranRecordMapper;
import com.woniu.pojo.Account;
import com.woniu.pojo.TranRecord;
import com.woniu.service.AccountService;
import com.woniu.util.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private TranRecordMapper tranRecordMapper;
    @Transactional
    @Override
    public boolean transferAccounts(String fromAccountno, String toAccountno, Float money) {
        boolean flag=false;
        Account fromAccount = accountMapper.findAccountByAccountno(fromAccountno);
        Account toAccount = accountMapper.findAccountByAccountno(toAccountno);
        if(fromAccount==null){
            throw new RuntimeException("转出账户不存在");
        }else if(toAccount==null){
            throw new RuntimeException("转入账户不存在");
        }else{
            if(fromAccount.getBlance()<money){
                throw new RuntimeException("转出账户余额不足");
            }else{
                fromAccount.setBlance(fromAccount.getBlance()-money);
                accountMapper.updateBlanceByAccountno(fromAccount);

                //int i=1/0;
                toAccount.setBlance(toAccount.getBlance()+money);
                accountMapper.updateBlanceByAccountno(toAccount);

                TranRecord fromTranRecord = new TranRecord();
                fromTranRecord.setType(1);
                fromTranRecord.setMoney(money);
                fromTranRecord.setMessage(fromAccount.getName()+"您好，您的借记卡"+fromAccountno+"已向"+toAccount.getName()+"成功转账"+money+"元，转出时间："+ DateFormat.getDateStr(new Date()));
                tranRecordMapper.insertTranRecord(fromTranRecord);
                TranRecord toTranRecord = new TranRecord();
                toTranRecord.setType(-1);
                toTranRecord.setMoney(money);
                toTranRecord.setMessage(toAccount.getName()+"您好，"+fromAccount.getName()+"给您的借记卡"+toAccountno+"已转入"+money+"元，转入时间："+ DateFormat.getDateStr(new Date()));
                tranRecordMapper.insertTranRecord(toTranRecord);
                flag=true;
            }
        }

        return false;
    }
}
