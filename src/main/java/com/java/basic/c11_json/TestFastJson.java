package com.java.basic.c11_json;

//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import org.junit.Assert;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-04-10 10:02
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class TestFastJson {

//    public static void main(String[] args) {
//        json2JsonObject();//将Json字符串转换为JSONObject对象
//        json2JavaBean();//将Json字符串转换为JavaBean对象
//        json2JsonArray();//将Json字符串转换为JSONArray对象
//        json2JavaBeanList();//将Json字符串转换为JavaBean的集合
//        javaBean2Json();//将JavaBean转换为Json格式的数据
//        javaBean2JsonObject();//将JavaBean转换为JSONObject对象
//        json2ListInMap();//从Json字符串的Map中获取List对象
//        list2JsonInMap();//将含list的Map对象转换为Json字符串
//        stringToMap();//json字符串转map
//        mapToString();//map转json字符串
//        mapToJsonObject();//map转json对象
//        testList2String();//list转json字符串
//    }
//
//    private static void json2JsonObject() {
//        String s = "{\"name\":\"peter\"}";
//        JSONObject object = JSON.parseObject(s);
//        System.out.println(object.get("name"));
//    }
//
//    private static void json2JavaBean() {
//        String s = "{\"id\":\"17051801\",\"name\":\"lucy\"}";
//        User user = JSON.parseObject(s, User.class);
//        System.out.println(user.getId());
//        System.out.println(user.getName());
//    }
//
//    private static void json2JsonArray() {
//        String s = "[{\"id\":\"17051801\",\"name\":\"lucy\"},{\"id\":\"17051802\",\"name\":\"peter\"}]";
//        JSONArray array = JSON.parseArray(s);
//        for (int i = 0; i < array.size(); i++) {
//            //JSONArray中的数据转换为String类型需要在外边加"";不然会报出类型强转异常！
//            String str = array.get(i) + "";
//            JSONObject object = JSON.parseObject(str);
//            System.out.println(object.get("name"));
//        }
//    }
//
//    private static void json2JavaBeanList() {
//        String s = "[{\"id\":\"17051801\",\"name\":\"lucy\"},{\"id\":\"17051802\",\"name\":\"peter\"}]";
//        List<User> list = JSON.parseArray(s, User.class);
//        for (User user : list) {
//            System.out.println(user.getName());
//        }
//    }
//
//    private static void javaBean2Json() {
//        User user = new User("17051801", "lucy");
//        String string = JSON.toJSONString(user);
//        System.out.println(string);
//    }
//
//    private static void javaBean2JsonObject() {
//        User user = new User("17051801", "lucy");
//        JSONObject json = (JSONObject) JSON.toJSON(user);
//        System.out.println(json.get("id"));
//    }
//
//    private static void json2ListInMap() {
//        String s = "{json:[{id:\"17051801\",\"name\":\"lucy\"},{id:\"17051802\",\"name\":\"peter\"},"
//                + "{id:\"17051803\",\"name\":\"tom\"},{id:\"17051804\",\"name\":\"lily\"}]}";
//        //将Json字符串转换为JSONObject对象,并取出list对象的值
//        JSONObject object = JSON.parseObject(s);
//        Object objArray = object.get("json");
//        String str = objArray + "";
//        //方式1:转换成JSONArray对象形式
//        JSONArray array = JSON.parseArray(str);
//        for (int i = 0; i < array.size(); i++) {
//            JSONObject obj = JSON.parseObject(array.get(i) + "");
//            System.out.println(obj.get("name"));
//        }
//        //方式2:转换成List<JavaBean>形式
//        List<User> list = JSON.parseArray(str, User.class);
//        for (User user : list) {
//            System.out.println(user.getName());
//        }
//    }
//
//    private static void list2JsonInMap() {
//        //方式1:构建一个带有list的JavaBean对象
//        School school = new School();
//        school.setId("1");
//        school.setName("schoolA");
//
//        User user1 = new User();
//        user1.setId("17051801");
//        user1.setName("lucy");
//        User user2 = new User();
//        user2.setId("17051802");
//        user2.setName("peter");
//
//        school.getStudents().add(user1);
//        school.getStudents().add(user2);
//        //将JavaBean对象转换成Json字符串
//        String string1 = JSON.toJSONString(school);
//        System.out.println(string1);
//
//        //方式2:构建一个带有list的Map对象
//        Map<String, Object> map1 = new HashMap<String, Object>();
//        map1.put("id", "17051801");
//        map1.put("name", "lucy");
//
//        Map<String, Object> map2 = new HashMap<String, Object>();
//        map2.put("id", "17051802");
//        map2.put("name", "peter");
//
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//        list.add(map1);
//        list.add(map2);
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("id", "1");
//        map.put("name", "schoolA");
//        map.put("students", list);
//        //将map对象转换成Json字符串
//        String string2 = JSON.toJSONString(map);
//        System.out.println(string2);
//    }
//
//    private static void stringToMap() {
//        String str = "{\"age\":\"24\",\"name\":\"cool_summer_moon\"}";
//        JSONObject jsonObject = JSONObject.parseObject(str);
//        //json对象转Map
//        Map<String, Object> map = (Map<String, Object>) jsonObject;
//        System.out.println("map对象是：" + map);
//        Object object = map.get("age");
//        System.out.println("age的值是" + object);
//    }
//
//    private static void mapToString() {
//        Map<String, Object> map = new HashMap<>();
//        map.put("age", 24);
//        map.put("name", "cool_summer_moon");
//        String jsonString = JSON.toJSONString(map);
//        System.out.println("json字符串是：" + jsonString);
//    }
//
//    private static void mapToJsonObject() {
//        Map<String, Object> map = new HashMap<>();
//        map.put("age", 24);
//        map.put("name", "cool_summer_moon");
//        JSONObject json = new JSONObject(map);
//        System.out.println("Json对象是：" + json);
//
//    }
//
//    /**
//     * 测试包装类型的List转换为json字符串
//     */
//    public static void testList2String() {
//        List<Long> longs = new ArrayList<Long>();
//        longs.add(1L);
//        longs.add(2L);
//        longs.add(3L);
//        String actual = JSON.toJSONString(longs);
//        Assert.assertEquals("[1,2,3]", actual);
//    }

}