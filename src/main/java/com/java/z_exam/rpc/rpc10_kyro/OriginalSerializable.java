package com.java.z_exam.rpc.rpc10_kyro;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:15 上午 2020/6/29
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class OriginalSerializable {

    public static void setSerializableObject() throws IOException {

        FileOutputStream fo = new FileOutputStream("D:/file2.bin");

        ObjectOutputStream so = new ObjectOutputStream(fo);

        for (int i = 0; i < 100000; i++) {
            Map<String,Integer> map = new HashMap<String, Integer>(2);
            map.put("zhang0", i);
            map.put("zhang1", i);
            so.writeObject(new Simple("zhang"+i,(i+1),map));
        }
        so.flush();
        so.close();
    }

    public static void getSerializableObject(){
        FileInputStream fi;
        try {
            fi = new FileInputStream("D:/file2.bin");
            ObjectInputStream si = new ObjectInputStream(fi);

            Simple simple =null;
            while((simple=(Simple)si.readObject()) != null){
                //System.out.println(simple.getAge() + "  " + simple.getName());
            }
            fi.close();
            si.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}