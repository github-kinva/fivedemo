package cn.kinva.service;

import cn.kinva.mapper.UserMapper;
import cn.kinva.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    public boolean save(User name) {
      int user=  userMapper.save(name);
      if(user !=0){
          return true;
      }
        return false;
    }
//查询
    public List<User> getAllInfo() {
        return userMapper.getAllInfo();
    }
}
