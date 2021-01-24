package reflect;

public class test {
    public static void main(String[] args) {
        Bank bank=new Bank();
        Class cla=bank.getClass();
        System.out.println(cla);// 获取对象所属类的信息
        Class cla1=Bank.class;//类名.class   创建指定类实例
        System.out.println(cla1);
        try {
            Class cla2=Class.forName("reflect.Bank");//常用获取对象实例的方法
            System.out.println(cla2);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
