package com.java.z_exam.rpc.rpc07;

import com.java.z_exam.rpc.common.User;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 4:42 下午 2020/6/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public interface IproductService {

    public User findUserById(Integer id);
}