package MapSetList;

import java.util.*;

/**
 * Set和List接口都基于Collection类接口
 * map：映射 list：有序 set：无序        存放对象Object（泛型）的数组
 * 有点类似于python的列表，字典，元组等（长度）可变结构-----容器
 * 继承了Collection接口
 * 常用方法：
 * add(对象形参)：添加对象元素   remove(对象）：移除指定元素     Iterator(): 迭代器，遍历容器
 * isEmpty()：判空         size():获取容器当前长度（元素数量）
 *
 */

public class studySet {
    public static void main(String[] args) {
        // HashSet
        Set set = new HashSet();
        //Set<Object> set = new HashSet<Object>();  等价上一个语句
        set.add(1014);
        set.add('男');
        set.add("郑鑫");
        set.add("SWUST");
        set.add("20");
        set.add(20);
        System.out.println(set); //可直接输出。相当于python的列表打印
        System.out.println(set.contains(1014));// contains判断是否存在容器中
        set.remove("20");
        System.out.println(set);
        set.clear();//清空集合
        System.out.println("-------------------------------------");
        set.add('a');
        set.add('b');
        set.add('c');
        set.add('d');
        //set的遍历：迭代器Iterator 或foreach： for(Object o : set)
        Iterator it=set.iterator();//创建迭代器，用set对象调用
        while(it.hasNext()){
            // hasNext()   存在下一个元素
            System.out.print(it.next());// 输出存在的next的对象
        }
        System.out.println();
        for (Object o : set) {
            // 将遍历set的对象赋值给Object o
            System.out.print(o);
        }
        System.out.println("当前set中元素个数为:"+set.size());
        System.out.println("--------------------------------------------------");
        //限制set存储的类型（泛型）
        Set<String> s=new HashSet<String>();
        // 异常处理
        try{
            s.add("SWUST");
            System.out.println(s);
//            s.add(1);    整型int报错
        }catch (Exception e){
            System.out.println("类型不正确，应为String类型！");
        }
        System.out.println("--------------------------------------------------");
        //TreeSet  自然排序
        Set<Phone> phoneSet = new TreeSet<Phone>(new Phone());
        Phone p1=new Phone("xiaomi",2888);
        Phone p2=new Phone("Vivo",2999);
        Phone p3=new Phone("Oppo",2555);
        Phone p4=new Phone("HuaWei",3888);
        phoneSet.add(p1);
        phoneSet.add(p2);
        phoneSet.add(p3);
        phoneSet.add(p4);
        System.out.println("手机价格如下：");
        for(Phone p:phoneSet){
            System.out.println(p.name+" "+p.price);
        }
    }

}

// 实现TreeSet的定制排序，需要实现Comparator<T>接口及override其方法compare（obj1,obj2）
class Phone implements Comparator<Phone>{
    String name;
    int price;
    public Phone(){}
    public Phone(String name,int price){
        // this引用当前所在类的成员变量，区分与参数同名
        this.name=name;
        this.price=price;
    }
    @Override
    public int compare(Phone o1, Phone o2) {
        //升序
        if(o1.price > o2.price){
            return 1;
        }else if(o1.price < o2.price){
            return -1;
        }
        else return 0;
    }

//    @Override
//    public int compare(Phone o1, Phone o2) {
//        //降序
//        if(o1.price < o2.price){
//            return 1;
//        }else if(o1.price > o2.price){
//            return -1;
//        }
//        else return 0;
//    }
}
