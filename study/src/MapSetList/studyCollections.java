package MapSetList;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * Collections ： 操作集合的工具类
 */

public class studyCollections {
    public static void main(String[] args) {
        List<Object> _list=new ArrayList<Object>();
        _list.add("zhengxin");//索引为0
        _list.add("SoftWare05");//索引为1
        _list.add("male");//索引为2
        _list.add(20);//索引为3
        System.out.println(_list);
        System.out.println("--------------------------------------------------");
        // Collections.reverse(集合) 倒序
        Collections.reverse(_list);
        System.out.println("reverse后："+_list);
        System.out.println("--------------------------------------------------");
        // Collections.shuffle  随机排序
        Collections.shuffle(_list);
        System.out.println("shuffle后："+_list);

        System.out.println("--------------------------------------------------");
        // Collections.sort  升序排序
        List<String> L_list=new ArrayList<String>();
        L_list.add("a");//索引为0
        L_list.add("c");//索引为1
        L_list.add("b");//索引为2
        L_list.add("d");//索引为3
        System.out.println("sort前："+L_list);
        Collections.sort(L_list);
        System.out.println("sort后："+L_list);
        System.out.println("--------------------------------------------------");
        // Collections.sort(list,Comparator<泛型>)
        List<Student> stus = new ArrayList<Student>();
        Student p1=new Student("xiaoming",17);
        Student p2=new Student("Tom",20);
        Student p3=new Student("John",18);
        Student p4=new Student("Kris",29);
        stus.add(p1);
        stus.add(p2);
        stus.add(p3);
        stus.add(p4);
        System.out.println("学生年龄如下：");
        for(Student stu:stus){
            System.out.println(stu.name+" "+stu.age);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("根据比较器Comparator定制排序后：");
        Collections.sort(stus,new Student());
        System.out.println("学生年龄如下：");
        for(Student stu:stus){
            System.out.println(stu.name+" "+stu.age);
        }
        System.out.println("--------------------------------------------------");
        //Collections.swap(list,索引1.索引2)
        Collections.swap(stus,0,3);
        System.out.println("swap后 学生年龄如下：");
        for(Student stu:stus){
            System.out.println(stu.name+" "+stu.age);
        }
        /**
         * 查找/替换
         * Collections.max/min(list)  查最大/小元素
         * Collections.frequency(list,字符/串)  查 指定元素 的出现次数
         *  Collections.replaceAll(list，原值,新替换值)   将所有 原值 替换成 新值
         *
         *  synchronizedXxx() 线程同步。。。这里简单提一下。
         */





    }

}


// 类似Set的Comparator<Student>        根据比较器进行定制排序
class Student implements Comparator<Student> {
    String name;
    int age;

    public Student() {
    }

    public Student(String name, int age) {
        // this引用当前所在类的成员变量，区分与参数同名
        this.name = name;
        this.age = age;
    }

    @Override
    public int compare(Student o1, Student o2) {
        //升序
        if (o1.age > o2.age) {
            return 1;
        } else if (o1.age < o2.age) {
            return -1;
        } else return 0;
    }
}
