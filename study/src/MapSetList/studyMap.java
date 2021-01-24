package MapSetList;

import java.util.*;

/**
 * Map: 单向一对一映射   键值对形式。类似python字典   键key要求不重复，通过键(key)找值(value)
 * Map是接口，实现类：HashMap和TreeMap(类似Set，但在该结构不常用)      Hashtable(古老。。。同vector 了解)
 */

public class studyMap {
    public static void main(String[] args) {
        //定义一个HashMap
       // Map<String,Integer> map = new HashMap<String,Integer>();// Integer即int类型
        Map<String,Object> map = new HashMap<String,Object>();//值为泛型
        // Map的添加元素方法：put(放进去的key,value)
        map.put("Name","zhengxin");
        map.put("sex","male");
        map.put("Age",20);
        map.put("ID","5120181014");
        map.put("school","SWUST");
        map.put("export","SoftWare");
        System.out.println(map);
        System.out.println("--------------------------------------------------");
        //根据key获取value，根据key->remove元素(键值对)
        System.out.println(map.get("Name"));
        map.remove("export");
        System.out.println("Remove后："+map);
        System.out.println("--------------------------------------------------");
        //判断map里是否存在键/值：containsKey()   containsValue()   map.size(获取容器长度)  map.claer(清空)
        System.out.println(map.containsKey("Name"));
        System.out.println(map.containsValue("ZhengXin"));//值不存在，应为zhengxin
        System.out.println("--------------------------------------------------");
        // map遍历  1.  keySet(): 获取所有键   values(): 获取所有值
        System.out.println("keySet方法遍历：");
        Set<String> Keys = map.keySet();// 用集合set接收所有键key
        map.values();
        for (String s:Keys) {
            System.out.println("key: "+s+"   value: "+map.get(s));
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Map.Entry<K,V>遍历：");
        // map遍历  2.  .entrySet()      遍历用：getKey()  getValue() 获取键/值
        Set<Map.Entry<String,Object>> entrys = map.entrySet(); //Map.Entry<String,Object> 引入了Map的静态方法
        for(Map.Entry<String,Object> entry:entrys){
            System.out.println("key: "+entry.getKey()+"   value: "+entry.getValue());
        }
    }

}
