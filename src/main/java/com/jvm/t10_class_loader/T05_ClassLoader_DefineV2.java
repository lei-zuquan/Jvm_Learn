package com.jvm.t10_class_loader;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:35 下午 2020/8/18
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T05_ClassLoader_DefineV2 extends AbstractMap implements Map {
    @Override
    public Set<Entry> entrySet() {
        return null;
    }

    @Override
    public String toString() {
        return "T05_ClassLoader_DefineV2{}";
    }

    static {
        System.out.println("T05_ClassLoader_DefineV2 init");
    }
}
