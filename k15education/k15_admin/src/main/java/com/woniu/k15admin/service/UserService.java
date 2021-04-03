package com.woniu.k15admin.service;



import com.woniu.k15admin.pojo.User;
import com.woniu.k15admin.vo.UserVo;

import java.util.List;

public interface UserService {
    public List<User> selectUserByPage(UserVo userVo);
    public boolean removeUser(Integer[] ids);
}
