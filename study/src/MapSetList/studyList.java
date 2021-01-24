package MapSetList;

import java.util.*;

/**
 * List: 有序集合，可重复 等同python列表     接口实现类：ArrayList和LinkedList   提一下vector（古老的集合。。。。）
 */

public class studyList {
    public static void main(String[] args) {
        //定义List，List是接口
        List<Object> list=new ArrayList<Object>();
        list.add("zhengxin");//索引为0
        list.add("SoftWare05");//索引为1
        list.add("male");//索引为2
        list.add(20);//索引为3
        list.add(1,'男');//索引为4    在指定位置0后插入数据
        System.out.println(list);
        System.out.println("--------------------------------------------------");
        //.get(int) 根据索引获取数据
        try{
            System.out.println(list.get(0));
            System.out.println(list.get(5));//索引5暂时无元素，会发生异常
        }catch (Exception e){
            System.out.println("list[5],该索引无元素！");
        }
        System.out.println("--------------------------------------------------");
        System.out.println("list信息如下：");
        //  list遍历
        for(Object obj:list){
            System.out.println(obj);
        }
        System.out.println("--------------------------------------------------");
        //添加一个集合：addAll()
        List<Object> list1=new ArrayList<Object>();
        list1.add("5120181014");
        list1.add("SWUST");
        list.addAll(list1);//list.addAll(1,list1);指定位置添加
        System.out.println(list);
        System.out.println("--------------------------------------------------");
        //也有数组的indexOf和lastindexOf 的获取目标索引的方法  remove()删除
        System.out.println(list.indexOf(20));
        list.remove(1);//删除第二个元素"男"
        // 替换元素：set(原元素索引，新元素值)
        list.set(2,"男");   //female改成中文
        System.out.println(list);
        System.out.println("--------------------------------------------------");
        //截取切片  subList([初，末))
        List<Object> list2 = list.subList(0,2);
        System.out.println(list2);
    }

}
