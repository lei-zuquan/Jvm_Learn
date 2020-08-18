package com.jvm.t10_class_loader;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:50 上午 2020/8/18
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 类加载器 —— 线程上下文类加载器
public class T04_ClassLoader_ThreadContext {
    // 继续看 loadInitialDrivers()  方法：JDK 在某些情况下需要打破双亲委派模式
    private static void loadInitialDriver() {
        String drivers;
        try {
            drivers = AccessController.doPrivileged(new PrivilegedAction<String>() {
                @Override
                public String run() {
                    return System.getProperty("jdbc.drivers");
                }
            });
        } catch (Exception ex) {
            drivers = null;
        }

        // 1) 使用ServiceLoader 机制加载驱动，即 SPI
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            @Override
            public Void run() {
                ServiceLoader<Driver> loaderDrivers = ServiceLoader.load(Driver.class);
                Iterator<Driver> driversIterator = loaderDrivers.iterator();
                try {
                    while (driversIterator.hasNext()) {
                        driversIterator.next();
                    }
                } catch (Throwable t) {
                    // Do nothing
                }
                return null;
            }
        });

        System.out.println("DriverManager.initialize: jdbc.drivers = " + drivers);

        // 2) 使用 jdbc.drivers 定义的驱动名加载驱动
        if (drivers == null || drivers.equals("")) {
            return;
        }

        String[] driversList = drivers.split(":");
        System.out.println("number of Drivers:" + driversList.length);
        for (String aDriver : driversList) {
            try {
                System.out.println("DriverManager.Initialize: loading " + aDriver);
                // 这里的 ClassLoader.getSystemLoader() 就是应用程序类加载器
                // getSystemClassLoader 其实就是应用程序类加载器，打破了双亲委派模式。在某些情况下需要打破双亲委派模式
                Class.forName(aDriver, true, ClassLoader.getSystemClassLoader());
            } catch (Exception ex) {
                System.out.println("DriverManager.Initialize: load failed: " + ex);
            }
        }
    }

}

//class DriverManager {
//    // 注册驱动的集合
//    private final static CopyOnWriteArrayList<DriverInfo> registeredDrivers
//            = new CopyOnWriteArrayList<>();
//
//    // 初始化驱动
//    static {
//        loadInitialDrivers();
//        System.out.println("JDBC DriverManager initialized");
//    }
//}


