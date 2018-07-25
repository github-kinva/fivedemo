package cn.kinva.service;

import cn.kinva.pojo.User;

import java.util.List;

public interface UserService {
    public boolean save(User user);

    //查询
    public List<User> getAllInfo();
}
