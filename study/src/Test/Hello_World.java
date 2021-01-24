package Test;

import java.util.Random; // java.util为包名   Ramdom为类名  import java.util.*; 代表引入util包中的所有方法


public class Hello_World {
    // 关键词 final 不可修改的变量----通常用于定义常量
    final int FINAL = 6;
    private final int FINALLY = 66;
    // 主方法 ---- 程序入口
    public static void main(String[] args) {
        //静态Math类方法：Ramdom() 在0.0-1.0随机
        double ra = Math.random();
        System.out.println(ra);
        //  使用Random类，先创建对象
        Random ram=new Random();
        System.out.println("随机int型："+ram.nextInt());
        System.out.println("随机0~n之间的数："+ram.nextInt(10));
        System.out.println("随机Long型："+ram.nextLong());
        System.out.println("随机Float型："+ram.nextFloat());
        System.out.println("随机Double型："+ram.nextDouble());
        System.out.println("随机Boolean型："+ram.nextBoolean());
        // Unicode编码中，前128为ACSII码
        System.out.println("随机字符型："+(char)(0+ram.nextInt(128)));


    }

}
