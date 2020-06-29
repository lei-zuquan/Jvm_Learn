package com.java.z_exam.rpc.rpc10_kyro;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:15 上午 2020/6/29
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class HessianSerializable {

    public static void setSerializableObject() throws IOException {

        FileOutputStream fo = new FileOutputStream("D:/file3.bin");

        Hessian2Output so = new Hessian2Output(fo);

        for (int i = 0; i < 100000; i++) {
            Map<String, Integer> map = new HashMap<String, Integer>(2);
            map.put("zhang0", i);
            map.put("zhang1", i);
            so.writeObject(new Simple("zhang" + i, (i + 1), map));
        }
        so.flush();
        so.close();
    }

    public static void getSerializableObject() {
        FileInputStream fi;
        try {
            fi = new FileInputStream("D:/file3.bin");
            Hessian2Input si = new Hessian2Input(fi);

            Simple simple = null;
            while ((simple = (Simple) si.readObject()) != null) {
                //System.out.println(simple.getAge() + "  " + simple.getName());
            }
            fi.close();
            si.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        }

    }

}