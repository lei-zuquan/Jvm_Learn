package com.java.z_exam.design_patterns.c05_proxy.static_proxy;

/**
 * @Author:
 * @Date: Created in 9:58 下午 2020/9/3
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 代理对象，静态代理
public class TeacherDaoProxy implements ITeacherDao {

    private ITeacherDao target; // 目标对象，通过接口来聚合

    // 构造器
    public TeacherDaoProxy(ITeacherDao target){
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("开始代理，完成某些操作..."); // 方法
        target.teach();
        System.out.println("提交...."); // 方法
    }
}
