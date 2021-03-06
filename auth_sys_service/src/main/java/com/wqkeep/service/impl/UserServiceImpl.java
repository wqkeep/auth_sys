package com.wqkeep.service.impl;

import com.wqkeep.dao.IUserDao;
import com.wqkeep.domain.Role;
import com.wqkeep.domain.UserInfo;
import com.wqkeep.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username){
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception  e) {
            e.printStackTrace();
            throw new RuntimeException("出现异常了....");
        }
        //处理自己的用户对象封装成UserDetails
//          User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(), null);
//        User user = new User(userInfo.getUsername(), "{noop}" + userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
        return user;
    }

    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll() {

        List<UserInfo> userInfos = userDao.findAll();

        return userInfos;
    }

    @Override
    public void save(UserInfo userInfo) {
        //密码加密，再保存用户
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));

        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {

        UserInfo user = userDao.findById(id);
        return user;
    }

    @Override
    public List<Role> findOtherRoles(String userId) {
        return userDao.findOtherRoles(userId);
    }

    @Override
    public void addRoleToUser(String userId, List<String> roleIds) {

        for (String roleId : roleIds) {
            userDao.addRoleToUser(userId,roleId);
        }
    }
}
