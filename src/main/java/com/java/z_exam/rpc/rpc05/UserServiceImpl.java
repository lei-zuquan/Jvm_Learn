package com.java.z_exam.rpc.rpc05;

import com.java.z_exam.rpc.common.IUserService;
import com.java.z_exam.rpc.common.User;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 3:00 下午 2020/6/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class UserServiceImpl implements IUserService {
    @Override
    public User findUserById(Integer id) {
        return new User(id, "Alice");
    }
}
