package com.woniu.mapper;

import com.woniu.pojo.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    /**
     * 通过账号修改余额
     * @param account
     */
    public void updateBlanceByAccountno(Account account);

    /**
     * 通过账号查找账户对象
     * @param accountno
     * @return
     */
    public Account findAccountByAccountno(@Param("accountno") String accountno);
}
