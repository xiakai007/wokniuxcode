package com.woniu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniu.pojo.Role;
import com.woniu.pojo.User;
import com.woniu.mapper.UserMapper;
import com.woniu.service.UserService;
import com.woniu.vo.UserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findUserAll() {
        return userMapper.selectUserAll();
    }

    @Override
    public List<User> findUserByDid(@Param("did")Integer did) {
        return userMapper.selectUserByDid(did);
    }

    @Override
    public User getUserByRealname(@Param("realname") String realname) {
        return userMapper.selectUserByRealname(realname);
    }

    @Override
    public User login(String telephone, String password) {
        return userMapper.selectUserByTelAndPwd(telephone,password);
    }

    @Override
    public boolean addUser(User user) {
        userMapper.insertUser(user);
        List<Role> roleList = user.getRoleList();
        if(roleList!=null&&!roleList.isEmpty()){
            for(Role role:roleList){
                userMapper.insertUserAndRole(user.getId(),role.getId());
            }
        }
        return true;
    }

    @Override
    public List<User> getUserByProperty(User user) {
        return userMapper.selectUserByProperty(user);
    }

    @Override
    public Page findUserPage(UserVo userVo) {
        Page<Object> page = PageHelper.startPage(userVo.getCurrentPage(), userVo.getPageSize());
        userMapper.selectUserByProperty(userVo);
        /*System.out.println("查询数据"+page.getResult());
        if(page.getResult()!=null&&page.getResult().size()>0){
            for(Object obj:page.getResult()){
                User user=(User)obj;
                System.out.println(user.getTelephone()+"\t"+user.getRealname()+"\t"+user.getDept().getDname());
            }
        }
        System.out.println("总页数："+page.getPages());
        System.out.println("每页记录数："+page.getResult().size());
        System.out.println("每页记录数："+page.getPageSize());
        System.out.println("总记录数："+page.getTotal());*/
        //page.getPageSize();page.getPageNum();
        return page;
    }

    @Override
    public boolean removeUser(Integer[] ids) {
        if(ids!=null&&ids.length>0){
            for(Integer id:ids){
                userMapper.deleteUserById(id);
            }
        }
        return true;
    }

    @Override
    public User getUserById(Integer id) {
        User user = userMapper.selectUserById(id);
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        userMapper.updateUser(user);
        System.out.println("****************");
        return true;
    }
}
