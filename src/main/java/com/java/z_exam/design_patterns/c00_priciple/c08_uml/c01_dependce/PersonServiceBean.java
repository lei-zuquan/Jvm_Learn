package com.java.z_exam.design_patterns.c00_priciple.c08_uml.c01_dependce;

/**
 * @Author:
 * @Date: Created in 10:08 下午 2020/8/30
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class PersonServiceBean {
    private PersonDao personDao;//类
    public void save(Person person){}

    public IDCard getIDCard(Integer personid){
        return null;
    }

    public void modify(){
        Department department = new Department();
    }
}
