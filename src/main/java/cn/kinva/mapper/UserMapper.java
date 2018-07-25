package cn.kinva.mapper;


import cn.kinva.pojo.User;

import java.util.List;

public interface UserMapper {
    public int save(User user);

    //查询
    public List<User> getAllInfo();


}
