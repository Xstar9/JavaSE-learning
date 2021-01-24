package MapSetList;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型类   class<T>    T指type，即该类可接收任意类型。在对象调用时，需要实例类型
 *
 */

public class studyTypeClass {
    public static void main(String[] args) {
        fanxing<String> a1 = new fanxing<String>();// 实例化泛型T为接收String类型
        fanxing<Integer> a2 = new fanxing<Integer>();// 实例化泛型T为接收int类型
        fanxing fx=new fanxing();//不声明即为Object

        a1.setName("zhengxin");
        String s=a1.getName();
        System.out.println(s);

        a2.setName(1014);
        int integer = a2.getName();
        System.out.println(integer);

        fx.setName('x');
        Object obj = fx.getName();
        System.out.println(obj);



    }
}

class fanxing<T>{
    private T name;
    public void setName(T name){   //T t 即参数可为任意类型----泛型
        this.name=name;
    }
    public T getName(){
        return this.name;
    }
}